package com.team.worlds.util;

import java.util.ArrayList;

public interface CountryMapper {
	
	ArrayList<Country> getAllCountry();
	ArrayList<Region> getRegionByCountry(String countryName);
	
}
