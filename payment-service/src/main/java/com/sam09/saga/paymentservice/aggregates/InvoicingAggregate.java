/**
 * 
 */
package com.sam09.saga.paymentservice.aggregates;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.sam09.saga.paymentservice.enums.Invoice;

import sam09.saga.coredomain.commandModels.InvoiceCreationCommand;
import sam09.saga.coredomain.eventModels.InvoiceCreationEvent;

/**
 * @author soumya
 *
 */
@Aggregate
public class InvoicingAggregate {

	@AggregateIdentifier
	private String payId;
	private String orderId;
	private Invoice invoiceStatus;
	
	public InvoicingAggregate() {}
	
	@CommandHandler
	public InvoicingAggregate(InvoiceCreationCommand _invoiceCreationCommand) {
		AggregateLifecycle.apply(
				new InvoiceCreationEvent(
						_invoiceCreationCommand.payId,
						_invoiceCreationCommand.orderId)
				);
	}
	
	@EventSourcingHandler
	public void on(InvoiceCreationEvent _invoiceCreationEvent) {
		this.payId = _invoiceCreationEvent.payId;
		this.orderId = _invoiceCreationEvent.orderId;
		this.invoiceStatus = Invoice.PAID;
	}
	
}
