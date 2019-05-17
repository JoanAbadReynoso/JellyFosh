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

	private Stage stage;
	SpriteBatch batch;

	//TEXTURE

	Texture Coral;
	Texture DeepSea;

	//Sprite

	Sprite MedusaSprite;
	Sprite coralSprite;
	Sprite coralSprite2;
	Sprite deepSeaSprite;

	private Texture texturaPlayer;

	MainCharacter MC;
	Coral Koral;
	Coral Koral2;


	@Override
	public void create () {
		stage = new Stage();

		batch = new SpriteBatch();

		DeepSea = new Texture ("DeepSea.png");



		//coralSprite2 = new Sprite(Coral);
		deepSeaSprite = new Sprite(DeepSea);


		//coralSprite2.setScale(0.2f);
		//coralSprite2.setRotation(180.f);

		//coralSprite.setPosition(coralPositionX1, coralPositionY1);
		//coralSprite2.setPosition(coralPositionX2, coralPositionY2);

		texturaPlayer = new Texture("jellyFish_1.png");
		MedusaSprite = new Sprite(texturaPlayer);
		MC=new MainCharacter(MedusaSprite);
		stage.addActor(MC);

		Coral = new Texture ("coral_pixel.png");
		coralSprite = new Sprite(Coral);
		Koral=new Coral(coralSprite);
		Koral2=new Coral(coralSprite);
		stage.addActor(Koral);


	}

	@Override
	public void render () {
		super.render();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);




		batch.begin();
		deepSeaSprite.draw(batch);
		//coralSprite.draw(batch);
		//coralSprite2.draw(batch);
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


