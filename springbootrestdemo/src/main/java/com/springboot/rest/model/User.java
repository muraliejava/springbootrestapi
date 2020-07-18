package com.springboot.rest.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.Size;

/**
 * @author Murali
 *
 */
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public User() {

	}

	public User(Integer user_id, String applicationName, LocalDateTime createdTime, LocalDateTime updatedTime,
			String status) {
		super();
		this.user_id = user_id;
		this.applicationName = applicationName;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
		this.status = status;
	}

	@Size(min = 0, max = 7)
	private Integer user_id;
	@Size(min = 0, max = 10)
	private String applicationName;
	private LocalDateTime createdTime;
	private LocalDateTime updatedTime;
	private String status;

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public LocalDateTime getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(LocalDateTime updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", applicationName=" + applicationName + ",createdTime=" + createdTime
				+ ", updatedTime=" + updatedTime + ",status=" + status + ",  ]";
	}
}
