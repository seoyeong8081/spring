package com.ssafy.enjoytrip.plan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoytrip.plan.model.service.PlanService;

@RestController
@RequestMapping("/plan")
public class PlanController {

	@Autowired
	PlanService planService;
	
}
