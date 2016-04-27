package com.wxcms.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.core.page.Pagination;
import com.wxcms.domain.Kefu;
import com.wxcms.service.KefuService;

@Controller
@RequestMapping("/kefu")
public class KefuCtrl {

	@Autowired
	private KefuService entityService;

	@RequestMapping(value = "/getById")
	public ModelAndView getById(String id) {
		entityService.getById(id);
		return new ModelAndView();
	}

	@RequestMapping(value = "/list")
	public ModelAndView list(Kefu searchEntity) {
		ModelAndView mv = new ModelAndView("wxcms/paginationEntity");
		return mv;
	}

	@RequestMapping(value = "/paginationEntity")
	public ModelAndView paginationEntity(Kefu searchEntity,Pagination<Kefu> pagination) {
		ModelAndView mv = new ModelAndView("wxcms/kefuList");
		pagination = entityService.paginationEntity(searchEntity, pagination);
		mv.addObject("pagination", pagination);
		mv.addObject("cur_nav", "kefu");
		return mv;
	}

	@RequestMapping(value = "/toMerge")
	public ModelAndView toMerge(Kefu entity) {

		return new ModelAndView();
	}

	@RequestMapping(value = "/merge")
	public ModelAndView doMerge(Kefu entity) {
		entityService.add(entity);
		return new ModelAndView();
	}

	@RequestMapping(value = "/delete")
	public ModelAndView delete(Kefu entity) {
		entityService.delete(entity);
		return new ModelAndView();
	}

}
