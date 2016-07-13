package com.shoppingmallloyality.login;

import com.shoppingmallloyality.R;
import com.shoppingmallloyality.location.MainActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivityLogin extends Activity {

	SharedPreferences sharedpreferences;
	EditText userName;
	EditText password;
	public static final String name = "nameKey";
	public static final String pass = "passwordKey";
	public final Context context = this;
	public static final String MyPREFERENCES = "MyPrefs";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.custombox_login_box);
		Button signUp = (Button) findViewById(R.id.signupbtn);
		onClickLogin();

		signUp.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivityLogin.this,
						SignUpActivity.class);
				startActivity(intent);
			}
		});

	}

	// @Override
	// protected void onResume() {
	// sharedpreferences = getSharedPreferences(MyPREFERENCES,
	// Context.MODE_PRIVATE);
	// if (sharedpreferences.contains(name)) {
	// if (sharedpreferences.contains(pass)) {
	// Intent i = new Intent(this, Menuactivity.class);
	// startActivity(i);
	// }
	// }
	// super.onResume();
	// }



	public void onClickLogin() {

		Button canceldialog_button = (Button) findViewById(R.id.cancel_bt);
		canceldialog_button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				setContentView(R.layout.cancel);

			}
		});
		Button logindialog_button = (Button) findViewById(R.id.loginbox_bt);
		userName = (EditText) findViewById(R.id.username_edt);
		password = (EditText) findViewById(R.id.password_edt);
		logindialog_button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				UserController uController = new UserController(
						MainActivityLogin.this);
				uController.open();

				int r = uController.checkUser(userName.getText().toString(),
						password.getText().toString());
				uController.close();
				if (r != 0) {

					Toast.makeText(context, "Login Successfully",
							Toast.LENGTH_SHORT).show();
				//	atLogin();
					Intent intent=new Intent(MainActivityLogin.this,MainActivity.class);
					startActivity(intent);
					MainActivityLogin.this.finish();
				} else {
					userName.setText("");
					password.setText("");
				
					Toast.makeText(context, "Invalid Username or Password",
							Toast.LENGTH_LONG).show();
				}
			}
		});

	}

}
