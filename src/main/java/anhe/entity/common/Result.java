package anhe.entity.common;

import java.io.Serializable;

/**
 * 结果信息
 * 
 * @author 文浩
 *
 */
public class Result implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private Boolean flag;
	private Object date;

	public Result(String message, Boolean flag) {
		this.message = message;
		this.flag = flag;
	}

	public Object getDate() {
		return date;
	}

	public void setDate(Object date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

}
