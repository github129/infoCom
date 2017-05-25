/**
 *
 */
package com.internousdev.info.dto;

/**
 * itemテーブルを扱うDTOクラス
 * @author BABATAKUMA
 * @since 2017/4/28
 *
 */
public class ItemDTO {

	/**
	 * 商品ID
	 */
	private int itemId;

	/**
	 * 商品名
	 */
	private String itemName;

	/**
	 * レベル
	 */
	private int level;

	/**
	 * 画像
	 */
	private String itemImg01;

	/**
	 * 詳細1
	 */
	private String itemDetail01;

	/**
	 * 詳細2
	 */
	private String itemDetail02;

	/**
	 * ステータス
	 */
	private String status;

	/**
	 * 商品IDを取得します。
	 * @return 商品ID
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * 商品IDを設定します。
	 * @param itemId 商品ID
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * 商品名を取得します。
	 * @return 商品名
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * 商品名を設定します。
	 * @param itemName 商品名
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * レベルを取得します。
	 * @return レベル
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * レベルを設定します。
	 * @param level レベル
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * 画像を取得します。
	 * @return 画像
	 */
	public String getItemImg01() {
		return itemImg01;
	}

	/**
	 * 画像を設定します。
	 * @param itemImg01 画像
	 */
	public void setItemImg01(String itemImg01) {
		this.itemImg01 = itemImg01;
	}

	/**
	 * 詳細1を取得します。
	 * @return 詳細1
	 */
	public String getItemDetail01() {
		return itemDetail01;
	}

	/**
	 * 詳細1を設定します。
	 * @param itemDetail01 詳細1
	 */
	public void setItemDetail01(String itemDetail01) {
		this.itemDetail01 = itemDetail01;
	}

	/**
	 * 詳細2を取得します。
	 * @return 詳細2
	 */
	public String getItemDetail02() {
		return itemDetail02;
	}

	/**
	 * 詳細2を設定します。
	 * @param itemDetail02 詳細2
	 */
	public void setItemDetail02(String itemDetail02) {
		this.itemDetail02 = itemDetail02;
	}

	/**
	 * ステータスを取得します。
	 * @return ステータス
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * ステータスを設定します。
	 * @param status ステータス
	 */
	public void setStatus(String status) {
		this.status = status;
	}



}
