package com.example.covid_19tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class onBoarding_screen extends AppCompatActivity {


    ViewPager viewPager;
    Adapter_onboarding_screen adapter_onboarding_screen;
    LinearLayout dotsLayout;
    ImageView Next_btn_onboarding;
    public TextView[] dots;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding_screen);


        viewPager = findViewById(R.id.viewpager);
        dotsLayout = findViewById(R.id.dotsLayout);
        Next_btn_onboarding = findViewById(R.id.Next_btn_onboarding);

        List<model_item_onboarding> listItem = new ArrayList<>();
        listItem.add(new model_item_onboarding(R.drawable.covidwelcomescreen,"Welcome to COVID Tracker","Stay informed and healthy with our real-time COVID insights."));
        listItem.add(new model_item_onboarding(R.drawable.worldwidedata,"Explore Global Data","Track cases, deaths, and recoveries worldwide"));
        listItem.add(new model_item_onboarding(R.drawable.protection,"Stay Informed, Stay Safe","COVID safety: Masks, distance, hygiene; protect, prevent, stay informed."));

        adapter_onboarding_screen = new Adapter_onboarding_screen(this, listItem);
        viewPager.setAdapter(adapter_onboarding_screen);

        Next_btn_onboarding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1,true);
            }
        });

        Dots(0);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                Dots(position);

                Next_btn_onboarding.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (position < 2 ) {
                            viewPager.setCurrentItem(position + 1, true);
                        }
                        else {
                            Intent intent = new Intent(onBoarding_screen.this,MainActivity.class);
                            startActivity(intent);
                        }
                    }
                });

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    public void Dots(int pos){

         dots = new TextView[3];
         dotsLayout.removeAllViews();

         for (int i = 0; i < dots.length; i++){
             dots[i] = new TextView(this);
             dots[i].setText(Html.fromHtml("&#8226;"));
             dots[i].setTextColor(getColor(R.color.unselect_grey));
             dots[i].setTextSize(40);                                     // unselected text (dots size) size
             dotsLayout.addView(dots[i]);

         }
             if (dots.length > 0){
             dots[pos].setTextColor(getColor(R.color.grey));
             dots[pos].setTextSize(40);
             }


    }

}