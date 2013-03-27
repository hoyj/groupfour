package com.example.groupfour;

import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class test extends Activity {
	TextView textOut;
	TextView textType;
	String str = "";
	Random generator = new Random();
	static ArrayList<String> low = new ArrayList<String>(deck.deckliststudy);
	static ArrayList<String> medium = new ArrayList<String>();
	static ArrayList<String> high = new ArrayList<String>();
	static int type;
	static int side = 0;
	static String front;
	static String back;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);
		textType = (TextView) findViewById(R.id.tvType);
		textOut = (TextView) findViewById(R.id.tvTest);
		front = low.get(0);	//always start from first card of low deck
		back = low.get(1);
		textOut.setText(front);
		str = "low";
		textType.setText(str);
		type = 0;	//start at low list
		//flip button
		Button flip = (Button) findViewById(R.id.bFlip); // need to finish
		flip.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//onClick, change the card view
				if(side == 0){
					textOut.setText(back);	//if front -> back
				}else{
					textOut.setText(front);	//if back -> front			
				}
				side  = (side + 1)%2;
			}
		});
	
	//ratings
	/*
	 * after every click, run the random number generator. If 0~8: low list, 9~12: medium list, 13:high list
	 */
		//low rating
		/*
		 * when the user presses low for this card, add this card to BACK OF LOW DECK, THEN DELETE FIRST CARD
		 */
		Button l = (Button) findViewById(R.id.bLow); // need to finish
		l.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(type == 0){	//currrently in low list
					//add card(front) to new list
					low.add(front);//front
					low.add(back);//back
					//then delete first(current) card
					low.remove(0);
					low.remove(0);
				}
				if(type == 1){	//currrently in low list
					//add card(front) to new list
					low.add(front);//front
					low.add(back);//back
					//then delete first(current) card
					medium.remove(0);
					medium.remove(0);
				}
				if(type == 2){	//currrently in low list
					//add card(front) to new list
					low.add(front);//front
					low.add(back);//back
					//then delete first(current) card
					high.remove(0);
					high.remove(0);
				}
				//then run the random number gen
				next();
			}
		});
		
		//medium rating
		/*
		 * when the user presses medium for this card, add this card to BACK OF MEDIUM DECK, THEN DELETE FIRST CARD
		 */
		Button m = (Button) findViewById(R.id.bMedium); // need to finish
		m.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(type == 0){	//currrently in low list
					//add card(front) to new list
					medium.add(front);//front
					medium.add(back);//back
					//then delete first(current) card
					low.remove(0);
					low.remove(0);
				}
				if(type == 1){	//currrently in low list
					//add card(front) to new list
					medium.add(front);//front
					medium.add(back);//back
					//then delete first(current) card
					medium.remove(0);
					medium.remove(0);
				}
				if(type == 2){	//currrently in low list
					//add card(front) to new list
					medium.add(front);//front
					medium.add(back);//back
					//then delete first(current) card
					high.remove(0);
					high.remove(0);
				}
				//then run the random number gen
				next();
			}
		});

		//high rating
		/*
		 * when the user presses high for this card, add this card to BACK OF HIGH DECK, THEN DELETE FIRST CARD
		 */
		Button h = (Button) findViewById(R.id.bHigh); // need to finish
		h.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(type == 0){	//currrently in low list
					//add card(front) to new list
					high.add(front);//front
					high.add(back);//back
					//then delete first(current) card
					low.remove(0);
					low.remove(0);
				}
				if(type == 1){	//currrently in low list
					//add card(front) to new list
					high.add(front);//front
					high.add(back);//back
					//then delete first(current) card
					medium.remove(0);
					medium.remove(0);
				}
				if(type == 2){	//currrently in low list
					//add card(front) to new list
					high.add(front);//front
					high.add(back);//back
					//then delete first(current) card
					high.remove(0);
					high.remove(0);
				}
				//then run the random number gen
				next();
			}
		});

	}
	
	private void next(){
		int random = generator.nextInt(14);
		
		if(random <= 8 && random >= 0){
			if(!low.isEmpty()){
				front = low.get(0);
				back = low.get(1);
				type = 0;
				str = "low";
				textOut.setText(front);
			}
		}else if(random <= 12 && random >= 9){
			if(!medium.isEmpty()){
				front = medium.get(0);
				back = medium.get(1);
				type = 1;
				str = "medium";
				textOut.setText(front);
			}
		}else{	//13
			if(!high.isEmpty()){
				front = high.get(0);
				back = high.get(1);
				type = 2;
				str = "high";
				textOut.setText(front);
			}
		}
		textType.setText(str); 
		side = 0;
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater ab = getMenuInflater();
		ab.inflate(R.menu.main2, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.study:
			// open up the about activity
			startActivity(new Intent("com.example.groupfour.CARD"));
			return true;
		}

		return false;
	}
}
