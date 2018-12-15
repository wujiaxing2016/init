package com.jaywu.weixin.mp.handler;

import java.util.Map;

import org.springframework.stereotype.Component;

import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

/**
 * <p>
 * 扫码Handler
 * </p>
 *
 * @author wujiaxing
 * @email jiaxing.wu@qq.com
 * @since 2018-12-15
 */
@Component
public class ScanHandler extends AbstractHandler {

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> map,
                                    WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {
        // 扫码事件处理
        return null;
    }
}
