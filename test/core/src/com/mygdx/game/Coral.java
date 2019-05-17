package com.mygdx.game;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class Coral extends Actor {


    int velocidadCoral = -3;
    int finDePantallaCoral = -200;
    int coralPositionX1 = 600;
    int coralPositionY1 = -270;
    int anchoCoral = 58, altoCoral = 268;


    Rectangle coralCollision;
    int coralPositionX2 = 650;
    int coralPositionY2 = 90;

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

        CoralSprite.setPosition(coralPositionX1,coralPositionY1);

        if (coralPositionX1 < finDePantallaCoral)
        {
            coralPositionX1 = 600;
        }

        recalcularBB();
    }

    public void recalcularBB()
    {
        coralCollision.setX(coralPositionX1 + anchoCoral);
        coralCollision.setY(coralPositionY1 - 5);
    }
}