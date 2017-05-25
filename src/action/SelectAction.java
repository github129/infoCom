/**
 *
 */
package com.internousdev.info.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.info.dao.ItemDAO;
import com.internousdev.info.dao.SiteDAO;
import com.internousdev.info.dto.ItemDTO;
import com.internousdev.info.dto.SiteDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 検索用のアクションクラス
 * @author BABATAKUMA
 *
 */
public class SelectAction extends ActionSupport {

	/**
	 * 商品検索リスト
	 */
	private ArrayList<ItemDTO> itemList=new ArrayList<>();

	/**
	 * サイト検索リスト
	 */
	private ArrayList<SiteDTO> siteList=new ArrayList<>();

	/**
	 * 検索ワード
	 */
	private String select;

	/**
	 * 商品メッセージ
	 */
	private String itemMsg;

	/**
	 * サイトメッセージ
	 */
	private String siteMsg;


	/**
	 *　実行メソッド
	 *成功ならSUCCESS　失敗ならERROR
	 *検索ワードがなければすべてのリストを出力する。
	 */
	public String execute() throws SQLException{

		SiteDAO siteDao=new SiteDAO();
		siteList=siteDao.siteNameSelect(select);

		ItemDAO itemDao=new ItemDAO();
		itemList=itemDao.selectItem(select);

		if(siteList.size()==0){
			siteMsg=select+"というサイトは登録されていません";
		}else{
			siteMsg=siteList.size()+"件見つかりました";
		}
		if(itemList.size()==0){
			itemMsg=select+"という商品は登録されていません";
		}else{
			itemMsg=itemList.size()+"件見つかりました";
		}
		return SUCCESS;
	}


	/**
	 * @return itemList
	 */
	public ArrayList<ItemDTO> getItemList() {
		return itemList;
	}


	/**
	 * @param itemList セットする itemList
	 */
	public void setItemList(ArrayList<ItemDTO> itemList) {
		this.itemList = itemList;
	}


	/**
	 * @return siteList
	 */
	public ArrayList<SiteDTO> getSiteList() {
		return siteList;
	}


	/**
	 * @param siteList セットする siteList
	 */
	public void setSiteList(ArrayList<SiteDTO> siteList) {
		this.siteList = siteList;
	}


	/**
	 * @return select
	 */
	public String getSelect() {
		return select;
	}


	/**
	 * @param select セットする select
	 */
	public void setSelect(String select) {
		this.select = select;
	}


	/**
	 * @return itemMsg
	 */
	public String getItemMsg() {
		return itemMsg;
	}


	/**
	 * @param itemMsg セットする itemMsg
	 */
	public void setItemMsg(String itemMsg) {
		this.itemMsg = itemMsg;
	}


	/**
	 * @return siteMsg
	 */
	public String getSiteMsg() {
		return siteMsg;
	}


	/**
	 * @param siteMsg セットする siteMsg
	 */
	public void setSiteMsg(String siteMsg) {
		this.siteMsg = siteMsg;
	}





}
