package com.lotus.jewel.sample.task;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduleExecTest {

    public static void main(String[] args) {
        // 실행간격 지정(3초)
        int sleepSec = 3 ;

        // 시간 출력 포맷
        final SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");

        // 주기적인 작업을 위한
        final ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);

        exec.scheduleAtFixedRate(new Runnable(){

            public void run(){
                try {
                    String threadName = Thread.currentThread().getName();

                    Calendar cal = Calendar.getInstance() ;

                    //System.out.println("B " + threadName + " " + fmt.format(cal.getTime())) ;
                    //Thread.sleep(10000);

                    // 콘솔에 현재 시간 출력
                    System.out.println("A " + threadName + " " + fmt.format(cal.getTime())) ;

                    TimeUnit.SECONDS.sleep(1);

                } catch (Exception e) {

                    e.printStackTrace();

                    // 에러 발생시 Executor를 중지시킨다
                    exec.shutdown() ;
                }
            }
        }, 0, sleepSec, TimeUnit.SECONDS);
    }
}
