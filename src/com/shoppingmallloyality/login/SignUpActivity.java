package com.shoppingmallloyality.login;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.shoppingmallloyality.R;



import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class SignUpActivity extends Activity implements OnClickListener {

	private EditText firstName;
	private EditText lastName;
	private EditText userName;
	private EditText password;
	private EditText confirmPassword;
	private EditText emailId;
	private EditText phoneNumber;
	private RadioGroup gender;
	private EditText dob;
	private Spinner citySpinner;
	private Spinner stateSpinner;
	private Spinner countrySpinner;
	private Button register;
	private boolean validate;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(com.shoppingmallloyality.R.layout.activity_register);
		initializeControls();
		List<String> list = setCountrySpinner();
		ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		countrySpinner.setAdapter(spinnerAdapter);
		registerControlOnListner();
	}

	private void initializeControls() {
		firstName = (EditText) findViewById(R.id.first_name);
		lastName = (EditText) findViewById(R.id.last_name);
		userName = (EditText) findViewById(R.id.user_name);
		password = (EditText) findViewById(R.id.password);
		confirmPassword = (EditText) findViewById(R.id.confirm_password);
		emailId = (EditText) findViewById(R.id.email_id);
		phoneNumber = (EditText) findViewById(R.id.phone_number);
		gender = (RadioGroup) findViewById(R.id.gender);
		dob = (EditText) findViewById(R.id.date_of_birth);
		stateSpinner = (Spinner) findViewById(R.id.state_spin);
		citySpinner = (Spinner) findViewById(R.id.city_spin);
		countrySpinner = (Spinner) findViewById(R.id.country_spin);
		register = (Button) findViewById(R.id.button1);

	}

	private void registerControlOnListner() {
		register.setOnClickListener(this);
		dob.setOnClickListener(this);

	}

	private List<String> setCountrySpinner() {
		Locale[] locales = Locale.getAvailableLocales();
		List<String> countryList = new ArrayList<String>();
		for (Locale locale : locales) {
			String country = locale.getDisplayCountry();
			if (country.trim().length() > 0 && !countryList.contains(country)) {
				countryList.add(country);
			}
		}
		Collections.sort(countryList);
		return countryList;

	}


	private boolean validateInput() {
		if (!ValidAction.checkFirstName(firstName.getText().toString())) {
			firstName.setText("");
			firstName.setHintTextColor(Color.RED);
			firstName.setHint("only alphabets");

			validate = false;
		}
		if (!ValidAction.checkLastName(lastName.getText().toString())) {
			lastName.setText("");
			lastName.setHintTextColor(Color.RED);
			lastName.setHint("only alphabets");

			validate = false;
		}
		if (!ValidAction.checkUser(userName.getText().toString())) {
			userName.setText("");
			userName.setHintTextColor(Color.RED);
			userName.setHint("only alphabet then numeric");

			validate = false;
		}
		if (!ValidAction.checkPass(password.getText().toString())) {
			password.setText("");
			password.setHintTextColor(Color.RED);
			password.setHint("more than 5 character");

			validate = false;
		}
		if (!ValidAction.checkConfirmPass(password.getText().toString(),
				confirmPassword.getText().toString())) {
			confirmPassword.setText("");
			confirmPassword.setHintTextColor(Color.RED);
			confirmPassword.setHint("password not match");

			validate = false;
		}
		if (!ValidAction.checkEmail(emailId.getText().toString())) {
			emailId.setText("");
			emailId.setHintTextColor(Color.RED);
			emailId.setHint("abc@xyz.com");

			validate = false;
		}
		if (!ValidAction.checkContact(phoneNumber.getText().toString())) {
			phoneNumber.setText("");
			phoneNumber.setHintTextColor(Color.RED);
			phoneNumber.setHint("enter valid number");

			validate = false;
		}
		Toast.makeText(this, "Validate", Toast.LENGTH_LONG).show();
		return validate;
	}

	@Override
	public void onClick(View v) {
		int choice = v.getId();
		switch (choice) {
		case R.id.button1:
			validate = true;
			validateInput();
			if (validate == true) {
				UserController c = new UserController(SignUpActivity.this);
				String selectedGender = ((RadioButton) findViewById(gender
						.getCheckedRadioButtonId())).getText().toString();
				c.open();
				long success = c.registerUser(firstName.getText().toString()
						.toUpperCase(), lastName.getText().toString()
						.toUpperCase(), userName.getText().toString(), password
						.getText().toString(), emailId.getText().toString(),
						phoneNumber.getText().toString(), selectedGender
								.toUpperCase(), dob.getText().toString(),
						countrySpinner.getSelectedItem().toString()
								.toUpperCase(), stateSpinner.getSelectedItem()
								.toString().toUpperCase(), citySpinner
								.getSelectedItem().toString().toUpperCase());
				if (success != 0) {
					Toast.makeText(SignUpActivity.this,
							"Successfully Registered", Toast.LENGTH_SHORT)
							.show();
					this.finish();
				}
				c.close();
			}
			break;
		case R.id.date_of_birth:
			new DatePickerDialog(SignUpActivity.this, date,
					myCalendar.get(Calendar.YEAR),
					myCalendar.get(Calendar.MONTH),
					myCalendar.get(Calendar.DAY_OF_MONTH)).show();
			break;

		}
	}

	Calendar myCalendar = Calendar.getInstance();

	DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			// TODO Auto-generated method stub
			myCalendar.set(Calendar.YEAR, year);
			myCalendar.set(Calendar.MONTH, monthOfYear);
			myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
			updateLabel();
		}

	};

	private void updateLabel() {

		String myFormat = "MM/dd/yy"; // In which you need put here
		SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

		dob.setText(sdf.format(myCalendar.getTime()));
	}
}
