package com.gruita.kb.misc.internetdetect;

import android.app.Activity;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;




public class AndroidDetectInternetConnectionActivity extends Activity implements View.OnClickListener {

	private ConnectionChangeReceiver connReceiver = null;
	


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		connReceiver = new ConnectionChangeReceiver(new Handler());
		String actionConnectivity = ConnectivityManager.CONNECTIVITY_ACTION;
		registerReceiver(connReceiver, new IntentFilter(actionConnectivity));


        Button button = (Button)findViewById(R.id.btnCheckConnectivity);
        button.setOnClickListener(this);
	}

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnCheckConnectivity){
            NetworkConnectionType type = ConnectionDetector.isConnectedToInternet(this);
            Toast.makeText(this, "ConnectionType: " + type.getStringRepresentation(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroy(){
        unregisterReceiver(connReceiver);
        super.onDestroy();
    }
}