package com.singpaulee.mcdhore.StepByStep;

import android.widget.Toast;

import com.singpaulee.mcdhore.FrekuensiKata;
import com.singpaulee.mcdhore.MainActivity;
import com.singpaulee.mcdhore.Model.NewsDetail;
import com.singpaulee.mcdhore.Model.TfIdfModel;

import java.util.ArrayList;

/**
 * Created by ASUS on 02/01/2018.
 */

public class TfIdf {
	ArrayList<String> listTerm;
	ArrayList<NewsDetail> listTwitter;

	ArrayList<TfIdfModel> listTf = new ArrayList<>();
	ArrayList<TfIdfModel> listTfIdf = new ArrayList<>();

	Integer q, d1, d2, d3, d4, d5;

	public TfIdf(ArrayList<String> listTerm, ArrayList<NewsDetail> listTwitter) {
		this.listTerm = listTerm;
		this.listTwitter = listTwitter;
	}

	public ArrayList<TfIdfModel> TermFrekuency() {
		for (int intAllTerm = 0; intAllTerm < listTerm.size(); intAllTerm++) {
			String term = listTerm.get(intAllTerm);
			for (int dok = 0; dok < listTwitter.size(); dok++) {
				String termDok = listTwitter.get(dok).getTweetText();
				if (termDok.contains(term)) {
					int count = -1;
					int jumlah = 0;
					count = termDok.indexOf(term);
					while (count >= 0) {
						++jumlah;
						count += term.length();
						count = termDok.indexOf(term, count);
					}

					if (dok == 0) {
						q = jumlah;
					} else if (dok == 1) {
						d1 = jumlah;
					} else if (dok == 2) {
						d2 = jumlah;
					} else if (dok == 3) {
						d3 = jumlah;
					} else if (dok == 4) {
						d4 = jumlah;
					} else if (dok == 5) {
						d5 = jumlah;
					}
				} else if (!termDok.contains(term)) {
					if (dok == 0) {
						q = 0;
					} else if (dok == 1) {
						d1 = 0;
					} else if (dok == 2) {
						d2 = 0;
					} else if (dok == 3) {
						d3 = 0;
					} else if (dok == 4) {
						d4 = 0;
					} else if (dok == 5) {
						d5 = 0;
					}
				}
			}
			TfIdfModel tf = new TfIdfModel(term, q, d1, d2, d3, d4, d5);
			listTf.add(tf);
		}
		return listTf;
	}



	public ArrayList<TfIdfModel> countTfIdf() {
		ArrayList<TfIdfModel> listTf = TermFrekuency();

		for (int y = 0; y < listTf.size(); y++) {
			int q=0, d1=0, d2=0, d3=0, d4=0, d5=0;
			int df=0;
			double dfi=0, idf=0;
			String term;

			term = listTf.get(y).getTerm();
			q = listTf.get(y).getQuery();
			d1 = listTf.get(y).getDokumen1();
			d2 = listTf.get(y).getDokumen2();
			d3 = listTf.get(y).getDokumen3();
			d4 = listTf.get(y).getDokumen4();
			d5 = listTf.get(y).getDokumen5();


			if(q!=0){df=df+1;}
			if(d1!=0){df=df+1;}
			if(d2!=0){df=df+1;}
			if(d3!=0){df=df+1;}
			if(d4!=0){df=df+1;}
			if(d5!=0){df=df+1;}

			dfi = 6/Double.valueOf(df);
			idf = Math.log(dfi);

			if(df != 0){
				TfIdfModel model = new TfIdfModel(term,q,d1,d2,d3,d4,d5,df,dfi,idf);
				listTfIdf.add(model);
			}
		}
		return listTfIdf;
	}
}
