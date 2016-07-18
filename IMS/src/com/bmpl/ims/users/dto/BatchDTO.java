package com.bmpl.ims.users.dto;

import java.util.Date;

public class BatchDTO {
	
	private String batchname;
	private String coursename;
	private int totalsets;
	private String trainername;
	private String description;
	private String batchstartdate;
	public String getBatchname() {
		return batchname;
	}
	public void setBatchname(String batchname) {
		this.batchname = batchname;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public int getTotalsets() {
		return totalsets;
	}
	public void setTotalsets(int totalsets) {
		this.totalsets = totalsets;
	}
	public String getTrainername() {
		return trainername;
	}
	public void setTrainername(String trainername) {
		this.trainername = trainername;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBatchstartdate() {
		return batchstartdate;
	}
	public void setBatchstartdate(String batchstartdate) {
		this.batchstartdate = batchstartdate;
	}
	
}
