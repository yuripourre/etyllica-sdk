package br.com.etyllica.dist;

import java.io.File;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

/**
 * Code based on http://mengyiyouth.blogspot.com.br/2014/01/zip-and-unzip-folders-and-files-using.html
 */
public class ZipLoader {

	private static final String CORRUPTED_ZIP_FILE = "The file is corrupted.";
	
	/***
	 * Extract zipfile to outdir with complete directory structure
	 * @param zipfile Input .zip file
	 * @param outdir Output directory
	 * @throws net.lingala.zip4j.exception.ZipException
	 */
	public static void unzipToFolder(String zipFile,String dest,String passwd)
			throws ZipException, net.lingala.zip4j.exception.ZipException {
		
		ZipFile zFile = new ZipFile(zipFile);
		
		if (!zFile.isValidZipFile()) {
			throw new ZipException(CORRUPTED_ZIP_FILE);
		}
		
		File destDir = new File(dest);
		if (destDir.isDirectory() && !destDir.exists()) {
			destDir.mkdir();
		}
		if (zFile.isEncrypted()) {
			zFile.setPassword(passwd);
		}
		
		zFile.extractAll(dest);
	}

	public static void zipFolder(String folderName, String zipFileName, String password)
			throws net.lingala.zip4j.exception.ZipException {

		// Initiate ZipFile object with the path/name of the zip file.
		File ff = new File(zipFileName);
		
		if(ff.exists()) {
			ff.deleteOnExit();
		}

		ZipFile zipFile = new ZipFile(zipFileName);

		// Initiate Zip Parameters which define various properties such
		// as compression method, etc.
		ZipParameters parameters = new ZipParameters();

		// set compression method to store compression
		parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);

		// Set the compression level
		parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);

		if (password!=null) {
			parameters.setEncryptFiles(true);
			parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
			parameters.setPassword(password);
		}
		/**
		 * whether the root folder need to zip
		 */
		parameters.setIncludeRootFolder(false);
		// Add folder to the zip file

		File fFolder = new File(folderName);
		if(fFolder.isDirectory()) {

			zipFile.addFolder(fFolder, parameters);

		} else {
			
			fFolder.mkdir();
			zipFile.addFolder(fFolder, parameters);
		}
	}

}
