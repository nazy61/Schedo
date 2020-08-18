package com.nazycodes.schedo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {
    private static final String TAG = "ForgotPassword";

    private TextInputEditText etResetEmail;
    private CardView cvReset;
    private ProgressBar pbLoading;
    private TextView tvMessage;

    private String email;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        auth = FirebaseAuth.getInstance();

        etResetEmail = findViewById(R.id.etResetEmail);
        cvReset = findViewById(R.id.cvReset);
        pbLoading = findViewById(R.id.pbLoading);
        tvMessage = findViewById(R.id.tvMessage);

        cvReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = etResetEmail.getText().toString().trim();
                validate();
            }
        });

    }

    private void validate() {
        if(email.isEmpty() || !email.contains("@")){
            etResetEmail.setError("email must be valid");
        } else {
            pbLoading.setVisibility(View.VISIBLE);
            sendEmailLink();
        }
    }

    private void sendEmailLink() {
        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            pbLoading.setVisibility(View.INVISIBLE);
                            tvMessage.setText(R.string.emailSentMessage);
                        } else {
                            pbLoading.setVisibility(View.INVISIBLE);
                            Log.w(TAG, "Error in sending Reset Mail", task.getException());
                            tvMessage.setText(R.string.emailSentErrorMessage);
                        }
                    }
                });
    }

}