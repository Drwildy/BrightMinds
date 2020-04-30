package com.brightminds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("PaymentController")
@RequestMapping(path = "/payment")
public class PaymentController {
	
	//private PaymentService paymentService;
	
//	@Autowired
//	public PaymentController(PaymentService paymentService) {
//		this.paymentService = paymentService;
//	}

}
