package com.gruita.kb.misc.internetdetect;

/**
 * Describes the type of the connection.
 */
public enum NetworkConnectionType {

    /* wifi connectivity */
	WIFI (0),

    /* Radio (4G, etc) */
	RADIO (1),

    /* Unknown */
	OTHER (2),

    /* not connected to Internet */
	NOT_CONNECTED (-1);

	
	private final int mNType;
	
	private NetworkConnectionType(int nType){

        mNType = nType;
	}

	public int getType() {

        return mNType;
	}
	
	public String getStringRepresentation(){

        return name() ;
	}
	
}


