package com.cfp.ssm.activities;

import com.cfp.ssm.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SchoolWizardMapActivity extends ActionBarActivity implements
		OnClickListener, GooglePlayServicesClient.ConnectionCallbacks,
		GooglePlayServicesClient.OnConnectionFailedListener, LocationListener, OnMapClickListener {

	Button btnNext;
	GoogleMap googleMap;

	LocationClient locationClient;
	
	Marker marker;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_school_wizard_map);
		btnNext = (Button) findViewById(R.id.btnNext);
		btnNext.setOnClickListener(this);
		googleMap = ((SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.mapView)).getMap();
		googleMap.setOnMapClickListener(this);
		locationClient = new LocationClient(this, this, this);
	}

	@Override
	protected void onStart() {
		super.onStart();
		locationClient.connect();
	}

	@Override
	protected void onStop() {
		locationClient.disconnect();
		super.onStop();
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btnNext:
			onNext();
			break;

		default:
			break;
		}

	}

	private void onNext() {
		startActivity(new Intent(this, SchoolWizardRegionActivity.class));
	}

	@Override
	public void onConnectionFailed(ConnectionResult arg0) {
		Log.d("SSM", "Connection Failed");

	}

	@Override
	public void onConnected(Bundle arg0) {
		locationClient.requestLocationUpdates(LocationRequest.create()
				.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
				.setInterval(2000), this);
		Log.d("SSM", "Connected");

	}

	@Override
	public void onDisconnected() {
		Log.d("SSM", "Disconnected");

	}

	@Override
	public void onLocationChanged(Location currentLocation) {
		Log.d("SSM", "onLocationChanged");
		if (googleMap == null || currentLocation == null) {
			return;
		}

		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(currentLocation.getLatitude(), currentLocation
						.getLongitude())).title("Current Location"));
		locationClient.removeLocationUpdates(this);

	}

	@Override
	public void onMapClick(LatLng latLng) {
		if(marker != null) {
			marker.remove();
		}
		
		marker = googleMap.addMarker(new MarkerOptions().position(
				new LatLng(latLng.latitude, latLng.longitude)).title("Current Location"));
	}

}
