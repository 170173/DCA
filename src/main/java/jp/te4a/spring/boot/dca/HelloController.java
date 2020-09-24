package jp.te4a.spring.boot.dca;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("tests")
public class HelloController{
	@Autowired
	TestService testService;
	@ModelAttribute TestForm setUpForm() {
		return new TestForm();
	}

	@GetMapping String list(Model model) {
		model.addAttribute("tests", testService.findAll());
		return "tests/list";
	} 

	@PostMapping(path="create")
	String create(TestForm form, Model mode) {
		testService.create(form);
		return "redirect:/tests";
	}

	@PostMapping(path = "edit", params = "form")
	String editForm(@RequestParam Integer id, TestForm form) {
		TestForm testForm = testService.findOne(id);
		BeanUtils.copyProperties(testForm,  form);
		return "tests/edit";
	} 

	@PostMapping(path = "edit")
	String edit(@RequestParam Integer id, TestForm form) {
		testService.update(form);
		return "redirect:/tests"; 
	}

	@PostMapping(path = "delete")
	String delete(@RequestParam Integer id) {
		testService.delete(id);
		return "redirect:/tests";
	} 

	@PostMapping(path = "edit", params = "goToTop") 
	String goToTop() {
		return "redirect:/tests";
	}
}
