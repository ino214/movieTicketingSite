package goott.spring.project1.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import goott.spring.project1.domain.ReserveSqlVO;
import goott.spring.project1.service.MovieService;
import goott.spring.project1.service.SeatService;

@Controller
@RequestMapping(value="/seat")
public class SeatController {
	private static Logger LOGGER = 
			LoggerFactory.getLogger(SeatController.class);

	@Autowired
	private SeatService seatService;

	@Autowired
	private MovieService movieService;
	
	@GetMapping("/seatReserve")
	public void seatList(String startTime, String endTime, String theaterId, String movieId, String movieName, int screenIn, String branchName, Model model) {
		ReserveSqlVO vo = new ReserveSqlVO(movieId, startTime, endTime, null, theaterId, 0, screenIn);
		LOGGER.info("seatList() 호출 : vo = " + vo);
		List<Integer> list = seatService.readSeat(vo);
		int[] seatNumList = new int[vo.getScreenIn()];
		for(int i = 0; i < seatNumList.length; i++) {
				seatNumList[i] = i + 1;
		}
		
		for(int i = 0; i < list.size(); i++) {
			for(int j = 0; j < seatNumList.length; j++) {
				if(list.get(i) == j + 1) {
					seatNumList[j] = 0;
				}
			}
		}
		
		model.addAttribute("branchName", branchName);
		model.addAttribute("seatNumList", seatNumList);
		model.addAttribute("reserveSqlVo", vo);
		model.addAttribute("movieName", movieName);
	}
	
	@GetMapping("/payment")
	public void credit(String movieName, Model model) {
		LOGGER.info("credit2() 호출");
		model.addAttribute("movieName", movieName);
	}
}
