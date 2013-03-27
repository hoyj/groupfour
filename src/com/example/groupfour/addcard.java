package com.example.groupfour;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.example.groupfour.R.layout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class addcard extends Activity {
	EditText TextInFront;
	EditText TextInBack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addcard);
		TextInFront = (EditText) findViewById(R.id.etFront);
		TextInBack = (EditText) findViewById(R.id.etBack);
		Button add = (Button) findViewById(R.id.bAddCard);
		Button done = (Button) findViewById(R.id.bDone);

		add.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (TextInFront.getText().toString() != null
						&& TextInBack.getText().toString() != null) {
					(deck.decklistdisplay).add(TextInFront.getText().toString());	//first add to deck for display.
					deck.aa.notifyDataSetChanged();
					//then add to front and back.
					String fStr = deck.deckName + "front";
					String bStr = deck.deckName + "back";
					SharedPreferences front = getSharedPreferences(fStr, Context.MODE_PRIVATE);
					SharedPreferences.Editor editor = front.edit();
					editor.putString(TextInFront.getText().toString(),TextInFront.getText().toString()).apply();
					SharedPreferences back = getSharedPreferences(bStr, Context.MODE_PRIVATE);
					SharedPreferences.Editor editor1 = back.edit();
					editor1.putString(TextInFront.getText().toString(),TextInBack.getText().toString()).apply();
					startActivity(new Intent("com.example.groupfour.ADDCARD"));
				}
			}
		});
		done.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (TextInFront.getText().toString() != null
						&& TextInBack.getText().toString() != null) {
					(deck.decklistdisplay).add(TextInFront.getText().toString());	//first add to deck for display.
					deck.aa.notifyDataSetChanged();
					//then add to front and back.
					String fStr = deck.deckName + "front";
					String bStr = deck.deckName + "back";
					SharedPreferences front = getSharedPreferences(fStr, Context.MODE_PRIVATE);
					SharedPreferences.Editor editor = front.edit();
					editor.putString(TextInFront.getText().toString(),TextInFront.getText().toString()).apply();
					SharedPreferences back = getSharedPreferences(bStr, Context.MODE_PRIVATE);
					SharedPreferences.Editor editor1 = back.edit();
					editor1.putString(TextInFront.getText().toString(),TextInBack.getText().toString()).apply();
				}
				finish();
			}
		});
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}	
}
