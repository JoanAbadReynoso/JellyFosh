package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MainCharacter extends Actor {

   public Texture medusa;
    Sprite medusaSprite;
    int xPosicion = -30;
    int yPosicion = 100;
    float velocidadMedusaSubida = 4;
    float velocidadMedusaBajada = 2;
    Boolean MedusaNadando = false;


    public MainCharacter(Sprite sprite)
    {
        this.medusaSprite = sprite;
        medusaSprite.setScale(0.2f);
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
             medusaSprite.draw(batch);

    }
    @Override
    public void act(float delta){

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE))
        {
            MedusaNadando = true;
        }
        else
        {
            MedusaNadando = false;
        }


        if (MedusaNadando == true)
        {
            //setY(getY()+velocidadMedusaSubida*delta);
            yPosicion+= velocidadMedusaSubida;
            medusaSprite.setPosition(xPosicion,yPosicion);
        }
        else
        {
            yPosicion-= velocidadMedusaBajada;
            medusaSprite.setPosition(xPosicion,yPosicion);
        }



    }
}