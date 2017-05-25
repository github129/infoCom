
package com.internousdev.info.action;

import com.internousdev.info.dao.ItemDAO;
import com.internousdev.info.dao.SiteDAO;
import com.internousdev.info.dao.UrlDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * サイトIDと商品IDを基にURLを登録するクラス
 * @author BABATAKUMA
 *@since 2017/4/27
 */
public class UrlInsertAction extends ActionSupport {


	/**
	 * 登録したいURL
	 */
	private String url;

	/**
	 * 登録したいサイト名
	 */
	private String siteName;
	/**
	 * 登録したい商品名
	 */
	private String itemName;



	/**
	 *
	 */
	public String execute(){
		if(url==null){
			return ERROR;
		}

		SiteDAO siteDao=new SiteDAO();
		int siteId = siteDao.siteSelect(siteName);
		if(siteId==0){
			return ERROR;
		}

		ItemDAO itemDao=new ItemDAO();

		int itemId = itemDao.itemSelect(itemName);

		if(itemId==0){
			return ERROR;
		}


		int pass=siteDao.sitePassSelect(siteName);
		UrlDAO urlDao=new UrlDAO();


		int count =urlDao.insert(siteId, itemId, url,pass);


		if(count==0){
			return ERROR;
		}

		return SUCCESS;
	}

	/**
	 * 登録したいURLを取得します。
	 * @return 登録したいURL
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 登録したいURLを設定します。
	 * @param url 登録したいURL
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 登録したいサイト名を取得します。
	 * @return 登録したいサイト名
	 */
	public String getSiteName() {
		return siteName;
	}

	/**
	 * 登録したいサイト名を設定します。
	 * @param siteName 登録したいサイト名
	 */
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	/**
	 * 登録したい商品名を取得します。
	 * @return 登録したい商品名
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * 登録したい商品名を設定します。
	 * @param itemName 登録したい商品名
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}



}
