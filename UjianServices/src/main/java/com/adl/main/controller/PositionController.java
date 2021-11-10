package com.adl.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adl.main.model.PositionModel;
import com.adl.main.repository.PositionRepository;

@RestController
public class PositionController {
	@Autowired
	PositionRepository positionRepo;

	@GetMapping("/position") // shows
	public List<PositionModel> getAllWorker() {
		List<PositionModel> lstPosition = positionRepo.findAll();
		return lstPosition;
	}

	@PostMapping("/position/add") // single
	public PositionModel saveWorker(@RequestBody PositionModel worker) {
		return positionRepo.save(worker);
	}

	@PostMapping("/position/adds") // many
	public List<PositionModel> saveWorkers(@RequestBody List<PositionModel> worker) {
		return positionRepo.saveAll(worker);
	}

	@DeleteMapping("/position/delete") // delete
	public String deletePlayer(@RequestParam("id") int id) {
		positionRepo.deleteById(id);
		return "deleted";
	}

	@PutMapping("/position/update")
	public PositionModel updateWorker(@RequestBody PositionModel worker) {
		return positionRepo.save(worker);
	}
}
