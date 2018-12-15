package com.jaywu.weixin.mp.handler;

import java.util.Map;

import org.springframework.stereotype.Component;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

/**
 * @author wujiaxing
 */
@Component
public class MenuHandler extends AbstractHandler {
	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService weixinService, WxSessionManager sessionManager) {
		String msgType = wxMessage.getMsgType();
		String event = wxMessage.getEvent();
		String eventKey = wxMessage.getEventKey();
		logger.info("type:%s, event:%s, key:%s", msgType, event, eventKey);
		if (WxConsts.MenuButtonType.VIEW.equals(event)) {
			return null;
		}

		return null;
	}

}
