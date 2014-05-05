package com.cfp.ssm.activities;

import com.cfp.ssm.R;
import com.cfp.ssm.R.id;
import com.cfp.ssm.R.layout;
import com.cfp.ssm.R.menu;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment implements
			OnClickListener {

		Button btnViewSchools;
		Button btnEnterSchool;

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			btnViewSchools = (Button) rootView
					.findViewById(R.id.btnViewSchools);
			btnEnterSchool = (Button) rootView
					.findViewById(R.id.btnEnterSchool);
			btnViewSchools.setOnClickListener(this);
			btnEnterSchool.setOnClickListener(this);
			return rootView;
		}

		@Override
		public void onClick(View view) {
			switch (view.getId()) {
			case R.id.btnEnterSchool:
				onEnterSchool();
				break;
				
			case R.id.btnViewSchools:
				onViewSchools();
				break;

			default:
				break;
			}

		}

		private void onEnterSchool() {
			startActivity(new Intent(getActivity(), SchoolWizardMapActivity.class));
		}

		private void onViewSchools() {
			startActivity(new Intent(getActivity(), ViewSchoolActivity.class));
		}
	}

}
