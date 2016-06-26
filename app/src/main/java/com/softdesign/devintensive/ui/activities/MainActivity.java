package com.softdesign.devintensive.ui.activities;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.softdesign.devintensive.R;
import com.softdesign.devintensive.utils.ConstantManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG= ConstantManager.TAG_PREFIX+"Main Acrivity";
    private EditText mPhone, mEmail, mGitHub, mAbout, mVkProfile;
    SharedPreferences sPref;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");
        sPref = getPreferences(MODE_PRIVATE);
        mPhone=(EditText) findViewById(R.id.phone_et);
        mEmail=(EditText) findViewById(R.id.email_et);
        mGitHub=(EditText) findViewById(R.id.git_et);
        mAbout=(EditText) findViewById(R.id.about_et);
        mVkProfile=(EditText) findViewById(R.id.vk_profile_et);
        if (savedInstanceState==null) {
            mPhone.setText(sPref.getInt("Phone",0));
            mEmail.setText(sPref.getString("Email",""));
            mGitHub.setText(sPref.getString("GitHub",""));
            mAbout.setText(sPref.getString("About",""));
            mVkProfile.setText(sPref.getString("VK",""));


            //first time run
        }
        else {
            //second time run
            mPhone.setText(savedInstanceState.getInt("Phone"));
            mEmail.setText(savedInstanceState.getString("Email"));
            mGitHub.setText(savedInstanceState.getString("GitHub"));
            mAbout.setText(savedInstanceState.getString("About"));
            mVkProfile.setText(savedInstanceState.getString("VK"));

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");

        SharedPreferences.Editor ed = sPref.edit();
        ed.putInt("Phone",Integer.parseInt(mPhone.getText().toString()));
        ed.putString("Email", mEmail.getText().toString());
        ed.putString("GitHub", mGitHub.getText().toString());
        ed.putString("VK", mVkProfile.getText().toString());
        ed.putString("About", mAbout.getText().toString());
        ed.commit();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.about_et:
                mAbout.setEnabled(true);
                break;
            case R.id.email_et:
                mEmail.setEnabled(true);
                break;
            case R.id.git_et:
                mGitHub.setEnabled(true);
                break;
            case R.id.phone_et:
                mPhone.setEnabled(true);
                break;
            case R.id.vk_profile_et:
                mVkProfile.setEnabled(true);
                break;

        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("Phone",Integer.parseInt(mPhone.getText().toString()));
        outState.putString("Email", mEmail.getText().toString());
        outState.putString("GitHub", mGitHub.getText().toString());
        outState.putString("VK", mVkProfile.getText().toString());
        outState.putString("About", mAbout.getText().toString());
    }
}

