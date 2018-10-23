package com.singpaulee.mcdhore;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.singpaulee.mcdhore.Model.KataDasarModel;
import com.singpaulee.mcdhore.Model.NewsDetail;
import com.singpaulee.mcdhore.Model.ResponseList;
import com.singpaulee.mcdhore.Model.StopWordModel;
import com.singpaulee.mcdhore.Model.TfIdfModel;
import com.singpaulee.mcdhore.Model.WdtModel;
import com.singpaulee.mcdhore.StepByStep.Filtering;
import com.singpaulee.mcdhore.StepByStep.Stemming;
import com.singpaulee.mcdhore.StepByStep.TfIdf;
import com.singpaulee.mcdhore.StepByStep.Tokenization;
import com.singpaulee.mcdhore.StepByStep.Wdt;
import com.singpaulee.mcdhore.rest.ApiClient;
import com.singpaulee.mcdhore.rest.ConfigSpreadsheet;
import com.singpaulee.mcdhore.rest.ConfigWebhost;

import java.util.ArrayList;
import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
	ArrayList<NewsDetail> listOfDoc;                    //list after get from twitter
	ArrayList<NewsDetail> listResult;
	ArrayList<StopWordModel> listStopword;
	ArrayList<KataDasarModel> listKatadasar;

	ArrayList<String> listTokenize = new ArrayList<>(); //daftar kata setelah tokenization
	ArrayList<String> listAfterStopword = new ArrayList<>();
	ArrayList<String> listStemming = new ArrayList<>();
	ArrayList<TfIdfModel> listHasilTfIdf = new ArrayList<>(); //daftar hasil proses tf idf
	ArrayList<WdtModel> listWdf = new ArrayList<>(); //daftar wdt
	ArrayList<Double> listWdqXwdt = new ArrayList<>();
	ArrayList<Double> listVector = new ArrayList<>();
	ArrayList<Double> listCosSim = new ArrayList<>();
	String query;        //get text from edittext

	Double ranking[] = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0,0.0,};
	String dokumen[] = {"", "", "", "", "", "","",};
	Integer index[] = {0, 0, 0, 0, 0, 0,0,};

	Tokenization tokenizationClass;
	TfIdf tfIdf;
	Wdt wdt;
	private TextView mTvDok1;
	private TextView mTvDok2;
	private TextView mTvDok3;
	private TextView mTvDok4;
	private TextView mTvDok5;
	private EditText medtDok6;
	private EditText mEdtQuery;
	private Button mBtnProses;
	private TextView mTvNama1;
	private TextView mTvNama2;
	private TextView mTvNama3;
	private TextView mTvNama4;
	private TextView mTvNama5;
	private TextView mTvNama6;

	private boolean doubleBackToExitPressedOnce=false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();

//		getStopword();
//		getKatadasar();
		getNews();

		listOfDoc = new ArrayList<>();
//		listResult = new ArrayList<>();
		mBtnProses.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if(!validasi()){
					return;
				}
				query = mEdtQuery.getText().toString().trim();
				NewsDetail model = new NewsDetail(mEdtQuery.getText().toString());
				listOfDoc.add(model);
				NewsDetail model1 = new NewsDetail(listResult.get(0).getTweetText());
				listOfDoc.add(model1);
				NewsDetail model2 = new NewsDetail(listResult.get(1).getTweetText());
				listOfDoc.add(model2);
				NewsDetail model3 = new NewsDetail(listResult.get(2).getTweetText());
				listOfDoc.add(model3);
				NewsDetail model4 = new NewsDetail(listResult.get(3).getTweetText());
				listOfDoc.add(model4);
				NewsDetail model5 = new NewsDetail(listResult.get(4).getTweetText());
				listOfDoc.add(model5);
				NewsDetail model6 = new NewsDetail(medtDok6.getText().toString());
				listOfDoc.add(model6);

				for (int list = 0; list < listOfDoc.size(); list++) {
					if (list == 0) {
						Log.d("Q and Doc", "Query: " + listOfDoc.get(list).getTweetText());
					} else {
						Log.d("Q and Doc", "Document: " + listOfDoc.get(list).getTweetText());
					}
				}

