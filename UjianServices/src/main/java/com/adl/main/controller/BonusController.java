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

import com.adl.main.model.BonusModel;

import com.adl.main.repository.BonusRepository;

@RestController
public class BonusController {
	@Autowired
	BonusRepository bonusRepo;

	@GetMapping("/bonus") // shows
	public List<BonusModel> getAllWorker() {
		List<BonusModel> lstBonus = bonusRepo.findAll();
		return lstBonus;
	}

	@PostMapping("/bonus/add") // single
	public BonusModel saveWorker(@RequestBody BonusModel worker) {
		return bonusRepo.save(worker);
	}

	@PostMapping("/bonus/adds") // many
	public List<BonusModel> saveWorkers(@RequestBody List<BonusModel> worker) {
		return bonusRepo.saveAll(worker);
	}

	@DeleteMapping("/bonus/delete") // delete
	public String deletePlayer(@RequestParam("id") int id) {
		bonusRepo.deleteById(id);
		return "deleted";
	}

	@PutMapping("/bonus/update")
	public BonusModel updateWorker(@RequestBody BonusModel worker) {
		return bonusRepo.save(worker);
	}
}
