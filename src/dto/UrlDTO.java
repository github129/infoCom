
package com.internousdev.info.dto;

/**
 * urlテーブルの情報を扱うDTOクラス
 * @author BABATAKUMA
 * @since 2017/4/27
 *
 */
public class UrlDTO {

	/**
	 * url
	 */
	private String url;


	/**
	 * urlID
	 */
	private int urlId;

	/**
	 * パス
	 */
	private int pass;
	/**
	 * 商品ID
	 */
	private int itemId;
	/**
	 * サイトID
	 */
	private int siteId;




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
	 * @return itemId
	 */
	public int getItemId() {
		return itemId;
	}


	/**
	 * @param itemId セットする itemId
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


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
	 * urlを取得します。
	 * @return url
	 */
	public String getUrl() {
		return url;
	}


	/**
	 * urlを設定します。
	 * @param url url
	 */
	public void setUrl(String url) {
		this.url = url;
	}


	/**
	 * urlIDを取得します。
	 * @return urlID
	 */
	public int getUrlId() {
		return urlId;
	}


	/**
	 * urlIDを設定します。
	 * @param urlId urlID
	 */
	public void setUrlId(int urlId) {
		this.urlId = urlId;
	}



}
