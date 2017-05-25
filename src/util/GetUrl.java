package com.internousdev.info.util;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * urlからｈｔｍｌをパースするクラス
 * @author BABATAKUMA
 *@since 2017/4/28
 */
public class GetUrl{




	public ArrayList<Object> info=new ArrayList<>();

/**
 * urlをアクションから取得して動かす
 * @param url 取得したいURL
 * @return info パースしたサイトの情報
 * @throws IOException
 */
	    public ArrayList<Object> url(String url) throws IOException {
	    	info.clear();
	    	info.add(url);

	        //ユーザエージェント(ある程度最新のブラウザを指定しないとコンテンツを返してくれないサイトがある)
	        String userAgent = "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0";
	        //取得・パース処理
	        Document document = Jsoup.connect(url).userAgent(userAgent).get();


	        Elements elements = document.body().getAllElements();

	        StringBuilder builder = new StringBuilder();


	        for (Element element : elements) {

	            if (element.ownText() == null) {
	                continue;
	            }
	            info.add(element.ownText());
	            builder.append(element.ownText()).append("\n");
	        }

	        return info;
	    }
	}
