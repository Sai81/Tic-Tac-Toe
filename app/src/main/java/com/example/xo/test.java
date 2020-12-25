package com.example.xo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class test extends AppCompatActivity {

    Button difficulty1, difficulty2, difficulty3, done;
    int d=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        difficulty1=findViewById(R.id.difficulty1);
        difficulty2=findViewById(R.id.difficulty2);
        difficulty3=findViewById(R.id.difficulty3);
        done=findViewById(R.id.btn_done);

        d=getIntent().getIntExtra("d",4);


        difficulty1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d=1;
                difficulty1.setBackgroundResource(R.drawable.rounded);
                difficulty2.setBackgroundResource(R.drawable.box_transparent);
                difficulty3.setBackgroundResource(R.drawable.box_transparent);

                difficulty1.setTextColor(getResources().getColor(R.color.colorAccent));
                difficulty2.setTextColor(getResources().getColor(R.color.dark));
                difficulty3.setTextColor(getResources().getColor(R.color.dark));
            }
        });

        difficulty2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d=2;
                difficulty2.setBackgroundResource(R.drawable.rounded);
                difficulty1.setBackgroundResource(R.drawable.box_transparent);
                difficulty3.setBackgroundResource(R.drawable.box_transparent);

                difficulty2.setTextColor(getResources().getColor(R.color.colorAccent));
                difficulty1.setTextColor(getResources().getColor(R.color.dark));
                difficulty3.setTextColor(getResources().getColor(R.color.dark));
            }
        });

        difficulty3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d=3;
                difficulty3.setBackgroundResource(R.drawable.rounded);
                difficulty2.setBackgroundResource(R.drawable.box_transparent);
                difficulty1.setBackgroundResource(R.drawable.box_transparent);

                difficulty3.setTextColor(getResources().getColor(R.color.colorAccent));
                difficulty2.setTextColor(getResources().getColor(R.color.dark));
                difficulty1.setTextColor(getResources().getColor(R.color.dark));
            }
        });


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("d",d);
                setResult(RESULT_OK,intent);
                test.this.finish();
            }
        });

        if (d==1){difficulty1.performClick();}
        else if (d==2){difficulty2.performClick();}
        else if (d==3){difficulty3.performClick();}
        else done.setText("4");

        ImageView back;
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){

            d=data.getIntExtra("d",1);
            if(d==1) difficulty1.performClick();
            else if (d==2) difficulty2.performClick();
            else if (d==3) difficulty3.performClick();

        }

    }
}
