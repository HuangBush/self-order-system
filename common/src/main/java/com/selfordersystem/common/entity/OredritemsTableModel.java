package com.selfordersystem.common.entity;

import java.util.List;

public class OredritemsTableModel {
	int code;
	String message;
	int count;
	List<Orderitems> data;
	public OredritemsTableModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OredritemsTableModel(int code, String message, int count,
			List<Orderitems> data) {
		super();
		this.code = code;
		this.message = message;
		this.count = count;
		this.data = data;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<Orderitems> getData() {
		return data;
	}
	public void setData(List<Orderitems> data) {
		this.data = data;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
		result = prime * result + count;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OredritemsTableModel other = (OredritemsTableModel) obj;
		if (code != other.code)
			return false;
		if (count != other.count)
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OredritemsTableModel [code=" + code + ", message=" + message
				+ ", count=" + count + ", data=" + data + "]";
	}
	

}
