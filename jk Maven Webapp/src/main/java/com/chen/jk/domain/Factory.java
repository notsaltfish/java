package com.chen.jk.domain;

import java.util.Date;

public class Factory {
	
	  /*FACTORY_ID           VARCHAR2(40)                    not null,
	   FULL_NAME            VARCHAR2(200),
	   FACTORY_NAME         VARCHAR2(50),
	   CONTACTS             VARCHAR2(30),
	   PHONE                VARCHAR2(20),
	   MOBILE               VARCHAR2(20),
	   FAX                  VARCHAR2(20),
	   NOTE                 VARCHAR2(1000),
	   INSPECTOR            VARCHAR2(30),
	   STATE                CHAR(1),
	   ORDER_NO             INT,
	   CREATE_BY            VARCHAR2(40),
	   CREATE_DEPT          VARCHAR2(40),
	   CREATE_TIME          TIMESTAMP,*/
	 private String id;
	 private String fullName;
	 private String factoryName;
	 private String contacts;
	 private String phone;
	 private String mobile;
	 private String fax;
	 private String note;
	 private String inspector;
	 private String state;
	 private String orderNo;
	 private String createBy;
	 private String  createDept;
	 private Date createDate;
	 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getFactoryName() {
		return factoryName;
	}
	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getInspector() {
		return inspector;
	}
	public void setInspector(String inspector) {
		this.inspector = inspector;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getCreateDept() {
		return createDept;
	}
	public void setCreateDept(String createDept) {
		this.createDept = createDept;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	 
		
	
}
