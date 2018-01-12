package com.singpaulee.mcdhore.StepByStep;

import android.graphics.ColorSpace;

import com.singpaulee.mcdhore.Model.TfIdfModel;
import com.singpaulee.mcdhore.Model.WdtModel;

import java.util.ArrayList;

/**
 * Created by ASUS on 02/01/2018.
 */

public class Wdt {
	ArrayList<TfIdfModel> listTfIdf;
	ArrayList<WdtModel> listWdf = new ArrayList<>();
	ArrayList<Double> listWdqXwdt = new ArrayList<>();
	ArrayList<Double> listVector = new ArrayList<>();
	ArrayList<Double> listCosSimularity = new ArrayList<>();

	public Wdt(ArrayList<TfIdfModel> listTfIdf) {
		this.listTfIdf = listTfIdf;
	}

	public ArrayList<WdtModel> countWdf() {
//		double q = 0, wd1 = 0, wd2 = 0, wd3 = 0, wd4 = 0, wd5 = 0;
		for (int x = 0; x < listTfIdf.size(); x++) {
			double q=0,d1 = 0, d2 = 0, d3 = 0, d4 = 0, d5 = 0, d6=0;
			q = listTfIdf.get(x).getQuery() * listTfIdf.get(x).getIdf();
			d1 = listTfIdf.get(x).getDokumen1() * listTfIdf.get(x).getIdf();
			d2 = listTfIdf.get(x).getDokumen2() * listTfIdf.get(x).getIdf();
			d3 = listTfIdf.get(x).getDokumen3() * listTfIdf.get(x).getIdf();
			d4 = listTfIdf.get(x).getDokumen4() * listTfIdf.get(x).getIdf();
			d5 = listTfIdf.get(x).getDokumen5() * listTfIdf.get(x).getIdf();
			d6 = listTfIdf.get(x).getDokumen6() * listTfIdf.get(x).getIdf();
			WdtModel model = new WdtModel(q, d1, d2, d3, d4, d5, d6);
			listWdf.add(model);
		}
		return listWdf;
	}

	public ArrayList<Double> countWdqXwdt() {
		double wd1 = 0, wd2 = 0, wd3 = 0, wd4 = 0, wd5 = 0, wd6 = 0;

		ArrayList<WdtModel> list = countWdf();

		for (int z = 0; z < list.size(); z++) {
			wd1 = wd1 + (list.get(z).getWdq() * list.get(z).getWd1());
			wd2 = wd2 + (list.get(z).getWdq() * list.get(z).getWd2());
			wd3 = wd3 + (list.get(z).getWdq() * list.get(z).getWd3());
			wd4 = wd4 + (list.get(z).getWdq() * list.get(z).getWd4());
			wd5 = wd5 + (list.get(z).getWdq() * list.get(z).getWd5());
			wd6 = wd6 + (list.get(z).getWdq() * list.get(z).getWd6());
		}
		listWdqXwdt.add(wd1);
		listWdqXwdt.add(wd2);
		listWdqXwdt.add(wd3);
		listWdqXwdt.add(wd4);
		listWdqXwdt.add(wd5);
		listWdqXwdt.add(wd6);
		return listWdqXwdt;
	}


	public ArrayList<Double> countVector() {
		ArrayList<WdtModel> list = countWdf();
		double q = 0, wd1 = 0, wd2 = 0, wd3 = 0, wd4 = 0, wd5 = 0, wd6 = 0;
		for (int z = 0; z < list.size(); z++) {
			q = q + Math.pow(list.get(z).getWdq(),2);
			wd1 = wd1 + Math.pow(list.get(z).getWd1(), 2);
			wd2 = wd2 + Math.pow(list.get(z).getWd2(), 2);
			wd3 = wd3 + Math.pow(list.get(z).getWd3(), 2);
			wd4 = wd4 + Math.pow(list.get(z).getWd4(), 2);
			wd5 = wd5 + Math.pow(list.get(z).getWd5(), 2);
			wd6 = wd6 + Math.pow(list.get(z).getWd6(), 2);
		}
		listVector.add(Math.sqrt(q));
		listVector.add(Math.sqrt(wd1));
		listVector.add(Math.sqrt(wd2));
		listVector.add(Math.sqrt(wd3));
		listVector.add(Math.sqrt(wd4));
		listVector.add(Math.sqrt(wd5));
		listVector.add(Math.sqrt(wd6));

		return listVector;
	}


	public ArrayList<Double> countCosSimularity(){
		ArrayList<Double> listWdqWdt = countWdqXwdt();
		ArrayList<Double> listVektor = countVector();

		double cosSimD1 = listWdqWdt.get(0) / (listVektor.get(0)*listVektor.get(1));
		double cosSimD2 = listWdqWdt.get(1) / (listVektor.get(0)*listVektor.get(2));
		double cosSimD3 = listWdqWdt.get(2) / (listVektor.get(0)*listVektor.get(3));
		double cosSimD4 = listWdqWdt.get(3) / (listVektor.get(0)*listVektor.get(4));
		double cosSimD5 = listWdqWdt.get(4) / (listVektor.get(0)*listVektor.get(5));
		double cosSimD6 = listWdqWdt.get(5) / (listVektor.get(0)*listVektor.get(6));

		listCosSimularity.add(cosSimD1);
		listCosSimularity.add(cosSimD2);
		listCosSimularity.add(cosSimD3);
		listCosSimularity.add(cosSimD4);
		listCosSimularity.add(cosSimD5);
		listCosSimularity.add(cosSimD6);
		return listCosSimularity;
	}
}
