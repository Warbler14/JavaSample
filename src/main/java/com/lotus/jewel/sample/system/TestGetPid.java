package com.lotus.jewel.sample.system;

import java.lang.reflect.Field;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.Pointer;

public class TestGetPid {

	public static void main(String[] args) {
		
	}
	
	public static long getProcessId(Process p) {
	    long pid = -1;

	    try {
	        if (p.getClass().getName().equals("java.lang.UNIXProcess")) {
	            Field f = p.getClass().getDeclaredField("pid");
	            f.setAccessible(true);
	            pid = f.getLong(p);
	            f.setAccessible(false);
	        } else if (p.getClass().getName().equals("java.lang.Win32Process") ||
	                p.getClass().getName().equals("java.lang.ProcessImpl")) {
	            Field f = p.getClass().getDeclaredField("handle");
	            f.setAccessible(true);
	            long handl = f.getLong(p);
	            Kernel32 kernel = Kernel32.INSTANCE;
	            WinNT.HANDLE hand = new WinNT.HANDLE();
	            hand.setPointer(Pointer.createConstant(handl));
	            pid = kernel.GetProcessId(hand);
	            f.setAccessible(false);
	        }
	    } catch (Exception e) {
	        pid = -1;
	    }
	    return pid;
	}
}
