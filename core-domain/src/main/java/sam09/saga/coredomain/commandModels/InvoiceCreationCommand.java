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

	private final String orderId;
	@TargetAggregateIdentifier
	private final String payId;
	
	public InvoiceCreationCommand(String _payId,String _orderId) {
		this.orderId = _orderId;
		this.payId = _payId;
	}

}
