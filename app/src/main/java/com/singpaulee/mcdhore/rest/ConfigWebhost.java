package com.singpaulee.mcdhore.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ASUS on 04/01/2018.
 */

public class ConfigWebhost {
	private static final String base_url= "https://unproportioned-gara.000webhostapp.com/api/information/";

	public static Retrofit getRetrofit(){
		Gson gson = new GsonBuilder()
				.setLenient()
				.create();


		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(base_url)
				.addConverterFactory(GsonConverterFactory.create(gson))
				.build();

		return retrofit;
	}
}
