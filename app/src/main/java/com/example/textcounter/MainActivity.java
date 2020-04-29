package com.example.textcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.textcounter.utils.ElementsCalculator.getCharsCount;

public class MainActivity extends AppCompatActivity {

    Spinner ddSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.ddSelection = (Spinner) findViewById(R.id.ddSelection);
        ArrayList<String> selectionOptionsList = new ArrayList<>();
        selectionOptionsList.add("Words");
        selectionOptionsList.add("Chars");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, selectionOptionsList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.ddSelection.setAdapter(arrayAdapter);
    }

    public void btnCalculateOnClick(View view) {
        EditText edUserInput = findViewById(R.id.edUserInput);
        TextView tvOutput = findViewById(R.id.tvOutput);
        String selection = this.ddSelection.getSelectedItem().toString();
        String userInputText = edUserInput.getText().toString();
        if (selection.equalsIgnoreCase("Chars")){
            int count = getCharsCount(userInputText);
            tvOutput.setText(String.valueOf(count));
            Toast.makeText(this, userInputText, Toast.LENGTH_LONG).show();
        }

    }
}
