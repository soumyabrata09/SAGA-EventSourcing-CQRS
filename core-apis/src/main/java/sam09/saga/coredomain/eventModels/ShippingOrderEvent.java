/**
 * 
 */
package sam09.saga.coredomain.eventModels;

/**
 * @author soumya
 *
 */
public class ShippingOrderEvent {

	 public final String shippingId;
	 public final String orderId;
	 public final String payId;

	 public ShippingOrderEvent(String _shippingId, String _orderId, String _payId) {
	     this.shippingId = _shippingId;
	     this.orderId = _orderId;
	     this.payId = _payId;
	 }
}
