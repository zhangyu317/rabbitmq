package com.zy.entity;

import java.io.Serializable;

public class Order implements Serializable{
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String name;
	
	/**
	 * messageId： 存储消息发送的唯一标识
	 */
	private String messageId;
	
	public Order() {
	}
	
	public Order(String id, String name, String messageId) {
		super();
		this.id = id;
		this.name = name;
		this.messageId = messageId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
}
