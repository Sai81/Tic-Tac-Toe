package com.example.xo;
import java.util.Random;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


class methods {





    int checktolose(int[] a){


        class method2{
            int checkeachtolose(int[] a, int i1, int i2, int i3){

                if( a[i1]==0 && a[i2]==1 && a[i3]==1 ) return i1;
                if( a[i1]==1 && a[i2]==0 && a[i3]==1 ) return i2;
                if( a[i1]==1 && a[i2]==1 && a[i3]==0 ) return i3;
                else return -1;

            }
        }


        int result=-1;

        method2 m2= new method2();
        if(m2.checkeachtolose(a,0,1,2)!=-1)result=m2.checkeachtolose(a,0,1,2);
        if(m2.checkeachtolose(a,3,4,5)!=-1)result=m2.checkeachtolose(a,3,4,5);
        if(m2.checkeachtolose(a,6,7,8)!=-1)result=m2.checkeachtolose(a,6,7,8);
        if(m2.checkeachtolose(a,0,3,6)!=-1)result=m2.checkeachtolose(a,0,3,6);
        if(m2.checkeachtolose(a,1,4,7)!=-1)result=m2.checkeachtolose(a,1,4,7);
        if(m2.checkeachtolose(a,2,5,8)!=-1)result=m2.checkeachtolose(a,2,5,8);
        if(m2.checkeachtolose(a,0,4,8)!=-1)result=m2.checkeachtolose(a,0,4,8);
        if(m2.checkeachtolose(a,2,4,6)!=-1)result=m2.checkeachtolose(a,2,4,6);

        return result;


    }




    int checktowin(int[] a, int difficulty){


        class method2{
            int checkeachtowin(int[] a, int i1, int i2, int i3){

                if( a[i1]==0 && a[i2]==-1 && a[i3]==-1 ) return i1;
                if( a[i1]==-1 && a[i2]==0 && a[i3]==-1 ) return i2;
                if( a[i1]==-1 && a[i2]==-1 && a[i3]==0 ) return i3;
                else return -1;

            }
        }


        int result=-1;

        method2 m2= new method2();
        if(m2.checkeachtowin(a,0,1,2)!=-1)result=m2.checkeachtowin(a,0,1,2);
        if(m2.checkeachtowin(a,3,4,5)!=-1)result=m2.checkeachtowin(a,3,4,5);
        if(m2.checkeachtowin(a,6,7,8)!=-1)result=m2.checkeachtowin(a,6,7,8);
        if(m2.checkeachtowin(a,0,3,6)!=-1)result=m2.checkeachtowin(a,0,3,6);
        if(m2.checkeachtowin(a,1,4,7)!=-1)result=m2.checkeachtowin(a,1,4,7);
        if(m2.checkeachtowin(a,2,5,8)!=-1)result=m2.checkeachtowin(a,2,5,8);
        if(m2.checkeachtowin(a,0,4,8)!=-1)result=m2.checkeachtowin(a,0,4,8);
        if(m2.checkeachtowin(a,2,4,6)!=-1)result=m2.checkeachtowin(a,2,4,6);

        if(result==-1){

            Random rand = new Random(); //instance of random class

            int int_random;
            do {
                int_random = rand.nextInt(9);
                //System.out.println(int_random);
            } while (a[int_random] != 0);

            if(difficulty==3){
                if(checktolose(a)!=-1)int_random=checktolose(a);
            }
            return int_random;


        }

        else{
            return result;
        }

    }


    int check(int[] a){
        int result;
        if( a[0]==a[1]&&a[1]==a[2]&&a[2]==1 )  return 1;
        if( a[0]==a[1]&&a[1]==a[2]&&a[2]==-1 )  return -1;

        if( a[3]==a[4]&&a[4]==a[5]&&a[5]==1 )  return 2;
        if( a[3]==a[4]&&a[4]==a[5]&&a[5]==-1 )  return -2;

        if( a[6]==a[7]&&a[7]==a[8]&&a[8]==1 )  return 3;
        if( a[6]==a[7]&&a[7]==a[8]&&a[8]==-1 )  return -3;

        if( a[0]==a[3]&&a[3]==a[6]&&a[6]==1 )  return 4;
        if( a[0]==a[3]&&a[3]==a[6]&&a[6]==-1 )  return -4;

        if( a[1]==a[4]&&a[4]==a[7]&&a[7]==1 )  return 5;
        if( a[1]==a[4]&&a[4]==a[7]&&a[7]==-1 )  return -5;

        if( a[2]==a[5]&&a[5]==a[8]&&a[8]==1 )  return 6;
        if( a[2]==a[5]&&a[5]==a[8]&&a[8]==-1 )  return -6;

        if( a[0]==a[4]&&a[4]==a[8]&&a[8]==1 )  return 7;
        if( a[0]==a[4]&&a[4]==a[8]&&a[8]==-1 )  return -7;

        if( a[2]==a[4]&&a[4]==a[6]&&a[6]==1 )  return 8;
        if( a[2]==a[4]&&a[4]==a[6]&&a[6]==-1 )  return -8;

        else return 0;
    }

}


