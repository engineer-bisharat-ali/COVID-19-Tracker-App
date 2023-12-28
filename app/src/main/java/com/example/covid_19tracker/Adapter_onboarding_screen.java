package com.example.covid_19tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import org.w3c.dom.Text;

import java.util.List;

public class Adapter_onboarding_screen extends PagerAdapter {

Context context;
List<model_item_onboarding> listitem;

    public Adapter_onboarding_screen(Context context, List<model_item_onboarding> listitem) {
        this.context = context;
        this.listitem = listitem;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.layout_item,null,false);


        ImageView onboard_image = view.findViewById(R.id.onboard_image);
        TextView onboard_tittle = view.findViewById(R.id.onboard_title);
        TextView onboard_description = view.findViewById(R.id.onboard_description);

        onboard_image.setImageResource(listitem.get(position).getImage_onboard());
        onboard_tittle.setText(listitem.get(position).getTiitle());
        onboard_description.setText(listitem.get(position).getDescription());

        container.addView(view);

        return view;

    }

    @Override
    public int getCount() {
        return listitem.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
