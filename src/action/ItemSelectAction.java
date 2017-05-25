
package com.internousdev.info.action;

import java.util.ArrayList;

import com.internousdev.info.dao.ItemDAO;
import com.internousdev.info.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 *商品情報を取得するクラス
 * @author BABATAKUMA
 *
 */
public class ItemSelectAction extends ActionSupport{

	/**
	 * 商品ID
	 */
	private int itemId;

	/**
	 * 商品情報の入ったリスト
	 */
	private ArrayList<ItemDTO> list=new ArrayList<>();


	/**
	 * 実行メソッド
	 * @return 成功ならSUCCESS　失敗、未入力ならERROR
	 */
	public String execute(){

		ItemDAO dao=new ItemDAO();

		list=dao.itemSelect(itemId);
		if(list.size()==0){
			return ERROR;
		}


		return SUCCESS;
	}


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
	 * 商品情報の入ったリストを取得します。
	 * @return 商品情報の入ったリスト
	 */
	public ArrayList<ItemDTO> getList() {
		return list;
	}


	/**
	 * 商品情報の入ったリストを設定します。
	 * @param list 商品情報の入ったリスト
	 */
	public void setList(ArrayList<ItemDTO> list) {
		this.list = list;
	}




}
