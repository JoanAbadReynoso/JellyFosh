package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import org.omg.CORBA.Current;

public class MainCharacter extends Actor {

    Animation Anim;

    int xPosicion = -30;
    int yPosicion = 100;
    float velocidadMedusaSubida = 4;
    float velocidadMedusaBajada = 2;
    float boundsMedusa;
    Boolean MedusaNadando = false;
    private TextureRegion currentRegion;
    private float time = 0;

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

        time += delta;
        currentRegion = (TextureRegion)Anim.getKeyFrame(time,true);

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE))
        {
            MedusaNadando = true;
            if (yPosicion >= Gdx.graphics.getHeight() - 165){

                yPosicion = Gdx.graphics.getHeight()-165;
            }
        }
        else
            {
                MedusaNadando = false;
            }

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

        System.out.println(yPosicion);
        System.out.println(Gdx.graphics.getHeight());



    }
}