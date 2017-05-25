/**
 *
 */
package com.internousdev.info.action;

import java.util.ArrayList;

import com.internousdev.info.dao.UrlDAO;
import com.internousdev.info.dto.UrlDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Url登録画面へ遷移するアクションクラス
 * @author BABATAKUMA
 *
 */
public class GoAdminUrlAddAction extends ActionSupport{


	private	ArrayList<UrlDTO> list=new ArrayList<>();

	private String msg;

	public String execute(){

		UrlDAO dao = new UrlDAO();

		list=dao.allSelect();

		if(list.size()==0){
			msg="まだ登録されていません";
		}else{
			msg=list.size()+"件登録されています。";
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
