package com.cfp.ssm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.cfp.ssm.R;

public class SchoolWizardRegionActivity extends ActionBarActivity implements OnClickListener, OnItemSelectedListener {
	
	Spinner spnrDistrict;
	Spinner spnrTehsil;
	Spinner spnrUc;
	
	Button btnNext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_school_wizard_region);
		
		spnrDistrict  = (Spinner) findViewById(R.id.spnrDistrict);
		spnrTehsil = (Spinner) findViewById(R.id.spnrTehsil);
		spnrUc = (Spinner) findViewById(R.id.spnrUc);
		
		btnNext = (Button) findViewById(R.id.btnNext);
		
		spnrDistrict.setAdapter(getAdapter(R.array.karachi_districts));
		spnrDistrict.setOnItemSelectedListener(this);
		spnrTehsil.setAdapter(getAdapter(R.array.karachi_east));
		spnrUc.setAdapter(getAdapter(R.array.karachi_central));
		
		btnNext.setOnClickListener(this);
	}
	
	private ArrayAdapter<CharSequence> getAdapter(int resID) {
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
				resID, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		return adapter;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnNext:
			onNext();
			break;

		default:
			break;
		}		
	}
	
	private void onNext() {
		startActivity(new Intent(this, SchoolWizardDataActivity.class));
	}

	@Override
	public void onItemSelected(AdapterView<?> adapterView, View view, int position,
			long arg3) {
		int arrayResID = getResID(position);
		spnrTehsil.setAdapter(getAdapter(arrayResID));
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> adapterView) {
		Toast.makeText(this, "NOTHING", Toast.LENGTH_LONG).show();
		
	}
		
	public int getResID(int position) {
		int resID = 0;
		switch (position) {
		case 0:
			resID = R.array.karachi_east;
			break;
		case 1:
			resID = R.array.karachi_west;
			break;
		case 2:
			resID = R.array.karachi_south;
			break;
		case 3:
			resID = R.array.karachi_central;
			break;
		case 4:
			resID = R.array.karachi_malir;
			break;
		default:
			resID = 0;
			break;
		}
		
		return resID;
	}

}
