// In this activity the person can enter his details and that details are saved in the databse using this activity

package com.example.bloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FindActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference ref;
    EditText ename, ephone, eaddress, egroup ;
    int maxid = 0;
    Member member;
    Button btn3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);



        btn3 = findViewById(R.id.btnSbmit);
        ename = findViewById(R.id.Name);
        ephone = findViewById(R.id.Phone);
        eaddress = findViewById(R.id.Address);
        egroup = findViewById(R.id.Bldgroup);

        member = new Member();

        ref = database.getInstance().getReference().child("Blood_Accepter");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    maxid = (int) snapshot.getChildrenCount();
                }
                else{
                    //

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                member.setName(ename.getText().toString());
                member.setPhone(ephone.getText().toString());
                member.setAddress(eaddress.getText().toString());
                member.setBlood_Group(egroup.getText().toString());

                ref.child(String.valueOf(maxid+1)).setValue(member);

                Toast.makeText(getApplicationContext(),"Submitted successfully...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
