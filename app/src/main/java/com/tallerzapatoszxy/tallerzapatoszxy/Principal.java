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

    public void calculate(View v) {
        result.setText("");
        if (isQuantityValid()) {
            double cant = Double.parseDouble(quantity.getText().toString());
            int selectedGender, selectedShoeType, selectedBrand;

            selectedGender = genderSpinner.getSelectedItemPosition();
            selectedShoeType = shoeTypeSpinner.getSelectedItemPosition();
            selectedBrand = brandSpinner.getSelectedItemPosition();

            double totalValue = Methods.getShoesValueFromCharacteristics(selectedGender, selectedShoeType, selectedBrand, cant);

            String totalPrinceText = resources.getString(R.string.total_price);
            String resultMessage = totalPrinceText  + " $" + NumberFormat.getNumberInstance().format(totalValue);
            result.setText(resultMessage);
        }
    }

    public boolean isQuantityValid() {
        if (quantity.getText().toString().trim().isEmpty()) {
            quantity.requestFocus();
            quantity.setError(resources.getString(R.string.blank_quantity));
            return false;
        }

        if (Double.parseDouble(quantity.getText().toString()) == 0.0) {
            quantity.requestFocus();
            quantity.setError(resources.getString(R.string.quantity_greater_than_zero));
            return false;
        }

        return true;
    }

    public void clear(View v) {
        quantity.setText("");
        quantity.requestFocus();
        result.setText("");
        genderSpinner.setSelection(0);
        shoeTypeSpinner.setSelection(0);
        brandSpinner.setSelection(0);
    }
}
