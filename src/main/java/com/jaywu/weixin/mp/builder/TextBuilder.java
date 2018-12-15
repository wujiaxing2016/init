package com.jaywu.weixin.mp.builder;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutTextMessage;

/**
 * @author wujiaxing
 */
public class TextBuilder extends AbstractBuilder {

	@Override
	public WxMpXmlOutMessage build(String content, WxMpXmlMessage wxMessage, WxMpService service) {
		WxMpXmlOutTextMessage message = WxMpXmlOutMessage.TEXT()//
				.content(content)//
				.fromUser(wxMessage.getToUser())//
				.toUser(wxMessage.getFromUser()).build();
		return message;
	}

}
