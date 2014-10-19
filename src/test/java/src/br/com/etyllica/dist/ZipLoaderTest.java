package br.com.etyllica.dist;

import net.lingala.zip4j.exception.ZipException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ZipLoaderTest {

	private static final String ZIP_PASSWORD = "etyllica";
	
	@Before
	public void setUp() {

	}
	
	@Test
	public void testCreateZip() {

		
		String path = ZipLoaderTest.class.getResource("").toString().substring(5);
		path += "../../../../../";
		//Point to assets folder 
				
		String folderName = "/assets/zip";
		
		try {
			ZipLoader.zipFolder(path+folderName, "assets.zip", ZIP_PASSWORD);			
		} catch (ZipException e) {
			Assert.fail();
		}
	}
}
