/**
 *
 */
package com.internousdev.info.action;

import java.sql.SQLException;

import com.internousdev.info.dao.UrlDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * URLを更新するアクションクラス
 * @author BABATAKUMA
 * @since 2017/5/5
 *
 */
public class AdminUrlUpdateAction extends ActionSupport {

	/**
	 * url
	 */
	private String url;

	/**
	 * パス
	 */
	private int pass;

	/**
	 * サイトID
	 */
	private int siteId;
	/**
	 * 商品ID
	 */
	private int itemId;

	/**
	 * URLID
	 */
	private int urlId;
	/**
	 * メッセージ
	 */
	private String msg;

	/**
	 * 実行メソッド
	 * 成功ならSUCCESS　失敗、URLの未入力ならERROR
	 * @throws SQLException
	 */
	public String execute() throws SQLException{

		if(url==null){
			return ERROR;
		}
		UrlDAO dao=new UrlDAO();
		int count=dao.update(url, pass, siteId, itemId, urlId);
		if(count==0){
		msg="更新できませんでした";
			return ERROR;
		}
		msg=count+"件更新しました";

		return SUCCESS;
	}

	/**
	 * @return url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url セットする url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return pass
	 */
	public int getPass() {
		return pass;
	}

	/**
	 * @param pass セットする pass
	 */
	public void setPass(int pass) {
		this.pass = pass;
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
