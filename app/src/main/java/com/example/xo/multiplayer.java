/*package com.example.xo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class multiplayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer);
    }
}*/
package com.example.xo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.os.Bundle;

public class multiplayer extends AppCompatActivity implements View.OnClickListener {

    Button[][] buttons = new Button[3][3];
    boolean player1Turn = true;
    int roundCount;
    int player1Points;
    int player2Points;
    TextView textViewPlayer1;
    TextView textViewPlayer2;
    TextView winner;
    Button buttonReset;
    int key=1;
    String p1,p2;
    boolean p1starts;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer);

        textViewPlayer1 = findViewById(R.id.text_view_p1);
        textViewPlayer2 = findViewById(R.id.text_view_p2);
        winner = findViewById(R.id.text_view_winner);

        View line[]=new View[8];
        line[0]=findViewById(R.id.line0);
        line[1]=findViewById(R.id.line1);
        line[2]=findViewById(R.id.line2);
        line[3]=findViewById(R.id.line3);
        line[4]=findViewById(R.id.line4);
        line[5]=findViewById(R.id.line5);
        line[6]=findViewById(R.id.line6);
        line[7]=findViewById(R.id.line7);

        p1="PLAYER1";
        p2="PLAYER2";

        p1starts=true;

        winner.setText(p1+" starts");


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }

        Button buttonClear = findViewById(R.id.button_clear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetBoard();
                if(player1Turn)winner.setText(p1+" starts");
                else winner.setText(p2+" starts");
            }
        });

        buttonReset = findViewById(R.id.button_reset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetBoard();
                player1Points=0;
                player2Points=0;
                textViewPlayer1.setText(p1+"(X): " + player1Points);
                textViewPlayer2.setText(p2+"(O): " + player2Points);
                if(player1Turn)winner.setText(p1+" starts");
                else winner.setText(p2+" starts");

            }
        });

        ImageView back;
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        Button edit_names;
        edit_names=findViewById(R.id.edit_name);
        edit_names.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(multiplayer.this,com.example.xo.EditName.class);
                startActivityForResult(intent,0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){
            p1=data.getStringExtra("player_1");
            p2=data.getStringExtra("player_2");
            buttonReset.performClick();


        }

    }

    @Override
    public void onClick(View v) {
        if (key==0) return;
        if (!((Button) v).getText().toString().equals("")) {
            return;
        }
        winner.setText("");
        if (player1Turn) {
            ((Button) v).setText("X");
        } else {
            ((Button) v).setText("O");
        }
        roundCount++;
        if (checkForWin()!=0) {
            key=0;

            View line[]=new View[8];
            line[0]=findViewById(R.id.line0);
            line[1]=findViewById(R.id.line1);
            line[2]=findViewById(R.id.line2);
            line[3]=findViewById(R.id.line3);
            line[4]=findViewById(R.id.line4);
            line[5]=findViewById(R.id.line5);
            line[6]=findViewById(R.id.line6);
            line[7]=findViewById(R.id.line7);
            if(checkForWin()==1)line[0].setVisibility(View.VISIBLE);
            if(checkForWin()==2)line[1].setVisibility(View.VISIBLE);
            if(checkForWin()==3)line[2].setVisibility(View.VISIBLE);
            if(checkForWin()==4)line[3].setVisibility(View.VISIBLE);
            if(checkForWin()==5)line[4].setVisibility(View.VISIBLE);
            if(checkForWin()==6)line[5].setVisibility(View.VISIBLE);
            if(checkForWin()==7)line[6].setVisibility(View.VISIBLE);
            if(checkForWin()==8)line[7].setVisibility(View.VISIBLE);

            if (player1Turn) {
                player1Wins();
            } else {
                player2Wins();
            }
        } else if (roundCount == 9) {
            draw();
        } else {
            player1Turn = !player1Turn;
        }
    }

    int checkForWin(){
        String[][] field = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }
        for (int i = 0; i < 3; i++) {
            if (field[i][0].equals(field[i][1])
                    && field[i][0].equals(field[i][2])
                    && !field[i][0].equals("")) {
                return i+1;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (field[0][i].equals(field[1][i])
                    && field[0][i].equals(field[2][i])
                    && !field[0][i].equals("")) {
                return 4+i;
            }
        }
        if (field[0][0].equals(field[1][1])
                && field[0][0].equals(field[2][2])
                && !field[0][0].equals("")) {
            return 7;
        }
        if (field[0][2].equals(field[1][1])
                && field[0][2].equals(field[2][0])
                && !field[0][2].equals("")) {
            return 8;
        }
        return 0;
    }

    private void player1Wins() {
        player1Points++;
        winner.setText("winner: "+p1);
        textViewPlayer1.setText(p1+"(X): " + player1Points);
        textViewPlayer2.setText(p2+"(O): " + player2Points);
    }
    private void player2Wins() {
        player2Points++;
        winner.setText("winner: "+p2);
        textViewPlayer1.setText(p1+"(X): " + player1Points);
        textViewPlayer2.setText(p2+"(O): " + player2Points);

    }
    private void draw() {
        winner.setText("winner: Draw");

    }

    private void resetBoard() {
        key=1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        roundCount = 0;
        p1starts=!p1starts;
        if(p1starts) player1Turn = true;
        else player1Turn = false;

        View line[]=new View[8];
        line[0]=findViewById(R.id.line0);
        line[1]=findViewById(R.id.line1);
        line[2]=findViewById(R.id.line2);
        line[3]=findViewById(R.id.line3);
        line[4]=findViewById(R.id.line4);
        line[5]=findViewById(R.id.line5);
        line[6]=findViewById(R.id.line6);
        line[7]=findViewById(R.id.line7);
        for(int i=0;i<8;i++)line[i].setVisibility(View.GONE);
    }

}