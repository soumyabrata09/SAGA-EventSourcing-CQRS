/**
 * 
 */
package sam09.saga.coredomain.commandModels;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @author soumya
 *
 */
public class InvoiceCreationCommand {

	@TargetAggregateIdentifier
	public final String payId;
	public final String orderId;
	
	public InvoiceCreationCommand(String _payId,String _orderId) {
		this.orderId = _orderId;
		this.payId = _payId;
	}

}
