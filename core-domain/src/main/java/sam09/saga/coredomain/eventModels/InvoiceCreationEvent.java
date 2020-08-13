/**
 * 
 */
package sam09.saga.coredomain.eventModels;

/**
 * @author soumya
 *
 */
public class InvoiceCreationEvent {

	private final String orderId;
	private final String payId;
	
	public InvoiceCreationEvent(String _payId,String _orderId) {
		this.payId = _payId;
		this.orderId = _orderId;
	}
}
