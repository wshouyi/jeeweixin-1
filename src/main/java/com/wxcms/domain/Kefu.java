package com.wxcms.domain;

public class Kefu {
	private long id;
	private String kefuAccount;//完整客服账号
	private String kefuHeadImgurl;//客服头像
	private String kefuId;//客服工号
	private String kefuNick;//客服昵称
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getKefuAccount() {
		return kefuAccount;
	}
	public void setKefuAccount(String kefuAccount) {
		this.kefuAccount = kefuAccount;
	}
	public String getKefuHeadImgurl() {
		return kefuHeadImgurl;
	}
	public void setKefuHeadImgurl(String kefuHeadImgurl) {
		this.kefuHeadImgurl = kefuHeadImgurl;
	}
	public String getKefuId() {
		return kefuId;
	}
	public void setKefuId(String kefuId) {
		this.kefuId = kefuId;
	}
	public String getKefuNick() {
		return kefuNick;
	}
	public void setKefuNick(String kefuNick) {
		this.kefuNick = kefuNick;
	}
	

}
