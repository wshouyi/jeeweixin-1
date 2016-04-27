package com.wxcms.service;

import java.util.List;

import com.core.page.Pagination;
import com.wxcms.domain.Kefu;

public interface KefuService {

	public Kefu getById(String id);
	
	public Kefu getByKefuId(String kefuId);

	public List<Kefu> list(Kefu searchEntity);

	public Pagination<Kefu> paginationEntity(Kefu searchEntity,Pagination<Kefu> pagination);

	public Kefu getLastKefuId();
	
	public void sync(Kefu searchEntity);
	
	public void add(Kefu entity);

	public void update(Kefu entity);

	public void delete(Kefu entity);

	public void deleteByKefuId(String kefuId);

}
