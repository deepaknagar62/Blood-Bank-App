// this is the Donate Activity code in which a User enter his/her details and the detail got submmitted to the firebase database.

package com.example.bloodbank;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DonateActivity extends AppCompatActivity {


    FirebaseDatabase database2;
    DatabaseReference ref2;
    Member_2 member2;
    EditText dname , dphone, daddress, dblood ;

    Button dbtn;
    int mid = 0 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);


        dname = findViewById(R.id.dtName);
        dphone = findViewById(R.id.dtPhone);
        daddress = findViewById(R.id.dtAddress);
        dblood = findViewById(R.id.dtblood);
        member2 = new Member_2();
        dbtn = findViewById(R.id.dtbtnSbmit);


        ref2 = database2.getInstance().getReference().child("Blood_Donater");

        ref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    mid = (int) snapshot.getChildrenCount();
                }
                else{


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        dbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                member2.setName(dname.getText().toString());
                member2.setPhone(dphone.getText().toString());
                member2.setAddress(daddress.getText().toString());
                member2.setBlood_Type(dblood.getText().toString());

                ref2.child(String.valueOf(mid+1)).setValue(member2);
                Toast.makeText(getApplicationContext(),"Submitted successfully...",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
