package com.singpaulee.mcdhore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.singpaulee.mcdhore.Model.NewsDetail;
import com.singpaulee.mcdhore.Model.TfIdfModel;
import com.singpaulee.mcdhore.Model.WdtModel;
import com.singpaulee.mcdhore.StepByStep.Wdt;

import java.util.ArrayList;

public class WdfActivity extends AppCompatActivity {
	private LinearLayout mRelativeWdf;
	private TextView mJudulActivity1;
	private LinearLayout mLineWdf;
	private LinearLayout mRelativeWdqwdf;
	private TextView mJudulActivity2;
	private Button mBtnNext;
	private LinearLayout mLineWdqwdf;
	private Button mBtnNext1;
	private TableLayout mTableWdf;
	private TableRow mTableRow;

	ArrayList<NewsDetail> listOfDoc;
	ArrayList<Double> listWdqXwdt = new ArrayList<>();
	ArrayList<TfIdfModel> listHasilTfIdf;
	ArrayList<String> listAfterStopword;
	ArrayList<WdtModel> listWdf = new ArrayList<>();
	Wdt wdt;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wdf);
		initView();

		listHasilTfIdf = getIntent().getParcelableArrayListExtra("listHasilTfIdf");
		listAfterStopword = getIntent().getStringArrayListExtra("listAfterStopword");
		listOfDoc = getIntent().getParcelableArrayListExtra("listOfDoc");
		wdt = new Wdt(listHasilTfIdf);

		countWdt();

		mBtnNext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				countWdqWdf();
				mBtnNext.setEnabled(false);
				mRelativeWdqwdf.setVisibility(View.VISIBLE);
			}
		});

		mBtnNext1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent i = new Intent(WdfActivity.this, WdfLanjutanActivity.class);
				i.putParcelableArrayListExtra("listHasilTfIdf", listHasilTfIdf);
				i.putParcelableArrayListExtra("listOfDoc", listOfDoc);
				startActivity(i);
			}
		});
	}

	private void countWdqWdf() {
		//TODO 6 MENGHITUNG WDQ X WDF
		listWdqXwdt = wdt.countWdqXwdt();
		for (int c = 0; c < listWdqXwdt.size(); c++) {
			Log.d("WdqXwd" + (c + 1), "" + listWdqXwdt.get(c));

			TextView textView = new TextView(this);
			textView.setText("Wdq*Wd" + (c + 1) + " " + listWdqXwdt.get(c));
			textView.setTextSize(16);

			mLineWdqwdf.addView(textView);
		}
	}

	private void countWdt() {
		//TODO 5 MENGHITUNG WDF
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

		for (int index = 0; index < listWdf.size(); index++) {
			mTableRow = new TableRow(this);
			TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
			mTableRow.setLayoutParams(params);
			mTableRow.setGravity(View.TEXT_ALIGNMENT_CENTER);
			params.setMargins(10, 5, 10, 5);
			mTableRow.setWeightSum(1);

			TextView tvKata = new TextView(this);
			tvKata.setText(listHasilTfIdf.get(index).getTerm());
			tvKata.setTextSize(18);
			tvKata.setLayoutParams(params);
			mTableRow.setId(0);
			mTableRow.addView(tvKata);

			TextView tvWDQ = new TextView(this);
			tvWDQ.setText("" + listWdf.get(index).getWdq());
			tvWDQ.setTextSize(18);
			tvWDQ.setLayoutParams(params);
			mTableRow.setId(0);
			mTableRow.addView(tvWDQ);

			TextView tvWD1 = new TextView(this);
			tvWD1.setText("" + listWdf.get(index).getWd1());
			tvWD1.setTextSize(18);
			tvWD1.setLayoutParams(params);
			mTableRow.setId(0);
			mTableRow.addView(tvWD1);

			TextView tvWD2 = new TextView(this);
			tvWD2.setText("" + listWdf.get(index).getWd2());
			tvWD2.setTextSize(18);
			tvWD2.setLayoutParams(params);
			mTableRow.setId(0);
			mTableRow.addView(tvWD2);

			TextView tvWD3 = new TextView(this);
			tvWD3.setText("" + listWdf.get(index).getWd3());
			tvWD3.setTextSize(18);
			tvWD3.setLayoutParams(params);
			mTableRow.setId(0);
			mTableRow.addView(tvWD3);

			TextView tvWD4 = new TextView(this);
			tvWD4.setText("" + listWdf.get(index).getWd4());
			tvWD4.setTextSize(18);
			tvWD4.setLayoutParams(params);
			mTableRow.setId(0);
			mTableRow.addView(tvWD4);

			TextView tvWD5 = new TextView(this);
			tvWD5.setText("" + listWdf.get(index).getWd5());
			tvWD5.setTextSize(18);
			tvWD5.setLayoutParams(params);
			mTableRow.setId(0);
			mTableRow.addView(tvWD5);

			TextView tvWD6 = new TextView(this);
			tvWD6.setText("" + listWdf.get(index).getWd6());
			tvWD6.setTextSize(18);
			tvWD6.setLayoutParams(params);
			mTableRow.setId(0);
			mTableRow.addView(tvWD6);

			mTableWdf.addView(mTableRow);
		}
	}

	private void initView() {
		mBtnNext = findViewById(R.id.btn_next);
		mLineWdqwdf = findViewById(R.id.line_wdqwdf);
		mBtnNext1 = findViewById(R.id.btn_next1);
		mTableWdf = findViewById(R.id.table_wdf);
		mTableRow = findViewById(R.id.table_row);
		mRelativeWdf = findViewById(R.id.relative_wdf);
		mJudulActivity1 = findViewById(R.id.judul_activity1);
		mLineWdf = findViewById(R.id.line_wdf);
		mRelativeWdqwdf = findViewById(R.id.relative_wdqwdf);
		mJudulActivity2 = findViewById(R.id.judul_activity2);
	}
}
