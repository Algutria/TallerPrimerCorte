package com.tallerzapatoszxy.tallerzapatoszxy;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.NumberFormat;

public class Principal extends AppCompatActivity {

    private EditText quantity;
    private TextView result;
    private Resources resources;
    private Spinner genderSpinner,
            shoeTypeSpinner,
            brandSpinner;
    private String genders[], shoeTypes[], brands[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        resources = this.getResources();
        quantity = findViewById(R.id.txtQuantity);
        result = findViewById(R.id.result);

        genderSpinner = findViewById(R.id.genderSpinner);
        shoeTypeSpinner = findViewById(R.id.shoeTypeSpinner);
        brandSpinner = findViewById(R.id.brandSpinner);

        genders = resources.getStringArray(R.array.gender_list);
        shoeTypes= resources.getStringArray(R.array.shoe_type_list);
        brands = resources.getStringArray(R.array.brand_list);

        ArrayAdapter<String> gendersAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, genders);
        genderSpinner.setAdapter(gendersAdapter);

        ArrayAdapter<String> shoeTypesAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, shoeTypes);
        shoeTypeSpinner.setAdapter(shoeTypesAdapter);

        ArrayAdapter<String> brandsAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, brands);
        brandSpinner.setAdapter(brandsAdapter);
    }

}
