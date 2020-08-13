package com.sam09.saga.orderservice.aggregates;

import java.math.BigDecimal;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.sam09.saga.orderservice.enums.ItemCatalog;
import com.sam09.saga.orderservice.enums.Status;

import sam09.saga.coredomain.commandModels.OrderPlaceCommand;
import sam09.saga.coredomain.commandModels.OrderUpdateCommand;
import sam09.saga.coredomain.eventModels.OrderPlaceEvent;
import sam09.saga.coredomain.eventModels.OrderUpdateEvent;

/**
 * @author soumya
 *
 */
@Aggregate
public class OrderActivityAggregate {
	
	@AggregateIdentifier
	private String orderId; 
	private ItemCatalog item;    
	private BigDecimal price;
	private Status orderStatus;
	private String currency;
	
	public OrderActivityAggregate() {}
	
	//Order Placing Aggregate
	@CommandHandler
	public OrderActivityAggregate(OrderPlaceCommand _orderPlaceCommand) {
		AggregateLifecycle.apply(new OrderPlaceEvent(
				_orderPlaceCommand.orderId,
				_orderPlaceCommand.item,
				_orderPlaceCommand.price,
				_orderPlaceCommand.orderStatus,
				_orderPlaceCommand.currency
				
				));
	}
	
	@EventSourcingHandler
	public void on(OrderPlaceEvent _orderPlaceEvent) {
		this.orderId = _orderPlaceEvent.orderId;
		this.item = ItemCatalog.valueOf(_orderPlaceEvent.item);
		this.price = _orderPlaceEvent.price;
		this.orderStatus = Status.valueOf(_orderPlaceEvent.orderStatus);
		this.currency = _orderPlaceEvent.currency;
	} 
	
	//Order Status Update Aggregate 
	@CommandHandler
	public void on(OrderUpdateCommand _orderUpdateCommand) {
		AggregateLifecycle.apply(new OrderUpdateEvent(
				_orderUpdateCommand.orderId,
				_orderUpdateCommand.status
				));
	}
	
	@EventSourcingHandler
	public void on(OrderUpdateEvent _orderUpdateEvent) {
		this.orderId = _orderUpdateEvent.orderId;
		this.orderStatus = Status.valueOf(_orderUpdateEvent.status);
	}
}
