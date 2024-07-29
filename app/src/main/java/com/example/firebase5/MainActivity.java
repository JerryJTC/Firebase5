package com.example.firebase5;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference HumedadRef = 	database.getReference("Sensores/Humedad");

        DatabaseReference presionRef = database.getReference("Sensores/Presión");

        DatabaseReference VelocidadRef = 	database.getReference("Sensores/Movimiento");

        DatabaseReference TemperauraRef = 	database.getReference("Sensores/Temperatura");

        HumedadRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                TextView txtHumedad = findViewById(R.id.valor_Humedad);
                txtHumedad.setText(snapshot.getValue(float.class).toString());


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        presionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                TextView txtPresion = findViewById(R.id.valor_Presion);
                txtPresion.setText(snapshot.getValue(Float.class).toString());


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        VelocidadRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                TextView txtVelocidad = findViewById(R.id.valor_Movimiento);
                txtVelocidad.setText(snapshot.getValue(Float.class).toString());


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        TemperauraRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                TextView txtTemp = findViewById(R.id.valor_Temperatura);
                txtTemp.setText(snapshot.getValue(Float.class).toString());


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}