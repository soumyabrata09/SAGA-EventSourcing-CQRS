/**
 * 
 */
package com.sam09.saga.orderservice.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sam09.saga.orderservice.dto.commands.OrderPlaceDTO;
import com.sam09.saga.orderservice.service.IOrderPlaceService;

import io.swagger.annotations.Api;

/**
 * @author soumya
 *
 */
@RestController
@RequestMapping(value = "/api/order-service")
@CrossOrigin(origins = "*")
@Api(value = "Product Order Managemet in SAGA", tags = "Order Commands", 
description = " Endpoints related to Order Creation")
public class OrderActivityAggregateController {

	private IOrderPlaceService orderPlaceService;
	
	public OrderActivityAggregateController(IOrderPlaceService _orderPlaceService) {
		this.orderPlaceService = _orderPlaceService;
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/orders")
	public CompletableFuture<String> placeOrder(@RequestBody OrderPlaceDTO orderPlaceDTO){
		return orderPlaceService.placeOrder(orderPlaceDTO);
	}
	
}
