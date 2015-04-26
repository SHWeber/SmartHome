package com.smarthome.jw.smarthome;

import com.smarthome.jw.smarthome.Home;

/**
 * Created by jonas on 22.04.15.
 */
public abstract class Screen {

    protected final Home home;

    public Screen(Home home) {
        this.home = home;
    }

    public abstract void update(float deltaTime);

    public abstract void paint(float deltaTime);

    public abstract void pause();

    public abstract void resume();

    public abstract void dispose();

    public abstract void backButton();


}
