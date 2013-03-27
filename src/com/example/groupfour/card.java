package com.example.groupfour;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class card extends Activity {

	TextView textOut;
	static String cur;	//current String
	static int side = 0;	// if 0, front; if 1, back
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.card);
		cur = deck.chosen;
		textOut = (TextView) findViewById(R.id.tv);
		SharedPreferences card = getSharedPreferences(deck.deckName + "front", Context.MODE_PRIVATE);
		String inputstr = card.getString(deck.chosen,null);
		textOut.setText(inputstr);
		// flip button
		Button flip = (Button) findViewById(R.id.bFlip); // need to finish
		flip.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// onClick, change the card view
				String str;
				int num = deck.deckliststudy.indexOf(cur);
				if (side == 0){
					str = deck.deckliststudy.get(num+1); // if front -> back
				}else{
					str = deck.deckliststudy.get(num);
				}
				side  = (side + 1)%2;
				textOut.setText(str);
			}
		});

		
		
		// prev button
		Button prev = (Button) findViewById(R.id.bPrev); // need to finish
		prev.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//get current position
				int curpos = deck.deckliststudy.indexOf(cur);
				if(curpos - 2 < 0)
					curpos = deck.deckliststudy.size();
				int newpos = (curpos - 2)%deck.deckliststudy.size();
				String str = deck.deckliststudy.get(newpos);
				cur = str;
				side = 0;
				textOut.setText(str);
			}
		});

		// next button
		Button next = (Button) findViewById(R.id.bNext); // need to finish
		next.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				int curpos = deck.deckliststudy.indexOf(cur);
				int newpos = (curpos + 2)%deck.deckliststudy.size();
				String str = deck.deckliststudy.get(newpos);
				cur = str;
				side = 0;
				textOut.setText(str);
			}
		});
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater ab = getMenuInflater();
		ab.inflate(R.menu.main, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.test:
			//Globals.testpos = 0;
			// open up the about activity
			startActivity(new Intent("com.example.groupfour.TEST"));
			return true;
		}

		return false;
	}
}
