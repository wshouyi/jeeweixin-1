package com.wxcms.mapper;

import java.util.List;

import com.core.page.Pagination;
import com.wxcms.domain.Kefu;

public interface KefuDao {
	
	public Kefu getById(String id);

	public Kefu getByKefuId(String kefuId);
	
	public List<Kefu> list(Kefu searchEntity);

	public Integer getTotalItemsCount(Kefu searchEntity);
	
	public List<Kefu> paginationEntity(Kefu searchEntity ,Pagination<Kefu> pagination);

	public Kefu getLastKefuId();
	
	public void add(Kefu entity);
	
	public void addList(List<Kefu> list);

	public void update(Kefu entity);

	public void delete(Kefu entity);

	public void deleteByKefuId(String kefuId);

	
}
