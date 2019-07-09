package com.example.jankenpo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
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
        this.mViewHolder.appear = new AlphaAnimation(0,1);
        this.mViewHolder.desappear = new AlphaAnimation(1,0);
        this.mViewHolder.desappear.setDuration(100);
        this.mViewHolder.appear.setDuration(1500);

        this.mViewHolder.desappear.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                mViewHolder.player2.setVisibility(View.VISIBLE);

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mViewHolder.player2.setVisibility(View.INVISIBLE);
                mViewHolder.player2.setAnimation(mViewHolder.appear);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        this.mViewHolder.appear.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                mViewHolder.player2.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mViewHolder.player2.setVisibility(View.VISIBLE);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
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
        this.mViewHolder.player2.setAnimation(mViewHolder.desappear);

    }
    public static class ViewHolder{
        ImageView player1,player2;
        ImageButton rock, paper, scissors;
        Animation appear, desappear;

    }

}
