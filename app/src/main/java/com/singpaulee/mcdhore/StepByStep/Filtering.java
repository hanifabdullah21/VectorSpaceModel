package com.singpaulee.mcdhore.StepByStep;


import android.util.Log;

import com.singpaulee.mcdhore.Model.StopWordModel;
import com.singpaulee.mcdhore.rest.ApiClient;
import com.singpaulee.mcdhore.rest.ConfigWebhost;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ASUS on 04/01/2018.
 */

public class Filtering {
	ArrayList<String> listTokenize;
	ArrayList<StopWordModel> listStopword;

	public Filtering(ArrayList<String> listTokenize, ArrayList<StopWordModel> listStopword) {
		this.listTokenize = listTokenize;
		this.listStopword = listStopword;
	}

//	public void getStopword(){
//		ApiClient apiClient = ConfigWebhost.getRetrofit().create(ApiClient.class);
//		final Call<ArrayList<StopWordModel>> q = apiClient.stopword();
//		q.enqueue(new Callback<ArrayList<StopWordModel>>() {
//			@Override
//			public void onResponse(Call<ArrayList<StopWordModel>> call, Response<ArrayList<StopWordModel>> response) {
//				ArrayList<StopWordModel> list = response.body();
//				listStopword = list;
//			}
//
//			@Override
//			public void onFailure(Call<ArrayList<StopWordModel>> call, Throwable t) {
//
//			}
//		});
//	}

	public ArrayList<String> filtering(){
		ArrayList<String> list = new ArrayList<>();
		ArrayList<String> word = new ArrayList<>();

		for (int j=0;j<listStopword.size();j++){
			word.add(listStopword.get(j).getWord());
		}

		for (int i=0;i<listTokenize.size();i++){
			String tokenize = listTokenize.get(i);
				if(!word.contains(tokenize)){
					list.add(tokenize);
				}
			}
//		}
		return list;
	}
}
