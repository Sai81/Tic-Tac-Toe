package com.example.xo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class edit_name extends AppCompatActivity {

    EditText et_player1,et_player2;
    Button btn_done;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_name);

        et_player1=findViewById(R.id.et_player1);
        et_player2=findViewById(R.id.et_player2);
        btn_done=findViewById(R.id.btn_done);

        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_player1.getText().toString().isEmpty() || et_player2.getText().toString().isEmpty())
                {
                    Toast.makeText(edit_name.this,"Please enter all fields",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent();
                    intent.putExtra("player_1",et_player1.getText().toString().trim());
                    intent.putExtra("player_2",et_player2.getText().toString().trim());
                    setResult(RESULT_OK,intent);
                    edit_name.this.finish();
                }
            }
        });

        ImageView back;
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                edit_name.this.finish();
            }
        });

    }
}
