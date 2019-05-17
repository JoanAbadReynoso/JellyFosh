package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class MainCharacter extends Actor {

   public Texture medusa;
    Sprite medusaSprite;
    int xPosicion = -30;
    int yPosicion = 100;
    int anchoMedusa = 37;
    int altoMedusa = 46;
    float velocidadMedusaSubida = 4;
    float velocidadMedusaBajada = 2;
    float boundsMedusa;
    Rectangle collisionMedusa;
    Boolean MedusaNadando = false;
    Coral cor;
    Boolean viva = true;

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
        if (viva == true) {
            if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
                MedusaNadando = true;
                if (yPosicion >= 310) {

                    yPosicion = 310;
                }
            } else {
                MedusaNadando = false;
            }

            if (MedusaNadando == true) {
                //setY(getY()+velocidadMedusaSubida*delta);
                yPosicion += velocidadMedusaSubida;
                medusaSprite.setPosition(xPosicion, yPosicion);
            } else {


                if (yPosicion <= -100) {
                    yPosicion = -100;
                }
                yPosicion -= velocidadMedusaBajada;
                medusaSprite.setPosition(xPosicion, yPosicion);
            }
            recalcularBB();
        }
        else
        {
            System.out.println("!TOCADO!");

        }



    }
    public void recalcularBB()
    {
        collisionMedusa.setX(xPosicion);
        collisionMedusa.setY(yPosicion);
    }
}