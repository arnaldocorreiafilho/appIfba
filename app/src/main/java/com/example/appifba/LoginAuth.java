package com.example.appifba;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class LoginAuth extends AppCompatActivity {

    private static final int MY_REQUEST_CODE = 1;
    List<AuthUI.IdpConfig> providers;



    private void updateUI(FirebaseUser user) {
        if(user.isAnonymous())
        {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
        else {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_auth);
        providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.AnonymousBuilder().build()
        );
        showSignInOptions();


    }

    private void showSignInOptions() {
        startActivityForResult(
                AuthUI.getInstance().createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .setTheme(R.style.AppTheme)
                        .setLogo(R.drawable.blue)
                        .build(), MY_REQUEST_CODE
        );
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MY_REQUEST_CODE) {
            IdpResponse response = IdpResponse.fromResultIntent(data);
            if (resultCode == RESULT_OK) {
                FirebaseAuth.getInstance().addAuthStateListener(new FirebaseAuth.AuthStateListener() {
                    @Override
                    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                        FirebaseUser user =  firebaseAuth.getInstance().getCurrentUser();
                        if(user != null) {
                            String email = user.getEmail();
                            if (email != null) {
                                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                                finish();
                            } else {
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                finish();
                            }
                        }
                    }
                });

                //Toast.makeText(this, "Welcome! " + user.isAnonymous(), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "" + response.getError().getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }
}




