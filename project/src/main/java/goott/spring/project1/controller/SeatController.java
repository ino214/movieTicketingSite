package goott.spring.project1.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import goott.spring.project1.domain.MovieVO;
import goott.spring.project1.domain.ReviewVO;
import goott.spring.project1.service.MovieService;
import goott.spring.project1.service.ReviewService;

@Controller
@RequestMapping(value="/seat")
public class SeatController {
	private static Logger LOGGER = 
			LoggerFactory.getLogger(SeatController.class);
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/seatReserve")
	public void seatList() {
		LOGGER.info("seatList() 호출");
	}
}
