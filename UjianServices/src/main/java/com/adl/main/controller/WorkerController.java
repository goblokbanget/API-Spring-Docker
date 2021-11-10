package com.adl.main.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adl.main.model.WorkerModel;
import com.adl.main.model.WorkerSalaries;
import com.adl.main.repository.WorkerRepository;

@RestController
public class WorkerController {

	@Autowired
	WorkerRepository workerRepo;

	@GetMapping("/worker") // shows
	public List<WorkerModel> getAllWorker() {
		List<WorkerModel> lstWorker = workerRepo.findAll();
		return lstWorker;
	}

	@GetMapping("/worker/salaries") // shows top 5 salaries
	public ResponseEntity<String> getTopSalaries() {
		List<WorkerSalaries> lstSalaries = workerRepo.getTopSalaries("");
		JSONArray list = new JSONArray();

		for (WorkerSalaries WorkerModel : lstSalaries) {
			JSONObject obj = new JSONObject();
			obj.put("first_name", WorkerModel.getfirst_name());
			obj.put("glast_name", WorkerModel.getglast_name());
			obj.put("department", WorkerModel.getdepartment());
			obj.put("salary", WorkerModel.getsalary());

			list.put(obj);

		}

		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(list.toString());

	}

	@GetMapping("/worker/specific") //show specific salaries and worker in it
	public ResponseEntity<String> getSameSalary(@RequestParam(value = "salary") String salary) {
		List<WorkerSalaries> lstSalaries = workerRepo.getSameSalaries(salary);
		JSONArray list = new JSONArray();

		for (WorkerSalaries WorkerModel : lstSalaries) {
			JSONObject obj = new JSONObject();
			obj.put("first_name", WorkerModel.getfirst_name());
			obj.put("glast_name", WorkerModel.getglast_name());
			obj.put("department", WorkerModel.getdepartment());
			obj.put("salary", WorkerModel.getsalary());
			list.put(obj);

		}

		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(list.toString());
 
	}

	@GetMapping("/worker/department/total") //shows total each department has
	public ResponseEntity<String> getTotalDepartment() {
		List<WorkerSalaries> lstSalaries = workerRepo.getTotalDepartment("");
		JSONArray list = new JSONArray();

		for (WorkerSalaries WorkerModel : lstSalaries) {
			JSONObject obj = new JSONObject();
			obj.put("department", WorkerModel.getdepartment());
			obj.put("total worker", WorkerModel.gettotal());
			list.put(obj);

		}

		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(list.toString());

	}

	@PostMapping("/worker/add") // single
	public WorkerModel saveWorker(@RequestBody WorkerModel worker) {
		return workerRepo.save(worker);
	}

	@PostMapping("/worker/adds") // many
	public List<WorkerModel> saveWorkers(@RequestBody List<WorkerModel> worker) {
		return workerRepo.saveAll(worker);
	}

	@DeleteMapping("/worker/delete") // delete
	public String deletePlayer(@RequestParam("id") int id) {
		workerRepo.deleteById(id);
		return "deleted";
	}

	@PutMapping("/worker/update")
	public WorkerModel updateWorker(@RequestBody WorkerModel worker) {

		return workerRepo.save(worker);
	}

}
