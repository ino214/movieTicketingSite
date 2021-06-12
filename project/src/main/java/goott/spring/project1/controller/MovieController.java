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
@RequestMapping(value="/movie")
public class MovieController {
	private static Logger LOGGER = 
			LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping("/movieList")
	public void list(Model model) {
		LOGGER.info("list() ȣ��");
		List<MovieVO> list = movieService.read();
		model.addAttribute("list", list);
		LOGGER.info("list ��");
	}
	
	@GetMapping("/movieDetail")
	public void detailGet(Model model, String movieId, String section) {
		LOGGER.info("detailGet() ȣ�� : movieId = " + movieId);
		MovieVO vo = movieService.read(movieId);
		List<ReviewVO> reviewList = reviewService.readReview(movieId);
		int reviewCount = reviewService.readCount(movieId);
		String movieSummeryContentTemp = vo.getMovieSummaryContent();
		movieSummeryContentTemp = movieSummeryContentTemp.replaceAll("\r\n", "<br>");
		vo.setMovieSummaryContent(movieSummeryContentTemp);
		int liIndex = 1; //movieSummary.jsp가 실행되도록 liIndex에 1값을 초기화
		if(section.equals("movieSummary.jsp")) {
			LOGGER.info("줄거리 표시");
			liIndex = 1;
		}else if(section.equals("movieReview.jsp")) {
			LOGGER.info("관람평 표시");
			liIndex = 2;
		}else {
			LOGGER.info("x");
		}
		model.addAttribute("vo", vo);
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("reviewCount", reviewCount);
		model.addAttribute("liIndex", liIndex);
	}
	
	@PostMapping("/movieDetail")
	public void detailPost(Model model, String movieId) {
		LOGGER.info("detailPost() 호출 : movieId : " + movieId);
	}
	
//	public detail
}
