package io.android.backend;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

public class Backend extends CordovaPlugin {
	
	private static final int GalleryRequestCode = 100;
	private CallbackContext callback;
	private Context c;


	@Override
	public boolean execute(String action, JSONArray data,CallbackContext callbackContext) throws JSONException {
		
		if (action.equals("toast")) {
			
			return true;
		} 
		else if (action.equals("getImage")) {
			pickPhoto(callbackContext);
			return true;
		}else {
			return false;
		}
    }
	
	private void pickPhoto(CallbackContext callbackContext){
		Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI); 
		cordova.startActivityForResult(this,i,GalleryRequestCode);
		this.callback = callbackContext;
		this.c = cordova.getActivity();	
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data){
		super.onActivityResult(requestCode, resultCode, data);
		
		if (requestCode == GalleryRequestCode  && data != null ){
			
			Uri selectedImage = data.getData();
	         
			String[] filePathColumn = { MediaStore.Images.Media.DATA };
	 
	        Cursor cursor = c.getContentResolver().query(selectedImage,filePathColumn, null, null, null);
	        
	        cursor.moveToFirst();
	 
	        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
	        String picturePath = cursor.getString(columnIndex);
	        cursor.close();
	        
			callback.success(picturePath);	
		}
	}

}
