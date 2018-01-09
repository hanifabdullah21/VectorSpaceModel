package com.singpaulee.mcdhore.Model;

import com.google.gson.annotations.SerializedName;

public class KataDasarModel {

	@SerializedName("katadasar")
	private String katadasar;

	@SerializedName("id_katadasar")
	private String idKatadasar;

	@SerializedName("tipe_katadasar")
	private String tipeKatadasar;

	public void setKatadasar(String katadasar){
		this.katadasar = katadasar;
	}

	public String getKatadasar(){
		return katadasar;
	}

	public void setIdKatadasar(String idKatadasar){
		this.idKatadasar = idKatadasar;
	}

	public String getIdKatadasar(){
		return idKatadasar;
	}

	public void setTipeKatadasar(String tipeKatadasar){
		this.tipeKatadasar = tipeKatadasar;
	}

	public String getTipeKatadasar(){
		return tipeKatadasar;
	}

	@Override
 	public String toString(){
		return 
			"KataDasarModel{" +
			"katadasar = '" + katadasar + '\'' + 
			",id_katadasar = '" + idKatadasar + '\'' + 
			",tipe_katadasar = '" + tipeKatadasar + '\'' + 
			"}";
		}
}