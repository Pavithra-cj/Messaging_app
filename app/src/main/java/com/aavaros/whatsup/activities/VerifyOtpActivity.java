package com.aavaros.whatsup.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aavaros.whatsup.R;
import com.aavaros.whatsup.databinding.ActivitySignInBinding;
import com.aavaros.whatsup.databinding.ActivityVerifyOtpBinding;
import com.chaos.view.PinView;

public class VerifyOtpActivity extends AppCompatActivity {

    PinView pinView;
    Button btnVerify;
    private ActivityVerifyOtpBinding binding;
    SendOTP sendOTP = new SendOTP();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);

        pinView = findViewById(R.id.PinView);
        btnVerify = findViewById(R.id.btnVerify);

        setListners();

    }

    private void setListners()
    {

        binding.btnVerify.setOnClickListener(v -> {
            String inputCode = pinView.getText().toString();
            if(inputCode.equals(String.valueOf(sendOTP.code)))
            {
                Intent intent = new Intent(VerifyOtpActivity.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(VerifyOtpActivity.this, "Successed.", Toast.LENGTH_SHORT).show();
            }else
            {
                Toast.makeText(VerifyOtpActivity.this, "Failed.", Toast.LENGTH_SHORT).show();
            }
        });

    }



}