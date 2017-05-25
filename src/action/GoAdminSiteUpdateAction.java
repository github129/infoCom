/**
 *
 */
package com.internousdev.info.action;

import java.util.ArrayList;

import com.internousdev.info.dao.SiteDAO;
import com.internousdev.info.dto.SiteDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * サイト更新画面へ遷移するアクションクラス
 * @author BABATAKUMA
 *@since 2017/5/4
 */
public class GoAdminSiteUpdateAction extends ActionSupport {



	private ArrayList<SiteDTO> list=new ArrayList<>();

	public String execute(){

		SiteDAO dao=new SiteDAO();
		list=dao.allSelect();

		if(list.size()==0){
			return ERROR;
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

}
