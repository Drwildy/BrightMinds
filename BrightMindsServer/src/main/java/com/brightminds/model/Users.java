package com.brightminds.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity

@Table(name = "users")

public class Users {

	@Id
	@GeneratedValue(generator = "user_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "user_id_seq", allocationSize = 1)
	@Column
	private int userid;
	@Column
	private int typeid;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private int status;
	@Column
	private Date createdAt;
	@Column
	private Date updatedAt;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(int userid, int typeid, String username, String password, int status, Date createdAt, Date updatedAt) {
		super();
		this.userid = userid;
		this.typeid = typeid;
		this.username = username;
		this.password = password;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + status;
		result = prime * result + typeid;
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
		result = prime * result + userid;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (status != other.status)
			return false;
		if (typeid != other.typeid)
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		if (userid != other.userid)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Users [userid=" + userid + ", typeid=" + typeid + ", username=" + username + ", password=" + password
				+ ", status=" + status + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
