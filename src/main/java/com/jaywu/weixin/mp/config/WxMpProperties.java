package com.jaywu.weixin.mp.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.alibaba.fastjson.JSONObject;

import lombok.Data;

/**
 * <p>
 * </p>
 *
 * @author wujiaxing
 * @email jiaxing.wu@qq.com
 * @since 2018-12-15
 */
@Data
@ConfigurationProperties(prefix = "wx.mp")
public class WxMpProperties {
    private List<MpConfig> configs;

    @Data
    public static class MpConfig {
        /**
         * 设置微信公众号的appid
         */
        private String appId;

        /**
         * 设置微信公众号的app secret
         */
        private String secret;

        /**
         * 设置微信公众号的token
         */
        private String token;

        /**
         * 设置微信公众号的EncodingAESKey
         */
        private String aesKey;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
