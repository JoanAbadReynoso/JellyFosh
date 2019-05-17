package com.mygdx.game;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Coral extends Actor {
    int velocidadCoral = -3;
    int finDePantallaCoral = -200;

    float coralPositionX1 = 600.f;
    float coralPositionY1 = -270.f;

    float coralPositionX2 = 650.f;
   // float coralPositionY2 = 90.f;

    private Sprite CoralSprite;
    public Coral(Sprite sprite)
    {
        this.CoralSprite = sprite;
        CoralSprite.setScale(0.2f);
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        CoralSprite.draw(batch);
    }
    @Override
    public void act(float delta){
        coralPositionX1+=velocidadCoral;
        coralPositionX2+=velocidadCoral;
        CoralSprite.setPosition(coralPositionX1,coralPositionY1);


        if (coralPositionX1 < finDePantallaCoral)
        {
            coralPositionX1 = 600;
        }

        /*if (coralPositionX2 < finDePantallaCoral)
        {
            coralPositionX2 = 650;
        }*/

    }
}