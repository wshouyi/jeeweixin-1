package com.wxcms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.core.page.Pagination;
import com.wxcms.domain.Homework;

public interface HomeworkDao {
	
	public Homework getById(String id);
	
	public Homework getByOpenId(String openId);
	
	public Homework getByMsgId(String msgId);
	
	public Integer getTotalCount(Homework homework);
	
	public List<Homework> listHomeworkByDate(@Param("date")String date,Pagination<Homework> pagination);//按时间查询
	
	public List<Homework> listStudentId(@Param("studentId")String studentId,Pagination<Homework> pagination);//按学号查询
	
	public List<Homework> paginationEntity(Homework homework ,Pagination<Homework> pagination);
	
	public Integer getCountByDate(String date);
	
	public Integer getCountByStudentId(String studentId);
	
	public Homework getLastOpenId();

	public void add(Homework homework);
	
	public void addList(List<Homework> list);
	
	public void grade(Homework homework);

	public void update(Homework homework);

	public void delete(Homework homework);

	public void deleteByOpenId(String openId);


}
