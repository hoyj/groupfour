package com.example.groupfour;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Map;

import android.R.menu;
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
import android.widget.Toast;

public class MainActivity extends ListActivity {
	static ArrayList<String> decklist;
	static ArrayAdapter<String> aa;
	static String chosen;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		decklist = getDecks();
		aa = new ArrayAdapter<String>(this,	android.R.layout.simple_list_item_1, decklist); 
		setListAdapter(aa);
	}

	@Override
	protected void onListItemClick(ListView lv, View v, int position, long id) {
		super.onListItemClick(lv, v, position, id);
		chosen = decklist.get(position);
		System.out.println("chosen at main: " + chosen);
		/*SharedPreferences prefs = getSharedPreferences("param", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putString("deck",chosen).commit();*/	//this string is passed onto deck class.
		startActivity(new Intent("com.example.groupfour.DECK"));
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	private ArrayList<String> getDecks() {
		//initialize and save in sharepreferences
		SharedPreferences prefs = getSharedPreferences("decks", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putString("example","example").commit();
		Map<String, String> tmp = (Map<String, String>) prefs.getAll();
		ArrayList<String> result = new ArrayList<String>(tmp.values());
		return result;
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater ab = getMenuInflater();
		ab.inflate(R.menu.main4, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.addDeck:
			startActivity(new Intent("com.example.groupfour.ADDDECK"));
			return true;
		case R.id.deleteDeck:
			startActivity(new Intent("com.example.groupfour.DELETEDECK"));
			return true;
		case R.id.about:
			Toast tAbout = Toast.makeText(MainActivity.this, "This is a flash card app for OS Project",Toast.LENGTH_LONG);
			tAbout.show();
			return true;
		case R.id.makers:
			Toast tMakers = Toast.makeText(MainActivity.this, "Group4\nJacob Ho\nMary Young\nCharlotte Ruelens\nKramer Allen\nFranklin Sneider",Toast.LENGTH_LONG);
			tMakers.show();
			return true;	
		}
		return false;
	}
}
