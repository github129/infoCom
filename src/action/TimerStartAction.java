/**
 *
 */
package com.internousdev.info.action;

import com.internousdev.info.util.Task;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author internousdev
 *
 */
public class TimerStartAction extends ActionSupport {



	public String execute(){

		Task task=new Task();
		task.autoTimer();

		return SUCCESS;
	}

}
