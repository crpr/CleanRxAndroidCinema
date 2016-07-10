package com.crpr.androidcinema.presentation.welcome_wizard.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.crpr.androidcinema.R;

/**
 * Created by claudioribeiro on 09/07/16.
 */
public class DefaultSlideFragment extends Fragment {

    public static DefaultSlideFragment newInstance(String title, String message, int imageId) {
        DefaultSlideFragment slide =  new DefaultSlideFragment();
        slide.setData(title, message, imageId);
        return slide;
    }

    private String _title;
    private String _message;
    private int _imageId;

    private void setData(String title, String message, int imageId) {
        this._title = title;
        this._message = message;
        this._imageId = imageId;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_default_slide, container, false);
        ((TextView)layout.findViewById(R.id.default_fragment_title_label)).setText(_title);
        ((ImageView)layout.findViewById(R.id.default_fragment_image)).setImageResource(_imageId);
        ((TextView)layout.findViewById(R.id.default_fragment_message_label)).setText(_message);
        return layout;
    }
}
