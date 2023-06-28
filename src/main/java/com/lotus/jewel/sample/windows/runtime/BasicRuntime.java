package com.lotus.jewel.sample.windows.runtime;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;

public class BasicRuntime {

    final static Integer CODE_PAGE_UTF8 = 65001;

    public static void main(String[] args) {

        //processRun("cmd");

        String pid = findKillPid("TCP", 8081);
        System.out.println("pid : " + pid);

        //taskKill(pid);
        processRun("chcp " + CODE_PAGE_UTF8 + " && taskkill /f /pid "+ pid);
    }

    private static String findKillPid(String type, Integer port) {
        Process process = runCmd("netstat -a -o");

        String processId = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"))) {
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }

                line = line.trim();

                if (!line.startsWith(type)) {
                    continue;
                }

                if (line.contains(":" + port)) {
                    processId = line.substring(line.lastIndexOf(" ") + 1, line.length());
                    break;
                }
            }
        } catch (IOException e) {
        }

        if (process != null) {
            process.destroy();
        }

        return processId;
    }

    private static void processRun(final String command) {
        Process process = runCmd(command);
        String result = getProcessResult(process);
        System.out.println(result);

        if (process != null) {
            process.destroy();
        }
    }

    private static Process runCmd(final String command) {
        try {
            //return Runtime.getRuntime().exec("cmd /c " + command);
            return new ProcessBuilder("cmd", "/c", command).start();

        } catch (IOException e) {
            System.out.println(e);
        }

        return null;
    }

    private static String getProcessResult(Process process) {
        if (process == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"))) {
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                builder.append(line).append("\n");
            }
        } catch (IOException e) {
        }

        return builder.toString();
    }
}
