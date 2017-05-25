/**
 *
 */
package com.internousdev.info.dto;

/**
 * サイト情報を扱うDTOクラス
 * @author BABATAKUMA
 *@since 2017/5/3
 */
public class SiteDTO {

	/**
	 * サイトID
	 */
	private int siteId;

	/**
	 * パス
	 */
	private int pass;


	/**
	 * サイト名
	 */
	private String siteName;

	/**
	 * @return siteId
	 */
	public int getSiteId() {
		return siteId;
	}

	/**
	 * @param siteId セットする siteId
	 */
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	/**
	 * @return pass
	 */
	public int getPass() {
		return pass;
	}

	/**
	 * @param pass セットする pass
	 */
	public void setPass(int pass) {
		this.pass = pass;
	}

	/**
	 * @return siteName
	 */
	public String getSiteName() {
		return siteName;
	}

	/**
	 * @param siteName セットする siteName
	 */
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}


}
