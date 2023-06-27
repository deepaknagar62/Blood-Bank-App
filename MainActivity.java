// this is the main activity when the app start it show two options in the main activity (1). Donate (2). Find blood


package com.example.bloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {


    Button btn1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn2 = findViewById(R.id.btnDonate);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDonateActivity();
            }
        });

        btn1 = findViewById(R.id.btnFind);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFindActivity();
            }
        });
    }

    private void openDonateActivity() {
        Intent x = new Intent(this , DonateActivity.class);
        startActivity(x);
    }

    public  void openFindActivity(){
        Intent i = new Intent(this,FindActivity.class);
        startActivity(i);
    }
}
