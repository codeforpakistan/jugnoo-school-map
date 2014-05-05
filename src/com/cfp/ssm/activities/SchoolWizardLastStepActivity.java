package com.cfp.ssm.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.cfp.ssm.R;

public class SchoolWizardLastStepActivity extends ActionBarActivity {
	
	EditText editTxtSchoolName;
	Spinner spnrDistrict;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_last_step);
		editTxtSchoolName = (EditText)findViewById(R.id.editTxtSchoolName);
		spnrDistrict = (Spinner) findViewById(R.id.spnrDistrict);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.karachi_districts, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spnrDistrict.setAdapter(adapter);
	}

}
