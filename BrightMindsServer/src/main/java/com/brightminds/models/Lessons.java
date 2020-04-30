package com.brightminds.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity

@Table(name="Lessons")
public class Lessons {
	@Id
	@GeneratedValue(generator="lesson_id_seq", strategy=GenerationType.AUTO)
	@SequenceGenerator(name="lesson_id_seq", allocationSize=1)
	@Column
	private int lessonId;
	//JOIN TABLE DEFINITION
//	@JoinTable(name="lessons_students", 
//	 joinColumns = {@JoinColumn(name="lesson_lessonId")}, 
//	 inverseJoinColumns = {@JoinColumn(name="students_studenstId")})
//	@JoinColumn
//	private Set<Students> Students; //default is lazy loading as it's a collection!
	@ManyToOne
	private Units unitId;
	@Column
	private int lessonNumber;
	@Column
	private String lessonName;
	@Column
	private String lessonUrl;
	@Column
	private int status;
	@Column
	private Date createdAt;
	@Column
	private Date updatedAt;
	
	public Lessons() {
		super();
	}

	public Lessons(int lessonId, Units unitId, int lessonNumber, String lessonName, String lessonUrl, int status,
			Date createdAt, Date updatedAt) {
		super();
		this.lessonId = lessonId;
		this.unitId = unitId;
		this.lessonNumber = lessonNumber;
		this.lessonName = lessonName;
		this.lessonUrl = lessonUrl;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public int getLessonId() {
		return lessonId;
	}

	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}

	public Units getUnitId() {
		return unitId;
	}

	public void setUnitId(Units unitId) {
		this.unitId = unitId;
	}

	public int getLessonNumber() {
		return lessonNumber;
	}

	public void setLessonNumber(int lessonNumber) {
		this.lessonNumber = lessonNumber;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public String getLessonUrl() {
		return lessonUrl;
	}

	public void setLessonUrl(String lessonUrl) {
		this.lessonUrl = lessonUrl;
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
		result = prime * result + lessonId;
		result = prime * result + ((lessonName == null) ? 0 : lessonName.hashCode());
		result = prime * result + lessonNumber;
		result = prime * result + ((lessonUrl == null) ? 0 : lessonUrl.hashCode());
		result = prime * result + status;
		result = prime * result + ((unitId == null) ? 0 : unitId.hashCode());
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
		Lessons other = (Lessons) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (lessonId != other.lessonId)
			return false;
		if (lessonName == null) {
			if (other.lessonName != null)
				return false;
		} else if (!lessonName.equals(other.lessonName))
			return false;
		if (lessonNumber != other.lessonNumber)
			return false;
		if (lessonUrl == null) {
			if (other.lessonUrl != null)
				return false;
		} else if (!lessonUrl.equals(other.lessonUrl))
			return false;
		if (status != other.status)
			return false;
		if (unitId == null) {
			if (other.unitId != null)
				return false;
		} else if (!unitId.equals(other.unitId))
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
		return "Lessons [lessonId=" + lessonId + ", unitId=" + unitId + ", lessonNumber=" + lessonNumber
				+ ", lessonName=" + lessonName + ", lessonUrl=" + lessonUrl + ", status=" + status + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}
		
}