public class single_player extends AppCompatActivity {

    final int difficulty[] = new int[1];
    Button difficulty1, difficulty2, difficulty3;
    TextView d_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);

        final TextView text;
        text=findViewById(R.id.text);

        final Button restart;
        restart=findViewById(R.id.restart);
        final Button button0;
        final Button button1;
        final Button button2;
        final Button button3;
        final Button button4;
        final Button button5;
        final Button button6;
        final Button button7;
        final Button button8;
        button0=findViewById(R.id.button0);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        button5=findViewById(R.id.button5);
        button6=findViewById(R.id.button6);
        button7=findViewById(R.id.button7);
        button8=findViewById(R.id.button8);

        final View line1,line2,line3,line4,line5,line6,line7,line8;
        line1=findViewById(R.id.line4);
        line2=findViewById(R.id.line5);
        line3=findViewById(R.id.line6);
        line4=findViewById(R.id.line1);
        line5=findViewById(R.id.line2);
        line6=findViewById(R.id.line3);
        line7=findViewById(R.id.line7);
        line8=findViewById(R.id.line8);
        d_text=findViewById(R.id.d_text);

        final int num[]=new int[1];
        final int a[] = new int[9];
        for(int i=0;i<=8;i++) a[i]=0;
        final int key[] = new int[1];
        key[0]=1;
        final methods m = new methods();
        final Random rand = new Random();

        difficulty[0]=1;


        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button0.getText().toString().isEmpty()&&key[0]==1) {
                    button0.setText("X");
                    a[0] = 1;
                    num[0]++;
                    int j = 0;
                    for (int k = 0; k < 9; k++) if (a[k] == 0) j++;
                    int z;
                    z = m.check(a);
                    key[0]=0;
                    if (z != 0){
                        text.setText("WIN");
                        if(z==1||z==-1)line1.setVisibility(View.VISIBLE);
                        if(z==2||z==-2)line2.setVisibility(View.VISIBLE);
                        if(z==3||z==-3)line3.setVisibility(View.VISIBLE);
                        if(z==4||z==-4)line4.setVisibility(View.VISIBLE);
                        if(z==5||z==-5)line5.setVisibility(View.VISIBLE);
                        if(z==6||z==-6)line6.setVisibility(View.VISIBLE);
                        if(z==7||z==-7)line7.setVisibility(View.VISIBLE);
                        if(z==8||z==-8)line8.setVisibility(View.VISIBLE);
                    }

                    else if (j == 0) text.setText("DRAW");

                    else {
                        key[0]=1;
                        int int_random;
                        do {
                            int_random = rand.nextInt(9);
                        } while (a[int_random] != 0);

                        if(difficulty[0]>=2) int_random=m.checktowin(a,difficulty[0]);
                        a[int_random] = -1;
                        num[0]++;

                        if (int_random == 0) button0.setText("0");
                        else if (int_random == 1) button1.setText("0");
                        else if (int_random == 2) button2.setText("0");
                        else if (int_random == 3) button3.setText("0");
                        else if (int_random == 4) button4.setText("0");
                        else if (int_random == 5) button5.setText("0");
                        else if (int_random == 6) button6.setText("0");
                        else if (int_random == 7) button7.setText("0");
                        else button8.setText("0");

                        z = m.check(a);
                        if (z < 0) {text.setText("YOU LOSE");
                            if(z==1||z==-1)line1.setVisibility(View.VISIBLE);
                            if(z==2||z==-2)line2.setVisibility(View.VISIBLE);
                            if(z==3||z==-3)line3.setVisibility(View.VISIBLE);
                            if(z==4||z==-4)line4.setVisibility(View.VISIBLE);
                            if(z==5||z==-5)line5.setVisibility(View.VISIBLE);
                            if(z==6||z==-6)line6.setVisibility(View.VISIBLE);
                            if(z==7||z==-7)line7.setVisibility(View.VISIBLE);
                            if(z==8||z==-8)line8.setVisibility(View.VISIBLE);
                            key[0]=0;
                        }

                        else if(num[0]>=9)text.setText("DRAW");


                    }

                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button1.getText().toString().isEmpty()&&key[0]==1) {
                    button1.setText("X");
                    a[1]=1;
                    num[0]++;
                    int j=0;
                    for(int k=0;k<9;k++)if(a[k]==0)j++;
                    int z;
                    z=m.check(a);
                    key[0]=0;
                    if(z!=0){
                        if(z==1||z==-1)line1.setVisibility(View.VISIBLE);
                        if(z==2||z==-2)line2.setVisibility(View.VISIBLE);
                        if(z==3||z==-3)line3.setVisibility(View.VISIBLE);
                        if(z==4||z==-4)line4.setVisibility(View.VISIBLE);
                        if(z==5||z==-5)line5.setVisibility(View.VISIBLE);
                        if(z==6||z==-6)line6.setVisibility(View.VISIBLE);
                        if(z==7||z==-7)line7.setVisibility(View.VISIBLE);
                        if(z==8||z==-8)line8.setVisibility(View.VISIBLE);
                        text.setText("WIN");}

                    else if( j==0 ) text.setText("DRAW");

                    else{
                        key[0]=1;
                        int int_random;
                        do {
                            int_random = rand.nextInt(9);
                        } while (a[int_random] != 0);

                        if(difficulty[0]>=2) int_random=m.checktowin(a,difficulty[0]);
                        a[int_random]=-1;
                        num[0]++;

                        if(int_random==0)button0.setText("0");
                        else if(int_random==1)button1.setText("0");
                        else if(int_random==2)button2.setText("0");
                        else if(int_random==3)button3.setText("0");
                        else if(int_random==4)button4.setText("0");
                        else if(int_random==5)button5.setText("0");
                        else if(int_random==6)button6.setText("0");
                        else if(int_random==7)button7.setText("0");
                        else button8.setText("0");

                        z=m.check(a);
                        if(z<0){
                            if(z==1||z==-1)line1.setVisibility(View.VISIBLE);
                            if(z==2||z==-2)line2.setVisibility(View.VISIBLE);
                            if(z==3||z==-3)line3.setVisibility(View.VISIBLE);
                            if(z==4||z==-4)line4.setVisibility(View.VISIBLE);
                            if(z==5||z==-5)line5.setVisibility(View.VISIBLE);
                            if(z==6||z==-6)line6.setVisibility(View.VISIBLE);
                            if(z==7||z==-7)line7.setVisibility(View.VISIBLE);
                            if(z==8||z==-8)line8.setVisibility(View.VISIBLE);
                            text.setText("YOU LOSE");
                            key[0]=0;
                        }
                        else if(num[0]>=9)text.setText("DRAW");

                    }


                }

            }});

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button2.getText().toString().isEmpty()&&key[0]==1) {
                    button2.setText("X");
                    a[2]=1;
                    num[0]++;
                    int j=0;
                    for(int k=0;k<9;k++)if(a[k]==0)j++;
                    int z;
                    z=m.check(a);
                    key[0]=0;
                    if(z!=0) {
                        if(z==1||z==-1)line1.setVisibility(View.VISIBLE);
                        if(z==2||z==-2)line2.setVisibility(View.VISIBLE);
                        if(z==3||z==-3)line3.setVisibility(View.VISIBLE);
                        if(z==4||z==-4)line4.setVisibility(View.VISIBLE);
                        if(z==5||z==-5)line5.setVisibility(View.VISIBLE);
                        if(z==6||z==-6)line6.setVisibility(View.VISIBLE);
                        if(z==7||z==-7)line7.setVisibility(View.VISIBLE);
                        if(z==8||z==-8)line8.setVisibility(View.VISIBLE);
                        text.setText("WIN");}

                    else if( j==0 ) text.setText("DRAW");

                    else{
                        key[0]=1;
                        int int_random;
                        do {
                            int_random = rand.nextInt(9);
                        } while (a[int_random] != 0);

                        if(difficulty[0]>=2) int_random=m.checktowin(a,difficulty[0]);
                        a[int_random]=-1;
                        num[0]++;

                        if(int_random==0)button0.setText("0");
                        else if(int_random==1)button1.setText("0");
                        else if(int_random==2)button2.setText("0");
                        else if(int_random==3)button3.setText("0");
                        else if(int_random==4)button4.setText("0");
                        else if(int_random==5)button5.setText("0");
                        else if(int_random==6)button6.setText("0");
                        else if(int_random==7)button7.setText("0");
                        else button8.setText("0");

                        z=m.check(a);
                        if(z<0) {
                            if(z==1||z==-1)line1.setVisibility(View.VISIBLE);
                            if(z==2||z==-2)line2.setVisibility(View.VISIBLE);
                            if(z==3||z==-3)line3.setVisibility(View.VISIBLE);
                            if(z==4||z==-4)line4.setVisibility(View.VISIBLE);
                            if(z==5||z==-5)line5.setVisibility(View.VISIBLE);
                            if(z==6||z==-6)line6.setVisibility(View.VISIBLE);
                            if(z==7||z==-7)line7.setVisibility(View.VISIBLE);
                            if(z==8||z==-8)line8.setVisibility(View.VISIBLE);
                            text.setText("YOU LOSE");key[0]=0;
                        }
                        else if(num[0]>=9)text.setText("DRAW");

                    }


                }

            }});

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button3.getText().toString().isEmpty()&&key[0]==1) {
                    button3.setText("X");
                    a[3]=1;
                    num[0]++;
                    int j=0;
                    for(int k=0;k<9;k++)if(a[k]==0)j++;
                    int z;
                    z=m.check(a);
                    key[0]=0;
                    if(z!=0){
                        if(z==1||z==-1)line1.setVisibility(View.VISIBLE);
                        if(z==2||z==-2)line2.setVisibility(View.VISIBLE);
                        if(z==3||z==-3)line3.setVisibility(View.VISIBLE);
                        if(z==4||z==-4)line4.setVisibility(View.VISIBLE);
                        if(z==5||z==-5)line5.setVisibility(View.VISIBLE);
                        if(z==6||z==-6)line6.setVisibility(View.VISIBLE);
                        if(z==7||z==-7)line7.setVisibility(View.VISIBLE);
                        if(z==8||z==-8)line8.setVisibility(View.VISIBLE);
                        text.setText("WIN");}

                    else if( j==0 ) text.setText("DRAW");

                    else{
                        key[0]=1;
                        int int_random;
                        do {
                            int_random = rand.nextInt(9);
                        } while (a[int_random] != 0);

                        if(difficulty[0]>=2) int_random=m.checktowin(a,difficulty[0]);
                        a[int_random]=-1;
                        num[0]++;

                        if(int_random==0)button0.setText("0");
                        else if(int_random==1)button1.setText("0");
                        else if(int_random==2)button2.setText("0");
                        else if(int_random==3)button3.setText("0");
                        else if(int_random==4)button4.setText("0");
                        else if(int_random==5)button5.setText("0");
                        else if(int_random==6)button6.setText("0");
                        else if(int_random==7)button7.setText("0");
                        else button8.setText("0");

                        z=m.check(a);
                        if(z<0){
                            if(z==1||z==-1)line1.setVisibility(View.VISIBLE);
                            if(z==2||z==-2)line2.setVisibility(View.VISIBLE);
                            if(z==3||z==-3)line3.setVisibility(View.VISIBLE);
                            if(z==4||z==-4)line4.setVisibility(View.VISIBLE);
                            if(z==5||z==-5)line5.setVisibility(View.VISIBLE);
                            if(z==6||z==-6)line6.setVisibility(View.VISIBLE);
                            if(z==7||z==-7)line7.setVisibility(View.VISIBLE);
                            if(z==8||z==-8)line8.setVisibility(View.VISIBLE);
                            text.setText("YOU LOSE");key[0]=0;
                        }
                        else if(num[0]>=9)text.setText("DRAW");

                    }


                }

            }});

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button4.getText().toString().isEmpty()&&key[0]==1) {
                    button4.setText("X");
                    a[4]=1;
                    num[0]++;
                    int j=0;
                    for(int k=0;k<9;k++)if(a[k]==0)j++;
                    int z;
                    z=m.check(a);
                    key[0]=0;
                    if(z!=0){
                        if(z==1||z==-1)line1.setVisibility(View.VISIBLE);
                        if(z==2||z==-2)line2.setVisibility(View.VISIBLE);
                        if(z==3||z==-3)line3.setVisibility(View.VISIBLE);
                        if(z==4||z==-4)line4.setVisibility(View.VISIBLE);
                        if(z==5||z==-5)line5.setVisibility(View.VISIBLE);
                        if(z==6||z==-6)line6.setVisibility(View.VISIBLE);
                        if(z==7||z==-7)line7.setVisibility(View.VISIBLE);
                        if(z==8||z==-8)line8.setVisibility(View.VISIBLE);
                        text.setText("WIN");}

                    else if( j==0 ) text.setText("DRAW");

                    else{
                        key[0]=1;
                        int int_random;
                        do {
                            int_random = rand.nextInt(9);
                        } while (a[int_random] != 0);

                        if(difficulty[0]>=2) int_random=m.checktowin(a,difficulty[0]);
                        a[int_random]=-1;
                        num[0]++;

                        if(int_random==0)button0.setText("0");
                        else if(int_random==1)button1.setText("0");
                        else if(int_random==2)button2.setText("0");
                        else if(int_random==3)button3.setText("0");
                        else if(int_random==4)button4.setText("0");
                        else if(int_random==5)button5.setText("0");
                        else if(int_random==6)button6.setText("0");
                        else if(int_random==7)button7.setText("0");
                        else button8.setText("0");

                        z=m.check(a);
                        if(z<0){
                            if(z==1||z==-1)line1.setVisibility(View.VISIBLE);
                            if(z==2||z==-2)line2.setVisibility(View.VISIBLE);
                            if(z==3||z==-3)line3.setVisibility(View.VISIBLE);
                            if(z==4||z==-4)line4.setVisibility(View.VISIBLE);
                            if(z==5||z==-5)line5.setVisibility(View.VISIBLE);
                            if(z==6||z==-6)line6.setVisibility(View.VISIBLE);
                            if(z==7||z==-7)line7.setVisibility(View.VISIBLE);
                            if(z==8||z==-8)line8.setVisibility(View.VISIBLE);
                            text.setText("YOU LOSE");key[0]=0;
                        }
                        else if(num[0]>=9)text.setText("DRAW");

                    }

                }
            }});

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button5.getText().toString().isEmpty()&&key[0]==1) {
                    button5.setText("X");
                    a[5]=1;
                    num[0]++;
                    int j=0;
                    for(int k=0;k<9;k++)if(a[k]==0)j++;
                    int z;
                    z=m.check(a);
                    key[0]=0;
                    if(z!=0){
                        if(z==1||z==-1)line1.setVisibility(View.VISIBLE);
                        if(z==2||z==-2)line2.setVisibility(View.VISIBLE);
                        if(z==3||z==-3)line3.setVisibility(View.VISIBLE);
                        if(z==4||z==-4)line4.setVisibility(View.VISIBLE);
                        if(z==5||z==-5)line5.setVisibility(View.VISIBLE);
                        if(z==6||z==-6)line6.setVisibility(View.VISIBLE);
                        if(z==7||z==-7)line7.setVisibility(View.VISIBLE);
                        if(z==8||z==-8)line8.setVisibility(View.VISIBLE);
                        text.setText("WIN");}

                    else if( j==0 ) text.setText("DRAW");

                    else{
                        key[0]=1;
                        int int_random;
                        do {
                            int_random = rand.nextInt(9);
                        } while (a[int_random] != 0);

                        if(difficulty[0]>=2) int_random=m.checktowin(a,difficulty[0]);
                        a[int_random]=-1;
                        num[0]++;

                        if(int_random==0)button0.setText("0");
                        else if(int_random==1)button1.setText("0");
                        else if(int_random==2)button2.setText("0");
                        else if(int_random==3)button3.setText("0");
                        else if(int_random==4)button4.setText("0");
                        else if(int_random==5)button5.setText("0");
                        else if(int_random==6)button6.setText("0");
                        else if(int_random==7)button7.setText("0");
                        else button8.setText("0");

                        z=m.check(a);
                        if(z<0){
                            if(z==1||z==-1)line1.setVisibility(View.VISIBLE);
                            if(z==2||z==-2)line2.setVisibility(View.VISIBLE);
                            if(z==3||z==-3)line3.setVisibility(View.VISIBLE);
                            if(z==4||z==-4)line4.setVisibility(View.VISIBLE);
                            if(z==5||z==-5)line5.setVisibility(View.VISIBLE);
                            if(z==6||z==-6)line6.setVisibility(View.VISIBLE);
                            if(z==7||z==-7)line7.setVisibility(View.VISIBLE);
                            if(z==8||z==-8)line8.setVisibility(View.VISIBLE);
                            text.setText("YOU LOSE");key[0]=0;
                        }
                        else if(num[0]>=9)text.setText("DRAW");

                    }
                }
            }});

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button6.getText().toString().isEmpty()&&key[0]==1) {
                    button6.setText("X");
                    a[6]=1;
                    num[0]++;
                    int j=0;
                    for(int k=0;k<9;k++)if(a[k]==0)j++;
                    int z;
                    z=m.check(a);
                    key[0]=0;
                    if(z!=0){
                        if(z==1||z==-1)line1.setVisibility(View.VISIBLE);
                        if(z==2||z==-2)line2.setVisibility(View.VISIBLE);
                        if(z==3||z==-3)line3.setVisibility(View.VISIBLE);
                        if(z==4||z==-4)line4.setVisibility(View.VISIBLE);
                        if(z==5||z==-5)line5.setVisibility(View.VISIBLE);
                        if(z==6||z==-6)line6.setVisibility(View.VISIBLE);
                        if(z==7||z==-7)line7.setVisibility(View.VISIBLE);
                        if(z==8||z==-8)line8.setVisibility(View.VISIBLE);
                        text.setText("WIN");}

                    else if( j==0 ) text.setText("DRAW");

                    else{
                        key[0]=1;
                        int int_random;
                        do {
                            int_random = rand.nextInt(9);
                        } while (a[int_random] != 0);

                        if(difficulty[0]>=2) int_random=m.checktowin(a,difficulty[0]);
                        a[int_random]=-1;
                        num[0]++;

                        if(int_random==0)button0.setText("0");
                        else if(int_random==1)button1.setText("0");
                        else if(int_random==2)button2.setText("0");
                        else if(int_random==3)button3.setText("0");
                        else if(int_random==4)button4.setText("0");
                        else if(int_random==5)button5.setText("0");
                        else if(int_random==6)button6.setText("0");
                        else if(int_random==7)button7.setText("0");
                        else button8.setText("0");

                        z=m.check(a);
                        if(z<0){
                            if(z==1||z==-1)line1.setVisibility(View.VISIBLE);
                            if(z==2||z==-2)line2.setVisibility(View.VISIBLE);
                            if(z==3||z==-3)line3.setVisibility(View.VISIBLE);
                            if(z==4||z==-4)line4.setVisibility(View.VISIBLE);
                            if(z==5||z==-5)line5.setVisibility(View.VISIBLE);
                            if(z==6||z==-6)line6.setVisibility(View.VISIBLE);
                            if(z==7||z==-7)line7.setVisibility(View.VISIBLE);
                            if(z==8||z==-8)line8.setVisibility(View.VISIBLE);
                            text.setText("YOU LOSE");key[0]=0;
                        }
                        else if(num[0]>=9)text.setText("DRAW");

                    }
                }
            }});

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button7.getText().toString().isEmpty()&&key[0]==1) {
                    button7.setText("X");
                    a[7]=1;
                    num[0]++;
                    int j=0;
                    for(int k=0;k<9;k++)if(a[k]==0)j++;
                    int z;
                    z=m.check(a);
                    key[0]=0;
                    if(z!=0){
                        if(z==1||z==-1)line1.setVisibility(View.VISIBLE);
                        if(z==2||z==-2)line2.setVisibility(View.VISIBLE);
                        if(z==3||z==-3)line3.setVisibility(View.VISIBLE);
                        if(z==4||z==-4)line4.setVisibility(View.VISIBLE);
                        if(z==5||z==-5)line5.setVisibility(View.VISIBLE);
                        if(z==6||z==-6)line6.setVisibility(View.VISIBLE);
                        if(z==7||z==-7)line7.setVisibility(View.VISIBLE);
                        if(z==8||z==-8)line8.setVisibility(View.VISIBLE);
                        text.setText("WIN");}
                    else if( j==0 ) text.setText("DRAW");

                    else{
                        key[0]=1;
                        int int_random;
                        do {
                            int_random = rand.nextInt(9);
                        } while (a[int_random] != 0);

                        if(difficulty[0]>=2) int_random=m.checktowin(a,difficulty[0]);
                        a[int_random]=-1;
                        num[0]++;

                        if(int_random==0)button0.setText("0");
                        else if(int_random==1)button1.setText("0");
                        else if(int_random==2)button2.setText("0");
                        else if(int_random==3)button3.setText("0");
                        else if(int_random==4)button4.setText("0");
                        else if(int_random==5)button5.setText("0");
                        else if(int_random==6)button6.setText("0");
                        else if(int_random==7)button7.setText("0");
                        else button8.setText("0");

                        z=m.check(a);
                        if(z<0){
                            if(z==1||z==-1)line1.setVisibility(View.VISIBLE);
                            if(z==2||z==-2)line2.setVisibility(View.VISIBLE);
                            if(z==3||z==-3)line3.setVisibility(View.VISIBLE);
                            if(z==4||z==-4)line4.setVisibility(View.VISIBLE);
                            if(z==5||z==-5)line5.setVisibility(View.VISIBLE);
                            if(z==6||z==-6)line6.setVisibility(View.VISIBLE);
                            if(z==7||z==-7)line7.setVisibility(View.VISIBLE);
                            if(z==8||z==-8)line8.setVisibility(View.VISIBLE);
                            text.setText("YOU LOSE");key[0]=0;
                        }
                        else if(num[0]>=9)text.setText("DRAW");

                    }

                }
            }});

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button8.getText().toString().isEmpty()&&key[0]==1) {
                    button8.setText("X");
                    a[8] = 1;
                    num[0]++;
                    int j = 0;
                    for (int k = 0; k < 9; k++) if (a[k] == 0) j++;
                    int z;
                    z = m.check(a);
                    key[0]=0;
                    if (z != 0){
                        if(z==1||z==-1)line1.setVisibility(View.VISIBLE);
                        if(z==2||z==-2)line2.setVisibility(View.VISIBLE);
                        if(z==3||z==-3)line3.setVisibility(View.VISIBLE);
                        if(z==4||z==-4)line4.setVisibility(View.VISIBLE);
                        if(z==5||z==-5)line5.setVisibility(View.VISIBLE);
                        if(z==6||z==-6)line6.setVisibility(View.VISIBLE);
                        if(z==7||z==-7)line7.setVisibility(View.VISIBLE);
                        if(z==8||z==-8)line8.setVisibility(View.VISIBLE);
                        text.setText("WIN");}


                    else if (j == 0) text.setText("DRAW");

                    else {
                        key[0]=1;
                        int int_random;
                        do {
                            int_random = rand.nextInt(9);
                        } while (a[int_random] != 0);

                        if(difficulty[0]>=2) int_random=m.checktowin(a,difficulty[0]);
                        a[int_random] = -1;
                        num[0]++;

                        if (int_random == 0) button0.setText("0");
                        else if (int_random == 1) button1.setText("0");
                        else if (int_random == 2) button2.setText("0");
                        else if (int_random == 3) button3.setText("0");
                        else if (int_random == 4) button4.setText("0");
                        else if (int_random == 5) button5.setText("0");
                        else if (int_random == 6) button6.setText("0");
                        else if (int_random == 7) button7.setText("0");
                        else button8.setText("0");

                        z = m.check(a);
                        if (z < 0){
                            if(z==1||z==-1)line1.setVisibility(View.VISIBLE);
                            if(z==2||z==-2)line2.setVisibility(View.VISIBLE);
                            if(z==3||z==-3)line3.setVisibility(View.VISIBLE);
                            if(z==4||z==-4)line4.setVisibility(View.VISIBLE);
                            if(z==5||z==-5)line5.setVisibility(View.VISIBLE);
                            if(z==6||z==-6)line6.setVisibility(View.VISIBLE);
                            if(z==7||z==-7)line7.setVisibility(View.VISIBLE);
                            if(z==8||z==-8)line8.setVisibility(View.VISIBLE);
                            text.setText("YOU LOSE");key[0]=0;
                        }
                        else if(num[0]>=9)text.setText("DRAW");

                    }
                }
            }});
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num[0]=0;
                key[0]=1;
                for(int i=0;i<=8;i++) a[i]=0;
                text.setText("");
                button0.setText("");
                button1.setText("");
                button2.setText("");
                button3.setText("");
                button4.setText("");
                button5.setText("");
                button6.setText("");
                button7.setText("");
                button8.setText("");

                line1.setVisibility(View.GONE);
                line2.setVisibility(View.GONE);
                line3.setVisibility(View.GONE);
                line4.setVisibility(View.GONE);
                line5.setVisibility(View.GONE);
                line6.setVisibility(View.GONE);
                line7.setVisibility(View.GONE);
                line8.setVisibility(View.GONE);


            }
        });





        /*final Button difficulty1, difficulty2, difficulty3;
        difficulty1=findViewById(R.id.difficulty1);
        difficulty2=findViewById(R.id.difficulty2);
        difficulty3=findViewById(R.id.difficulty3);

        difficulty1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                difficulty[0]=1;
                difficulty1.setBackgroundResource(R.drawable.box);
                difficulty2.setBackgroundResource(R.drawable.box_transparent);
                difficulty3.setBackgroundResource(R.drawable.box_transparent);

                difficulty1.setTextColor(getResources().getColor(R.color.dark));
                difficulty2.setTextColor(getResources().getColor(R.color.darklight));
                difficulty3.setTextColor(getResources().getColor(R.color.darklight));

                restart.performClick();

            }
        });

        difficulty2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                difficulty[0]=2;
                difficulty2.setBackgroundResource(R.drawable.box);
                difficulty1.setBackgroundResource(R.drawable.box_transparent);
                difficulty3.setBackgroundResource(R.drawable.box_transparent);

                difficulty2.setTextColor(getResources().getColor(R.color.dark));
                difficulty1.setTextColor(getResources().getColor(R.color.darklight));
                difficulty3.setTextColor(getResources().getColor(R.color.darklight));

                restart.performClick();
            }
        });

        difficulty3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                difficulty[0]=3;
                difficulty3.setBackgroundResource(R.drawable.box);
                difficulty1.setBackgroundResource(R.drawable.box_transparent);
                difficulty2.setBackgroundResource(R.drawable.box_transparent);

                difficulty3.setTextColor(getResources().getColor(R.color.dark));
                difficulty2.setTextColor(getResources().getColor(R.color.darklight));
                difficulty1.setTextColor(getResources().getColor(R.color.darklight));

                restart.performClick();

            }
        });*/



        Button play;
        play=findViewById(R.id.play);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restart.performClick();

                int int_random;
                int_random = rand.nextInt(9);

                a[int_random] = -1;
                num[0]++;
                if (int_random == 0) button0.setText("0");
                else if (int_random == 1) button1.setText("0");
                else if (int_random == 2) button2.setText("0");
                else if (int_random == 3) button3.setText("0");
                else if (int_random == 4) button4.setText("0");
                else if (int_random == 5) button5.setText("0");
                else if (int_random == 6) button6.setText("0");
                else if (int_random == 7) button7.setText("0");
                else button8.setText("0");

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


        Button btn_difficulty;
        btn_difficulty=findViewById(R.id.difficulty);
        btn_difficulty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(single_player.this,com.example.xo.SelectDifficulty.class);
                intent.putExtra("d",difficulty[0]);
                startActivityForResult(intent,0);
            }
        });






        //while(result==0)


        //methods m = new methods();
        //result=m.check(a);

        //Scanner sc = new Scanner(System.in);
        //System.out.println("Enter number");
        //int z = sc.nextInt();
            /*a[1] = 1;
            a[2] = 1;
            a[3] = 1;
            a[4] = 1;
            a[5] = 1;
            a[6] = 1;*/

            /*Random rand = new Random(); //instance of random class

            int int_random;
            do {
                int_random = rand.nextInt(9);
                //System.out.println(int_random);
            } while (a[int_random] != 0);
            a[int_random]=-1; */





    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            difficulty[0]=data.getIntExtra("d",difficulty[0]);
            if(difficulty[0]==1)d_text.setText("DIFFICULTY: I");
            else if(difficulty[0]==2)d_text.setText("DIFFICULTY: II");
            else d_text.setText("DIFFICULTY: III");
        }

    }
}
