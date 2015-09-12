package br.com.etyllica.util;

import java.io.File;
import java.lang.management.ManagementFactory;

public class SystemHelper {

	private static final long MEGA = 1024*1024; 
	
	private static String convertLongToMega(long value) {
		
		long megaValue = value/MEGA;
		
		String result = Long.toString(megaValue)+" MB";
		
        return result;
		
	}
	
	public static String getOSName() {
		
		return System.getProperty ("os.name");
		 
	}
	
	public static String getOSVersion() {
		
		return System.getProperty ("os.version");
		
	}
	
	public static String getOSArch() {
		
		return System.getProperty ("os.arch");
		
	}
	
	public static String diskSize() {
		
		long diskSize = new File("/").getTotalSpace();
		
		return convertLongToMega(diskSize);
		
	}
	
	public static String maxMemory() {
		
		long maxMemory = Runtime.getRuntime().maxMemory();
				
		return convertLongToMega(maxMemory);
		
	}
	
	public static String totalMemorySize() {
		
		long memorySize = ((com.sun.management.OperatingSystemMXBean) ManagementFactory
		        .getOperatingSystemMXBean()).getTotalPhysicalMemorySize();
				
		return convertLongToMega(memorySize);
		
	}
		
}
