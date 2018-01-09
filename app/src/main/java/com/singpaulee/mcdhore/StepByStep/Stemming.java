package com.singpaulee.mcdhore.StepByStep;

import com.singpaulee.mcdhore.Model.KataDasarModel;

import java.util.ArrayList;

/**
 * Created by ASUS on 04/01/2018.
 */

public class Stemming {
	ArrayList<String> listFiltering;
	ArrayList<KataDasarModel> listKatadasar;

	public Stemming(ArrayList<String> listFiltering, ArrayList<KataDasarModel> listKatadasar) {
		this.listFiltering = listFiltering;
		this.listKatadasar = listKatadasar;
	}

	public ArrayList<String> listStemming(){
		String akarkata;
		String akarkata2;
		ArrayList<String> stemming = new ArrayList<>();
		for (int f=0;f<listFiltering.size();f++){
			for (int kd=0;kd<listKatadasar.size();kd++){
				String kata = listFiltering.get(f);
				String katadasar = listKatadasar.get(kd).getKatadasar().toLowerCase();
				if(kata.equals(katadasar)){
					akarkata = kata;
					stemming.add(akarkata);
					kd++;
				}else{
					akarkata = hapusImbuhanBelakang(kata);
					if(akarkata.equals(katadasar)){
						stemming.add(akarkata);
					}else{
						akarkata2 = hapusImbuhanDepan(akarkata,katadasar);
						if (akarkata2.equals(katadasar)){
							stemming.add(akarkata2);
							kd++;
						}
					}
				}
			}
		}

		return stemming;
	}

	private String hapusImbuhanDepan(String akarkata, String katadasar) {
		String akar2 = "";
		if ((akarkata.startsWith("di") || akarkata.startsWith("ke") || akarkata.startsWith("se")) && akarkata.length() > 2) {
			akar2 = akarkata.substring(2);
			return akar2;
		}

		if ((akarkata.startsWith("diper") || akarkata.startsWith("keber") || akarkata.startsWith("keter")) && akarkata.length() > 5) {
			akar2 = akarkata.substring(5);
			return akar2;
		}

		if ((akarkata.startsWith("be") || akarkata.startsWith("te")) && akarkata.length() > 2) {
			akar2 = akarkata.substring(2);
			return akar2;
		}

		if ((akarkata.startsWith("bel") || akarkata.startsWith("ber") || akarkata.startsWith("tel") || akarkata.startsWith("ter")) && akarkata.length() > 3) {
			akar2 = akarkata.substring(3);
			return akar2;
		}

		if ((akarkata.startsWith("me") || akarkata.startsWith("pe")) && akarkata.length() > 2) {
			akar2 = akarkata.substring(2);
			if(akar2.equals(katadasar)){
				return akar2;
			}else{
				if((akar2.startsWith("men") || akar2.startsWith("pen")) && akar2.length() > 3){
					akar2 = akar2.substring(3);
					return akar2;
				}
			}
		}

		if ((akarkata.startsWith("meny") || akarkata.startsWith("peny")) && akarkata.length() > 4) {
			akar2 = "s"+akarkata.substring(4);
			return akar2;
		}

		if ((akarkata.startsWith("meng") || akarkata.startsWith("peng")) && akarkata.length() > 4) {
			akar2 = akarkata.substring(4);
			if (akar2.equals(katadasar)){
				return akar2;
			}else {
				akar2 = "k"+akar2;
				return akar2;
			}
		}

		if ((akarkata.startsWith("mel") || akarkata.startsWith("mer") || akarkata.startsWith("per") || akarkata.startsWith("pel")) && akarkata.length() > 3) {
			akar2 = akarkata.substring(3);
			return akar2;
		}

		if ((akarkata.startsWith("mem") || akarkata.startsWith("pem")) && akarkata.length() > 3) {
			akar2 = akarkata.substring(3);
			if(akar2.equals(katadasar)){
				return akar2;
			}else{
				akar2 = "p"+akar2;
				return akar2;
			}
		}

		if ((akarkata.startsWith("mempel")) && akarkata.length() > 6) {
			akar2 = akarkata.substring(6);
			return akar2;
		}

		if ((akarkata.startsWith("memper")) && akarkata.length() > 6) {
			akar2 = akarkata.substring(6);
			return akar2;
		}

		return akarkata;
	}

	private String hapusImbuhanBelakang(String kata) {
		String akar="";
		if(kata.endsWith("lah") || kata.endsWith("kah") || kata.endsWith("nya")|| kata.endsWith("tah") || kata.endsWith("pun")){
			akar = kata.substring(0, kata.length()-3);
		}else if(kata.endsWith("ku") || kata.endsWith("mu") || kata.endsWith("an")){
			akar = kata.substring(0, kata.length()-2);
		}else if(kata.endsWith("i") || kata.endsWith("k")){
			akar = kata.substring(0, kata.length()-1);
		}else {
			akar = kata;
		}
		return akar;
	}
}
