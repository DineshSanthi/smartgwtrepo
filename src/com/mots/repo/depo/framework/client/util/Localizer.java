package com.mots.repo.depo.framework.client.util;

public class Localizer {

    public static native String getMessage(String key)/*-{
	    try
	    {
	        var value = $wnd.repo.localization[key];
	        if(value) return value;
	        var error = "Localizer --> No value for " + key;
	    }
	    catch(err)
	    {
			 var error = "Localizer --> Error while reading key " + err ;
	    }
	    return "UNDEFINED";
	}-*/;
	
}
