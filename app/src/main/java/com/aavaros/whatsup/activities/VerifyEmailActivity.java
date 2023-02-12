package com.aavaros.whatsup.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aavaros.whatsup.R;
import com.aavaros.whatsup.databinding.ActivityVerifyEmailBinding;
import com.aavaros.whatsup.databinding.ActivityVerifyOtpBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class VerifyEmailActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    FirebaseUser mUser;
    private Object Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_email);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        Button = findViewById(R.id.btnVerify);

    }



}