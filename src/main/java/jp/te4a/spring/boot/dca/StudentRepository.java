package jp.te4a.spring.boot.dca;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class StudentRepository {
	
	private final ConcurrentMap<String,StudentBean>studentMap
		= new ConcurrentHashMap<>();
	
	public StudentBean save(StudentBean studentBean) {
		return studentMap.put(studentBean.getS_id(), studentBean);
	}
	
	public void delete(String studentId) {
		studentMap.remove(studentId);
	}
	
	public List<StudentBean> findAll(){
		return new ArrayList<>(studentMap.values());
	}
	
}
