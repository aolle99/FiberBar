package cat.fiberfarra.fiberbar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.BoringLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PurchaseSummaryActivity extends AppCompatActivity {

    int numProductes = 6;
    float preuTotal = 0f;
    String names[] = {"Pitifli","Bocata","Jarra","Comb"};
    float prices[] = { 3.45f, 5.25f, 2.50f,7.50f};
    ArrayList<CheckBox> checks = new ArrayList<CheckBox>();
    ArrayList<TextView> texts = new ArrayList<TextView>();
    ArrayList<Boolean> bought = new ArrayList<Boolean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_summary);

        LinearLayout h_layout = (LinearLayout) findViewById(R.id.myHorizontalLayout);
        LinearLayout v_layout = (LinearLayout) findViewById(R.id.myLayout);
        TextView preuTotalText = new TextView(this);

        ArrayList<String> names_ = new ArrayList<String>();
        ArrayList<Float> prices_ = new ArrayList<Float>();

        for(int i=0; i<numProductes; i++){
            int value = (int)(Math.random()*names.length);
            names_.add(names[value]);
            prices_.add(prices[value]);
            preuTotal += prices[value];
        }

        preuTotalText.setText("Preu Total: "+ String.valueOf(preuTotal)+"€");
        preuTotalText.setTextSize(30);
        preuTotalText.setHeight(200);
        preuTotalText.setId(0);
        preuTotalText.setPadding(100,0,0,0);
        preuTotalText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        preuTotalText.setTextColor(Color.WHITE);
        preuTotalText.setGravity(Gravity.CENTER);
        LinearLayout h_layout_ = new LinearLayout(this);
        h_layout_.setBackgroundColor(Color.parseColor("#C10000"));
        h_layout_.addView(preuTotalText);
        h_layout.setPadding(0,0,0,0);
        v_layout.setPadding(0,0,0,0);
        v_layout.addView(h_layout_);

        for(int i=0; i<numProductes;i++){
            LinearLayout horizontal_layout = new LinearLayout(this);
            CheckBox btn = new CheckBox(this);

            TextView name = new TextView(this);
            btn.setWidth(100);
            if(i==0) {
                btn.setHeight(150);
                btn.setGravity(Gravity.BOTTOM);

                name.setHeight(150);
                name.setGravity(Gravity.BOTTOM);
            }
            else {
                btn.setHeight(100);
            }
            horizontal_layout.setGravity(Gravity.CENTER);
            name.setText(names_.get(i) + " " + String.valueOf(prices_.get(i)) + "€");
            name.setWidth(400);
            name.setTextSize(25);
            horizontal_layout.addView(btn);
            horizontal_layout.addView(name);
            horizontal_layout.setMinimumHeight(150);
            v_layout.addView(horizontal_layout);
            checks.add(btn);
            texts.add(name);
            bought.add(false);
        }

        Button btn = new Button(this);
        btn.setText("Pagar");
        btn.setId(0);
        LinearLayout horizontal_button_layout = new LinearLayout(this);
        btn.setTextColor(Color.WHITE);
        btn.setBackgroundColor(Color.parseColor("#C10000"));
        horizontal_button_layout.addView(btn);
        horizontal_button_layout.setGravity(Gravity.CENTER);
        horizontal_button_layout.setPadding(300,100,300,0);
        v_layout.addView(horizontal_button_layout);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int max = checks.toArray().length;
                for(int i=0; i<max;i++){
                    if(checks.get(i).isChecked()) {
                        if(bought.get(i)==false) {
                            texts.get(i).setText("Pagat!");
                            preuTotal -= prices_.get(i);
                            preuTotalText.setText("Preu Total: " + String.valueOf(preuTotal) + "€");
                            bought.set(i, true);
                        }
                    }
                }
                if(preuTotal<=0) {
                    Intent i = new Intent(PurchaseSummaryActivity.this, ComandaFetaActivity.class);
                    startActivity(i);
                }
            }
        });

    }



}