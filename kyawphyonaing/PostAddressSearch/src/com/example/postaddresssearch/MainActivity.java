package com.example.postaddresssearch;

import http.ServerHttpIF;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.xmlpull.v1.XmlPullParserException;

import parse.ZipAddressEntityParse;
import util.IntegerUtil;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import entity.ZipAddressEntity;

public class MainActivity extends Activity {

	String url = 
			"http://zip.cgis.biz/xml/zip.php?zn=";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		String url = "http://zip.cgis.biz/xml/zip.php?zn=";

		try {
			BufferedReader input = 
					new BufferedReader(
							new InputStreamReader(
					System.in));

			String line = input.readLine();
			
			String accessUrl;
			if(IntegerUtil.isNumber(line) &&
					line.length() == 7){
				accessUrl = url + line;
			}else{
				// error 処理
				System.out.println("郵便番号が不正です");
				return;
			}

			ServerHttpIF httpIF = new ServerHttpIF();
			HttpEntity entity = httpIF.httpGet(accessUrl);

			if (entity != null) {
				// success
				// System.out.println(httpIF.responseText());
			}
			ZipAddressEntity zipAddressEntity = new ZipAddressEntity();
			ZipAddressEntityParse zipAddressEntityParse = new ZipAddressEntityParse();

			zipAddressEntity = (ZipAddressEntity) zipAddressEntityParse
					.create(httpIF.responseText());
			System.out.println(
					zipAddressEntity.getState() +
					zipAddressEntity.getCity() +
					zipAddressEntity.getAddress() +
					"(" +
					zipAddressEntity.getStateKana() +
					zipAddressEntity.getCityKana() +
					zipAddressEntity.getAddressKana() +
					")" 
					);
		} catch (XmlPullParserException e) {
			System.out.println("parse miss");
		} catch (Exception e) {
			System.out.println("errorです");
		}
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
