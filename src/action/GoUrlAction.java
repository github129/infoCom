/**
 *
 */
package com.internousdev.info.action;

import java.io.IOException;
import java.util.ArrayList;

import com.internousdev.info.dao.UrlDAO;
import com.internousdev.info.dto.UrlDTO;
import com.internousdev.info.util.GetUrl;
import com.opensymphony.xwork2.ActionSupport;

/**
 * URLをDAOに渡すアクションクラス
 * @author BABATAKUMA
 *
 */
public class GoUrlAction extends ActionSupport {


	private  int siteId;

	private String siteName;

	private int price;

	private String pageUrl;

	private ArrayList<UrlDTO> list =new ArrayList<>();



	public String execute() throws IOException{

		UrlDAO urlDao=new UrlDAO();

		list =urlDao.select();
		if(list.size()==0){
			return ERROR;
		}
		for(UrlDTO dto:list){
			pageUrl=dto.getUrl();
			GetUrl getUrl=new GetUrl();


		}


		return SUCCESS;
	}

}
