package com.example.infinity.prof.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.infinity.prof.R;
import com.example.infinity.prof.constants.NavigationDrawerConstants;

public class VideoFragment extends Fragment {
    WebView videoDas1,videoDas2,videoDas3,videoDas4,videoDas5;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(NavigationDrawerConstants.TAG_VIDEO);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View video = inflater.inflate(R.layout.fragment_video, container, false);
        String cDas1 = "<html><body><iframe width=\"350\" height=\"300\" src=\"https://www.youtube.com/embed/4049IJPOSG8\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe></body></html>";
        String cDas2 = "<html><body><iframe width=\"350\" height=\"300\" src=\"https://www.youtube.com/embed/Q0I6I3pS3TI\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe></body></html>";
        String cDas3 = "<html><body><iframe width=\"350\" height=\"300\" src=\"https://www.youtube.com/embed/3fzIk-rFldY\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe></body></html>";
        String cDas4 = "<html><body><iframe width=\"350\" height=\"300\" src=\"https://www.youtube.com/embed/guOhCdn_yuY\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe></body></html>";
        String cDas5 = "<html><body><iframe width=\"350\" height=\"300\" src=\"https://www.youtube.com/embed/PdbPW_Tnt1s\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe></body></html>";

        videoDas1 = (WebView) video.findViewById(R.id.videoDas1);
        videoDas1.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        WebSettings webSettings1 = videoDas1.getSettings();
        webSettings1.setJavaScriptEnabled(true);
        videoDas1.loadData(cDas1, "text/html", "utf-8");

        videoDas2 = (WebView) video.findViewById(R.id.videoDas2);
        videoDas2.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        WebSettings webSettings2 = videoDas2.getSettings();
        webSettings2.setJavaScriptEnabled(true);
        videoDas2.loadData(cDas2, "text/html", "utf-8");

        videoDas3 = (WebView) video.findViewById(R.id.videoDas3);
        videoDas3.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        WebSettings webSettings3 = videoDas3.getSettings();
        webSettings3.setJavaScriptEnabled(true);
        videoDas3.loadData(cDas3, "text/html", "utf-8");

        videoDas4 = (WebView) video.findViewById(R.id.videoDas4);
        videoDas4.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        WebSettings webSettings4 = videoDas4.getSettings();
        webSettings4.setJavaScriptEnabled(true);
        videoDas4.loadData(cDas4, "text/html", "utf-8");

        videoDas5 = (WebView) video.findViewById(R.id.videoDas5);
        videoDas5.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        WebSettings webSettings5 = videoDas5.getSettings();
        webSettings5.setJavaScriptEnabled(true);
        videoDas5.loadData(cDas5, "text/html", "utf-8");

        return video;
    }
}
