package com.jaywu.weixin.mp.builder;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutImageMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

/**
 * @author Jay Wu
 */
public class ImageBuilder extends AbstractBuilder {

	@Override
	public WxMpXmlOutMessage build(String content, WxMpXmlMessage wxMessage, WxMpService service) {
		WxMpXmlOutImageMessage message = WxMpXmlOutMessage.IMAGE()//
				.mediaId(content) //
				.fromUser(wxMessage.getToUser())//
				.toUser(wxMessage.getFromUser()).build();
		return message;
	}

}