//				tokenization();

				Intent i = new Intent(MainActivity.this, TokenizingActivity.class);
				i.putParcelableArrayListExtra("listOfDoc",listOfDoc);
				startActivity(i);

			}
		});
	}

	private boolean validasi() {
		if(medtDok6.getText().toString().isEmpty()){
			medtDok6.setError("Masukkan dokumen lebih dahulu");
			medtDok6.requestFocus();
			return false;
		}
		if (mEdtQuery.getText().toString().isEmpty()){
			mEdtQuery.setError("Masukkan query lebih dahulu");
			mEdtQuery.requestFocus();
			return false;
		}
		return true;
	}


	private void getNews() {
		final ProgressDialog pd = new ProgressDialog(this);
		pd.setMessage("Load Data");
		pd.show();
		ApiClient apiClient = ConfigSpreadsheet.getRetrofit().create(ApiClient.class);
		final Call<ResponseList> responseList = apiClient.list();
		responseList.enqueue(new Callback<ResponseList>() {
			@Override
			public void onResponse(Call<ResponseList> call, Response<ResponseList> response) {
				pd.dismiss();
				ResponseList list = response.body();
				ArrayList<NewsDetail> newsDetails = list.getRespons();
				listResult = newsDetails;
				//ambil data dari spreadsheet, set di texxtview
				String[] dok1 = newsDetails.get(0).getTweetText().split("\\.");
				mTvDok1.setText(dok1[0]);
				String[] dok2 = newsDetails.get(1).getTweetText().split("\\.");
				mTvDok2.setText(dok2[0]);
				String[] dok3 = newsDetails.get(2).getTweetText().split("\\.");
				mTvDok3.setText(dok3[0]);
				String[] dok4 = newsDetails.get(3).getTweetText().split("\\.");
				mTvDok4.setText(dok4[0]);
				String[] dok5 = newsDetails.get(4).getTweetText().split("\\.");
				mTvDok5.setText(dok5[0]);
			}

			@Override
			public void onFailure(Call<ResponseList> call, Throwable t) {
				Toast.makeText(MainActivity.this, "" + t, Toast.LENGTH_SHORT).show();
			}
		});
	}

	//TODO 1 TOKENIZATION
	private void tokenization() {
		//Tokenization
		tokenizationClass = new Tokenization(listOfDoc);
		listTokenize = tokenizationClass.countTerm();

		filtering();
	}


	//TODO 2 FILTERING
	private void filtering() {
		Filtering filtering = new Filtering(listTokenize, listStopword);
		listAfterStopword = filtering.filtering();
		for (int f = 0; f < listAfterStopword.size(); f++) {
			Log.d("StopWord", "" + listAfterStopword.get(f));
		}
		//stemming();
		countTfIdf();
	}

	public void getKatadasar() {
		final ProgressDialog pd = new ProgressDialog(this);
		pd.setMessage("Load Data");
		pd.show();

		ApiClient apiClient = ConfigWebhost.getRetrofit().create(ApiClient.class);
		final Call<ArrayList<KataDasarModel>> q = apiClient.katadasar();
		q.enqueue(new Callback<ArrayList<KataDasarModel>>() {
			@Override
			public void onResponse(Call<ArrayList<KataDasarModel>> call, Response<ArrayList<KataDasarModel>> response) {
				pd.dismiss();
				ArrayList<KataDasarModel> list = response.body();
				listKatadasar = list;
			}

			@Override
			public void onFailure(Call<ArrayList<KataDasarModel>> call, Throwable t) {
				Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
			}
		});
	}

	//TODO 3 STEMMING
	private void stemming() {
		Stemming stemming = new Stemming(listAfterStopword, listKatadasar);
		listStemming = stemming.listStemming();
		for (int s=0;s<listStemming.size();s++){
			Log.d("Stemming", ""+listStemming.get(s));
		}
	}

	//TODO 4 PEMBOBOTAN TF IDF
	private void countTfIdf() {
		tfIdf = new TfIdf(listAfterStopword, listOfDoc);
		listHasilTfIdf = tfIdf.countTfIdf();

		for (int a = 0; a < listHasilTfIdf.size(); a++) {
			Log.d("TFIDF", listHasilTfIdf.get(a).getTerm() + "\t\t\t\t\t" +
					listHasilTfIdf.get(a).getQuery() + "\t" +
					listHasilTfIdf.get(a).getDokumen1() + "\t" +
					listHasilTfIdf.get(a).getDokumen2() + "\t" +
					listHasilTfIdf.get(a).getDokumen3() + "\t" +
					listHasilTfIdf.get(a).getDokumen4() + "\t" +
					listHasilTfIdf.get(a).getDokumen5() + "\t" +
					listHasilTfIdf.get(a).getDokumen6() + "\t" +
					listHasilTfIdf.get(a).getTotalDf() + "\t" +
					listHasilTfIdf.get(a).getDfi() + "\t" +
					listHasilTfIdf.get(a).getIdf() + "\t");
		}

		countWdt();
	}


	private void countWdt() {
		//TODO 5 MENGHITUNG WDF
		wdt = new Wdt(listHasilTfIdf);
		listWdf = wdt.countWdf();

		for (int b = 0; b < listWdf.size(); b++) {
			Log.d("Wdf", listWdf.get(b).getWdq() + "\t" +
					listWdf.get(b).getWd1() + "\t" +
					listWdf.get(b).getWd2() + "\t" +
					listWdf.get(b).getWd3() + "\t" +
					listWdf.get(b).getWd4() + "\t" +
					listWdf.get(b).getWd5() + "\t" +
					listWdf.get(b).getWd6() + "\t");

		}

		//TODO 6 MENGHITUNG WDQ X WDF
		listWdqXwdt = wdt.countWdqXwdt();
		for (int c = 0; c < listWdqXwdt.size(); c++) {
			Log.d("WdqXwd" + (c + 1), "" + listWdqXwdt.get(c));
		}

		//TODO 7 MENGHITUNG PANJANG VECTOR
		listVector = wdt.countVector();
		for (int d = 0; d < listVector.size(); d++) {
			Log.d("Panjang Vector", "" + listVector.get(d));
		}

		//TODO 8 MENGHITUNG COSINUS SIMULARITY
		listCosSim = wdt.countCosSimularity();
		for (int e = 0; e < listCosSim.size(); e++) {
			Log.d("CossineSimularity", "Dok " + (e + 1) + " " + listCosSim.get(e));
			ranking[e] = listCosSim.get(e);
			dokumen[e] = "Dokumen " + (e + 1);
			index[e] = e + 1;
		}

//		Collections.sort(listCosSim);
//		Collections.reverse(listCosSim);

		//TODO 9 MERANKING DOKUMEN
		Double temp;
		String tempDok;
		Integer tempIndex;
		for (int i = 0; i < ranking.length; i++) {
			for (int j = i + 1; j < ranking.length; j++) {
				if (ranking[j] > ranking[i]) {
					temp = ranking[i];
					tempDok = dokumen[i];
					tempIndex = index[i];
					ranking[i] = ranking[j];
					dokumen[i] = dokumen[j];
					index[i] = index[j];
					ranking[j] = temp;
					dokumen[j] = tempDok;
					index[j] = tempIndex;
				}
			}
		}

		showDialog();
	}

	public void showDialog() {
//		final AlertDialog.Builder alertdialog = new AlertDialog.Builder(this);
//		alertdialog.setTitle("Hasil");
//
//		alertdialog
////				.setMessage("" + listCosSim.get(0) + "\n" + listCosSim.get(1) + "\n" + listCosSim.get(2) + "\n" + listCosSim.get(3) + "\n" + listCosSim.get(4))
//				.setMessage(dokumen[0] + " " + ranking[0] + "\n" +
//						dokumen[1] + " " + ranking[1] + "\n" +
//						dokumen[2] + " " + ranking[2] + "\n" +
//						dokumen[3] + " " + ranking[3] + "\n" +
//						dokumen[4] + " " + ranking[4])
//				.setCancelable(false)
//				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//					@Override
//					public void onClick(DialogInterface dialogInterface, int i) {
//
//					}
//				});
//
//		AlertDialog alert = alertdialog.create();
//		alert.show();

		mTvNama1.setText(dokumen[0]);
		String[] dok1 = listOfDoc.get(index[0]).getTweetText().split("\\.");
		mTvDok1.setText(dok1[0]);
//		mTvDok1.setText(listOfDoc.get(index[0]).getTweetText());

		mTvNama2.setText(dokumen[1]);
		String[] dok2 = listOfDoc.get(index[1]).getTweetText().split("\\.");
		mTvDok2.setText(dok2[0]);
//		mTvDok2.setText(listOfDoc.get(index[1]).getTweetText());

		mTvNama3.setText(dokumen[2]);
		String[] dok3 = listOfDoc.get(index[2]).getTweetText().split("\\.");
		mTvDok3.setText(dok3[0]);
//		mTvDok3.setText(listOfDoc.get(index[2]).getTweetText());

		mTvNama4.setText(dokumen[3]);
		String[] dok4 = listOfDoc.get(index[3]).getTweetText().split("\\.");
		mTvDok4.setText(dok4[0]);
//		mTvDok4.setText(listOfDoc.get(index[3]).getTweetText());

		mTvNama5.setText(dokumen[4]);
		String[] dok5 = listOfDoc.get(index[4]).getTweetText().split("\\.");
		mTvDok5.setText(dok5[0]);

		mTvNama6.setText(dokumen[5]);
		String[] dok6 = listOfDoc.get(index[5]).getTweetText().split("\\.");
		medtDok6.setText(dok6[0]);
//		mTvDok5.setText(listOfDoc.get(index[4]).getTweetText());

	}

	@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
	@Override
	public void onBackPressed() {
		if (doubleBackToExitPressedOnce) {
			super.onBackPressed();
			finishAffinity();
			return;
		}
		this.doubleBackToExitPressedOnce = true;
		Toast.makeText(this, "Ketuk lagi untuk keluar", Toast.LENGTH_SHORT).show();

		new Handler().postDelayed(new Runnable() {
			@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
			@Override
			public void run() {
				doubleBackToExitPressedOnce = false;
				finishAffinity();
			}
		}, 2000);
	}

	private void initView() {
		mTvDok1 = findViewById(R.id.tv_dok1);
		mTvDok2 = findViewById(R.id.tv_dok2);
		mTvDok3 = findViewById(R.id.tv_dok3);
		mTvDok4 = findViewById(R.id.tv_dok4);
		mTvDok5 = findViewById(R.id.tv_dok5);
		medtDok6 = findViewById(R.id.tv_dok6);
		mEdtQuery = findViewById(R.id.edt_query);
		mBtnProses = findViewById(R.id.btn_proses);
		mTvNama1 = findViewById(R.id.tv_nama1);
		mTvNama2 = findViewById(R.id.tv_nama2);
		mTvNama3 = findViewById(R.id.tv_nama3);
		mTvNama4 = findViewById(R.id.tv_nama4);
		mTvNama5 = findViewById(R.id.tv_nama5);
		mTvNama6 = findViewById(R.id.tv_nama6);
	}
}

