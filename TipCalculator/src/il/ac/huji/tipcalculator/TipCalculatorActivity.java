package il.ac.huji.tipcalculator;

import android.os.Bundle;
import android.app.Activity;

import java.text.DecimalFormat;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {
	final private static double tipPercentage = 0.12;
	final private static String TIP = "Tip: $";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        Button button = (Button)findViewById(R.id.btnCalculate);
        // Register the onClick listener with the implementation above
        button.setOnClickListener(buttonListener);
    }
    
 // Create an anonymous implementation of OnClickListener
    private OnClickListener buttonListener = new OnClickListener() {
        

		@Override
		public void onClick(View view) {
			CheckBox cb = (CheckBox)findViewById(R.id.chkRound);
			boolean shouldRound = cb.isChecked();
			EditText et = (EditText)findViewById(R.id.edtBillAmount);
			String input = et.getText().toString();
			if (input == null || input.equals("")){
				return;
			}
			double etVal = Double.parseDouble(input);
			etVal *=tipPercentage;
			DecimalFormat df = new DecimalFormat("#.00");
			TextView tv = (TextView)findViewById(R.id.txtTipResult);
			if (shouldRound){
				int p = (int) Math.round(etVal);
				tv.setText(TIP + p);
			}
			else{
				tv.setText(TIP + df.format(etVal));
			}
		}
    };

    
}

