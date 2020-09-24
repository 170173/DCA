package jp.te4a.spring.boot.dca;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

@Repository
public class TestRepository {
	private final ConcurrentMap<Integer, TestBean> testMap = new ConcurrentHashMap<>();
	private int TEST_ID = 1;
	public int getTestId() {
		return TEST_ID++;
	}

	
	public TestBean create(TestBean testBean) {
		return testMap.put(testBean.getId(), testBean);
		}
	
	public TestBean update(TestBean updateTestBean) {
		TestBean testBean = testMap.get(updateTestBean.getId());
		BeanUtils.copyProperties(updateTestBean, testBean);
		return testBean;
	}
	
	public void delete(Integer testId) {
		testMap.remove(testId);
		}
	
	public List<TestBean>findAll() {
		return new ArrayList<>(testMap.values()); 
		}
	
	public TestBean findOne(Integer id) {
		return testMap.get(id);
		}

}