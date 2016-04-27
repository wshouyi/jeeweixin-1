package com.wxcms.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.core.page.Pagination;
import com.wxcms.domain.Homework;
import com.wxcms.service.HomeworkService;

@Controller
@RequestMapping("/homework")
public class HomeworkCtrl {

	@Autowired
	private HomeworkService homeworkService;
	
	@RequestMapping(value = "/getById")
	public ModelAndView getById(String id){
		homeworkService.getById(id);
		return new ModelAndView();
	}

	@RequestMapping(value = "/getByOpenId")
	public ModelAndView getByOpenId(String openId){
		Homework homework = homeworkService.getByOpenId(openId);
		ModelAndView mv = new ModelAndView("wxcms/homeworkInfo");
		mv.addObject("homework",homework);
		mv.addObject("cur_nav","homework");
		return mv;
	}
	
	@RequestMapping(value = "/getByMsgId")
	public ModelAndView getByMsgId(String msgId){
		Homework homework = homeworkService.getByMsgId(msgId);
		ModelAndView mv = new ModelAndView("wxcms/homeworkInfo");
		mv.addObject("homework",homework);
		mv.addObject("cur_nav","homework");
		return mv;
	}
	
	@RequestMapping(value = "/list")
	public  ModelAndView list(Homework homework){
		ModelAndView mv = new ModelAndView("wxcms/paginationEntity");
		return mv;
	}
	
	@RequestMapping(value = "/searchHomework")
	public  ModelAndView searchHomework(String studentId,String date,Pagination<Homework> pagination){
		if("" != studentId){
			return listStudentId( studentId, pagination);
		}else if("" != date){
			return listHomeworkByDate(date,pagination);
		}else{
			return new ModelAndView("redirect:/homework/paginationEntity.html");
		}
	}
	
	@RequestMapping(value = "/homeworkByDate")
	public  ModelAndView listHomeworkByDate(String date,Pagination<Homework> pagination){
		ModelAndView mv = new ModelAndView("wxcms/homeworkPagination");
		pagination = homeworkService.listHomeworkByDate(date, pagination);
		mv.addObject("pagination",pagination);
		mv.addObject("cur_nav","homework");
		return mv;

	}
	
	@RequestMapping(value = "/homeworkByStudentId")
	public  ModelAndView listStudentId(String studentId,Pagination<Homework> pagination){
		ModelAndView mv = new ModelAndView("wxcms/homeworkPagination");
		pagination = homeworkService.listStudentId(studentId, pagination);
		mv.addObject("pagination",pagination);
		mv.addObject("cur_nav","homework");
		return mv;
	}

	@RequestMapping(value = "/paginationEntity")
	public  ModelAndView paginationEntity(Homework homework, Pagination<Homework> pagination){
		ModelAndView mv = new ModelAndView("wxcms/homeworkPagination");
		pagination = homeworkService.paginationEntity(homework,pagination);
		mv.addObject("pagination",pagination);
		mv.addObject("cur_nav","homework");
		return mv;
	}
	
	@RequestMapping(value = "/toMerge")
	public ModelAndView toMerge(Homework homework){

		return new ModelAndView();
	}

	@RequestMapping(value = "/merge")
	public ModelAndView doMerge(Homework homework){
		homeworkService.add(homework);
		return new ModelAndView();
	}
	
	@RequestMapping(value = "/update")
	public ModelAndView update(Homework homework){
		homeworkService.update(homework);
		return new ModelAndView("redirect:/homework/paginationEntity.html");
	}
	
	@RequestMapping(value = "/grade")
	public ModelAndView grade(Homework homework){
		homeworkService.grade(homework);
		return new ModelAndView("redirect:/homework/paginationEntity.html");
	}

	@RequestMapping(value = "/delete")
	public ModelAndView delete(Homework homework){
		homeworkService.delete(homework);
		return new ModelAndView("redirect:/homework/paginationEntity.html");
	}
}
