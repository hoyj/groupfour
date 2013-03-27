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

public class adddeck extends Activity {
	EditText TextIn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adddeck);
		TextIn = (EditText) findViewById(R.id.etDeck);
		
		Button atd = (Button) findViewById(R.id.bAddToDeck);
		//pressing this button will change the view to add card.
		atd.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (TextIn.getText().toString().length() != 0){
					MainActivity.decklist.add(TextIn.getText().toString());
					SharedPreferences prefs = getSharedPreferences("decks", Context.MODE_PRIVATE);
					SharedPreferences.Editor editor = prefs.edit();
					editor.putString(TextIn.getText().toString(),TextIn.getText().toString()).apply();
					MainActivity.aa.notifyDataSetChanged();
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
