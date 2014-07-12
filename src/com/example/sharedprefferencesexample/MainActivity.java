package com.example.sharedprefferencesexample;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView name, phone, email, street, place;
	public static final String MyPREFERENCES = "MyPrefs" ;
	public static final String NOMBRE = "nameKey"; 
	public static final String TELEFONO = "phoneKey"; 
	public static final String EMAIL = "emailKey"; 
	public static final String CALLE = "streetKey"; 
	public static final String LUGAR = "placeKey"; 

	SharedPreferences sharedpreferences;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		name = (TextView) findViewById(R.id.editTextName);
		phone = (TextView) findViewById(R.id.editTextPhone);
		email = (TextView) findViewById(R.id.editTextStreet);
		street = (TextView) findViewById(R.id.editTextEmail);
		place = (TextView) findViewById(R.id.editTextCity);

		sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

		if (sharedpreferences.contains(NOMBRE)){
			name.setText(sharedpreferences.getString(NOMBRE, ""));
		}if (sharedpreferences.contains(TELEFONO)){
			phone.setText(sharedpreferences.getString(TELEFONO, ""));
		}if (sharedpreferences.contains(EMAIL)){
			email.setText(sharedpreferences.getString(EMAIL, ""));
		}
		if (sharedpreferences.contains(CALLE)){
			street.setText(sharedpreferences.getString(CALLE, ""));
		}
		if (sharedpreferences.contains(LUGAR)){
			place.setText(sharedpreferences.getString(LUGAR,""));
		}
	}

	public void guardar(View view){
		String n  = name.getText().toString();
		String ph  = phone.getText().toString();
		String e  = email.getText().toString();
		String s  = street.getText().toString();
		String p  = place.getText().toString();
		Editor editor = sharedpreferences.edit();
		editor.putString(NOMBRE, n);
		editor.putString(TELEFONO, ph);
		editor.putString(EMAIL, e);
		editor.putString(CALLE, s);
		editor.putString(LUGAR, p);

		editor.commit(); 

	}

}
