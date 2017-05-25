/**
 *
 */
package com.internousdev.info.action;

import java.util.ArrayList;

import com.internousdev.info.dao.ItemDAO;
import com.internousdev.info.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 商品登録画面へ遷移するアクションクラス
 * @author BABATAKUMA
 * @since 2017/5/3
 *
 */
public class GoAdminItemAddAction extends ActionSupport
{

	private ArrayList<ItemDTO> list=new ArrayList<>();


	private String msg;

	/**
	 * 実行メソッド
	 */
	public String execute(){


		ItemDAO dao =new ItemDAO();
		list=dao.allSelect();

		if(list.size() == 0){
			msg="まだ登録されていません";
		}else{
			msg=list.size()+"件登録されています。";
		}

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




}
