/**
 * 
 */
package sam09.saga.coredomain.commandModels;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @author soumya
 *
 */
public class OrderUpdateCommand {

	@TargetAggregateIdentifier
	private String orderId;
	private String status;
	
	public OrderUpdateCommand(String _orderId,String _status) {
		this.orderId = _orderId;
		this.status = _status;
	}
	
}
