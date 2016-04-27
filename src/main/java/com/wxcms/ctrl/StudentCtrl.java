package com.wxcms.ctrl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.core.page.Pagination;
import com.wxcms.domain.Student;
import com.wxcms.service.StudentService;


@Controller
@RequestMapping("/student")
public class StudentCtrl {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/getByStudentId")
	public ModelAndView getByStudentId(String id){
		studentService.getByStudentId(id);
		return new ModelAndView();
	}

	@RequestMapping(value = "/list")
	public  ModelAndView list(Student student){
		ModelAndView mv = new ModelAndView("wxcms/paginationStudent");
		return mv;
	}
	
	@RequestMapping(value = "/classStudent")
	public  ModelAndView classStudent(String classId,Pagination<Student> pagination){
		ModelAndView mv = new ModelAndView("wxcms/studentPagination");
		pagination = studentService.listClassStudent(classId,pagination);
		mv.addObject("pagination",pagination);
		mv.addObject("cur_nav","student");
		return mv;
	}

	@RequestMapping(value = "/paginationStudent")
	public  ModelAndView paginationStudent(Student student, Pagination<Student> pagination){
		ModelAndView mv = new ModelAndView("wxcms/studentPagination");
		pagination = studentService.paginationStudent(student,pagination);
		mv.addObject("pagination",pagination);
		mv.addObject("cur_nav","student");
		return mv;
	}
	
	@RequestMapping(value = "/toMerge")
	public ModelAndView toMerge(Student student){

		return new ModelAndView();
	}

	@RequestMapping(value = "/merge")
	public ModelAndView doMerge(Student student){
		studentService.add(student);
		return new ModelAndView();
	}
	
	@RequestMapping(value = "/update")
	public ModelAndView update(Student student){
		studentService.update(student);
		return new ModelAndView("redirect:/student/paginationStudent.html");
	}

	@RequestMapping(value = "/delete")
	public ModelAndView delete(Student student){
		studentService.delete(student);
		return new ModelAndView("redirect:/student/paginationStudent.html");
	}




}
