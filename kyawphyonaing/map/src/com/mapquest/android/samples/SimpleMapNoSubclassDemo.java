package com.mapquest.android.samples;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.mapquest.android.maps.AnnotationView;
import com.mapquest.android.maps.DefaultItemizedOverlay;
import com.mapquest.android.maps.GeoPoint;
import com.mapquest.android.maps.ItemizedOverlay;
import com.mapquest.android.maps.MapController;
import com.mapquest.android.maps.MapView;
import com.mapquest.android.maps.OverlayItem;

/**
 * This sample shows how to use the MapQuest SDK map without subclassing the map activity.  For
 * demonstration purposes this class will recreate everything in onResume and clean everything
 * up in the onPause - this may not an be the ideal way of using the map in your application 
 *
 */
public class SimpleMapNoSubclassDemo extends Activity {

	private MapView map;
	AnnotationView annotation;

	@Override
	protected void onPause() {
		
		//make sure you clean up the mapView since you are not subclassing the MapActivity, 
		//the mapView will not know when to clean up after itself
		if(map!=null){
			map.destroy();
			map=null;
		}
		super.onPause();
		
	}

	@Override
	protected void onResume() {
		setupMap();
		super.onResume();
	}

	
	/**
     * Sets up the map.  Adds a couple Pois.
     */
    private void setupMap() {
    	setContentView(R.layout.simple_map_no_subclass);
		map=(MapView)this.findViewById(R.id.map);
		
		MapController mapController=map.getController();
		mapController.setZoom(13);
		mapController.setCenter(new GeoPoint(40732270,-74013985));
    	
        // initialize the annotation to be shown later 
    	annotation = new AnnotationView(map);
    	// add an onclick listener to the annotationView
    	annotation.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(map.getContext(), 
						"Clicked the "+annotation.getOverlayItem().getTitle()+" annotation", 
						Toast.LENGTH_SHORT).show();
			}
		});
    	
        Drawable icon = getResources().getDrawable(R.drawable.location_marker);
    	final DefaultItemizedOverlay overlay = new DefaultItemizedOverlay(icon);
    	
    	// add items with a title and a snippet
    	OverlayItem item1 = new OverlayItem(new GeoPoint(40720640, -73995171), "New York, NY", "The Big Apple");
    	overlay.addItem(item1);
    	OverlayItem item2 = new OverlayItem(new GeoPoint(40743900, -74032800), "Hoboken, NJ", "The Mile Square City");
    	overlay.addItem(item2);
    	
    	// add a tap listener
    	overlay.setTapListener(new ItemizedOverlay.OverlayTapListener() {
			@Override
			public void onTap(GeoPoint pt, MapView mapView) {
				// when tapped, show the annotation for the overlayItem
				int lastTouchedIndex = overlay.getLastFocusedIndex();
				if(lastTouchedIndex>-1){
					OverlayItem tapped = overlay.getItem(lastTouchedIndex);
					annotation.showAnnotationView(tapped);
				}
			}
		});
    	
    	map.getOverlays().add(overlay);
    	map.invalidate();
    	
    }

}
