package com.singpaulee.mcdhore.StepByStep;

import android.util.Log;

import com.singpaulee.mcdhore.Model.NewsDetail;

import java.util.ArrayList;

/**
 * Created by ASUS on 02/01/2018.
 */

public class Tokenization {
	ArrayList<NewsDetail> listTwitter;
	String query = "Setya Novanto ditangkap KPK";
	ArrayList<String> listTokenize = new ArrayList<>();

	public Tokenization(ArrayList<NewsDetail> listTwitter) {
		this.listTwitter = listTwitter;
	}

	public ArrayList<String> countTerm() {
		for (int index = 0; index < listTwitter.size(); index++) {
			String es = listTwitter.get(index).getTweetText().toLowerCase().replaceAll("[\"+.^:,#|?_@/()0123456789-]", " ");
			String[] result = es.split("\\s");
			for (int x = 0; x < result.length; x++) {
				Log.d("All Term", "dokumen " + index + " " + result[x]);
				if (!listTokenize.contains(result[x]) && !result[x].isEmpty()) {
					listTokenize.add(result[x]);
				}
			}
		}

		for (int token = 0; token < listTokenize.size(); token++) {
			Log.d("Tokenize", " " + listTokenize.get(token));
		}
		return listTokenize;
	}
}
