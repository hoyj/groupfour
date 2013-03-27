package com.example.groupfour;

import java.util.ArrayList;
import java.util.Map;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class deck extends ListActivity {
	static ArrayList<String> decklistdisplay;
	static ArrayList<String> deckliststudy;
	static ArrayAdapter<String> aa;
	static String chosen;
	static String deckName;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		decklistdisplay = getCards();
		aa = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,decklistdisplay);
		setListAdapter(aa);
	}

	@Override
	protected void onListItemClick(ListView lv, View v, int position, long id) {
		super.onListItemClick(lv, v, position, id);
		deckliststudy=getAll();
		chosen = decklistdisplay.get(position);
		System.out.println("chosen at deck: " + chosen);
		// need to pass in the chosen card position **DO NOT FORGET
		startActivity(new Intent("com.example.groupfour.CARD"));
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	private ArrayList<String> getCards() {
		//only need front for display. the cards at the back, can be created during addcard.
		//the following code is for creating a sample deck that is always existent
		SharedPreferences exf = getSharedPreferences("examplefront", Context.MODE_PRIVATE);
		SharedPreferences exb = getSharedPreferences("exampleback", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = exf.edit();
		SharedPreferences.Editor editor2 = exb.edit();
		editor.clear().apply();//delete any manipulations
		editor2.clear().apply();
		editor.putString("a","a").apply();
		editor2.putString("a","apple").apply();
		editor.putString("b","b").apply();
		editor2.putString("b","banana").apply();
		editor.putString("c","c").apply();
		editor2.putString("c","chocolate").apply();
		editor.putString("d","d").apply();
		editor2.putString("d","developer").apply();
		editor.putString("e","e").apply();
		editor2.putString("e","egg").apply();
		editor.putString("f","f").apply();
		editor2.putString("f","frapuccino").apply();
		editor.putString("g","g").apply();
		editor2.putString("g","gandalf").apply();
		editor.putString("h","h").apply();
		editor2.putString("h","happiness").apply();
		editor.putString("i","i").apply();
		editor2.putString("i","iphone").apply();
		editor.putString("j","j").apply();
		editor2.putString("j","joy").apply();
		editor.putString("k","k").apply();
		editor2.putString("k","korea").apply();
		editor.putString("l","l").apply();
		editor2.putString("l","lucky").apply();
		editor.putString("m","m").apply();
		editor2.putString("m","monopoly").apply();
		editor.putString("n","n").apply();
		editor2.putString("n","nullify").apply();
		editor.putString("o","o").apply();
		editor2.putString("o","osake").apply();
		editor.putString("p","p").apply();
		editor2.putString("p","pineapple").apply();
		editor.putString("q","q").apply();
		editor2.putString("q","quartet").apply();
		editor.putString("s","s").apply();
		editor2.putString("s","sadness").apply();
		editor.putString("t","t").apply();
		editor2.putString("t","table").apply();
		editor.putString("u","u").apply();
		editor2.putString("u","underground").apply();
		editor.putString("v","v").apply();
		editor2.putString("v","vertex").apply();
		editor.putString("w","w").apply();
		editor2.putString("w","wonderful").apply();
		editor.putString("x","x").apply();
		editor2.putString("x","xenophone").apply();
		editor.putString("y","y").apply();
		editor2.putString("y","yolo").apply();
		editor.putString("z","z").apply();
		editor2.putString("z","zoo").apply();	
		
		deckName = MainActivity.chosen;
		System.out.println("deckName at getCards is " + deckName);
		String tmpStr = deckName + "front";
		SharedPreferences cardlist = getSharedPreferences(tmpStr, Context.MODE_PRIVATE);
		Map<String, String> tmp = (Map<String, String>) cardlist.getAll();
		ArrayList<String> result = new ArrayList<String>(tmp.keySet());
		return result;
	}
	
	private ArrayList<String> getAll() {
		SharedPreferences front = getSharedPreferences(deckName + "front", Context.MODE_PRIVATE);
		SharedPreferences back = getSharedPreferences(deckName + "back", Context.MODE_PRIVATE);
		Map<String, String> tmpfront = (Map<String, String>) front.getAll();
		Map<String, String> tmpback = (Map<String, String>) back.getAll();
		ArrayList<String> fulldeck = new ArrayList<String>(tmpfront.values());
		ArrayList<String> backdeck = new ArrayList<String>(tmpback.values());
		int num = fulldeck.size();
		for(int i = 0; i < num; ++i) {
			fulldeck.add((i*2)+1,backdeck.get(i));
		}
		
		return fulldeck;
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater ab = getMenuInflater();
		ab.inflate(R.menu.main3, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.addCard:
			startActivity(new Intent("com.example.groupfour.ADDCARD"));
			return true;
		case R.id.deleteCard:
			startActivity(new Intent("com.example.groupfour.DELETECARD"));
			return true;
		}

		return false;
	}
}
