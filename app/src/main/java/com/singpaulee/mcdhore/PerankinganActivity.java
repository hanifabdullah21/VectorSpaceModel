package com.singpaulee.mcdhore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.singpaulee.mcdhore.Model.NewsDetail;

import java.util.ArrayList;

public class PerankinganActivity extends AppCompatActivity {
	private TextView mTvNama1;
	private TextView mTvDok1;
	private TextView mTvNama2;
	private TextView mTvDok2;
	private TextView mTvNama3;
	private TextView mTvDok3;
	private TextView mTvNama4;
	private TextView mTvDok4;
	private TextView mTvNama5;
	private TextView mTvDok5;
	private TextView mTvNama6;
	private TextView mTvDok6;
	private TextView mJudulActivity;
	private Button mBtnSelesai;

	ArrayList<String> listCosSim;
	ArrayList<NewsDetail> listOfDoc;

	Double ranking[] = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,};
	String dokumen[] = {"", "", "", "", "", "", "",};
	Integer index[] = {0, 0, 0, 0, 0, 0, 0,};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_perankingan);
		initView();

		listCosSim = getIntent().getStringArrayListExtra("listCosSim");
		listOfDoc = getIntent().getParcelableArrayListExtra("listOfDoc");

		perankingan();
		setDokumen();

		mBtnSelesai.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				finish();
				Intent i = new Intent(PerankinganActivity.this, MainActivity.class);
				startActivity(i);
			}
		});
	}

	private void setDokumen() {
		mTvNama1.setText(dokumen[0]);
		String[] dok1 = listOfDoc.get(index[0]).getTweetText().split("\\.");
		mTvDok1.setText(dok1[0]);

		mTvNama2.setText(dokumen[1]);
		String[] dok2 = listOfDoc.get(index[1]).getTweetText().split("\\.");
		mTvDok2.setText(dok2[0]);

		mTvNama3.setText(dokumen[2]);
		String[] dok3 = listOfDoc.get(index[2]).getTweetText().split("\\.");
		mTvDok3.setText(dok3[0]);

		mTvNama4.setText(dokumen[3]);
		String[] dok4 = listOfDoc.get(index[3]).getTweetText().split("\\.");
		mTvDok4.setText(dok4[0]);

		mTvNama5.setText(dokumen[4]);
		String[] dok5 = listOfDoc.get(index[4]).getTweetText().split("\\.");
		mTvDok5.setText(dok5[0]);

		mTvNama6.setText(dokumen[5]);
		String[] dok6 = listOfDoc.get(index[5]).getTweetText().split("\\.");
		mTvDok6.setText(dok6[0]);
	}

	private void perankingan() {
		//TODO 9 MERANKING DOKUMEN
		for (int e = 0; e < listCosSim.size(); e++) {
			ranking[e] = Double.valueOf(listCosSim.get(e));
			dokumen[e] = "Dokumen " + (e + 1);
			index[e] = e + 1;
		}

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
	}

	private void initView() {
		mTvNama1 = findViewById(R.id.tv_nama1);
		mTvDok1 = findViewById(R.id.tv_dok1);
		mTvNama2 = findViewById(R.id.tv_nama2);
		mTvDok2 = findViewById(R.id.tv_dok2);
		mTvNama3 = findViewById(R.id.tv_nama3);
		mTvDok3 = findViewById(R.id.tv_dok3);
		mTvNama4 = findViewById(R.id.tv_nama4);
		mTvDok4 = findViewById(R.id.tv_dok4);
		mTvNama5 = findViewById(R.id.tv_nama5);
		mTvDok5 = findViewById(R.id.tv_dok5);
		mTvNama6 = findViewById(R.id.tv_nama6);
		mTvDok6 = findViewById(R.id.tv_dok6);
		mJudulActivity = findViewById(R.id.judul_activity);
		mBtnSelesai = findViewById(R.id.btn_selesai);
	}
}
