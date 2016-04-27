package com.wxcms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.core.page.Pagination;
import com.wxcms.domain.AccountFans;
import com.wxcms.domain.Student;

public interface StudentDao {
	
	public Student getByStudentId(String studentId);
	
	public Student getByOpenId(String openId);
	
	public Integer getTotalCount(Student student);
	
	public List<Student> listClassStudent(@Param("classId")String classId,Pagination<Student> pagination);
	
	public List<Student> paginationStudent(Student student ,Pagination<Student> pagination);
	
	public Integer getCountByClass(String classId);
	
	public Student getLastOpenId();

	public void add(Student student);
	
	public void addList(List<Student> list);

	public void update(Student student);

	public void delete(Student student);

	public void deleteByOpenId(String openId);

}
