package com.example.miniprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText firstname_input, lastname_input, age_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        firstname_input = findViewById(R.id.firstname_input);
        lastname_input = findViewById(R.id.lastname_input);
        age_input = findViewById(R.id.age_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addUser(firstname_input.getText().toString().trim(),
                        lastname_input.getText().toString().trim(),
                        Integer.valueOf(age_input.getText().toString().trim()));
            }
        });
    }
}
