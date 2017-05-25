
package com.internousdev.info.dto;

/**
 * infoテーブルを扱うDTOクラス
 * @author BABATAKUMA
 *@since 2017/4/27
 */
public class InfoDTO {

	/**
	 * サイトId
	 */
	private int siteId;

	/**
	 * 商品Id
	 */
	private int itemId;

	/**
	 * urlId
	 */
	private int urlId;

	/**
	 * 価格
	 */
	private int price;

	/**
	 * url
	 */
	private String url;

	/**
	 * 更新回数
	 */
	private  int updateCount;

	/**
	 * メモ
	 */
	private String memo;

	/**
	 * 削除フラグ
	 */
	private boolean deleteFlg;

	/**
	 * 登録日
	 */
	private String registrationDate;

	/**
	 * 更新日
	 */
	private String updatedDate;

	/**
	 * サイトIdを取得します。
	 * @return サイトId
	 */
	public int getSiteId() {
		return siteId;
	}

	/**
	 * サイトIdを設定します。
	 * @param siteId サイトId
	 */
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	/**
	 * 商品Idを取得します。
	 * @return 商品Id
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * 商品Idを設定します。
	 * @param itemId 商品Id
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * urlIdを取得します。
	 * @return urlId
	 */
	public int getUrlId() {
		return urlId;
	}

	/**
	 * urlIdを設定します。
	 * @param urlId urlId
	 */
	public void setUrlId(int urlId) {
		this.urlId = urlId;
	}

	/**
	 * 価格を取得します。
	 * @return 価格
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * 価格を設定します。
	 * @param price 価格
	 */
	public void setPrice(int price) {
		this.price = price;
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
	 * 更新回数を取得します。
	 * @return 更新回数
	 */
	public int getUpdateCount() {
		return updateCount;
	}

	/**
	 * 更新回数を設定します。
	 * @param updateCount 更新回数
	 */
	public void setUpdateCount(int updateCount) {
		this.updateCount = updateCount;
	}

	/**
	 * メモを取得します。
	 * @return メモ
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * メモを設定します。
	 * @param memo メモ
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * 削除フラグを取得します。
	 * @return 削除フラグ
	 */
	public boolean isDeleteFlg() {
		return deleteFlg;
	}

	/**
	 * 削除フラグを設定します。
	 * @param deleteFlg 削除フラグ
	 */
	public void setDeleteFlg(boolean deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	/**
	 * 登録日を取得します。
	 * @return 登録日
	 */
	public String getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * 登録日を設定します。
	 * @param registrationDate 登録日
	 */
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	/**
	 * 更新日を取得します。
	 * @return 更新日
	 */
	public String getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * 更新日を設定します。
	 * @param updatedDate 更新日
	 */
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}


}
