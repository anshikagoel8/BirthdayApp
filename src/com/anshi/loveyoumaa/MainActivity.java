package com.anshi.loveyoumaa;

import java.util.Calendar;
import java.util.Locale;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	String txt;
	TextToSpeech tts;
	public static boolean isQuit = false;

	




	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		 
		    if(MainActivity.isQuit)
		        finish();
	}




	EditText e;
	int res;
	Button b;
	MediaPlayer mp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final Vibrator v=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
		final Calendar cal=Calendar.getInstance();
		final int h=cal.get(Calendar.DATE);
		final int h1=cal.get(Calendar.HOUR_OF_DAY);
		final int h2=cal.get(Calendar.MINUTE);
		final AlertDialog.Builder alert=new AlertDialog.Builder(this);
		
		e=(EditText) findViewById(R.id.editText1);
		b=(Button)findViewById(R.id.button2);
		final Button b1=(Button)findViewById(R.id.button1);
		
		
		
		tts=new TextToSpeech(MainActivity.this,new TextToSpeech.OnInitListener() {
			
			@Override
			public void onInit(int arg0) {
				// TODO Auto-generated method stub
				if(arg0==TextToSpeech.SUCCESS)
					 res=tts.setLanguage(Locale.US);
				 	if(res==TextToSpeech.LANG_MISSING_DATA||res==TextToSpeech.LANG_NOT_SUPPORTED)
				 		Log.e("error","not supported");
				 	
			}
			
		});
		      tts.speak(txt, TextToSpeech.QUEUE_FLUSH,null);
             b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				if(e.getText().toString().equals(null)||e.getText().toString().equals(" "))
				{
					 tts.speak(txt, TextToSpeech.QUEUE_FLUSH, null);
				        Toast.makeText(MainActivity.this,txt,Toast.LENGTH_LONG).show();
				}
				
				if(e.getText().toString().equalsIgnoreCase("kalpana")&& h!=22)
				{  
					  Toast.makeText(MainActivity.this,"Happy Birthday Maa, LOVE YOU",Toast.LENGTH_LONG).show();
						         Intent i=new Intent();
								i.setClass(MainActivity.this,Options.class);
								startActivityForResult(i,0);
						    	 
			    }
			   
				else
					if(!e.getText().toString().equalsIgnoreCase("kalpana")||e.getText().toString().equals(" "))
					      { v.vibrate(400);
						    txt=e.getText().toString()+" you are an invalid user, Please exit  ";
					        @SuppressWarnings("unused")
							int speak = tts.speak(txt, TextToSpeech.QUEUE_FLUSH, null);
					        Toast.makeText(MainActivity.this,txt,Toast.LENGTH_LONG).show();
					      }
					
					
						
					
					if(e.getText().toString().equalsIgnoreCase("kalpana")&& h==22){
						v.vibrate(300);
						
					    if(h1>=1&&h1<=12)
						{  txt="MOM please wait till midnight. "+(11-h1)+" hour(s) "+(60-h2)+ " minute(s) remaining.";
						tts.speak("MOM please wait till midnight. "+(11-h1)+" hour "+(60-h2)+ " minute remaining", TextToSpeech.QUEUE_FLUSH, null);
						}
					    else 
					    	if(h1>=13&&h1<=24)
					    	{
					    		txt="MOM please wait till midnight. "+(23-h1)+" hour(s) "+(60-h2)+ " minute(s) remaining.";
					    		tts.speak("MOM please wait till midnight. "+(23-h1)+" hour "+(60-h2)+ " minute remaining", TextToSpeech.QUEUE_FLUSH, null);
					    	}
						Toast.makeText(MainActivity.this,txt,Toast.LENGTH_LONG).show();
						
						
						}
					
				
					
					
					
					}
		});
             b1.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this,"GoodBye!",Toast.LENGTH_LONG).show();
					
				        finishAffinity();
				        finish();
					}
				});     
	
	
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
}
