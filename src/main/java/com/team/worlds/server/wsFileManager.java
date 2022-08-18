package com.team.worlds.server;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.json.simple.JSONObject;

public class wsFileManager {

	private static String filePath="";

	public static String getFilePath() {
		return filePath;
	}

	public static void setFilePath(String filePath) {
		wsFileManager.filePath = filePath;
	}
}
