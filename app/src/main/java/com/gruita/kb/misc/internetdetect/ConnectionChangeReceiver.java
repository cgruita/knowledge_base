package com.gruita.kb.misc.internetdetect;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

/**
 * Notifies the connectivity change (whenever the Internet connectivity changes)
 * 
 * @author cristian.gruita
 *
 */
public class ConnectionChangeReceiver extends BroadcastReceiver {
	
	/* used to detect what kind of connectivity we have 
	possible to check using the kind of connectivity using the intent of the receiver
	but the ConnectionDetector can be used independently, so we're using that */
	private ConnectionDetector cd = null;
	
	/* used for communication with the main thread */
	private final Handler handler; 

    public ConnectionChangeReceiver(Handler handler) {
        this.handler = handler;
    }

	@Override
	public void onReceive(final Context context, Intent intent) {

		final NetworkConnectionType connType = ConnectionDetector.isConnectedToInternet(context);
		
		handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, "Toast from broadcast receiver: " + connType.getStringRepresentation(), Toast.LENGTH_SHORT).show();
            }
        });
	}

}