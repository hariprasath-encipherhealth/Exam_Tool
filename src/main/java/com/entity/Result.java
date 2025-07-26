package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Resulttable")
public class Result {

	@Id
	@NotNull
	@Column(name = "resultid")
	private String resultid;

	@NotNull
	@Column(name = "examid")
	private String examid;   // used for insert/update

	@NotNull
	@Column(name = "studid")
	private String studid;   // used for insert/update

	@Column(name = "marks")
	private String marks;

	@Column(name = "totalmarks")
	private String totalmarks;

	@Column(name = "exstatus")
	private String exstatus;

	// ---- Relationships (read-only) ----
	@ManyToOne
	@JoinColumn(name = "studid", insertable = false, updatable = false)
	private Student student;

	@ManyToOne
	@JoinColumn(name = "examid", insertable = false, updatable = false)
	private Exam exam;

	// ---- Getters and Setters ----
	public String getResultid() {
		return resultid;
	}

	public void setResultid(String resultid) {
		this.resultid = resultid;
	}

	public String getExamid() {
		return examid;
	}

	public void setExamid(String examid) {
		this.examid = examid;
	}

	public String getStudid() {
		return studid;
	}

	public void setStudid(String studid) {
		this.studid = studid;
	}

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

	public String getTotalmarks() {
		return totalmarks;
	}

	public void setTotalmarks(String totalmarks) {
		this.totalmarks = totalmarks;
	}

	public String getExstatus() {
		return exstatus;
	}

	public void setExstatus(String exstatus) {
		this.exstatus = exstatus;
	}

	public Student getStudent() {
		return student;
	}

	public Exam getExam() {
		return exam;
	}

	public Result(String resultid, String examid, String studid, String marks, String totalmarks, String exstatus) {
		this.resultid = resultid;
		this.examid = examid;
		this.studid = studid;
		this.marks = marks;
		this.totalmarks = totalmarks;
		this.exstatus = exstatus;
	}

	public Result() {
	}
}
