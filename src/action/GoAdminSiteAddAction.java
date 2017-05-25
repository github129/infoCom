/**
 *
 */
package com.internousdev.info.action;

import java.util.ArrayList;

import com.internousdev.info.dao.SiteDAO;
import com.internousdev.info.dto.SiteDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 *　サイト登録画面へ遷移するアクションクラス
 * @author BABATAKUMA
 *@since 2017/5/3
 */
public class GoAdminSiteAddAction extends ActionSupport{


	private ArrayList<SiteDTO> list=new ArrayList<>();

	private String msg;

	public String execute(){

		SiteDAO dao=new SiteDAO();
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
	public ArrayList<SiteDTO> getList() {
		return list;
	}

	/**
	 * @param list セットする list
	 */
	public void setList(ArrayList<SiteDTO> list) {
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
