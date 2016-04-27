package com.wxcms.service;

import com.core.page.Pagination;
import com.wxcms.domain.Student;

public interface StudentService {

	public Student getByStudentId(String studentId);
	
	public Student getByOpenId(String openId);
		
	public Student getLastOpenId();
	
	public Pagination<Student> listClassStudent(String classId,Pagination<Student> pagination);
	
	public Pagination<Student> paginationStudent(Student student ,Pagination<Student> pagination);
	
	public Integer getCountByClass(String classId);
	
	public void sync(Student student);

	public void add(Student student);

	public void update(Student student);

	public void delete(Student student);

	public void deleteByOpenId(String openId);

}
