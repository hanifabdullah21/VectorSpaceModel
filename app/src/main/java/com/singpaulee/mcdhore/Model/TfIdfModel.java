package com.singpaulee.mcdhore.Model;

/**
 * Created by ASUS on 02/01/2018.
 */

public class TfIdfModel {
	String term;
	Integer query, dokumen1, dokumen2, dokumen3, dokumen4,dokumen5;
	Integer totalDf;
	Double dfi;
	Double idf;

	public TfIdfModel(String term, Integer query, Integer dokumen1, Integer dokumen2, Integer dokumen3, Integer dokumen4, Integer dokumen5) {
		this.term = term;
		this.query = query;
		this.dokumen1 = dokumen1;
		this.dokumen2 = dokumen2;
		this.dokumen3 = dokumen3;
		this.dokumen4 = dokumen4;
		this.dokumen5 = dokumen5;
	}

	public TfIdfModel(String term, Integer query, Integer dokumen1, Integer dokumen2, Integer dokumen3, Integer dokumen4, Integer dokumen5, Integer totalDf, Double dfi, Double idf) {
		this.term = term;
		this.query = query;
		this.dokumen1 = dokumen1;
		this.dokumen2 = dokumen2;
		this.dokumen3 = dokumen3;
		this.dokumen4 = dokumen4;
		this.dokumen5 = dokumen5;
		this.totalDf = totalDf;
		this.dfi = dfi;
		this.idf = idf;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public Integer getQuery() {
		return query;
	}

	public void setQuery(Integer query) {
		this.query = query;
	}

	public Integer getDokumen1() {
		return dokumen1;
	}

	public void setDokumen1(Integer dokumen1) {
		this.dokumen1 = dokumen1;
	}

	public Integer getDokumen2() {
		return dokumen2;
	}

	public void setDokumen2(Integer dokumen2) {
		this.dokumen2 = dokumen2;
	}

	public Integer getDokumen3() {
		return dokumen3;
	}

	public void setDokumen3(Integer dokumen3) {
		this.dokumen3 = dokumen3;
	}

	public Integer getDokumen4() {
		return dokumen4;
	}

	public void setDokumen4(Integer dokumen4) {
		this.dokumen4 = dokumen4;
	}

	public Integer getDokumen5() {
		return dokumen5;
	}

	public void setDokumen5(Integer dokumen5) {
		this.dokumen5 = dokumen5;
	}

	public Integer getTotalDf() {
		return totalDf;
	}

	public void setTotalDf(Integer totalDf) {
		this.totalDf = totalDf;
	}

	public Double getDfi() {
		return dfi;
	}

	public void setDfi(Double dfi) {
		this.dfi = dfi;
	}

	public Double getIdf() {
		return idf;
	}

	public void setIdf(Double idf) {
		this.idf = idf;
	}
}
