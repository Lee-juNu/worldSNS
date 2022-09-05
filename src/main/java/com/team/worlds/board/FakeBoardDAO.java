package com.team.worlds.board;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.team.worlds.util.Country;
import com.team.worlds.util.CountryMapper;
import com.team.worlds.util.Region;

@Service
public class FakeBoardDAO {

	@Autowired
	private SqlSession ss;

	
	
	
	public JsonArray getAllCountry()
	{
		ArrayList<Country> arrCountry =  ss.getMapper(CountryMapper.class).getAllCountry();
		
			for (Country country : arrCountry) {
				System.out.println(country.getCountry_id());
			}

		return new GsonBuilder().create().toJsonTree(arrCountry).getAsJsonArray();
	}




	public JsonArray getRegionByCountry(String countryName) {
		
		ArrayList<Region> arrRegion = ss.getMapper(CountryMapper.class).getRegionByCountry(countryName);
		return new GsonBuilder().create().toJsonTree(arrRegion).getAsJsonArray();

	}
	
}
