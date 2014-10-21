package examples.util;

import br.com.etyllica.util.SystemHelper;

public class SystemExample {

	public static void main(String[] args) {

		System.out.println("OS Name: "+SystemHelper.getOSName());
		
		System.out.println("OS Version: "+SystemHelper.getOSVersion());
		
		System.out.println("OS Arch: "+SystemHelper.getOSArch());

		System.out.println("Disk Size: "+SystemHelper.diskSize());

		System.out.println("Max Size: "+SystemHelper.maxMemory());

		System.out.println("Mem Size: "+SystemHelper.totalMemorySize());
	}

}
