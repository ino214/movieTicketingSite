package goott.spring.project1.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import goott.spring.project1.domain.MovieVO;
import goott.spring.project1.service.BranchService;
import goott.spring.project1.service.MovieService;
import goott.spring.project1.service.ReserveService;

@Controller
@RequestMapping(value="/reserve")
public class ReserveController {
	private static Logger LOGGER = 
			LoggerFactory.getLogger(ReserveController.class);
	
//	@Autowired
//	private ReserveService reserveService;
	
	@Autowired
	private MovieService movieService;
	
//	@Autowired
//	private ScreenDateService screenDateService;
	
	@GetMapping("/movieTicketing")
	public void movieTicketing(Model model, String movieId) {
		LOGGER.info("movieTicketing() 호출 : movieId = " + movieId);
		LOGGER.info("날짜 설정");
		List<String> dateList = new ArrayList<>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		for(int i = 1; i <= 8; i++) {
			System.out.println(format.format(cal.getTime()));
			dateList.add(format.format(cal.getTime()));
			cal.add(Calendar.DAY_OF_MONTH, +1);
		}
		
		List<MovieVO> movieList = movieService.read();
		
		LOGGER.info("영화 개수 : " + movieList.size());
		
		LOGGER.info("날짜 : " + dateList);
		LOGGER.info("오늘 : " + dateList);
		
		model.addAttribute("movieList", movieList);
		model.addAttribute("dateList", dateList);
		
	}
}
