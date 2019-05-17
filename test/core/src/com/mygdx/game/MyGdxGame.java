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


public class MyGdxGame extends Game {

	int velocidadCoral = -3;
	int finDePantallaCoral = -200;

	float coralPositionX1 = 600.f;
	float coralPositionY1 = -270.f;

	float coralPositionX2 = 650.f;
	float coralPositionY2 = 90.f;


	private Stage stage;
	SpriteBatch batch;

	//TEXTURES

	Texture img;

	Texture Coral;
	Texture DeepSea;

	//Sprite

	Sprite MedusaSprite;
	Sprite coralSprite;
	Sprite coralSprite2;
	Sprite deepSeaSprite;

	private Texture texturaPlayer;

	MainCharacter MC;

	@Override
	public void create () {
		stage = new Stage();

		batch = new SpriteBatch();
		Coral = new Texture ("coral_pixel.png");
		DeepSea = new Texture ("DeepSea.png");


		coralSprite = new Sprite(Coral);
		coralSprite2 = new Sprite(Coral);
		deepSeaSprite = new Sprite(DeepSea);

		coralSprite.setScale(0.2f);
		coralSprite2.setScale(0.2f);
		coralSprite2.setRotation(180.f);

		coralSprite.setPosition(coralPositionX1, coralPositionY1);
		coralSprite2.setPosition(coralPositionX2, coralPositionY2);

		texturaPlayer = new Texture("jellyFish_1.png");
		MedusaSprite = new Sprite(texturaPlayer);
		MC=new MainCharacter(MedusaSprite);
		stage.addActor(MC);
	}

	@Override
	public void render () {
		super.render();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


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


