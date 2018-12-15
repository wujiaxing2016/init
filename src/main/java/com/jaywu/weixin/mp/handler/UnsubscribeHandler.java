package com.jaywu.weixin.mp.handler;

import java.util.Map;

import org.springframework.stereotype.Component;

import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

/**
 * @author wujiaxing
 */
@Component
public class UnsubscribeHandler extends AbstractHandler {

	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager sessionManager) {
		String openId = wxMessage.getFromUser();
		this.logger.info("取消关注用户 OPENID: " + openId);
		return null;
	}

}
