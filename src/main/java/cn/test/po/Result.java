package cn.test.po;

import java.io.Serializable;

/**
 * ͨ��ʵ����
 * 
 * @param <T>
 */
public class Result<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ״̬��Ĭ����ʧ��=false
	 */
	private boolean status = false;

	/**
	 * �����룬Ĭ����ʧ��=99���ɹ�=0
	 */
	private int errCode = 99;

	/**
	 * ������Ϣ
	 */
	private String errMsg = "";

	/**
	 * ���ؽ��ʵ��
	 */
	private T resultData;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getErrCode() {
		return errCode;
	}

	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public T getResultData() {
		return resultData;
	}

	public void setResultData(T resultData) {
		this.resultData = resultData;
	}

	@Override
	public String toString() {
		return "Result [status=" + status + ", errCode=" + errCode + ", errMsg=" + errMsg + ", resultData=" + resultData + "]";
	}
}
