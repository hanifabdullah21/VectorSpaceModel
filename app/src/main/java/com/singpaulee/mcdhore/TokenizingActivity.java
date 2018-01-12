package com.singpaulee.mcdhore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.singpaulee.mcdhore.Model.NewsDetail;
import com.singpaulee.mcdhore.StepByStep.Tokenization;

import java.util.ArrayList;
import java.util.Collections;

public class TokenizingActivity extends AppCompatActivity {
	ArrayList<NewsDetail> listOfDoc;                 //list after get from twitter
	ArrayList<String> listTokenize = new ArrayList<>(); //daftar kata setelah tokenization

	Tokenization tokenizationClass;
	private LinearLayout mLineTokenize;
	private Button mBtnNext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tokenizing);

		initView();

		listOfDoc = getIntent().getParcelableArrayListExtra("listOfDoc");
		tokenization();

		mBtnNext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent i = new Intent(TokenizingActivity.this, StopWordActivity.class);
				i.putStringArrayListExtra("listTokenize",listTokenize);
				i.putParcelableArrayListExtra("listOfDoc",listOfDoc);
				startActivity(i);
			}
		});
	}

	//TODO 1 TOKENIZATION
	private void tokenization() {
		//Tokenization
		tokenizationClass = new Tokenization(listOfDoc);
		listTokenize = tokenizationClass.countTerm();
		Collections.sort(listTokenize);

		for (int index = 0; index < listTokenize.size(); index++) {
			TextView textView = new TextView(this);
			textView.setTextSize(16);
			textView.setText(listTokenize.get(index));
			mLineTokenize.addView(textView);
		}
	}

	private void initView() {
		mLineTokenize = findViewById(R.id.line_tokenize);
		mBtnNext = findViewById(R.id.btn_next);
	}
}
