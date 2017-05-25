/**
 *
 */
package com.internousdev.info.action;

import java.util.ArrayList;

import com.internousdev.info.dao.ItemDAO;
import com.internousdev.info.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 商品情報を更新するアクションクラス
 * @author BABATAKUMA
 *@since 2017/5/5
 */
public class AdminItemUpdateAction extends ActionSupport{


	/**
	 * 情報の入ったリスト
	 */
	private ArrayList<ItemDTO> list=new ArrayList<>();

	/**
	 * メッセージ
	 */
	private String msg;

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
	 * 商品イメージ
	 */
	private String itemImg01 ="";

	/**
	 * 商品説明
	 */
	private String itemDetail01 ="";

	/**
	 * 詳細商品説明（必要であれば）
	 */
	private String itemDetail02 ="";

	/**
	 * ステータス（必要であれば）
	 */
	private String status ="";


	/**
	 * 実行メソッド
	 * @return 成功ならSUCCESS　失敗、IDの未入力ならERROR
	 */
	public String execute(){





		if(itemId==0 || itemName==null){
			return ERROR;
		}
		ItemDAO dao=new ItemDAO();
		int count=dao.update(itemId, level, itemName, itemImg01, itemDetail01, itemDetail02, status);
		if(count==0){
			msg="更新できませんでした";

			return ERROR;
		}

		msg=count+"件更新しました。";

		return SUCCESS;
	}


	/**
	 * @return list
	 */
	public ArrayList<ItemDTO> getList() {
		return list;
	}


	/**
	 * @param list セットする list
	 */
	public void setList(ArrayList<ItemDTO> list) {
		this.list = list;
	}


	/**
	 * @return msg
	 */
	public String getMsg() {
		return msg;
	}


	/**
	 * @param msg セットする msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
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
	 * @return itemName
	 */
	public String getItemName() {
		return itemName;
	}


	/**
	 * @param itemName セットする itemName
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	/**
	 * @return level
	 */
	public int getLevel() {
		return level;
	}


	/**
	 * @param level セットする level
	 */
	public void setLevel(int level) {
		this.level = level;
	}


	/**
	 * @return itemImg01
	 */
	public String getItemImg01() {
		return itemImg01;
	}


	/**
	 * @param itemImg01 セットする itemImg01
	 */
	public void setItemImg01(String itemImg01) {
		this.itemImg01 = itemImg01;
	}


	/**
	 * @return itemDetail01
	 */
	public String getItemDetail01() {
		return itemDetail01;
	}


	/**
	 * @param itemDetail01 セットする itemDetail01
	 */
	public void setItemDetail01(String itemDetail01) {
		this.itemDetail01 = itemDetail01;
	}


	/**
	 * @return itemDetail02
	 */
	public String getItemDetail02() {
		return itemDetail02;
	}


	/**
	 * @param itemDetail02 セットする itemDetail02
	 */
	public void setItemDetail02(String itemDetail02) {
		this.itemDetail02 = itemDetail02;
	}


	/**
	 * @return status
	 */
	public String getStatus() {
		return status;
	}


	/**
	 * @param status セットする status
	 */
	public void setStatus(String status) {
		this.status = status;
	}





}
