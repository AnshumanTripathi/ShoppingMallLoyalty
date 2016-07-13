package com.shoppingmallloyality.location;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.shoppingmallloyality.R;

public class NewMap extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_places);
		GoogleMap mMap;

		mMap = ((SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.mapview)).getMap();

		mMap.setMyLocationEnabled(true);
		LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
		Criteria criteria = new Criteria();
		String provider = locationManager.getBestProvider(criteria, true);
		Location location = locationManager.getLastKnownLocation(provider);
		mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		double latitude = location.getLatitude();
		double longitude = location.getLongitude();
		LatLng latLng = new LatLng(latitude, longitude);

		mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
		// mMap.moveCamera(CameraUpdateFactory.newLatLng(ti));
		mMap.animateCamera(CameraUpdateFactory.zoomBy(8));

		mMap.addMarker(new MarkerOptions().position(
				new LatLng(latitude, longitude)).title("you r here"));
		// mMap.addMarker(new MarkerOptions().position(new
		// LatLng(22.721180700000000000,
		// 75.878481999999960000)).title("treaser island"));
		MarkerOptions ti = new MarkerOptions().position(
				new LatLng(22.721180700000000000, 75.878481999999960000))
				.title("TREASURE ISLAND");
		ti.icon(BitmapDescriptorFactory
				.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));

		mMap.addMarker(ti);

		// for central mall

		MarkerOptions cent = new MarkerOptions().position(
				new LatLng(22.717129200000000000, 75.872751000000000000))
				.title("CENTRAL MALL");
		cent.icon(BitmapDescriptorFactory
				.defaultMarker(BitmapDescriptorFactory.HUE_RED));
		mMap.addMarker(cent);

		// for malhar mall

		MarkerOptions mal = new MarkerOptions().position(
				new LatLng(22.744078700000000000, 75.894725800000030000))
				.title("MALHAR MALL");
		mal.icon(BitmapDescriptorFactory
				.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
		mMap.addMarker(mal);

		// for c21 mall

		MarkerOptions c21 = new MarkerOptions().position(
				new LatLng(22.744070000000000000, 75.894228000000000000))
				.title("C21 MALL");
		c21.icon(BitmapDescriptorFactory
				.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		mMap.addMarker(c21);

		// mMap.addMarker(new
		// MarkerOptions().position(central)).setTitle("CENTRAL MALL");
		// mMap.addMarker(new
		// MarkerOptions().position(c21)).setTitle("C21 MALL");
		// mMap.addMarker(new
		// MarkerOptions().position(malhar)).setTitle("MALHAR MALL");
		//
	}

	// @Override
	// public void onMapClick(LatLng position) {
	// // TODO Auto-generated method stub
	// mMap.addMarker(new
	// MarkerOptions().position(position).icon(BitmapDescriptorFactory.defaultMarker()));
	//
	// }

}
