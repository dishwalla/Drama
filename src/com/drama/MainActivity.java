package com.drama;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	protected Button drama;
	protected Button rada;
	protected Button theme;
	protected Button march;
	protected Button stop;
	protected MediaPlayer mp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(com.drama.R.layout.activity_main); 
		drama = (Button)findViewById(com.drama.R.id.drama);
		rada = (Button)findViewById(com.drama.R.id.rada);
		theme = (Button)findViewById(com.drama.R.id.theme);
		march = (Button)findViewById(com.drama.R.id.imp_march);
		stop = (Button)findViewById(com.drama.R.id.stop);
		drama.setOnClickListener(this);
		rada.setOnClickListener(this);
		theme.setOnClickListener(this);
		march.setOnClickListener(this);
		stop.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		try{
			switch (v.getId()) 
			{
			case com.drama.R.id.drama:
				playDrama(drama.getContext());
				break;
			case com.drama.R.id.rada: 
				playRada(rada.getContext());
				break;
			case com.drama.R.id.theme:
				playTheme(theme.getContext());
				break;
			case com.drama.R.id.imp_march:
				playMarch(theme.getContext());
				break;
			case com.drama.R.id.stop:
				stopPlay(stop.getContext());
				break;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(com.drama.R.menu.settings, menu);
		MenuItem exit = menu.findItem(com.drama.R.id.action_exit);
		return true;

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId())
		{
		case com.drama.R.id.action_exit:
			android.os.Process.killProcess(android.os.Process.myPid());
			super.onDestroy();
			break; 
		}
		return super.onOptionsItemSelected(item);
	}

	public void playDrama(Context context){
		playIfNotPlay(context, com.drama.R.raw.drama);
	}

	public void playRada(Context context){
		playIfNotPlay(context, com.drama.R.raw.rada);
	}

	public void playTheme(Context context){
		playIfNotPlay(context, com.drama.R.raw.swtheme); 
	}

	public void playMarch(Context context){
		playIfNotPlay(context, com.drama.R.raw.impma);
	}

	public void stopPlay(Context context){
		mp.stop();
	}

	public void playIfNotPlay(Context context, int musicID){
		if (mp != null && mp.isPlaying()){
			return;
		}
		mp = MediaPlayer.create(context, musicID);  
		mp.start(); 

	}
}
