/**
 * 
 */
package sam09.saga.coredomain.eventModels;

/**
 * @author soumya
 *
 */
public class OrderUpdateEvent {

	 public final String orderId;
	 public final String status;

	 public OrderUpdateEvent(String _orderId, String _status) {
	     this.orderId = _orderId;
	     this.status = _status;
	 }
	
}
