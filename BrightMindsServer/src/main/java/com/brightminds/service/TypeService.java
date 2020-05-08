package com.brightminds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brightminds.model.Type;
import com.brightminds.repository.TypeRepository;

@Service("typeService")
public class TypeService {
	
	@Autowired
	private TypeRepository typeRepository;
	
	// used for constructor injection
	public  TypeService() {}
	
	public void setTypeRepository( TypeRepository  typeRepository) {
		this.typeRepository = typeRepository;
	}
	
	public Type getById(int typeId) {
		return this.typeRepository.getById(typeId);
	}

}
