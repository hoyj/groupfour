package com.example.groupfour;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Map;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class deletedeck extends ListActivity {
	private ArrayList<String> decklist = MainActivity.decklist;
	private ArrayAdapter<String> aa;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		aa = new ArrayAdapter<String>(this,	android.R.layout.simple_list_item_1, decklist); 
		setListAdapter(aa);
	}
	

	@Override
	protected void onListItemClick(ListView lv, View v, int position, long id) {
		super.onListItemClick(lv, v, position, id);
		String deck = decklist.get(position);
		MainActivity.decklist.remove(MainActivity.decklist.indexOf(deck));
		SharedPreferences prefs = getSharedPreferences("decks", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();
		editor.remove(deck).apply();	
		SharedPreferences prefs2 = getSharedPreferences(deck,Context.MODE_PRIVATE);
		SharedPreferences.Editor editor2 = prefs2.edit();
		editor.clear().apply();
		MainActivity.aa.notifyDataSetChanged();
		finish();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
}
