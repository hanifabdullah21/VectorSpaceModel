package com.singpaulee.mcdhore.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ASUS on 30/12/2017.
 */

public class ConfigSpreadsheet {
	private static final String base_url= "https://script.googleusercontent.com/";

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
