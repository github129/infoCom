/**
 *
 */
package com.internousdev.info.action;

import java.util.ArrayList;

import com.internousdev.info.dao.InfoDAO;
import com.internousdev.info.dao.UrlDAO;
import com.internousdev.info.dto.InfoDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * urlIDからそれに格納されているpriceを取得してくるアクションクラス
 * @author BABATAKUMA
 *@since 2017/4/27
 */
public class InfoGetAction extends ActionSupport {


	/**
	 * リスト
	 */
	private  ArrayList<InfoDTO> list =new ArrayList<>();


	/**
	 * 表示するリスト
	 */
	private ArrayList<InfoDTO> priceList=new ArrayList<>();

/**
 * urlID
 */
	private int urlId;

	/**
	 * 商品ID
	 */
	private int itemId;

	/**
	 * サイトID
	 */
	private int siteId;


	/**
	 * 実行メソッド
	 */
	public String execute(){

		/*
		 *商品IDかサイトIDの取得ができていなかっだ場合はERROR
		 */
		if(itemId==0 ||siteId==0 ){
			return ERROR;
		}


		UrlDAO urlDao=new UrlDAO();
		urlId=urlDao.urlSelect(itemId, siteId);
		
		if(urlId==0){
			return ERROR;
		}

		InfoDAO dao=new InfoDAO();

		list=dao.priceSelect(urlId);

		if(list.size()==0){
			return ERROR;
		}

		for(int i=0;i<list.size();i++){
			priceList.add(list.get(i));
			if(i==6){
				break;
			}
		}


		return SUCCESS;
	}

	/**
	 * @return list
	 */
	public ArrayList<InfoDTO> getList() {
		return list;
	}

	/**
	 * @param list セットする list
	 */
	public void setList(ArrayList<InfoDTO> list) {
		this.list = list;
	}

	/**
	 * @return priceList
	 */
	public ArrayList<InfoDTO> getPriceList() {
		return priceList;
	}

	/**
	 * @param priceList セットする priceList
	 */
	public void setPriceList(ArrayList<InfoDTO> priceList) {
		this.priceList = priceList;
	}

	/**
	 * @return urlId
	 */
	public int getUrlId() {
		return urlId;
	}

	/**
	 * @param urlId セットする urlId
	 */
	public void setUrlId(int urlId) {
		this.urlId = urlId;
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





}
