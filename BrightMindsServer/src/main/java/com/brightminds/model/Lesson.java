package com.brightminds.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity

@Table(name="lesson")
public class Lesson {
	@Id
	@GeneratedValue(generator="lesson_id_seq", strategy=GenerationType.AUTO)
	@SequenceGenerator(name="lesson_id_seq", allocationSize=1)
	@Column
	private int id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="user_id")
	private Unit unitId;
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
	
	@OneToOne
	@JoinTable(name = "student_lesson", 
	joinColumns= {@JoinColumn(name="student_id", referencedColumnName="id")},
	inverseJoinColumns= {@JoinColumn(name="lesson_id", referencedColumnName="id")})
	private Student student;

	public Lesson() {
		super();
	}

	public Lesson(int id, Unit unitId, int lessonNumber, String lessonName, String lessonUrl, int status,
			Date createdAt, Date updatedAt, Student student) {
		super();
		this.id = id;
		this.unitId = unitId;
		this.lessonNumber = lessonNumber;
		this.lessonName = lessonName;
		this.lessonUrl = lessonUrl;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Unit getUnitId() {
		return unitId;
	}

	public void setUnitId(Unit unitId) {
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + id;
		result = prime * result + ((lessonName == null) ? 0 : lessonName.hashCode());
		result = prime * result + lessonNumber;
		result = prime * result + ((lessonUrl == null) ? 0 : lessonUrl.hashCode());
		result = prime * result + status;
		result = prime * result + ((student == null) ? 0 : student.hashCode());
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
		Lesson other = (Lesson) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (id != other.id)
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
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
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
		return "Lesson [id=" + id + ", unitId=" + unitId + ", lessonNumber=" + lessonNumber + ", lessonName="
				+ lessonName + ", lessonUrl=" + lessonUrl + ", status=" + status + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", student=" + student + "]";
	}
	
	
}
