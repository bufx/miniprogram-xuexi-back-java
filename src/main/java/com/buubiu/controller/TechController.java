package com.buubiu.controller;

import com.buubiu.service.TechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @comment:
 * @author: buubiu
 * @create: 2021/12/1 14:38
 */
@RestController
@RequestMapping("/tech")
public class TechController {

	@Autowired
	private TechService techService;

	@PostMapping("/{userId}")
	public void start(@PathVariable(value = "userId") String userId) {
		techService.restart(userId);
	}
}
