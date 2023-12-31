package com.example.covid_19tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {
    private MeowBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigation=findViewById(R.id.bottomNavigation);
        bottomNavigation.show(2, true);

        // add your bottom navigation icon here
        bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.star_svgrepo_com));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.earth_12_svgrepo_com__1_));
        bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.flag_2_svgrepo_com));




        bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {

                int id = model.getId();

                if (id==1){
                    LoadFragments(new Countries_Fragment(),false);
                } else if (id==2) {
                    LoadFragments(new global_Data_Fragments(),false);
                } else {
                    LoadFragments(new Home_country_Fragment(),false);
                }

//
//                switch(model.getId())
//                {
//                    case 1:
//                        break;
//                    case 2:
//                        break;
//                    case 3:
//                        break;
//                }
                return null;
            }
        });

        LoadFragments(new global_Data_Fragments(),true);

    }

    public void LoadFragments(Fragment fragment, boolean flag){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (flag) {
            fragmentTransaction.add(R.id.container, fragment);
        }
        else {
            fragmentTransaction.replace(R.id.container,fragment);
        }
        fragmentTransaction.commit();
    }

}