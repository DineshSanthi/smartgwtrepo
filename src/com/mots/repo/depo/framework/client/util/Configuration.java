package com.mots.repo.depo.framework.client.util;

import java.util.List;

public class Configuration {

	public static native List<String> getFieldList(String tableName) /*-{
		try {
			var list = @java.util.ArrayList::new()();
			var fields = eval("$wnd.repo.collection['" + tableName + "']");
			if (fields)
			{
				var keys = Object.keys(fields);
				for (var i=0; i<keys.length; i++)
				{
					list.@java.util.ArrayList::add(Ljava/lang/Object;)(keys[i]);
				}
			}
			return list;
		} catch (error) {
			var errorText = "getFieldList failed to read value";
		}
	 return @java.util.ArrayList::new()();	
	}-*/;	
	
	public static native String getServiceUrl() /*-{
		if (!$wnd.repo) return "http://127.0.0.1:8080/";
		return $wnd.repo.serviceUrl;
	}-*/;
	
	public static native String getApplicationName() /*-{
		if (!$wnd.repo) return "";
		return $wnd.repo.applicationName;
	}-*/;
	
	public static native String getTemplateName() /*-{
	if (!$wnd.repo) return "";
	return $wnd.repo.defaultTemplate;
	}-*/;
	
	public static native String getThemeName() /*-{
	if (!$wnd.repo) return "";
	return $wnd.repo.themeTemplate;
	}-*/;
	
	
}
