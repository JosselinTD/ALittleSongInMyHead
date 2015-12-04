package com.josselin.alittlesonginmyhead;

import com.example.alittlesonginmyhead.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * This activity handle all the process : play, pause, rate
 * @author Josselin
 *
 */
public class HomeActivity extends Activity {
	
	private View playPause, play, pause, rate;
	private boolean playing;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		
		playing = false;
		
		playPause = findViewById(R.id.play_pause);
		play = findViewById(R.id.play);
		pause = findViewById(R.id.pause);
		rate = findViewById(R.id.rate);
		
		playPause.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(playing){
					pause.setVisibility(View.GONE);
					play.setVisibility(View.VISIBLE);
				} else {
					pause.setVisibility(View.VISIBLE);
					play.setVisibility(View.GONE);
				}
				playing = !playing;
			}
		});
		
		rate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_VIEW);
			    //Try Google play
			    intent.setData(Uri.parse("market://details?id=com.josselin.alittlesonginmyhead"));
			    startActivity(intent);
			}
		});
	}
}
