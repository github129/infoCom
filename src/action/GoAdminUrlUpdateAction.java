/**
 *
 */
package com.internousdev.info.action;

import java.util.ArrayList;

import com.internousdev.info.dao.UrlDAO;
import com.internousdev.info.dto.UrlDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * URLの更新画面へ遷移するアクションクラス
 * @author BABATAKUMAA
 *@since 2017/5/4
 */
public class GoAdminUrlUpdateAction extends ActionSupport{

	private ArrayList<UrlDTO> list=new ArrayList<>();



	public String execute(){

		UrlDAO dao=new UrlDAO();
		list=dao.allSelect();


		if(list.size()==0){
			return ERROR;
		}


		return SUCCESS;
	}



	/**
	 * @return list
	 */
	public ArrayList<UrlDTO> getList() {
		return list;
	}



	/**
	 * @param list セットする list
	 */
	public void setList(ArrayList<UrlDTO> list) {
		this.list = list;
	}


}
