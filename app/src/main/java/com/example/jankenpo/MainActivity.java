package com.example.jankenpo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ViewHolder mViewHolder = new ViewHolder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.player1 = findViewById(R.id.player1);
        this.mViewHolder.player2 = findViewById(R.id.player2);
        this.mViewHolder.paper = findViewById(R.id.buttonPaper);
        this.mViewHolder.rock = findViewById(R.id.buttonRock);
        this.mViewHolder.scissors = findViewById(R.id.buttonScissors);
    }
    public void tocouBotao(View view){


        switch (view.getId()){

            case(R.id.buttonPaper): this.mViewHolder.player1.setImageResource(R.drawable.papel);
            break;

            case(R.id.buttonRock): this.mViewHolder.player1.setImageResource(R.drawable.pedra);
            break;
            case (R.id.buttonScissors): this.mViewHolder.player1.setImageResource(R.drawable.tesoura);
            break;


        }
        this.mViewHolder.player2.setImageResource(R.drawable.interrogacao);

    }
    public static class ViewHolder{
        ImageView player1,player2;
        ImageButton rock, paper, scissors;
    }
}
