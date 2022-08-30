package com.team.worlds.fileUtil;

import java.io.File;
import java.io.FileNotFoundException;

import com.team.worlds.server.wsFileManager;

public class FileManager {
	  public static void createUploadFolder(String folderName) throws FileNotFoundException
	    {
	    	File Folder = new File(wsFileManager.getFilePath()+"/"+folderName);
	    	// 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
	    	if (!Folder.exists()) {
	    		try{
	    		    Folder.mkdir(); //폴더 생성합니다.
	    		    System.out.println("폴더가 생성되었습니다.");
	    	        } 
	    	        catch(Exception e){
	    		    e.getStackTrace();
	    		}        
	             }else {
	    		System.out.println("이미 폴더가 생성되어 있습니다.");
	    	}
	    }
}
