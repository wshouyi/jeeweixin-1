package com.wxcms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.page.Pagination;
import com.wxcms.domain.Student;
import com.wxcms.mapper.StudentDao;
import com.wxcms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;
	
	public Student getByStudentId(String studentId){
		return studentDao.getByStudentId(studentId);
	}
	
	public Student getByOpenId(String openId){
		return studentDao.getByOpenId(openId);
	}
	
	public Student getLastOpenId(){
		return studentDao.getLastOpenId();
	}
	
	public Pagination<Student> listClassStudent(String classId,Pagination<Student> pagination){
		Integer totalClassCount = studentDao.getCountByClass(classId);		
		List<Student> items = studentDao.listClassStudent(classId,pagination);
		pagination.setTotalItemsCount(totalClassCount);
		pagination.setItems(items);
		return pagination;
	}
	
	public Pagination<Student> paginationStudent(Student student ,Pagination<Student> pagination){
		Integer totalItemsCount = studentDao.getTotalCount(student);
		List<Student> items = studentDao.paginationStudent(student,pagination);
		pagination.setTotalItemsCount(totalItemsCount);
		pagination.setItems(items);
		return pagination;
	}
	
	public Integer getCountByClass(String classId){
		return studentDao.getCountByClass(classId);
	}
	
	public void sync(Student student){
		Student lastStudent = studentDao.getLastOpenId();
		String lastOpenId = "";
		if(lastStudent != null){
			lastOpenId = lastStudent.getOpenId();
		}
	}

	public void add(Student student){
		studentDao.add(student);
	}

	public void update(Student student){
		studentDao.update(student);
	}

	public void delete(Student student){
		studentDao.delete(student);
	}

	public void deleteByOpenId(String openId){
		studentDao.deleteByOpenId(openId);
	}


}
