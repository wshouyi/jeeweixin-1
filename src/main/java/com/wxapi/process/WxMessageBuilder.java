package com.wxapi.process;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.wxapi.vo.Article;
import com.wxapi.vo.MsgRequest;
import com.wxapi.vo.MsgResponse;
import com.wxapi.vo.MsgResponseNews;
import com.wxapi.vo.MsgResponseText;
import com.wxapi.vo.MsgResponseTransInfo;
import com.wxapi.vo.TransInfo;
import com.wxcms.domain.MsgNews;
import com.wxcms.domain.MsgText;

/**
 * 消息builder工具类
 */
public class WxMessageBuilder {
	
	//客服文本消息
	public static String prepareCustomText(String openid,String content){
		JSONObject jsObj = new JSONObject();
		jsObj.put("touser", openid);
		jsObj.put("msgtype", MsgType.Text.name());
		JSONObject textObj = new JSONObject();
		textObj.put("content", content);
		jsObj.put("text", textObj);
		return jsObj.toString();
	}
	
	//获取 MsgResponseText 对象
	public static MsgResponseText getMsgResponseText(MsgRequest msgRequest,MsgText msgText){
		if(msgText != null){
			MsgResponseText reponseText = new MsgResponseText();
			reponseText.setToUserName(msgRequest.getFromUserName());
			reponseText.setFromUserName(msgRequest.getToUserName());
			reponseText.setMsgType(MsgType.Text.toString());
			reponseText.setCreateTime(new Date().getTime());
			reponseText.setContent(msgText.getContent());
			return reponseText;
		}else{
			return null;
		}
	}
	
	//获取 MsgResponseNews 对象
	public static MsgResponseNews getMsgResponseNews(MsgRequest msgRequest,List<MsgNews> msgNews){
		if(msgNews != null && msgNews.size() > 0){
			MsgResponseNews responseNews = new MsgResponseNews();
			responseNews.setToUserName(msgRequest.getFromUserName());
			responseNews.setFromUserName(msgRequest.getToUserName());
			responseNews.setMsgType(MsgType.News.toString());
			responseNews.setCreateTime(new Date().getTime());
			responseNews.setArticleCount(msgNews.size());
			List<Article> articles = new ArrayList<Article>(msgNews.size());
			for(MsgNews n : msgNews){
				Article a = new Article();
				a.setTitle(n.getTitle());
				a.setPicUrl(n.getPicpath());
				if(StringUtils.isEmpty(n.getFromurl())){
					a.setUrl(n.getUrl());
				}else{
					a.setUrl(n.getFromurl());
				}
				a.setDescription(n.getBrief());
				articles.add(a);
			}
			responseNews.setArticles(articles);
			return responseNews;
		}else{
			return null;
		}
	}
	
	//转发到客服
	public static MsgResponse getMsgResponse(MsgRequest msgRequest){
			MsgResponse response = new MsgResponse();
			response.setToUserName(msgRequest.getFromUserName());
			response.setFromUserName(msgRequest.getToUserName());
			response.setMsgType(MsgType.TRANSFER.toString());
			response.setCreateTime(new Date().getTime());
			return response;
	}
	
	//转发到作业客服
	public static MsgResponseTransInfo getMsgResponseTransInfo(MsgRequest msgRequest,String kfAccount){
		MsgResponseTransInfo response = new MsgResponseTransInfo();
		TransInfo transInfo = new TransInfo();
		transInfo.setKfAccount(kfAccount); //作业客服账号
		response.setToUserName(msgRequest.getFromUserName());
		response.setFromUserName(msgRequest.getToUserName());
		response.setMsgType(MsgType.TRANSFER.toString());
		response.setTransInfo(transInfo);
		response.setCreateTime(new Date().getTime());
		return response;
}
	
}
