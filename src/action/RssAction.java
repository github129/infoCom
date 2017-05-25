/**
 *
 */
package com.internousdev.info.action;

import com.internousdev.info.util.Rss;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Rssを取得するツール
 * @author internousdev
 *
 */
public class RssAction extends ActionSupport{



	public String execute(){

		String rss;

		Rss rssUrl=new Rss();

		rss=rssUrl.rss();

		rssUrl.parseXML(rss);

		return SUCCESS;
	}

}
