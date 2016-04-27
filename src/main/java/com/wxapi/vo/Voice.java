package com.wxapi.vo;

/**
 * 语音消息
 * 
 * 
 */
public class Voice {
	private String MediaId;
	private String Format;
	private String Recognition;

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}

	public String getRecognition() {
		return Recognition;
	}

	public void setRecognition(String recognition) {
		Recognition = recognition;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
}
