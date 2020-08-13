/**
 * 
 */
package sam09.saga.coredomain.eventModels;

import java.math.BigDecimal;

/**
 * @author soumya
 *
 */
public class OrderPlaceEvent {

	private final String orderId;
	private final String item;
	private final BigDecimal price;
	private final String orderStatus;
	private final String currency;
	
	public OrderPlaceEvent(String _orderId,String _item,BigDecimal _price,String _orderStatus,String _currency){
		this.orderId = _orderId;
		this.item = _item;
		this.price = _price;
		this.orderStatus = _orderStatus;
		this.currency = _currency;
		
	}
	
}
