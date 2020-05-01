package com.brightminds.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity

@Table(name="Unit")
public class Unit {
	
	@Id
	@GeneratedValue(generator = "unit_id_seq", strategy=GenerationType.AUTO)
	@SequenceGenerator(name="unit_id_seq", allocationSize=1)
	@Column
	private int id;
	@ManyToOne
	private int courseId;
	@Column
	private String unitName;
	@Column
	private int unitNumber; //let us know what will be the sequence of the units example 1 -> 100
	@Column
	private int status;
	@Column
	private Date createdAt;
	@Column
	private Date updatedAt;
	
	public Unit() {
		super();
	}

	public Unit(int unitId, int courseId, String unitName, int unitNumber, int status, Date createdAt,
			Date updatedAt) {
		super();
		this.id = unitId;
		this.courseId = courseId;
		this.unitName = unitName;
		this.unitNumber = unitNumber;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public int getUnitId() {
		return id;
	}

	public void setUnitId(int unitId) {
		this.id = unitId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public int getUnitNumber() {
		return unitNumber;
	}

	public void setUnitNumber(int unitNumber) {
		this.unitNumber = unitNumber;
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
		result = prime * result + courseId;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + status;
		result = prime * result + id;
		result = prime * result + ((unitName == null) ? 0 : unitName.hashCode());
		result = prime * result + unitNumber;
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
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
		Unit other = (Unit) obj;
		if (courseId != other.courseId)
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (status != other.status)
			return false;
		if (id != other.id)
			return false;
		if (unitName == null) {
			if (other.unitName != null)
				return false;
		} else if (!unitName.equals(other.unitName))
			return false;
		if (unitNumber != other.unitNumber)
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Units [unitId=" + id + ", courseId=" + courseId + ", unitName=" + unitName + ", unitNumber="
				+ unitNumber + ", status=" + status + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
	
}
