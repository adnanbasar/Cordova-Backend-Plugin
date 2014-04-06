package me.adnanbasar.backend;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;

import org.json.JSONArray;
import org.json.JSONException;
import android.widget.Toast;

public class Backend extends CordovaPlugin {

	@Override
	public boolean execute(String action, JSONArray data,
			CallbackContext callbackContext) throws JSONException {

		if (action.equals("toast")) {
            
            Toast.makeText(cordova.getActivity(), "adnan", Toast.LENGTH_LONG).show();

            callbackContext.success("yes");
			
			return true;
		} else {
			return false;
		}
	


    }

}
