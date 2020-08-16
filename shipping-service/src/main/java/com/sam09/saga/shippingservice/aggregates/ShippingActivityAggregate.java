/**
 * 
 */
package com.sam09.saga.shippingservice.aggregates;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import sam09.saga.coredomain.commandModels.ShippingOrderCommand;
import sam09.saga.coredomain.eventModels.ShippingOrderEvent;

/**
 * @author soumya
 *
 */
@Aggregate
public class ShippingActivityAggregate {

	@AggregateIdentifier
	 private String shippingId;
	 private String orderId;
	 private String paymentId;
	 
	 public ShippingActivityAggregate() {}
	 
	 @CommandHandler
	 public ShippingActivityAggregate(ShippingOrderCommand _shippingOrderCommand) {
		 AggregateLifecycle.apply(
				 new ShippingOrderEvent(
						 _shippingOrderCommand.shippingId, 
						 _shippingOrderCommand.orderId, 
						 _shippingOrderCommand.payId)
				 );
	 }
	 
	 @EventSourcingHandler
	 public void on(ShippingOrderEvent _shippingOrderEvent) {
		 this.shippingId = _shippingOrderEvent.shippingId;
		 this.orderId = _shippingOrderEvent.orderId;
		 this.paymentId = _shippingOrderEvent.payId;
	 }
	 
}
