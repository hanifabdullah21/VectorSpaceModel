package com.singpaulee.mcdhore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.singpaulee.mcdhore.Model.NewsDetail;
import com.singpaulee.mcdhore.Model.TfIdfModel;
import com.singpaulee.mcdhore.StepByStep.TfIdf;

import java.util.ArrayList;

public class TfIdfActivity extends AppCompatActivity {
	//list untuk menampung daftar hasil proses filtering/stopword
	ArrayList<String> listAfterStopword = new ArrayList<>();

	//list after get from twitter
	ArrayList<NewsDetail> listOfDoc;

	ArrayList<TfIdfModel> listHasilTfIdf = new ArrayList<>();

	TfIdf tfIdf;
	private TextView mJudulActivity;
	private Button mBtnNext;
	private TableLayout mTableTfIdf;
	private TableRow mTableRow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tf_idf);
		initView();

		listAfterStopword = getIntent().getStringArrayListExtra("listAfterStopword");
		listOfDoc = getIntent().getParcelableArrayListExtra("listOfDoc");

		countTfIdf();

		mBtnNext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent i = new Intent(TfIdfActivity.this, WdfActivity.class);
				i.putParcelableArrayListExtra("listHasilTfIdf",listHasilTfIdf);
				i.putStringArrayListExtra("listAfterStopword",listAfterStopword);
				i.putParcelableArrayListExtra("listOfDoc",listOfDoc);
				startActivity(i);
			}
		});
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

		for (int index = 0; index < listHasilTfIdf.size(); index++) {
			mTableRow = new TableRow(this);
			TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
			mTableRow.setLayoutParams(params);
			mTableRow.setGravity(View.TEXT_ALIGNMENT_CENTER);
			params.setMargins(10, 5, 10, 5);

			TextView tvKata = new TextView(this);
			tvKata.setText(listHasilTfIdf.get(index).getTerm());
			tvKata.setTextSize(18);
			tvKata.setLayoutParams(params);
			mTableRow.setId(0);
			mTableRow.addView(tvKata);

			TextView tvFKQ = new TextView(this);
			tvFKQ.setText(""+listHasilTfIdf.get(index).getQuery());
			tvFKQ.setTextSize(18);
			tvFKQ.setLayoutParams(params);
			mTableRow.setId(0);
			mTableRow.addView(tvFKQ);

			TextView tvFKD1 = new TextView(this);
			tvFKD1.setText(""+listHasilTfIdf.get(index).getDokumen1());
			tvFKD1.setTextSize(18);
			tvFKD1.setLayoutParams(params);
			mTableRow.setId(0);
			mTableRow.addView(tvFKD1);

			TextView tvFKD2 = new TextView(this);
			tvFKD2.setText(""+listHasilTfIdf.get(index).getDokumen2());
			tvFKD2.setTextSize(18);
			tvFKD2.setLayoutParams(params);
			mTableRow.setId(0);
			mTableRow.addView(tvFKD2);

			TextView tvFKD3 = new TextView(this);
			tvFKD3.setText(""+listHasilTfIdf.get(index).getDokumen3());
			tvFKD3.setTextSize(18);
			tvFKD3.setLayoutParams(params);
			mTableRow.setId(0);
			mTableRow.addView(tvFKD3);

			TextView tvFKD4 = new TextView(this);
			tvFKD4.setText(""+listHasilTfIdf.get(index).getDokumen4());
			tvFKD4.setTextSize(18);
			tvFKD4.setLayoutParams(params);
			mTableRow.setId(0);
			mTableRow.addView(tvFKD4);

			TextView tvFKD5 = new TextView(this);
			tvFKD5.setText(""+listHasilTfIdf.get(index).getDokumen5());
			tvFKD5.setTextSize(18);
			tvFKD5.setLayoutParams(params);
			mTableRow.setId(0);
			mTableRow.addView(tvFKD5);

			TextView tvFKD6 = new TextView(this);
			tvFKD6.setText(""+listHasilTfIdf.get(index).getDokumen6());
			tvFKD6.setTextSize(18);
			tvFKD6.setLayoutParams(params);
			mTableRow.setId(0);
			mTableRow.addView(tvFKD6);

			TextView tvDFI = new TextView(this);
			tvDFI.setText(""+listHasilTfIdf.get(index).getTotalDf());
			tvDFI.setTextSize(18);
			tvDFI.setLayoutParams(params);
			mTableRow.setId(0);
			mTableRow.addView(tvDFI);

			TextView tvDperDFI = new TextView(this);
			tvDperDFI.setText(""+listHasilTfIdf.get(index).getDfi());
			tvDperDFI.setTextSize(18);
			tvDperDFI.setLayoutParams(params);
			mTableRow.setId(0);
			mTableRow.addView(tvDperDFI);

			TextView tvIDF = new TextView(this);
			tvIDF.setText(""+listHasilTfIdf.get(index).getIdf());
			tvIDF.setTextSize(18);
			tvIDF.setLayoutParams(params);
			mTableRow.setId(0);
			mTableRow.addView(tvIDF);

			mTableTfIdf.addView(mTableRow);
		}
	}

	private void initView() {
		mJudulActivity = findViewById(R.id.judul_activity);
		mBtnNext = findViewById(R.id.btn_next);
		mTableTfIdf = findViewById(R.id.tableTfIdf);
		mTableRow = findViewById(R.id.table_row);
	}
}
