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

	public final String orderId;
	public final String item;
	public final BigDecimal price;
	public final String orderStatus;
	public final String currency;
	
	public OrderPlaceEvent(String _orderId,String _item,BigDecimal _price,String _orderStatus,String _currency){
		this.orderId = _orderId;
		this.item = _item;
		this.price = _price;
		this.orderStatus = _orderStatus;
		this.currency = _currency;
		
	}
	
}
