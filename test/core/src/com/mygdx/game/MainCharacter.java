package com.mygdx.game;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MainCharacter extends Actor {

    private Texture texture;
    public MainCharacter(Texture texture)
    {
        this.texture = texture;
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture,getX(),getY(),0,0,texture.getWidth(),
                texture.getHeight(),getScaleX(), getScaleY(),getRotation(),0,0,
                texture.getWidth(),texture.getHeight(),false, false);
    }
    @Override
    public void act(float delta){


    }
}