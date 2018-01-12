package com.singpaulee.mcdhore;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.singpaulee.mcdhore.Model.NewsDetail;
import com.singpaulee.mcdhore.Model.StopWordModel;
import com.singpaulee.mcdhore.StepByStep.Filtering;
import com.singpaulee.mcdhore.rest.ApiClient;
import com.singpaulee.mcdhore.rest.ConfigWebhost;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StopWordActivity extends AppCompatActivity {
	ArrayList<String> listTokenize;

	//list untuk menampung daftar stopword setelah load dari database
	ArrayList<StopWordModel> listStopword;

	//list untuk menampung daftar hasil proses filtering/stopword
	ArrayList<String> listAfterStopword = new ArrayList<>();

	//list after get from twitter
	ArrayList<NewsDetail> listOfDoc;

	private LinearLayout mLineStopword;
	private TextView mJudulAvtivity;
	private Button mBtnNext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stop_word);
		initView();

		listTokenize = getIntent().getStringArrayListExtra("listTokenize");
		listOfDoc = getIntent().getParcelableArrayListExtra("listOfDoc");
		getStopword();

		mBtnNext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent i = new Intent(StopWordActivity.this, TfIdfActivity.class);
				i.putParcelableArrayListExtra("listOfDoc",listOfDoc);
				i.putStringArrayListExtra("listAfterStopword",listAfterStopword);
				startActivity(i);
			}
		});

	}

	public void getStopword() {
		final ProgressDialog pd = new ProgressDialog(this);
		pd.setMessage("Load Data");
		pd.show();

		ApiClient apiClient = ConfigWebhost.getRetrofit().create(ApiClient.class);
		final Call<ArrayList<StopWordModel>> q = apiClient.stopword();
		q.enqueue(new Callback<ArrayList<StopWordModel>>() {
			@Override
			public void onResponse(Call<ArrayList<StopWordModel>> call, Response<ArrayList<StopWordModel>> response) {
				pd.dismiss();
				ArrayList<StopWordModel> list = response.body();
				listStopword = list;
				filtering();
			}

			@Override
			public void onFailure(Call<ArrayList<StopWordModel>> call, Throwable t) {
				Toast.makeText(StopWordActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
			}
		});
	}

	private void filtering() {
		Filtering filtering = new Filtering(listTokenize, listStopword);
		listAfterStopword = filtering.filtering();
		for (int f = 0; f < listAfterStopword.size(); f++) {
			Log.d("StopWord", "" + listAfterStopword.get(f));
		}

		for (int index = 0; index < listAfterStopword.size(); index++) {
			TextView textView = new TextView(this);
			textView.setTextSize(16);
			textView.setText(listAfterStopword.get(index));
			mLineStopword.addView(textView);
		}
	}

	private void initView() {
		mLineStopword = findViewById(R.id.line_stopword);
		mJudulAvtivity = findViewById(R.id.judul_avtivity);
		mBtnNext = findViewById(R.id.btn_next);
	}
}
