package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterView;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView spinPointer;
    private Random rand = new Random();
    private int lastDirection;
    private boolean spin;

    private ImageView postPic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinPointer = findViewById(R.id.spinnerImage);

    }

    //onClick fxn for pool cue (spinner)
    public void spinPointer(View v) {
        //check spin state is done
        if (!spin) {
            //generate random number 1-1800
            int num = rand.nextInt(1800);

            //spin at image center
            float posX = spinPointer.getWidth() / 2;
            float posY = spinPointer.getHeight() / 2;

            Animation rotate = new RotateAnimation(lastDirection, num, posX, posY);

            rotate.setDuration(2500);

            rotate.setFillAfter(true);
            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart (Animation animate) {
                    spin = true;
                }

                @Override
                public void onAnimationEnd(Animation animate) {
                    spin = false;
                }

                @Override
                public void onAnimationRepeat(Animation animate) {
                }
            });

            lastDirection = num;

            spinPointer.startAnimation(rotate);
        }
    }

//    public void postPic(String picName, View v) {
//        View pic = findViewById(R.id.picName);
//        ImageButton show_pic = new ImageButton(this);
//        show_pic.setBackgroundColor(Color.GRAY);
//        show_pic.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(postPic.getVisibility() == View.INVISIBLE) {
//                    postPic.setVisibility(View.VISIBLE);
//                } else if(postPic.getVisibility() == View.VISIBLE) {
//                        postPic.setVisibility(View.INVISIBLE);
//                }
//            }
//        });
//
//        params = newRelativeLayout.LayoutParams(100, 100);
//        params.topmargin = 5;
//        params.leftMargin = 5;
//        v.addView(show_pic, params);
//
//        //Imageview loaded from drawable
//        postPic = new ImageView(this);
//        params = new RelativeLayout.LayoutParams(100, 100);
//        params.topMargin = 0;
//        params.leftMargin = 30;
//        postPic.setImageResource(R.drawable.pic);
//        postPic.setVisibility(View.INVISIBLE);
//        v.addView(postPic, params);
//
//        this.setContentView(v);
//    }
}
