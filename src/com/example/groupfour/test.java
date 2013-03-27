package com.example.groupfour;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class test extends Activity {
	TextView textOut;
	EditText textIn;
	String str = "";
	Random generator = new Random();
	static ArrayList<String> question; 
	static int index = 0;
	static int attempt = 0;
	static int success = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);
		question = getQuestions();
		success = question.size();
		textOut = (TextView) findViewById(R.id.tvQuestion);
		textIn = (EditText) findViewById(R.id.etAnswer);
		index = generator.nextInt(question.size());
		textOut.setText(question.get(index));
		Button check = (Button) findViewById(R.id.bCheck);
		check.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				//check the edittext and see if the answer is correct
				String ans = textIn.getText().toString();
				SharedPreferences q = getSharedPreferences(deck.deckName+"back", Context.MODE_PRIVATE);
				attempt++;
				if(q.contains(ans) && (q.getString(ans, null)).equals(textOut.getText().toString())) //first check if the input answer is part of the key
				{
					System.out.print("does q contain ans?: ");
					System.out.println(q.contains(ans));
					System.out.print("is it the correct relation?: ");
					System.out.println(q.getString(ans,null).equals(textOut.getText().toString()));
					//if it comes in here, the user provided the correct answer
					//congratulate
					System.out.println("SUCCESSFULLY came here");
					System.out.print("number of questions left before remove: ");
					System.out.println(question.size());
					Toast t = Toast.makeText(test.this, "Correct!",Toast.LENGTH_SHORT);
					t.show();
					//delete card
					question.remove(index);
					System.out.print("number of questions left after remove: ");
					System.out.println(question.size());
					//if the questions are empty(the user successfully finished the test)
					if(question.isEmpty()){
						startActivity(new Intent("com.example.groupfour.FINISH"));
						finish();
					}else{
						//update question
						index = generator.nextInt(question.size());
						textOut.setText(question.get(index));
						textIn.setText("");
						System.out.print("attempts: ");
						System.out.println(test.attempt);
						return;
					}
				}else{
					System.out.println("WRONGFULLY came here");
					//the user got the question wrong. Laugh at their face
					Toast t = Toast.makeText(test.this, "Wrong!",Toast.LENGTH_SHORT);
					t.show();
					//keep the card. Only change the question
					index = generator.nextInt(question.size());
					textOut.setText(question.get(index));
					textIn.setText("");
					System.out.print("attempts: ");
					System.out.println(test.attempt);
					return;
				}
			}
		});
	}
		
	private ArrayList<String> getQuestions(){
		SharedPreferences q = getSharedPreferences(deck.deckName+"back", Context.MODE_PRIVATE);
		Map<String, String> tmp = (Map<String, String>) q.getAll();
		ArrayList<String> result = new ArrayList<String>(tmp.values());	//because values of back arraylist contains the back of cards
		return result;
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
