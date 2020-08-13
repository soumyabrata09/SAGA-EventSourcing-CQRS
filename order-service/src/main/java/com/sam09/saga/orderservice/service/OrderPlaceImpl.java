/**
 * 
 */
package com.sam09.saga.orderservice.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;

import com.sam09.saga.orderservice.dto.commands.OrderPlaceDTO;
import com.sam09.saga.orderservice.enums.Status;

import sam09.saga.coredomain.commandModels.OrderPlaceCommand;

/**
 * @author soumya
 *
 */
public class OrderPlaceImpl implements IOrderPlaceService{

	private final CommandGateway commandGateway;
	
	public OrderPlaceImpl(CommandGateway _commandGateway) {
		this.commandGateway = _commandGateway;
	}
	
	@Override
	public CompletableFuture<String> placeOrder(OrderPlaceDTO _orderPlaceDTO) {
		
		return commandGateway.send(new OrderPlaceCommand(
				UUID.randomUUID().toString(),
				_orderPlaceDTO.getItem(),
				_orderPlaceDTO.getPrice(),
				_orderPlaceDTO.getCurrency(),
				String.valueOf(Status.CREATED)
				));
	}

}
