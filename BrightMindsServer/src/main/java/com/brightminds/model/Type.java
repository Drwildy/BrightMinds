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

@Table(name = "type")
public class Type {
	
	@Id
	@GeneratedValue(generator ="type_id_seq_", strategy = GenerationType.AUTO)
	@SequenceGenerator(name="type_id_seq", allocationSize=1)
	@Column
	private int id;
	@Column
	private String type;
	@Column
	private int status; //0- to be deleted 1- created 9 - cancel
	@Column
	private Date CreatedAt;
	@Column
	private Date UpdatedAt;
	
	
	public Type() {
		super();
	}
	public Type(int typeId, String type, int status, Date createdAt, Date updatedAt) {
		super();
		this.id = typeId;
		this.type = type;
		this.status = status;
		CreatedAt = createdAt;
		UpdatedAt = updatedAt;
	}
	public int getTypeId() {
		return id;
	}
	public void setTypeId(int typeId) {
		this.id = typeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
		result = prime * result + status;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + id;
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
		Type other = (Type) obj;
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
		if (status != other.status)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Types [typeId=" + id + ", type=" + type + ", status=" + status + ", CreatedAt=" + CreatedAt
				+ ", UpdatedAt=" + UpdatedAt + "]";
	}
	
	
	
	
	
	
}
