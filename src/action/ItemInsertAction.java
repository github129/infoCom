/**
 *
 */
package com.internousdev.info.action;

import com.internousdev.info.dao.ItemDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 商品を登録するアクションクラス
 * @author BABATAKUMA
 *
 */
public class ItemInsertAction extends ActionSupport{
	/**
	 * 商品名
	 */
	private String itemName;



	/**
	 * 実行メソッド
	 * @return 成功ならSUCCESS　商品名が未入力,失敗ならERROR
	 */
	public String execute(){

		if(itemName.length()==0){
			return ERROR;
		}

		ItemDAO dao =new ItemDAO();
		int count=dao.insert(itemName);

		if(count ==0){
			return ERROR;
		}

		return SUCCESS;

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


}
