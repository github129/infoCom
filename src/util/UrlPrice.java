/**
 *
 */
package com.internousdev.info.util;

import java.io.IOException;
import java.util.ArrayList;

/**
 * パースされた情報を基に金額を取得するクラス
 * @author BABATAKUMA
 *@since 2017/4/28
 */
public class UrlPrice {


	private ArrayList<Object> list =new ArrayList<>();

	private ArrayList<String> actionList =new ArrayList<>();

	private ArrayList<String> subList=new ArrayList<>();

	private ArrayList<String> yenList=new ArrayList<>();

	private String sb="";

	private int l;



/**
 * 実行メソッド
 * @param pageUrl　url
 * @return l price
 * @throws IOException 例外処理
 */
	public int price(String pageUrl) throws IOException{


		if(pageUrl==null){
			return 0;
		}
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


			l=Integer.parseInt(yenList.get(0));

		}


		return l;
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

	/**
	 * @return l
	 */
	public int getL() {
		return l;
	}

	/**
	 * @param l セットする l
	 */
	public void setL(int l) {
		this.l = l;
	}
}
