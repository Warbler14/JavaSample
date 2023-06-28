package com.lotus.jewel.sample.windows.runtime;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProcessKill {
    public int killProcessID(int port) {
        Process ps = null;
        BufferedReader br = null;
        try {
            // netstat -a -o라는 명령어를 프로세스로 실행한다.
            ps = new ProcessBuilder("cmd", "/c", "netstat -a -o").start();
            // 프로세스 실행한걸 읽어들인다.
            br = new BufferedReader(new InputStreamReader(ps.getInputStream(), "UTF-8"));
            String line = "";
            String[] arr = null;
            // 읽어들인 br객체에서 한줄씩 가져온다. 없으면 종료
            while ((line = br.readLine()) != null) {
                // 만약 내가 원하는 포트번호를 포함한다면
                if (line.contains(":" + port)) {
                    // 2칸짜리 공백이 있으면
                    while (line.contains("  ")) {
                        // 2칸짜리 공백을 1칸으로 줄인다.
                        line = line.replace("  ", " ");
                    }
                    // line을 공백을 기준으로 나누게 되면
                    arr = line.split(" ");
                    // 5번 index가 pid
                    int pid = Integer.parseInt(arr[5]);
                    // 프로세스를 죽인다.
                    ps.destroy();
                    // pid를 리턴
                    return pid;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void main(String[] args) {
        ProcessKill pk = new ProcessKill();
        System.out.println(pk.killProcessID(8081));
    }
}