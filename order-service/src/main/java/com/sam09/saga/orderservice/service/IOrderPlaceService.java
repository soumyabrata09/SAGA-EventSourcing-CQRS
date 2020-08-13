/**
 * 
 */
package com.sam09.saga.orderservice.service;

import java.util.concurrent.CompletableFuture;

import com.sam09.saga.orderservice.dto.commands.OrderPlaceDTO;

/**
 * @author soumya
 *
 */
public interface IOrderPlaceService {

	public CompletableFuture<String> placeOrder(OrderPlaceDTO _orderPlaceDTO);
}
