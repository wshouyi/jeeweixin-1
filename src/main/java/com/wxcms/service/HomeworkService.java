package com.wxcms.service;

import org.apache.ibatis.annotations.Param;

import com.core.page.Pagination;
import com.wxcms.domain.Homework;

public interface HomeworkService {

	public Homework getById(String id);
	
	public Homework getByOpenId(String openId);
	
	public Homework getByMsgId(String msgId);
		
	public Homework getLastOpenId();
	
	public Pagination<Homework> listHomeworkByDate(@Param("date")String date,Pagination<Homework> pagination);
	
	public Pagination<Homework> listStudentId(@Param("studentId")String studentId,Pagination<Homework> pagination);//按学号查询
	
	public Pagination<Homework> paginationEntity(Homework homework ,Pagination<Homework> pagination);
	
	public Integer getCountByDate(String date);
	
	public Integer getCountByStudentId(String studentId);
	
	public void sync(Homework homework);

	public void add(Homework homework);

	public void update(Homework homework);
	
	public void grade(Homework homework);

	public void delete(Homework homework);

	public void deleteByOpenId(String openId);
}
