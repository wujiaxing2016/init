package com.jaywu.modular.test.entity;

import com.jaywu.base.mp.extension.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 微信小程序用户表
 * </p>
 *
 * @author Jay Wu
 * @since 2018-12-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class WechatMaUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 微信唯一识别码
     */
    private String openid;

    /**
     * 用户的昵称
     */
    private String nickname;

    /**
     * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     */
    private Integer gender;

    /**
     * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
     */
    private String avatar;

    /**
     * 国家，如中国为CN
     */
    private String country;

    /**
     * 省份
     */
    private String province;

    /**
     * 普通用户个人资料填写的城市
     */
    private String city;

    /**
     * 显示语言
     */
    private String language;

    /**
     * 微信appid
     */
    private String appid;

    /**
     * 用户在开放平台的唯一标识符
     */
    private String unionid;

    /**
     * 微信的sessionKey
     */
    private String sessionKey;

    /**
     * 手机号码
     */
    private String phoneNumber;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 更新者
     */
    private String updateBy;


}
