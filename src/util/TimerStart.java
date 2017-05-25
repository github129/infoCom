/**
 *
 */
package com.internousdev.info.util;

import java.util.TimerTask;

import com.internousdev.info.action.UrlAction;

/**
 * 時間ごとに実行されるクラス
 * @author BABATAKUMA
 * @since 2017/4/27
 *
 */
public class TimerStart extends TimerTask {


	/**
	 * 1日ごとに実行されるメソッド
	 * Urlアクションが実行される
	 */
	public void run() {
        UrlAction action =new UrlAction();
        try {
			action.execute();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
        }
    }

