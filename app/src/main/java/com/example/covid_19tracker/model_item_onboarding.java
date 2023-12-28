package com.example.covid_19tracker;

public class model_item_onboarding {


    int image_onboard;
    String tiitle , description;

    public model_item_onboarding(int image_onboard, String tiitle, String description) {
        this.image_onboard = image_onboard;
        this.tiitle = tiitle;
        this.description = description;
    }


    public int getImage_onboard() {
        return image_onboard;
    }

    public String getTiitle() {
        return tiitle;
    }

    public String getDescription() {
        return description;
    }
}
