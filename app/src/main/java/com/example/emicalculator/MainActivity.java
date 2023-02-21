package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

EditText amount,interest,months;
Button calculate;
TextView txtEmi, txtInterestAmt, txtTotalAmt;





    @Override
    public <T extends View> T findViewById(int id) {
        return super.findViewById(id);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amount = findViewById(R.id.amount);
        interest = findViewById(R.id.interest);
        months = findViewById(R.id.months);
        calculate = findViewById(R.id.calculate);

          int amt = Integer.parseInt(amount.getText().toString());
          double rest = Double.parseDouble(interest.getText().toString());
          int mon = Integer.parseInt(months.getText().toString());

          double r = rest/(12*100);
          double cal1 = 1;
        for (int i = 0; i <mon ; i++) {
                  cal1 *=(1+r);
        }
        double ans = amt * r * (cal1/(cal1 - 1));
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);

        txtEmi.setText("EMI ="+df.format(ans));
        double total = ans*mon;
        txtTotalAmt.setText("Total Amount ="+df.format(total));
        double iAmt = total - amt;
        txtInterestAmt.setText("Interest Amount =" + df.format(iAmt));
    }
}