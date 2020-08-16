/**
 * 
 */
package com.sam09.saga.orderservice.manager;

import java.util.UUID;

import javax.inject.Inject;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;

import com.sam09.saga.orderservice.enums.Status;

import sam09.saga.coredomain.commandModels.InvoiceCreationCommand;
import sam09.saga.coredomain.commandModels.OrderUpdateCommand;
import sam09.saga.coredomain.commandModels.ShippingOrderCommand;
import sam09.saga.coredomain.eventModels.InvoiceCreationEvent;
import sam09.saga.coredomain.eventModels.OrderPlaceEvent;
import sam09.saga.coredomain.eventModels.OrderUpdateEvent;
import sam09.saga.coredomain.eventModels.ShippingOrderEvent;

/**
 * @author soumya
 *
 */
@Saga
public class OrderManagerSAGA {

	@Inject
	private transient CommandGateway _commandGateway;
	
	/*
	 * SAGA Manager / OrderManagerSAGA will manage our order processing as a whole
	 * 
	 * Once an order is placed then it will initiate invoice creation command and after invoice is generated and payment is successful 
	 * then order shipment command will be initiated and simultaneously order status update will also get inittiated.
	 * This whole oder processing activity will be managed by our SAGA manager class
	 * 
	 * */
	
	@StartSaga
	@SagaEventHandler(associationProperty = "orderId")
	public void handle(OrderPlaceEvent _orderPlaceEvent) {
		
		String paymentID = UUID.randomUUID().toString();
		SagaLifecycle.associateWith("payId",paymentID); // SAGA association
		_commandGateway.send(
				new InvoiceCreationCommand(
						paymentID,
						_orderPlaceEvent.orderId)
				);
	}
	
	@SagaEventHandler(associationProperty = "payId")
	public void handle(InvoiceCreationEvent _invoiceCreationEvent) {
		
		String shippingID = UUID.randomUUID().toString();
		SagaLifecycle.associateWith("shippingId", shippingID);
		_commandGateway.send(
				new ShippingOrderEvent(
						shippingID, 
						_invoiceCreationEvent.orderId,
						_invoiceCreationEvent.payId)
				);
	}
	
	@SagaEventHandler(associationProperty = "orderId")
	public void handle(ShippingOrderEvent _shippingOrderEvent) {
		_commandGateway.send(
				new OrderUpdateCommand(
						_shippingOrderEvent.orderId, 
						String.valueOf(Status.SHIPPED))
				);
	}
	
	@SagaEventHandler(associationProperty = "orderId")
	public void handle(OrderUpdateEvent _orderUpdateEvent) {
		SagaLifecycle.end(); // Here Our Saga Manager ends
	}
	
}
