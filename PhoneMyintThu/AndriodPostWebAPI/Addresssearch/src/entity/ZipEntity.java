package entity;

import java.util.List;

public class ZipEntity extends BaseEntity {
	private String requestZipNum;
	private String requestZipVersion;
	private String resultCode;
	private String resultZipNum;
	private String resultZipVersion;
	private String resultValuesCount;
	private List<ZipAddressEntity> zipAddressEntityLst;
	/**
	 * requestZipNumを取得します。
	 * @return requestZipNum
	 */
	public String getRequestZipNum() {
	    return requestZipNum;
	}
	/**
	 * requestZipNumを設定します。
	 * @param requestZipNum requestZipNum
	 */
	public void setRequestZipNum(String requestZipNum) {
	    this.requestZipNum = requestZipNum;
	}
	/**
	 * requestZipVersionを取得します。
	 * @return requestZipVersion
	 */
	public String getRequestZipVersion() {
	    return requestZipVersion;
	}
	/**
	 * requestZipVersionを設定します。
	 * @param requestZipVersion requestZipVersion
	 */
	public void setRequestZipVersion(String requestZipVersion) {
	    this.requestZipVersion = requestZipVersion;
	}
	/**
	 * resultCodeを取得します。
	 * @return resultCode
	 */
	public String getResultCode() {
	    return resultCode;
	}
	/**
	 * resultCodeを設定します。
	 * @param resultCode resultCode
	 */
	public void setResultCode(String resultCode) {
	    this.resultCode = resultCode;
	}
	/**
	 * resultZipNumを取得します。
	 * @return resultZipNum
	 */
	public String getResultZipNum() {
	    return resultZipNum;
	}
	/**
	 * resultZipNumを設定します。
	 * @param resultZipNum resultZipNum
	 */
	public void setResultZipNum(String resultZipNum) {
	    this.resultZipNum = resultZipNum;
	}
	/**
	 * resultZipVersionを取得します。
	 * @return resultZipVersion
	 */
	public String getResultZipVersion() {
	    return resultZipVersion;
	}
	/**
	 * resultZipVersionを設定します。
	 * @param resultZipVersion resultZipVersion
	 */
	public void setResultZipVersion(String resultZipVersion) {
	    this.resultZipVersion = resultZipVersion;
	}
	/**
	 * resultValuesCountを取得します。
	 * @return resultValuesCount
	 */
	public String getResultValuesCount() {
	    return resultValuesCount;
	}
	/**
	 * resultValuesCountを設定します。
	 * @param resultValuesCount resultValuesCount
	 */
	public void setResultValuesCount(String resultValuesCount) {
	    this.resultValuesCount = resultValuesCount;
	}
	/**
	 * zipAddressEntityLstを取得します。
	 * @return zipAddressEntityLst
	 */
	public List<ZipAddressEntity> getZipAddressEntityLst() {
	    return zipAddressEntityLst;
	}
	/**
	 * zipAddressEntityLstを設定します。
	 * @param zipAddressEntityLst zipAddressEntityLst
	 */
	public void setZipAddressEntityLst(List<ZipAddressEntity> zipAddressEntityLst) {
	    this.zipAddressEntityLst = zipAddressEntityLst;
	}
	
}
