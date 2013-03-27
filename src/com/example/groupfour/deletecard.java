package com.example.groupfour;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class deletecard extends ListActivity{
	private ArrayList<String> decklistdisplay = deck.decklistdisplay;
	private ArrayAdapter<String> aa;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		aa = new ArrayAdapter<String>(this,	android.R.layout.simple_list_item_1, decklistdisplay); 
		setListAdapter(aa);
	}
	

	@Override
	protected void onListItemClick(ListView lv, View v, int position, long id) {
		super.onListItemClick(lv, v, position, id);
		String card = decklistdisplay.get(position);
		deck.decklistdisplay.remove(deck.decklistdisplay.indexOf(card));
		SharedPreferences prefs = getSharedPreferences(deck.deckName + "front", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();
		editor.remove(card).apply();	//remove front side	
		SharedPreferences prefs2 = getSharedPreferences(deck.deckName + "back",Context.MODE_PRIVATE);
		SharedPreferences.Editor editor2 = prefs2.edit();
		editor2.remove(card).apply();	//remove back side
		deck.aa.notifyDataSetChanged();
		finish();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
}
