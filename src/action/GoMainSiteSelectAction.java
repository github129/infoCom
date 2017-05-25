/**
 *
 */
package com.internousdev.info.action;

import java.util.ArrayList;

import com.internousdev.info.dao.SiteDAO;
import com.internousdev.info.dto.SiteDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * サイト選択画面へ遷移するためのアクションクラス
 * @author BABATAKUMA
 *
 */
public class GoMainSiteSelectAction extends ActionSupport {




	/**
	 * 商品ID
	 */
	private int itemId;
	/**
	 * サイトID
	 */
	private int siteId;

	/**
	 * 商品名
	 */
	private String itemName;

	/**
	 * サイト名
	 */
	private String siteName;

	/**
	 * メッセージ
	 */
	private String msg;


	/**
	 * リスト
	 */
	private ArrayList<SiteDTO> list=new ArrayList<>();

	public String execute(){

		SiteDAO dao=new SiteDAO();

		list=dao.allSelect();
		if(list.size()==0){
			msg="サイトが登録されていません";
		}


		return SUCCESS;
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
	 * @return siteId
	 */
	public int getSiteId() {
		return siteId;
	}

	/**
	 * @param siteId セットする siteId
	 */
	public void setSiteId(int siteId) {
		this.siteId = siteId;
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
	 * @return siteName
	 */
	public String getSiteName() {
		return siteName;
	}

	/**
	 * @param siteName セットする siteName
	 */
	public void setSiteName(String siteName) {
		this.siteName = siteName;
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
