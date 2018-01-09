package com.singpaulee.mcdhore;

import java.util.ArrayList;

/**
 * Created by ASUS on 30/12/2017.
 */

public class FrekuensiKataFinal {
	String term;
	ArrayList<FrekuensiKata> list;
	Integer df;
	Double perDfi;
	Double idf;

	public FrekuensiKataFinal(String term, ArrayList<FrekuensiKata> list, Integer df) {
		this.term = term;
		this.list = list;
		this.df = df;
	}

	public FrekuensiKataFinal(String term, ArrayList<FrekuensiKata> list, Integer df, Double perDfi, Double idf) {
		this.term = term;
		this.list = list;
		this.df = df;
		this.perDfi = perDfi;
		this.idf = idf;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public ArrayList<FrekuensiKata> getList() {
		return list;
	}

	public void setList(ArrayList<FrekuensiKata> list) {
		this.list = list;
	}

	public Integer getDf() {
		return df;
	}

	public void setDf(Integer df) {
		this.df = df;
	}

	public Double getPerDfi() {
		return perDfi;
	}

	public void setPerDfi(Double perDfi) {
		this.perDfi = perDfi;
	}

	public Double getIdf() {
		return idf;
	}

	public void setIdf(Double idf) {
		this.idf = idf;
	}
}
