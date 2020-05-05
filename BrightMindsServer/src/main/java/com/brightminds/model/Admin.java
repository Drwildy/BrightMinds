package com.brightminds.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity

@Table(name = "admin")
public class Admin {
	
	@Id
	@GeneratedValue(generator ="admin_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name="admin_id_seq", allocationSize=1)
	@Column
	private int id;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "users_id")
	private User userid;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private int status; //0- to be deleted 1- created 9 - cancel
	@Column
	private Date CreatedAt;
	@Column
	private Date UpdatedAt;
	
	public Admin() {
		super();
	}
	public Admin(int id, User userId, String firstName, String lastName, int status, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.userid = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.status = status;
		CreatedAt = createdAt;
		UpdatedAt = updatedAt;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUserId() {
		return userid;
	}
	public void setUserId(User userId) {
		this.userid = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreatedAt() {
		return CreatedAt;
	}
	public void setCreatedAt(Date createdAt) {
		CreatedAt = createdAt;
	}
	public Date getUpdatedAt() {
		return UpdatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		UpdatedAt = updatedAt;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CreatedAt == null) ? 0 : CreatedAt.hashCode());
		result = prime * result + ((UpdatedAt == null) ? 0 : UpdatedAt.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + status;
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
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
		Admin other = (Admin) obj;
		if (CreatedAt == null) {
			if (other.CreatedAt != null)
				return false;
		} else if (!CreatedAt.equals(other.CreatedAt))
			return false;
		if (UpdatedAt == null) {
			if (other.UpdatedAt != null)
				return false;
		} else if (!UpdatedAt.equals(other.UpdatedAt))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (status != other.status)
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", userId=" + userid + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", status=" + status + ", CreatedAt=" + CreatedAt + ", UpdatedAt=" + UpdatedAt + "]";
	}
	
}
