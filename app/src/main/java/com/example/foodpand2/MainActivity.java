package com.example.foodpand2;

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

public class MainActivity extends AppCompatActivity {
    EditText resturantnames, price, num_of_reviews,raating ;
    Button btnsubmit;
   String name;
   int Price,reviews,Rating;
   FirebaseDatabase myfirebasedata;
   DatabaseReference myreference;
   Modelclass mymodelclass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


//        resturantnames=findViewById(R.id.resturantname);
//        price= findViewById(R.id.price);
//        num_of_reviews=findViewById(R.id.noofreviews);
//        raating=findViewById(R.id.rating);
//        btnsubmit=findViewById(R.id.submit);

        myfirebasedata= FirebaseDatabase.getInstance();
        myreference= myfirebasedata.getReference("Mypanda");

        mymodelclass= new Modelclass();

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                converttextview();

                addDataToFirebase(name,Price,Rating,reviews);
            }
        });


    }


    public void converttextview()
    {
        name= resturantnames.getText().toString();
       Price= Integer.valueOf(price.getText().toString());
       reviews= Integer.valueOf(num_of_reviews.getText().toString());
       Rating= Integer.valueOf(raating.getText().toString());

    }


   public void addDataToFirebase(String name,int Price, int Rating, int reviews)
   {
       mymodelclass.setResturantnames(name);
       mymodelclass.setPrice( Price);
       mymodelclass.setRating(Rating);
       mymodelclass.setNumbersofreviews(reviews);


       myreference.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               myreference.setValue(mymodelclass);
               Toast.makeText(MainActivity.this, "data added", Toast.LENGTH_SHORT).show();
           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

               Toast.makeText(MainActivity.this, "failed to save data"+error, Toast.LENGTH_SHORT).show();
           }
       });

   }


}