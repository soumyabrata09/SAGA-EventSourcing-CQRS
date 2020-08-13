/**
 * 
 */
package sam09.saga.coredomain.commandModels;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @author soumya
 *
 */
public class ShippingOrderCommand {

	@TargetAggregateIdentifier
	public final String shippingId;
	public final String orderId;
	public final String payId;
	
	public ShippingOrderCommand(String _shippingId, String _orderId, String _payId) {
		this.shippingId = _shippingId;
	    this.orderId = _orderId;
	    this.payId = _payId;
	}
}
