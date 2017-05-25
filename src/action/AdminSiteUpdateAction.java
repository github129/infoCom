/**
 *
 */
package com.internousdev.info.action;

import com.internousdev.info.dao.SiteDAO;
import com.internousdev.info.dao.UrlDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * サイト情報を更新するアクションクラス
 * @author BABATAKUMA
 * @since 2017/5/5
 *
 */
public class AdminSiteUpdateAction extends ActionSupport {

	/**
	 * サイト名
	 */
	private String siteName;
	/**
	 * パス
	 */
	private int pass;
	/**
	 * サイトID
	 */
	private int siteId;

	/**
	 * メッセージ
	 */
	private String msg ;

	/**
	 * 実行メソッド
	 * 成功ならSUCCESS　失敗、入力ミスならERROR
	 */
	public String execute(){

		if(siteName==null || siteId==0){
			return ERROR;
		}

		SiteDAO dao=new SiteDAO();
		int count =dao.siteUpdate(siteName, siteId, pass);

		UrlDAO urlDao=new UrlDAO();
		count =urlDao.urlUpdate(siteId, pass);


		msg=count+"件の情報を更新しました";

		return SUCCESS;
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
