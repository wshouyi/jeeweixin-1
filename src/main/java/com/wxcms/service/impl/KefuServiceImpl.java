package com.wxcms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.page.Pagination;
import com.wxcms.domain.Kefu;
import com.wxcms.mapper.KefuDao;
import com.wxcms.service.KefuService;

@Service
public class KefuServiceImpl implements KefuService {
	
	@Autowired
	private KefuDao kefuDao;

	@Override
	public Kefu getById(String id) {
		return kefuDao.getById(id);
	}

	@Override
	public Kefu getByKefuId(String kefuId) {
		
		return kefuDao.getByKefuId(kefuId);
	}

	@Override
	public List<Kefu> list(Kefu searchEntity) {
		
		return kefuDao.list(searchEntity);
	}

	@Override
	public Pagination<Kefu> paginationEntity(Kefu searchEntity,
			Pagination<Kefu> pagination) {
		Integer totalItemsCount = kefuDao.getTotalItemsCount(searchEntity);
		List<Kefu> items = kefuDao.paginationEntity(searchEntity,pagination);
		pagination.setTotalItemsCount(totalItemsCount);
		pagination.setItems(items);
		return pagination;
	}

	@Override
	public Kefu getLastKefuId() {
		
		return kefuDao.getLastKefuId();
	}

	@Override
	public void sync(Kefu searchEntity) {
		Kefu lastKefu = kefuDao.getLastKefuId();
		String lastOpenId = "";
		if(lastKefu != null){
			lastOpenId = lastKefu.getKefuId();
		}

	}

	@Override
	public void add(Kefu entity) {
		kefuDao.add(entity);
	}

	@Override
	public void update(Kefu entity) {
		kefuDao.update(entity);

	}

	@Override
	public void delete(Kefu entity) {
		kefuDao.delete(entity);

	}

	@Override
	public void deleteByKefuId(String kefuId) {
		kefuDao.deleteByKefuId(kefuId);

	}

}
