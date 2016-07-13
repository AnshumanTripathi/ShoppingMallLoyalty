package com.shoppingmallloyality;




import java.util.Timer;
import java.util.TimerTask;
import com.shoppingmallloyality.login.MainActivityLogin;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class Launcher extends Activity{
	TextToSpeech tts;
	int i;
	String startup= "Hello user welcome to shopping Mall loyality application";
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launcher);
	
		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Launcher.this,MainActivityLogin.class);
	startActivity(intent);
			}}, 1000);	}
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.launcher, menu);
        return true;
    }



    
}
