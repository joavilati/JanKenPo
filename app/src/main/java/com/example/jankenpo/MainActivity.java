package com.example.jankenpo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ViewHolder mViewHolder = new ViewHolder();

    int player1Plays;
    int player2Plays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.player1 = findViewById(R.id.player1);
        this.mViewHolder.player2 = findViewById(R.id.player2);
        this.mViewHolder.paper = findViewById(R.id.buttonPaper);
        this.mViewHolder.rock = findViewById(R.id.buttonRock);
        this.mViewHolder.scissors = findViewById(R.id.buttonScissors);

        this.mViewHolder.appear = new AlphaAnimation(0,1);
        this.mViewHolder.desappear = new AlphaAnimation(1,0);
        this.mViewHolder.desappear.setDuration(1500);
        this.mViewHolder.appear.setDuration(250);

        this.mViewHolder.desappear.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                mViewHolder.player2.setVisibility(View.VISIBLE);


            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mViewHolder.player2.setVisibility(View.INVISIBLE);
                mViewHolder.player2.startAnimation(mViewHolder.appear);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        this.mViewHolder.appear.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                mViewHolder.player2.setScaleX(-1f);
                moveLottery();
                mViewHolder.player2.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                checkGame(player1Plays,player2Plays);

                mViewHolder.player2.setVisibility(View.VISIBLE);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void checkGame(int player1Plays, int player2Plays) {
        int result = player1Plays - player2Plays;
        switch (result){
            case -2:
                Toast.makeText(this,"Você Ganhou!",Toast.LENGTH_SHORT).show();// Player 1 win (p1 = Paper && p2 = Rock) || (p1 = Rock && p2 = Scissors)
                break;
            case -4:
                Toast.makeText(this,"Você Perdeu!",Toast.LENGTH_SHORT).show();// Player 2 win (p1 = Paper && p2 =Scissors )
            case 0:
                Toast.makeText(this,"Empate!",Toast.LENGTH_SHORT).show();// Draw (p1 = p2)
                break;
            case 1:
                // Player 2 win
                break;
            case 2:
                Toast.makeText(this,"Você Perdeu!",Toast.LENGTH_SHORT).show();// Player 2 win (p1 = Rock && p2 = Paper) || (p1 = Scissors && p2 = Rock)
                break;
            case 4:
                Toast.makeText(this,"Você Ganhou!",Toast.LENGTH_SHORT).show();// Player 1 win (p1 = Scissors && p2 = Paper)
                break;
        }
    }

    public void moveLottery(){
        Random mRandom =  new Random();
        int randomNum = mRandom.nextInt(3);

        switch (randomNum){
            case 0:
                this.mViewHolder.player2.setImageResource(R.drawable.papel);// Paper
                player2Plays = 1;
                break;
            case 1:
                this.mViewHolder.player2.setImageResource(R.drawable.pedra);// Rock
                player2Plays = 3;
                break;
            case 2:
                this.mViewHolder.player2.setImageResource(R.drawable.tesoura); // Scissors
                player2Plays = 5;
                break;
        }
    }
    public void buttonTouched(View view){


        switch (view.getId()){

            case(R.id.buttonPaper): this.mViewHolder.player1.setImageResource(R.drawable.papel);// Paper
                player1Plays = 1;
            break;

            case(R.id.buttonRock): this.mViewHolder.player1.setImageResource(R.drawable.pedra); // Rock
                player1Plays = 3;
            break;

            case (R.id.buttonScissors): this.mViewHolder.player1.setImageResource(R.drawable.tesoura); //Scissors
                player1Plays = 5;
            break;


        }
        this.mViewHolder.player2.setScaleX(1f);
        this.mViewHolder.player2.setImageResource(R.drawable.interrogacao);
        this.mViewHolder.player2.startAnimation(mViewHolder.desappear);

    }
    public static class ViewHolder{
        ImageView player1,player2;
        ImageButton rock, paper, scissors;
        Animation appear, desappear;

    }

}
