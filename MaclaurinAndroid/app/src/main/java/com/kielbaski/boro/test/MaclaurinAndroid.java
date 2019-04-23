package com.kielbaski.boro.test;

import android.content.Context;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kielbaski.boro.test.Resources.ArgumentParser;
import com.kielbaski.boro.test.Resources.MaclaurinModel;
import com.kielbaski.boro.test.Resources.MaclaurinModelImp;

import java.util.Vector;

/**
 * Contains problem logic. There is all computing.
 *
 * @author Bartosz Borys
 * @version 5.0
 */

public class MaclaurinAndroid extends AppCompatActivity {

    @Override

    /**
     * Program view
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button maclaurinCalculate = findViewById(R.id.calculate);
        maclaurinCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                executeMaclaurin();
            }

            private void executeMaclaurin(){
                TextView arg = findViewById(R.id.arguments);
                TextView acc = findViewById(R.id.accuracy);
                TextView out = findViewById(R.id.output);

                ArgumentParser parser = new ArgumentParser(arg.getText().toString());
                MaclaurinModel model = MaclaurinModelImp.getInstance();

                try {
                    int accuracy = Integer.parseInt(acc.getText().toString());
                    Vector<Double> arguments = parser.parse();

                    model.setAccuracy(accuracy);
                    model.setManyArguments(arguments);

                    int counter = 0;
                    String output = "Accuracy: " + accuracy + "\n";

                    for(Double result : model.getManyResults()){
                        output+= "[" + counter + "]: " + result + "\n";
                        counter++;
                    }
                    out.setText(output);
                }catch(Exception e){
                    out.setText(e.getMessage());
                }


            }
        });

    }
}
