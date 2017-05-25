package com.internousdev.info.util;


import java.util.Timer;



public class Task{

	public void autoTimer(){
        Timer timer = new Timer();
        timer.schedule(new TimerStart(), 0, 86400000); // タスクの実行間隔は1日毎
    }
}