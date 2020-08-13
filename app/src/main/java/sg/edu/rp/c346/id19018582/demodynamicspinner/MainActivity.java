package sg.edu.rp.c346.id19018582.demodynamicspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Spinner spinner1, spinner2;
    Button btnUpdate;
    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        btnUpdate = findViewById(R.id.buttonUpdate);

        //initiate ArrayList
        alNumbers = new ArrayList<>();
        //get string-array and store an Array
        String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
        //convery Array to List and add to ArrayList
        alNumbers.addAll(Arrays.asList(strNumbers));

        //create Arrayadapter using the default Spinner layout and ArrayList
        aaNumbers = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alNumbers);

        //Bind ArrayAdapter to Spinner
        spinner2.setAdapter(aaNumbers);

        /*alNumbers.add("2");
        alNumbers.add("4");
        alNumbers.add("6");*/

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = spinner1.getSelectedItemPosition();
                alNumbers.clear();

                //Apply either of the two approaches
                //to load the correct number list based on the selection of spinner1
                if(pos == 0){
                    String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                }
                else{
                    String[] strNumbers = getResources().getStringArray(R.array.odd_numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                }
                aaNumbers.notifyDataSetChanged();
            }
        });

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
                        //alNumbers.clear();
                        alNumbers.addAll(Arrays.asList(strNumbers));
                        break;
                    case 1:
                        strNumbers = getResources().getStringArray(R.array.odd_numbers);
                        //alNumbers.clear();
                        alNumbers.addAll(Arrays.asList(strNumbers));
                        break;
                }
                aaNumbers.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
