package com.cput.PickMeUp;

import android.app.Activity;  
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.cput.PickMeUp.R;

public class MainActivity extends Activity implements LocationListener {
	// Class to do operations on the Map
	GoogleMap googleMap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// setting location manager to perform location related operations
		LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

		// Requesting location manager for location updates
		locationManager.requestLocationUpdates(
				LocationManager.NETWORK_PROVIDER, 1, 1, this);

		// To get map from MapFragment from layout
		googleMap = ((MapFragment) getFragmentManager().findFragmentById(
				R.id.map)).getMap();

		// To change the map type to Satellite
		 //googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

		// To show our current location in the map with dot
		 googleMap.setMyLocationEnabled(true);

		// To listen action whenever we click on the map
		googleMap.setOnMapClickListener(new OnMapClickListener() {

			@Override
			public void onMapClick(LatLng latLng) {
				/*
				 * LatLng:Class will give us selected position latigude and
				 * longitude values
				 */
				Toast.makeText(getApplicationContext(), latLng.toString(),
						Toast.LENGTH_LONG).show();
			}
		});

	}

	@Override
	public void onLocationChanged(Location location) {
		// To get latitude value from location object
		double latti = location.getLatitude();
		// To get longitude value from location object
		double longi = location.getLongitude();

		// To hold latitude and longitude values
		LatLng position = new LatLng(latti, longi);

		// Creating object to pass our current location to the map
		MarkerOptions markerOptions = new MarkerOptions();
		// To store current location in the marker options object
		markerOptions.position(position);

		// Zooming to our current location with zoom level 17.0f
		googleMap.animateCamera(CameraUpdateFactory
				.newLatLngZoom(position, 17f));

		// adding marker options class object to the map to show our current
		// location in the map with help of default marker
		googleMap.addMarker(markerOptions);

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}
}
