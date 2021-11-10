package com.adl.main.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.adl.main.model.WorkerModel;
import com.adl.main.model.WorkerSalaries;


@Repository
public interface WorkerRepository extends JpaRepository<WorkerModel, Integer> {
	@Query(value="select * from worker where worker_id = ?1", nativeQuery = true)
	WorkerModel getWorker(String worker);
	@Query(value="SELECT * FROM worker ORDER BY salary DESC LIMIT 5", nativeQuery = true)
	List<WorkerSalaries> getTopSalaries(String salary);
//	@Query(value="Select w1.first_name, w1.glast_name, w1.department, w1.salary From worker w1 Inner join worker w2 on w1.salary = w2.salary and w1.worker_id <> w2.worker_id and w1.worker_id > w2.worker_id", nativeQuery = true)
//	List<WorkerSalaries> getSameSalary(String department);
	@Query(value="Select * from worker where salary= ?1", nativeQuery = true)
	List<WorkerSalaries> getSameSalaries(String salary);
	@Query(value="select department, count(*) as total from worker group by department", nativeQuery = true)
	List<WorkerSalaries> getTotalDepartment(String total);
}
