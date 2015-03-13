package com.gruita.kb.misc.internetdetect;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


/**
 * Checks the kind of connectivity. Can be used independently.
 * Also integrated with the ConnectivityChangeReceiver
 * 
 * @author cristian.gruita
 *
 */
public class ConnectionDetector {

    /**
     * No need for public constructor
     */
	private ConnectionDetector(){

	}

	public static NetworkConnectionType isConnectedToInternet(Context context){
		ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = null;
		  if (connectivity != null) 
		  {
			  activeNetwork = connectivity.getActiveNetworkInfo();
			  if (activeNetwork != null){
				 if(activeNetwork.getState() == NetworkInfo.State.CONNECTED){
					 int networkConnectionType = activeNetwork.getType();
					 
					 switch (networkConnectionType) {
					 	case ConnectivityManager.TYPE_WIFI:
					 		return NetworkConnectionType.WIFI;
						case ConnectivityManager.TYPE_MOBILE:
							return NetworkConnectionType.RADIO;
						default:
							return NetworkConnectionType.OTHER;
						}
				  }
			  }
		  }
		  return NetworkConnectionType.NOT_CONNECTED;
	}
}

