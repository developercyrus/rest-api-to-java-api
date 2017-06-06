package foo.bar.client.api;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m3.curly.HTTP;
import com.m3.curly.Response;

public class OnlineStoreRequest<T> extends HashMap<String, String> {
	private static Logger logger = Logger.getLogger(OnlineStoreRequest.class);
	
	private OnlineStore client;
	private Class<T> responseClass;
	private String uriTemplate;
	protected String id;
	
	
	public OnlineStoreRequest(OnlineStore client, String uriTemplate, Class<T> responseClass) {
		this.client = client;
		this.responseClass = responseClass;
		this.uriTemplate = uriTemplate;
	}    

	public T execute() throws IOException {
		
		/* 
		// throws HTTP error fetching URL. Status=406, 
		String responseBody = Jsoup.connect(this.buildHttpRequestUrl())			                 
			                .header("Accept", "text/*")
			                .header("Content-Type", "application/json")
			                .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
			                .timeout(1000000) 			                
			                .get()
			                .body()
			                .text();			                
		*/	                
		
		String url = this.buildHttpRequestUrl();
		logger.debug(url);	
		String responseBody = new String(HTTP.get(url).getBody());	
		logger.debug(responseBody);

		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(responseBody, responseClass);

	}
	
	public String buildHttpRequestUrl() {
		String url = client.getBaseUrl() + uriTemplate;
		logger.debug(url);
		url = url.replaceFirst(Pattern.quote("{version}"), "1");
		logger.debug(url);
		
		if (id != null) {
			url = url.replaceFirst(Pattern.quote("{id}"), id);
			logger.debug(url);
		}
		
		if (this.entrySet().size() > 0) {	
			String parameters = "";
			for (Map.Entry<String, String> entry : this.entrySet()) {	
				logger.debug(entry.getKey() + "=" + entry.getValue());
				try {
					parameters = parameters + "&" + entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), "UTF-8");
				} catch (UnsupportedEncodingException e) {				
					e.printStackTrace();
				}
			}
			url = url + "?" + parameters.substring(1);
		}
		
		logger.debug(url);
		return url;
	}

}
