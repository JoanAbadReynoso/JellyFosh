package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import org.omg.CORBA.Current;


public class MainCharacter extends Actor {

    Animation Anim;

    int xPosicion = -30;
    int yPosicion = 100;
    int anchoMedusa = 37;
    int altoMedusa = 46;
    float velocidadMedusaSubida = 4;
    float velocidadMedusaBajada = 2;
    float boundsMedusa;
    Rectangle collisionMedusa;
    Boolean MedusaNadando = false;
    private TextureRegion currentRegion;
    private float time = 0;
    Coral cor;
    Boolean viva = true;

    public MainCharacter(Animation Up)
    {
        this.Anim = Up;

    }
    @Override
    public void draw(Batch batch, float ParentAlpha){
        batch.draw(currentRegion, xPosicion, yPosicion);

    }
    @Override
    public void act(float delta){
        if (viva == true) {
            if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
                MedusaNadando = true;
                if (yPosicion >= 310) {

        time += delta;
        currentRegion = (TextureRegion)Anim.getKeyFrame(time,true);

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE))
        {
            MedusaNadando = true;
            if (yPosicion >= Gdx.graphics.getHeight() - 165){
                    yPosicion = 310;
                }
            } else {
                MedusaNadando = false;
            }

                yPosicion = Gdx.graphics.getHeight()-165;
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
                MedusaNadando = false;
            }
        {
            System.out.println("!TOCADO!");

            if (MedusaNadando == true)
            {
            yPosicion+= velocidadMedusaSubida;

        }
        else
        {
            if(yPosicion <= -100)
            {
                yPosicion = -100;
            }
            yPosicion -= velocidadMedusaBajada;


        }



    }
    public void recalcularBB()
    {
        collisionMedusa.setX(xPosicion);
        collisionMedusa.setY(yPosicion);
    }
}