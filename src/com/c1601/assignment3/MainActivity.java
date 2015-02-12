package com.c1601.assignment3;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.*;
import android.app.*;

public class MainActivity extends Activity {

	//create variables for form attributes
	private Button dec;
	private Button bin;
	private Button hex;
	private EditText text;
	private NumberConverter nc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//look in fragment_ain
		setContentView(R.layout.fragment_main);
		
		//initialize attribute variables
		nc = new NumberConverter();
		text = (EditText) this.findViewById(R.id.text_box);
		dec = (Button) this.findViewById(R.id.decimal);
		bin = (Button) this.findViewById(R.id.binary);
		hex = (Button) this.findViewById(R.id.hex);

		// add listener to decimal button
		dec.setOnClickListener(new OnClickListener() {
			// handle event
			public void onClick(View view) {

				text.setBackgroundResource(android.R.drawable.editbox_background_normal);
				dec.setBackgroundResource(R.drawable.green_rounded_button);
				bin.setBackgroundResource(R.drawable.red_rounded_button);
				hex.setBackgroundResource(R.drawable.red_rounded_button);

				String t = text.getText().toString();
				if (nc.toDecimal(t).equals("error")) {
					text.setBackgroundResource(R.drawable.error_box);
				}
				text.setText(nc.toDecimal(t));
			}
		});
		
		//add listener to binary button
		bin.setOnClickListener(new OnClickListener() {
			// handle event
			public void onClick(View view) {

				text.setBackgroundResource(android.R.drawable.editbox_background_normal);
				dec.setBackgroundResource(R.drawable.red_rounded_button);
				bin.setBackgroundResource(R.drawable.green_rounded_button);
				hex.setBackgroundResource(R.drawable.red_rounded_button);

				String t = text.getText().toString();
				if (nc.toDecimal(t).equals("error")) {
					text.setBackgroundResource(R.drawable.error_box);
				}

				text.setText(nc.toBinary(t));
			}
		});
		
		//add listener to hex button
		hex.setOnClickListener(new OnClickListener() {
			// handle event
			public void onClick(View view) {

				text.setBackgroundResource(android.R.drawable.editbox_background_normal);
				dec.setBackgroundResource(R.drawable.red_rounded_button);
				bin.setBackgroundResource(R.drawable.red_rounded_button);
				hex.setBackgroundResource(R.drawable.green_rounded_button);

				String t = text.getText().toString();
				if (nc.toDecimal(t).equals("error")) {
					text.setBackgroundResource(R.drawable.error_box);
				}
				text.setText(nc.toHex(t));
			}
		});

		/*
		 * if (savedInstanceState == null) {
		 * getFragmentManager().beginTransaction() .add(R.id.container, new
		 * PlaceholderFragment()) .commit(); }
		 */
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
