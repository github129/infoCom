/**
 *
 */
package com.internousdev.info.action;

import java.util.ArrayList;

import com.internousdev.info.dao.ItemDAO;
import com.internousdev.info.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 更新画面へ遷移するアクション
 * @author BABATAKUMA
 *@since 2017/5/4
 */
public class GoAdminItemUpdateAction extends ActionSupport {


	/**
	 *全商品のリスト
	 */
	private ArrayList<ItemDTO> list=new ArrayList<>();


	/**
	 * 実行メソッド
	 *　成功ならSUCCESS 失敗ならERROR
	 */
	public String execute(){

		ItemDAO dao=new ItemDAO();

		list=dao.allSelect();
		if(list.size()==0){
			return ERROR;
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

}
