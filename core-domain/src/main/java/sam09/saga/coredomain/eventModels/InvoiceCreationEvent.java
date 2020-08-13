/**
 * 
 */
package sam09.saga.coredomain.eventModels;

/**
 * @author soumya
 *
 */
public class InvoiceCreationEvent {

	public final String orderId;
	public final String payId;
	
	public InvoiceCreationEvent(String _payId,String _orderId) {
		this.payId = _payId;
		this.orderId = _orderId;
	}
}
