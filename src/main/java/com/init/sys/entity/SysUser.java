package com.init.sys.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.init.base.mp.extension.DataEntity;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author JayWu
 * @since 2018-08-24
 */
@TableName("sys_user")
public class SysUser extends DataEntity<SysUser> {

	private static final long serialVersionUID = 1L;

	/**
	 * 登录名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 归属部门
	 */
	@TableField("office_id")
	private String officeId;

	/**
	 * 工号
	 */
	private String number;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 电话
	 */
	private String phone;

	/**
	 * 用户头像
	 */
	private String avatar;

	/**
	 * 最后登陆IP
	 */
	@TableField("login_ip")
	private String loginIp;

	/**
	 * 最后登陆时间
	 */
	@TableField("login_at")
	private LocalDateTime loginAt;

	/**
	 * 备注信息
	 */
	private String remark;

	/**
	 * 删除标记
	 */
	@TableField("is_delete")
	private Integer isDelete;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOfficeId() {
		return officeId;
	}

	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public LocalDateTime getLoginAt() {
		return loginAt;
	}

	public void setLoginAt(LocalDateTime loginAt) {
		this.loginAt = loginAt;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "SysUser{" + "id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", officeId=" + officeId + ", number=" + number + ", email=" + email + ", phone=" + phone + ", avatar=" + avatar + ", loginIp=" + loginIp + ", loginAt=" + loginAt + ", createAt=" + createAt + ", updateAt=" + updateAt + ", remark=" + remark + ", isDelete=" + isDelete + "}";
	}
}
