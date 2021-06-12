package goott.spring.project1.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import goott.spring.project1.domain.BranchVO;
import goott.spring.project1.domain.ReserveSqlVO;
import goott.spring.project1.service.BranchService;
import goott.spring.project1.service.ScreenDateService;

@RestController
@RequestMapping(value = "/reserves")
public class ReserveRESTController {
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(ReviewRESTController.class);
	
	@Autowired
	BranchService branchService;
	
	@Autowired
	ScreenDateService screenDateService;
	
	@GetMapping("/{branchCity}")
	public ResponseEntity<List<BranchVO>> selectBranch(
			@PathVariable("branchCity") String branchCity
			) {
		LOGGER.info("selectBranch() 호출 : branchCity = " + branchCity);
		List<BranchVO> branchList = branchService.readBranch(branchCity);
		return new ResponseEntity<List<BranchVO>>(branchList, HttpStatus.OK);
	}
	
	@GetMapping("/date/{branchId}")
	public ResponseEntity<List<ReserveSqlVO>> selectDate(
			@PathVariable("branchId") String branchId,
			String screenDate, String movieId
			){
		LOGGER.info("selectDate() 호출 : branchCity");
		HashMap<String, String> reserveSqlMap = new HashMap<String, String>();
		reserveSqlMap.put("branchId", branchId);
		reserveSqlMap.put("screenDate", screenDate);
		reserveSqlMap.put("movieId", movieId);
		List<ReserveSqlVO> list = screenDateService.readReserveItem(reserveSqlMap);
		return new ResponseEntity<List<ReserveSqlVO>>(list, HttpStatus.OK);
	}
}
