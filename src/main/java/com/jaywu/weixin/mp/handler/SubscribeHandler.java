package com.jaywu.weixin.mp.handler;

import java.util.Map;

import org.springframework.stereotype.Component;

import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

/**
 * @author wujiaxing
 */
@Component
public class SubscribeHandler extends AbstractHandler {

	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, //
			Map<String, Object> context, //
			WxMpService wxMpService, //
			WxSessionManager sessionManager) throws WxErrorException {

		// 获取微信用户基本信息
		WxMpUser wxMpUser = wxMpService.getUserService().userInfo(wxMessage.getFromUser(), null);

		// 处理特殊请求，比如用户是扫码进来的
		WxMpXmlOutMessage responseResult = null;
		try {
			responseResult = handleSpecial(wxMessage, wxMpUser, wxMpService);
		} catch (Exception e) {
			this.logger.error(e.getMessage(), e);
		}
		if (responseResult != null) {
			return responseResult;
		}
		return null;
	}

	/**
	 * 处理特殊请求，比如如果是扫码进来的，可以做相应处理
	 */
	protected WxMpXmlOutMessage handleSpecial(WxMpXmlMessage wxMessage, WxMpUser wxMpUser, WxMpService weixinService) throws Exception {
		System.out.println("=========handleSpecial方法已经执行=========");
		return null;
	}

}
