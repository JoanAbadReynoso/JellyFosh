package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class MyGdxGame extends ApplicationAdapter {
	int xMedusa=-30;
	int yMedusa=100;
	float velocidadMedusaSubida = 4;
	float velocidadMedusaBajada = 2;
	int velocidadCoral = -3;
	int finDePantallaCoral = -200;
	Boolean MedusaNadando = false;
	float startTime = 0;

	float coralPositionX1 = 600.f;
	float coralPositionY1 = -270.f;

	float coralPositionX2 = 650.f;
	float coralPositionY2 = 90.f;

public class MyGdxGame extends Game {

	private Stage stage;
	SpriteBatch batch;

	//TEXTURES

	Texture img;
	Texture medusa;
	Texture Coral;
	Texture DeepSea;

	//Sprite

	Sprite medusaSprite;
	Sprite coralSprite;
	Sprite coralSprite2;
	Sprite deepSeaSprite;
	
	private Texture texturaPlayer;

	@Override
	public void create () {
		batch = new SpriteBatch();
		medusa = new Texture ("jellyFish_1.png");
		Coral = new Texture ("coral_pixel.png");
		DeepSea = new Texture ("DeepSea.png");


		medusaSprite = new Sprite(medusa);
		coralSprite = new Sprite(Coral);
		coralSprite2 = new Sprite(Coral);
		deepSeaSprite = new Sprite(DeepSea);




		medusaSprite.setPosition(xMedusa,yMedusa);
		medusaSprite.setScale(0.2f);

		coralSprite.setScale(0.2f);
		coralSprite2.setScale(0.2f);
		coralSprite2.setRotation(180.f);

		coralSprite.setPosition(coralPositionX1, coralPositionY1);
		coralSprite2.setPosition(coralPositionX2, coralPositionY2);

		texturaPlayer = new Texture("jellyFish_1.png");
		MainCharacter MC = new MainCharacter(texturaPlayer);
		stage = new Stage();
		stage.addActor(MC);
		MC.setPosition(100,100);
	}

	@Override
	public void render () {
		super.render();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if (Gdx.input.isKeyPressed(Input.Keys.SPACE))
		{
			MedusaNadando = true;
		}
		else
		{
			MedusaNadando = false;
		}

		startTime = System.currentTimeMillis();


		if (MedusaNadando == true)
		{
			yMedusa+= velocidadMedusaSubida;
			medusaSprite.setPosition(xMedusa,yMedusa);
		}
		else
		{
			yMedusa-= velocidadMedusaBajada;
			medusaSprite.setPosition(xMedusa,yMedusa);
		}


		coralPositionX1+=velocidadCoral;
		coralPositionX2+=velocidadCoral;
		coralSprite.setPosition(coralPositionX1,coralPositionY1);
		coralSprite2.setPosition(coralPositionX2,coralPositionY2);

		if (coralPositionX1 < finDePantallaCoral)
		{
			coralPositionX1 = 600;
		}

		if (coralPositionX2 < finDePantallaCoral)
		{
			coralPositionX2 = 650;
		}

		batch.begin();
		deepSeaSprite.draw(batch);
		medusaSprite.draw(batch);
		coralSprite.draw(batch);
		coralSprite2.draw(batch);
		batch.end();
		stage.act();
		stage.draw();
	}

		@Override
		public void dispose () {
			super.dispose();
			stage.dispose();
			texturaPlayer.dispose();
		}
	}

}
