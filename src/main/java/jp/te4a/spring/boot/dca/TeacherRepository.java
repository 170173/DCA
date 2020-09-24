package jp.te4a.spring.boot.dca;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TeacherRepository {
	private final ConcurrentMap<String,TeacherBean>teacherMap
		= new ConcurrentHashMap<>();
	
	public TeacherBean save(TeacherBean teacherBean) {
		return teacherMap.put(teacherBean.getT_id(), teacherBean);
	}
	
	public void delete(String teacherId) {
		teacherMap.remove(teacherId);
	}
	
	public List<TeacherBean> findAll(){
		return new ArrayList<>(teacherMap.values());
	}

}
