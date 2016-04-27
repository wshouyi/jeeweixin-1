package com.wxcms.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.page.Pagination;
import com.wxcms.domain.Homework;
import com.wxcms.mapper.HomeworkDao;
import com.wxcms.service.HomeworkService;

@Service
public class HomeworkServiceImpl implements HomeworkService {
	
	@Autowired
	private HomeworkDao homeworkDao;

	@Override
	public Homework getById(String id) {
		return homeworkDao.getById(id);
	}

	@Override
	public Homework getByOpenId(String openId) {
		return homeworkDao.getByOpenId(openId);
	}

	@Override
	public Homework getByMsgId(String msgId) {
		return homeworkDao.getByMsgId(msgId);
	}
	
	@Override
	public Homework getLastOpenId() {
		return homeworkDao.getLastOpenId();
	}
	
	@Override
	public Pagination<Homework> listHomeworkByDate(String date,Pagination<Homework> pagination) {
		Integer totalClassCount = homeworkDao.getCountByDate(date);		
		List<Homework> items = homeworkDao.listHomeworkByDate(date,pagination);
		pagination.setTotalItemsCount(totalClassCount);
		pagination.setItems(items);
		return pagination;
	}

	@Override
	public Pagination<Homework> listStudentId(String studentId,
			Pagination<Homework> pagination) {
		Integer totalClassCount = homeworkDao.getCountByStudentId(studentId);		
		List<Homework> items = homeworkDao.listStudentId(studentId,pagination);
		pagination.setTotalItemsCount(totalClassCount);
		pagination.setItems(items);
		return pagination;
	}

	@Override
	public Pagination<Homework> paginationEntity(Homework homework,
			Pagination<Homework> pagination) {
		Integer totalClassCount = homeworkDao.getTotalCount(homework);		
		List<Homework> items = homeworkDao.paginationEntity(homework, pagination);
		pagination.setTotalItemsCount(totalClassCount);
		pagination.setItems(items);
		return pagination;
	}

	@Override
	public Integer getCountByDate(String date) {
		return homeworkDao.getCountByDate(date);
	}

	
	@Override
	public Integer getCountByStudentId(String studentId) {
		return homeworkDao.getCountByStudentId(studentId);
	}

	@Override
	public void sync(Homework homework) {
		Homework lastHomework = homeworkDao.getLastOpenId();
		String lastOpenId = "";
		if(lastHomework != null){
			lastOpenId = lastHomework.getOpenId();
		}
	}

	@Override
	public void add(Homework homework) {
		homeworkDao.add(homework);
	}

	public void grade(Homework homework ){
		homeworkDao.grade(homework);
	}

	
	@Override
	public void update(Homework homework) {
		homeworkDao.update(homework);
	}

	@Override
	public void delete(Homework homework) {
		homeworkDao.delete(homework);
	}

	@Override
	public void deleteByOpenId(String openId) {
		homeworkDao.deleteByOpenId(openId);
	}

}
