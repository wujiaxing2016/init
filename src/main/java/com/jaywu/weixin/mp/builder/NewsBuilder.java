package com.jaywu.weixin.mp.builder;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutNewsMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutNewsMessage.Item;

/**
 * @author wujiaxing
 * @email 470021508@qq.com
 * @date Oct 23, 2018
 */
public class NewsBuilder extends AbstractBuilder {

	@Override
	public WxMpXmlOutMessage build(String content, WxMpXmlMessage wxMessage, WxMpService service) {
		Item item = new Item();
		WxMpXmlOutNewsMessage message = WxMpXmlOutMessage.NEWS()//
				.addArticle(item)//
				.fromUser(wxMessage.getToUser())//
				.toUser(wxMessage.getFromUser()).build();
		return message;
	}

}
