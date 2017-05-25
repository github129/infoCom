/**
 *
 */
package com.internousdev.info.action;

import com.internousdev.info.dao.SiteDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * サイトを登録するためのアクションクラス
 * @author BABATAKUMA
 * @since 2017/4/27
 *
 */
public class SiteInsertAction extends ActionSupport {


	private String siteName;


	private int pass;

	/**
	 * 実行メソッド
	 * サイト名を引数としてDAOクラスに渡す
	 * @return 成功ならSUCCESS　サイト名未入力、失敗ならERROR
	 */
	public String execute(){

		if(siteName==null){
			return ERROR;
		}


		SiteDAO dao=new SiteDAO();

		int count = dao.insert(siteName,pass);
		if(count==0){
			return ERROR;
		}


		return SUCCESS;

	}

	/**
	 * siteNameを取得します。
	 * @return siteName
	 */
	public String getSiteName() {
		return siteName;
	}

	/**
	 * siteNameを設定します。
	 * @param siteName siteName
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




}
