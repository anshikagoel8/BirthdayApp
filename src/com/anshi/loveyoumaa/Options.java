package com.anshi.loveyoumaa;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Options extends Activity {

	String arr[]={"Voice Messages","Memories","WeLoveYou","Exit"};
	ListView lv;
	MediaPlayer mp;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_options);
		
		final Vibrator v=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
		final AlertDialog.Builder ad=new AlertDialog.Builder(this);
		lv=(ListView) findViewById(R.id.listView1);
		ArrayAdapter<String>adp= new ArrayAdapter<String>(Options.this,android.R.layout.simple_list_item_1,arr);
		lv.setAdapter(adp);
		if(mp!=null&&mp.isPlaying())
	    {   
		 mp.stop();         
        }
			
		
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View arg1, int pos,
					long id) {
				// TODO Auto-generated method stub
				String msg=lv.getItemAtPosition(pos).toString();
				if(msg.equals(arr[0])){
					v.vibrate(50);
					Toast.makeText(Options.this," Messages from ur loved ones",Toast.LENGTH_SHORT).show();
					Intent i=new Intent();
					i.setClass(Options.this, Audiomsg.class);
					startActivity(i);
					}
				if(msg.equals(arr[1])){
					v.vibrate(50);
					Toast.makeText(Options.this,"Memories with dear ones",Toast.LENGTH_SHORT).show();
					Intent i=new Intent();
					i.setClass(Options.this, Memory.class);
					startActivity(i);
					}
				
			
				if(msg.equals(arr[2])){
					v.vibrate(50);
					Toast.makeText(Options.this,"For My DEar MOM!",Toast.LENGTH_SHORT).show();
					Intent i=new Intent();
					i.setClass(Options.this, Gallery.class);
					startActivity(i);
					}
				
				
				if(msg.equals(arr[3]))
				{
					v.vibrate(50);
					ad.setTitle("Confirmation");
					ad.setMessage("Are you sure you want to exit?");
					ad.setCancelable(true);
					ad.setPositiveButton("yes", new OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							v.vibrate(50);
							Toast.makeText(Options.this,"Wish You A very Happy Birthday Maa !",Toast.LENGTH_LONG).show(); 
							
							
							finishAffinity();
							  finish();
							
						}
					});
					ad.setNegativeButton("No", new OnClickListener() {
						
						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							// TODO Auto-generated method stub
							v.vibrate(50);
						}
					});
					AlertDialog dialog=ad.create();
					dialog.show();
				}
			}
		});
	 
	
		
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.options, menu);
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
