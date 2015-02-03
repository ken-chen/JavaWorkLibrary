package com.dream.tools;

public class StringUtils {
	
	public static String encodeURL(String url) {

		url = url.replaceAll("-", "");
		url = url.replaceAll("/", "");
		url = url.replaceAll("  ", "");
		url = url.replaceAll("&", "And");
		url = url.replaceAll(" ", "-");
		url = url.toLowerCase();

		try {
			url = java.net.URLEncoder.encode(url, "UTF-8");
		} catch (Exception ex) {
			//logger.debug(("Error encoding friendly URL: " + url));
		}

		url = url.replaceAll("%C2%AE", "");

		try {
			url = java.net.URLDecoder.decode(url, "UTF-8");
		} catch (Exception ex) {
			//logger.debug(("Error decoding friendly URL: " + url));
		}

		return url;
	}
}
