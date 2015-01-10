package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class Main
{
	// ƒvƒƒOƒ‰ƒ€‚ÌŠJŽn
	public static void main(String args[])
	{
		new Main();
	}
	
	public Main()
	{
		String apiUrl = "http://weather.livedoor.com/forecast/webservice/json/v1?city=";
		
		System.out.print("’nˆæID‚ð“ü—Íi“Œ‹ž : 130010j : ");
		
		try
		{
			// “ü—Í•¶Žš‚ðŽæ‚é
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			String city = input.readLine();
			
			// ƒpƒ‰ƒ[ƒ^•t—^
			apiUrl += city;
			
			// HTTPƒNƒ‰ƒCƒAƒ“ƒgì¬
			HttpURLConnection client = null;
			// URL¶¬
			URL url = new URL(apiUrl);
			
			client = (HttpURLConnection) url.openConnection();
			client.setRequestMethod("GET");
			
			if (client.getResponseCode() == HttpURLConnection.HTTP_OK)
			{
				InputStreamReader isr = new InputStreamReader(client.getInputStream());
                BufferedReader reader = new BufferedReader(isr);
                
                String line = "";
                String r = "";
                while ((line = reader.readLine()) != null)
                {
                	r += line;
                }
                Gson gson = new Gson();
                WeatherData data = gson.fromJson(r.toString(),WeatherData.class);
                System.out.print(data.forecasts.get(0).dateLabel +"‚Ì"+data.title+"‚Í"+data.forecasts.get(0).telop);
			}
		}
		catch(Exception ex)
		{
			System.out.print("ƒGƒ‰[‚ª‚Å‚Ü‚µ‚½");
		}
	}
}
