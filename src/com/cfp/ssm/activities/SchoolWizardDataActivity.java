package com.cfp.ssm.activities;

import com.cfp.ssm.R;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SchoolWizardDataActivity extends ActionBarActivity {

	Spinner spnrSchoolStatus;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_school_wizard_data);
		
		spnrSchoolStatus = (Spinner) findViewById(R.id.spnrStatus);
		spnrSchoolStatus.setAdapter(getAdapter(R.array.school_status));
	}
	
	private ArrayAdapter<CharSequence> getAdapter(int resID) {
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
				resID, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		return adapter;
	}
}
