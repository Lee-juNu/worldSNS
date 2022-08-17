package com.team.worlds.server;

import java.util.ArrayList;
import java.util.HashMap;

import javax.websocket.Session;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;



@Service
public class wsAlaramController {

	public static void onMessage(JSONObject result, Session session, HashMap<String, ArrayList<Session>> sessionmap) {
		
	}
	
}
