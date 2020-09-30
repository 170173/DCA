package jp.te4a.spring.boot.dca.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.te4a.spring.boot.dca.bean.TestBean;
import jp.te4a.spring.boot.dca.form.TestForm;
import jp.te4a.spring.boot.dca.repository.TestRepository;

@Service
public class TestService {

	@Autowired 
	TestRepository testRepository;

	public TestForm create(TestForm testForm) {
		  TestBean testBean = new TestBean();
		  BeanUtils.copyProperties(testForm, testBean);
		  testRepository.save(testBean);
		  return testForm;
		}


	public TestForm update(TestForm testForm) {
		  TestBean testBean = new TestBean();
		  BeanUtils.copyProperties(testForm, testBean);
		  testRepository.save(testBean);
		  return testForm;
		}


	public void delete(Integer id) {
		TestBean testBean = new TestBean();
		testBean.setId(id);
		testRepository.delete(testBean);
	}

	public List<TestForm> findAll() {
		List<TestBean> beanList = testRepository.findAll();
		List<TestForm> formList = new ArrayList<TestForm>();
		for(TestBean testBean: beanList){ 
			TestForm testForm = new TestForm();
			BeanUtils.copyProperties(testBean, testForm);
			formList.add(testForm); 
		} 
		return formList;
	}

	public TestForm findOne(Integer id) {
		Optional<TestBean> testBean = testRepository.findById(id);
		TestForm testForm = new TestForm();
		BeanUtils.copyProperties(testBean, testForm);
		return testForm;
	}
}
