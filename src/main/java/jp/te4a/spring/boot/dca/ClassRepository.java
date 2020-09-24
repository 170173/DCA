package jp.te4a.spring.boot.dca;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public class ClassRepository {
	private final ConcurrentMap<String, ClassBean> classMap 
	= new ConcurrentHashMap<>();
	
	public ClassBean save(ClassBean classbean) {
		return classMap.put(classbean.getC_id(), classbean);
	}
	
	public void delete(String classId) {
		classMap.remove(classId);
	}
	
	public List<ClassBean> findAll(){
		return new ArrayList<>(classMap.values());
	}
}
