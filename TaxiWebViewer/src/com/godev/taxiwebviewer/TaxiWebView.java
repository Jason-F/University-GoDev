package com.godev.taxiwebviewer;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.SyncStateContract.Constants;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TaxiWebView extends ActionBarActivity {
	 
	private WebView mWebView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_taxi_web_view);
		
		mWebView = (WebView) findViewById(R.id.webView1);
		WebSettings webSettings = mWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		mWebView.loadUrl("http://www.mangareader.net/");
		mWebView.setWebViewClient(new WebViewClient(){
			
			@Override
		    public void onPageStarted(WebView view, String url, Bitmap favicon) {
	        super.onPageStarted(view, url, favicon);
	        mWebView.setVisibility(View.VISIBLE);
		    }
	
		    @Override
		    public void onPageFinished(WebView view, String url) {
		        super.onPageFinished(view, url);
		        mWebView.setVisibility(View.INVISIBLE);
		    }
	    
		    
	    
		});
		
	}
	
	 @Override
	    public void onBackPressed() {
	        if(mWebView.canGoBack()) {
	            mWebView.goBack();
	        } else {
	            super.onBackPressed();
	        }
	    }

	  
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.taxi_web_view, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
