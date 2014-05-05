package com.cfp.ssm.activities;

import java.util.ArrayList;

import com.cfp.ssm.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;

public class ViewSchoolActivity extends ActionBarActivity {
	
	GoogleMap googleMap;
	ArrayList<Marker> markersList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_schools);
		googleMap = ((SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.mapView)).getMap();
		markersList = new ArrayList<Marker>();
		(new Handler()).postDelayed(new Runnable() {
			
			@Override
			public void run() {
				addMarkers();
				zoomToAdjustAllMarkers();				
			}
		}, 5000);
	}
	
	private void addMarkers() {
		markersList.add(googleMap.addMarker(new MarkerOptions().position(new LatLng(24.92834, 66.97432)).title("Baldia School")));
		markersList.add(googleMap.addMarker(new MarkerOptions().position(new LatLng(24.97425, 66.99887)).title("New Karachi School")));
		
	}
	
	private void zoomToAdjustAllMarkers() {
		LatLngBounds.Builder builder = new LatLngBounds.Builder();
		for (Marker marker : markersList) {
		    builder.include(marker.getPosition());
		}
		LatLngBounds bounds = builder.build();
		int padding = 50;
		CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
//		googleMap.moveCamera(cu);
		googleMap.animateCamera(cu);
	}

}
