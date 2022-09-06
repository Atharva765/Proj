package com.order.api.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.api.model.Address;
import com.order.api.model.Orders;
import com.order.api.repository.AddressRepository;
import com.order.api.repository.OrderRepository;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@PostMapping("/addorder")
	public Orders placeOrder(@RequestBody Orders orders) {
		orders.setOrderDate(LocalDate.now());
		return orderRepository.save(orders);
	}
	
	@GetMapping("/allorders")
	public List<Orders> getAllOrders(){
		return orderRepository.findAll();
	}
	
	@DeleteMapping("/order/removeorder/{oid}")
	public void removeOrder(@PathVariable Long oid) {
		orderRepository.deleteById(oid);
	}
	
	@PutMapping("/order/changestatus/{oid}")
	public Orders changeOrderStatus(@PathVariable Long oid,@RequestBody Orders order) {
		
		Orders orderdb = orderRepository.getById(oid);
		orderdb.setOrderStatus(order.getOrderStatus());
		return orderRepository.save(orderdb);
		
	}
	
	@GetMapping("/getaddress")
	public List<Address> getAllAddress(){
		return addressRepository.findAll();
	}
	
	@GetMapping("/order/{cid}")
	public List<Orders> getOrderByCustomerId(@PathVariable Long cid){
		List<Orders> orderList = (List<Orders>) orderRepository.getById(cid);
		return orderList;
	}
	
	@PostMapping("/storeaddress")
	public Address storeAddress(@RequestBody Address address) {
		return addressRepository.save(address);
	}
	
	@GetMapping("/address/{cid}")
	public List<Address> getAddressByCustomerId(@PathVariable Long cid){
		return (List<Address>)addressRepository.getById(cid);
	}
}











