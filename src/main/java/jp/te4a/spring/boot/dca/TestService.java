package jp.te4a.spring.boot.dca;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	
	
	 @Autowired 
	TestRepository testRepository;
		public TestForm create(TestForm testForm) {
			testForm.setId(testRepository.getTestId());
			TestBean testBean = new TestBean();
			BeanUtils.copyProperties(testForm, testBean);
			testRepository.create(testBean);
			return testForm;
		}
		
		public TestForm update(TestForm testForm){
			TestBean testBean = new TestBean();
			BeanUtils.copyProperties(testForm, testBean);
			testRepository.update(testBean);
			return testForm;
			}
		
		public void delete(Integer id) {
			testRepository.delete(id);
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
			TestBean testBean = testRepository.findOne(id);
			TestForm testForm = new TestForm();
			BeanUtils.copyProperties(testBean, testForm);
			return testForm;
			}
}
