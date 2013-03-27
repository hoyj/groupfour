package com.example.groupfour;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class finish extends Activity{
	TextView textOut;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.finish);
		textOut = (TextView) findViewById(R.id.finish);
		String comment = null;
		double SuccessRate = 0;
		if (test.attempt != 0)
			SuccessRate = (100.0 * test.success/test.attempt);
		System.out.print("success(num of questions): ");
		System.out.println(test.success);
		System.out.print("attempts: ");
		System.out.println(test.attempt);
		if(SuccessRate <= 33)
			comment = "Why not study first?";
		else if(SuccessRate > 33  && SuccessRate <= 66)
			comment = "Little bit more!";
		else //successrate > 66
			comment = "WellDone!";
		textOut.setText(comment + "\n Attempts: "+test.attempt+"\n SuccessRate: " + SuccessRate + "%");
		test.attempt = 0;
		Thread logoTimer = new Thread(){
			public void run(){
				try {
					sleep(5000);
					//we want this intent to open the menu class
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					finish();
				}
				
			}
		};
		logoTimer.start();
	}
}
