package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.InputStreamReader;


public class FileIO {
	private File absFilePath;
	private String cwp = System.getProperty("user.dir");
	
	public FileIO() {
	}
	
	public FileIO(String p_filePath) {
		 this.absFilePath = new File(this.cwp + File.separator+ p_filePath);
	}
	
	public void listDataFiles(String subfix) {
		System.out.println("Reading files at: " + this.absFilePath.toString());
		File[] allFiles = absFilePath.listFiles(new FilenameFilter() {
			public boolean accept(File pathname, String name) {
				return name.endsWith(subfix);
			}
		});
		if (allFiles == null) {
			System.out.println("file name has an error");
			return;
		} else if (allFiles.length == 0){
			System.out.println("no specific files are found.");
		}
		for (int i = 0; i < allFiles.length; i++) {
			System.out.println(allFiles[i]);
		}
	}
	
	public File[] getDataFiles(String subfix) {
		System.out.println("Reading files at: " + this.absFilePath.toString());
		File[] allFiles = absFilePath.listFiles(new FilenameFilter() {
			public boolean accept(File pathname, String name) {
				return name.endsWith(subfix);
			}
		});
		if (allFiles == null) {
			System.out.println("file name has an error");
			return null;
		} else if (allFiles.length == 0){
			System.out.println("no specific files are found.");
		}
		return allFiles;
	}
	
	public BufferedReader getBufferedReader(File file) {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if (fileInputStream == null) { //given file name not found
			return null;
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
		return br;
	}
}
