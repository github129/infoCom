/**
 *
 */
package com.internousdev.info.action;

import java.util.ArrayList;

import com.internousdev.info.dao.InfoDAO;
import com.internousdev.info.dao.UrlDAO;
import com.internousdev.info.dto.UrlDTO;
import com.internousdev.info.util.GetUrl;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @author internousdev
 *
 */
public class UrlAction extends ActionSupport {


	private ArrayList<UrlDTO> urlList =new ArrayList<>();

	private ArrayList<Object> list =new ArrayList<>();

	private ArrayList<String> actionList =new ArrayList<>();

	private ArrayList<String> subList=new ArrayList<>();

	private ArrayList<String> yenList=new ArrayList<>();

	private String sb="";



	public String execute() throws Exception{




		UrlDAO urlDao=new UrlDAO();

		urlList =urlDao.select();
		if(urlList.size()==0){
			return ERROR;
		}

		for(UrlDTO dto:urlList){
			list.clear();
			actionList.clear();
			subList.clear();
			yenList.clear();


			String pageUrl=dto.getUrl();
			int urlId=dto.getUrlId();
			GetUrl url =new GetUrl();
			list=url.url(pageUrl);

			for(int i=0;i<list.size() ;i++){
				int k=8;
				String s=(String)list.get(i);
				if(s.contains("円")){
					String s2=(s.substring(0,s.indexOf("円")+1));
					if(s2.length() <k){
						k=s2.length();
					}
					String s3=(s2.substring(s2.length()-k));

					System.out.println("s3"+s3);
					for(int j=0;j<s3.length();j++){
						char en;
						en =s3.charAt(j);
						String sen=String.valueOf(en);
						if(sen.matches("[0-9]|円")){
							subList.add(sen);
						}

					}
				}



				else if(s.contains("￥")){
					String s3=(s.substring(0));

					System.out.println(s3);
					for(int j=0;j<s3.length();j++){
						char en;
						en =s3.charAt(j);
						String sen=String.valueOf(en);
						if(sen.matches("[0-9]|￥")){
							subList.add(sen);
						}

					}
				}

				System.out.println(i+"回目"+list.get(i));
			}





			/*
			 * 取得した数字(String型)を連結する
			 */
			for(int a=0; a<subList.size();a++){

				if(subList.get(a).matches("￥")){
					if(a ==0){
						continue;
					}
				}else if(subList.get(a).matches("円")){
					if(a ==0){
						continue;
					}
				}
				if(subList.get(a).matches("[0-9]")){
					sb = sb+(subList.get(a));
				}else if(subList.get(a).matches("￥") || subList.get(a).matches("円")){
					yenList.add(sb);
					System.out.println(yenList);
					sb="";
					continue;
				}
			}


			if(yenList.size()!=0){
				System.out.println("urlは"+list.get(0));
				String getUrl=list.get(0).toString();
				int pass=urlDao.passSelect(getUrl);
System.out.println("pass"+pass);
				int l=0;
				l=Integer.parseInt(yenList.get(pass));

				InfoDAO infoDao=new InfoDAO();
				int count =infoDao.insert(l, urlId);
				if(count==0){
					System.out.println("失敗しました");
				}

			}

		}


		return SUCCESS;
	}

	/**
	 * listを取得します。
	 * @return list
	 */
	public ArrayList<Object> getList() {
		return list;
	}

	/**
	 * listを設定します。
	 * @param list list
	 */
	public void setList(ArrayList<Object> list) {
		this.list = list;
	}

	/**
	 * actionListを取得します。
	 * @return actionList
	 */
	public ArrayList<String> getActionList() {
		return actionList;
	}

	/**
	 * actionListを設定します。
	 * @param actionList actionList
	 */
	public void setActionList(ArrayList<String> actionList) {
		this.actionList = actionList;
	}

	/**
	 * subListを取得します。
	 * @return subList
	 */
	public ArrayList<String> getSubList() {
		return subList;
	}

	/**
	 * subListを設定します。
	 * @param subList subList
	 */
	public void setSubList(ArrayList<String> subList) {
		this.subList = subList;
	}

	/**
	 * @return yenList
	 */
	public ArrayList<String> getYenList() {
		return yenList;
	}

	/**
	 * @param yenList セットする yenList
	 */
	public void setYenList(ArrayList<String> yenList) {
		this.yenList = yenList;
	}

	/**
	 * @return sb
	 */
	public String getSb() {
		return sb;
	}

	/**
	 * @param sb セットする sb
	 */
	public void setSb(String sb) {
		this.sb = sb;
	}




}
