package com.singpaulee.mcdhore.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ASUS on 04/01/2018.
 */

public class StopWordModel {
	@SerializedName("id")
	@Expose
	private String id;
	@SerializedName("word")
	@Expose
	private String word;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
}
