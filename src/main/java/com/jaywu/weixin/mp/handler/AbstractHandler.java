package com.jaywu.weixin.mp.handler;

import com.google.gson.Gson;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wujiaxing
 */
public abstract class AbstractHandler implements WxMpMessageHandler {

	protected final Gson gson = new Gson();
	protected Logger logger = LoggerFactory.getLogger(getClass());

}
