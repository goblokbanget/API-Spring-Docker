package com.adl.main.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="position")
public class PositionModel {
	@Id
	@GeneratedValue
	private String id;
	private String aWorkerTitle;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime bAffectedFrom;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="workerRefId",referencedColumnName = "workerId")
	private WorkerModel workerid;
}
