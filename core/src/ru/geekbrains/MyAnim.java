package ru.geekbrains;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyAnim {
    Texture img;
    Animation<TextureRegion> anm;
    private float time;

    public MyAnim(String name) {
        time = 0;
        img = new Texture(name);
        TextureRegion reg = new TextureRegion(img);
        TextureRegion[][] regions = reg.split(img.getWidth()/10, img.getHeight());
        anm = new Animation<>(1/60f, regions[0]);
        anm.setPlayMode(Animation.PlayMode.LOOP);
    }

    public TextureRegion draw() {

        return anm.getKeyFrame(time);
    }

    public void setTime(float dT) {

        time += dT;
    }

    public void dispose() {
        this.img.dispose();
    }
}
