package net.abc.model;

import java.io.Serializable;

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 * @param <T>
 */
public class ResultMap<T> implements Serializable {

	private static final long serialVersionUID = -6162240726324772880L;

	private T data;
	private String msg;
	private String code;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 检测数据有效性
	 * 
	 * @return
	 */
	public boolean isValid() {
		return true;
	}

}
