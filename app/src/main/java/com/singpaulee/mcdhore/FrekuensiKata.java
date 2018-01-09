package com.singpaulee.mcdhore;

/**
 * Created by ASUS on 30/12/2017.
 */

public class FrekuensiKata {
	Integer dokumen, tf;
	String term;

	public FrekuensiKata() {
	}

	public FrekuensiKata(Integer dokumen, Integer tf, String term) {
		this.dokumen = dokumen;
		this.tf = tf;
		this.term = term;
	}

	public Integer getDokumen() {
		return dokumen;
	}

	public void setDokumen(Integer dokumen) {
		this.dokumen = dokumen;
	}

	public Integer getTf() {
		return tf;
	}

	public void setTf(Integer tf) {
		this.tf = tf;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}
}
