package com.anshi.loveyoumaa;

import android.app.Activity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Audiomsg extends Activity {

	String arr[]={"Sandeep","Maa","Anshika","Ishita","Vansh"};
	ListView lv;
	MediaPlayer mp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_audiomsg);
		
		final Vibrator v=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
		lv=(ListView) findViewById(R.id.listView1);
		ArrayAdapter<String>adp= new ArrayAdapter<String>(Audiomsg.this,android.R.layout.simple_list_item_1,arr);
		lv.setAdapter(adp);
		lv.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View arg1, int pos, 
					long id) {
				// TODO Auto-generated method stub
				v.vibrate(50);
				String msg=lv.getItemAtPosition(pos).toString();
				
				
				if(msg.equals(arr[0])){
					Toast.makeText(Audiomsg.this, "Birthday Wishes from Sandeep", Toast.LENGTH_SHORT).show();
					 if(mp!=null&&mp.isPlaying())
							
				        {    mp.stop();         
				        }
			        mp=MediaPlayer.create(Audiomsg.this, R.raw.papa);
			        mp.start();
					}

				if(msg.equals(arr[1])){
					Toast.makeText(Audiomsg.this, "Birthday Wishes from Maa", Toast.LENGTH_SHORT).show();
					 if(mp!=null&&mp.isPlaying())
							
				        {    mp.stop();         
				        }
			        mp=MediaPlayer.create(Audiomsg.this, R.raw.dadiji);
			        mp.start();
					}

				if(msg.equals(arr[2])){
					Toast.makeText(Audiomsg.this, "Birthday Wishes from Anshika", Toast.LENGTH_SHORT).show();
					 if(mp!=null&&mp.isPlaying())
							
				        {    mp.stop();         
				        }
			        mp=MediaPlayer.create(Audiomsg.this, R.raw.anshi);
			        mp.start();
					}

				if(msg.equals(arr[3])){
					Toast.makeText(Audiomsg.this, "Birthday Wishes from Ishita", Toast.LENGTH_SHORT).show();
					 if(mp!=null&&mp.isPlaying())
							
				        {    mp.stop();         
				        }
			        mp=MediaPlayer.create(Audiomsg.this, R.raw.ishi);
			        mp.start();
					}

				if(msg.equals(arr[4])){
					Toast.makeText(Audiomsg.this, "Birthday Wishes from Vansh", Toast.LENGTH_SHORT).show();
					 if(mp!=null&&mp.isPlaying())
							
				        {    mp.stop();         
				        }
			        mp=MediaPlayer.create(Audiomsg.this, R.raw.vansh);
			        mp.start();
					}
				
		}

			
				
			
		
		
		
		});


	
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		if(mp.isPlaying()&&mp!=null)
		{mp.stop();}
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.audiomsg, menu);
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
}
