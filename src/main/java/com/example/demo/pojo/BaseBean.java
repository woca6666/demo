package com.example.demo.pojo;


import com.example.demo.utils.DateFormatUtil;

public class BaseBean {

	// 主键
	private Integer id;

	// 创建人ID
	private Integer createUserId;

	// 创建人名称
	private String createUserName;

	// 创建时间
	private Integer createTime;

	// 更新时间
	private Integer updateTime;

	// 状态
	private Integer state;

	// 备注
	private String remark;

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	public Integer getCreateTime() {
		return createTime;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getState() {
		return state;
	}

	public void setUpdateTime(Integer updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getUpdateTime() {
		return updateTime;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

	public String getCreateTimeStr() {
		return createTime == null ? null : DateFormatUtil.transToString(createTime);
	}

	public String getShortCreateTimeStr() {
		return createTime == null ? null : DateFormatUtil.transToStringShort(createTime);
	}

	public String getUpdateTimeStr() {
		return updateTime == null ? null : DateFormatUtil.transToString(updateTime);
	}

	public String getShortUpdateTimeStr() {
		return updateTime == null ? null : DateFormatUtil.transToStringShort(updateTime);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
