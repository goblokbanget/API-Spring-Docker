package com.adl.main.model;


import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="worker")
public class WorkerModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int workerId;
	private String firstName;
	private String glastName;
	private float salary;
	private String department;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime joiningDate;
	
}

