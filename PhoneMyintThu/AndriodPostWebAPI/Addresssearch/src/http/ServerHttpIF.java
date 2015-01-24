package http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class ServerHttpIF {
	
	HttpClient client;
	HttpResponse response;
	
	public ServerHttpIF(){
		client = new DefaultHttpClient();
	}
	
	public String responseText(){
		try {
			return EntityUtils.toString(response.getEntity());
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * サーバ送信[GET]
	 */
	public HttpEntity httpGet(String url){
		
		HttpGet httpGet = new HttpGet(url);
		try{
			// server 処理実行
			response = client.execute(httpGet);
			
			if(response.getStatusLine().
					getStatusCode()
					!= HttpStatus.SC_OK)
				return null;
			
			return response.getEntity();
		}catch(Exception e){
			// noop
		}
		return null;
	}
	
	/**
	 * サーバ送信[POST]
	 */
	private void httpPost(){
		// 後で実装
	}
}
