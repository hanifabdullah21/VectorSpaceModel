package com.singpaulee.mcdhore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.singpaulee.mcdhore.Model.NewsDetail;
import com.singpaulee.mcdhore.Model.TfIdfModel;
import com.singpaulee.mcdhore.Model.WdtModel;
import com.singpaulee.mcdhore.StepByStep.Wdt;

import java.util.ArrayList;

public class WdfLanjutanActivity extends AppCompatActivity {

	private LinearLayout mRelativeWdqwdf;
	private TextView mJudulActivity2;
	private LinearLayout mLineWdqwdf;
	private Button mBtnNext1;
	private LinearLayout mRelativePanjangVektor;
	private TextView mJudulActivity3;
	private LinearLayout mLinePanjangVektor;
	private Button mBtnNext2;
	private LinearLayout mRelativeCossineSimilarity;
	private TextView mJudulActivity4;
	private LinearLayout mLineCossim;
	private Button mBtnNext3;

	ArrayList<NewsDetail> listOfDoc;
	ArrayList<TfIdfModel> listHasilTfIdf;
	ArrayList<Double> listVector = new ArrayList<>();
	ArrayList<Double> listCossineSimilarity = new ArrayList<>();
	ArrayList<String> listCossineSimilarityStrng = new ArrayList<>();
	Wdt wdt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wdf_lanjutan);
		initView();

		listHasilTfIdf = getIntent().getParcelableArrayListExtra("listHasilTfIdf");
		listOfDoc = getIntent().getParcelableArrayListExtra("listOfDoc");
		wdt = new Wdt(listHasilTfIdf);

		countVectorLength();

		mBtnNext2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				mBtnNext2.setEnabled(false);
				mRelativeCossineSimilarity.setVisibility(View.VISIBLE);
				countCossineSimilarity();
			}
		});

		mBtnNext3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent i = new Intent(WdfLanjutanActivity.this, PerankinganActivity.class);
				i.putStringArrayListExtra("listCosSim",listCossineSimilarityStrng);
				i.putParcelableArrayListExtra("listOfDoc",listOfDoc);
				startActivity(i);
			}
		});
	}

	private void countCossineSimilarity() {
		//TODO 8 MENGHITUNG COSINUS SIMULARITY
		listCossineSimilarity = wdt.countCosSimularity();
		for (int e = 0; e < listCossineSimilarity.size(); e++) {
			Log.d("CossineSimularity", "Dok " + (e + 1) + " " + listCossineSimilarity.get(e));

			listCossineSimilarityStrng.add(String.valueOf(listCossineSimilarity.get(e)));

			TextView textView = new TextView(this);
			textView.setTextSize(16);
			textView.setText("Dokumen "+(e+1)+" "+listCossineSimilarity.get(e));
			mLineCossim.addView(textView);
		}
	}

	private void countVectorLength() {
		//TODO 7 MENGHITUNG PANJANG VECTOR
		listVector = wdt.countVector();
		for (int d = 0; d < listVector.size(); d++) {
			Log.d("Panjang Vector", "" + listVector.get(d));

			TextView textView = new TextView(this);
			textView.setTextSize(16);
			textView.setText("Dokumen "+(d+1)+" "+listVector.get(d));
			mLinePanjangVektor.addView(textView);
		}
	}


	private void initView() {
		mRelativeWdqwdf = findViewById(R.id.relative_wdqwdf);
		mJudulActivity2 = findViewById(R.id.judul_activity2);
		mLineWdqwdf = findViewById(R.id.line_wdqwdf);
		mBtnNext1 = findViewById(R.id.btn_next1);
		mRelativePanjangVektor = findViewById(R.id.relative_panjang_vektor);
		mJudulActivity3 = findViewById(R.id.judul_activity3);
		mLinePanjangVektor = findViewById(R.id.line_panjang_vektor);
		mBtnNext2 = findViewById(R.id.btn_next2);
		mRelativeCossineSimilarity = findViewById(R.id.relative_cossine_similarity);
		mJudulActivity4 = findViewById(R.id.judul_activity4);
		mLineCossim = findViewById(R.id.line_cossim);
		mBtnNext3 = findViewById(R.id.btn_next3);
	}
}
