package com.team.worlds.server;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.websocket.Session;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.worlds.alarm.AlarmDAO;
import com.team.worlds.messages.MessageDAO;



@Service
public class wsAlaramController {

	

	
	public static void onMessage(JSONObject result, Session session, HashMap<String, ArrayList<Session>> sessionmap) {
		
	}
	
}
