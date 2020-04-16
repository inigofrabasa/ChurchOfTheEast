package android.churchoftheeast.info;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView btnBack, btnDonations, btnMemebership, btnExit;
    private ImageButton btnProfile, btnBookings, btnLive, btnNews, btnChurch;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        initWebView();

    }

    private void findViews(){
        btnBack = findViewById(R.id.btn_back);
        btnDonations = findViewById(R.id.btn_donations);
        btnMemebership = findViewById(R.id.btn_memebership);
        btnExit = findViewById(R.id.btn_exit);
        btnProfile = findViewById(R.id.btn_profile);
        btnBookings = findViewById(R.id.btn_bookings);
        btnLive = findViewById(R.id.btn_live);
        btnNews = findViewById(R.id.btn_news);
        btnChurch = findViewById(R.id.btn_church);
        webView = findViewById(R.id.webView);

        btnBack.setOnClickListener(this);
        btnDonations.setOnClickListener(this);
        btnMemebership.setOnClickListener(this);
        btnExit.setOnClickListener(this);
        btnProfile.setOnClickListener(this);
        btnBookings.setOnClickListener(this);
        btnLive.setOnClickListener(this);
        btnNews.setOnClickListener(this);
        btnChurch.setOnClickListener(this);
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initWebView(){
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl(getResources().getString(R.string.home_screen));
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_back:
                webView.goBack();
                break;
            case R.id.btn_donations:
                loadUrlChrome(getResources().getString(R.string.url_btn_2));
                break;
            case R.id.btn_memebership:
                loadUrlChrome(getResources().getString(R.string.url_btn_3));
                break;
            case R.id.btn_exit:
                finish();
                break;
            case R.id.btn_profile:
                webView.loadUrl(getResources().getString(R.string.url_btn_5));
                break;
            case R.id.btn_bookings:
                webView.loadUrl(getResources().getString(R.string.url_btn_6));
                break;
            case R.id.btn_live:
                webView.loadUrl(getResources().getString(R.string.url_btn_7));
                break;
            case R.id.btn_news:
                webView.loadUrl(getResources().getString(R.string.url_btn_8));
                break;
            case R.id.btn_church:
                webView.loadUrl(getResources().getString(R.string.url_btn_9));
                break;
        }
    }

    private void loadUrlChrome(String url){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.setPackage("com.android.chrome");
        try {
            startActivity(i);
        } catch (ActivityNotFoundException e) {
            i.setPackage(null);
            startActivity(i);
        }
    }
}
