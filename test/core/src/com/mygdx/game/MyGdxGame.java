package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class MyGdxGame extends Game {

	private Stage stage;
	SpriteBatch batch;
	AssetManager manager;
	Animation Up;
	private TextureAtlas textureAtlas;
	//TEXTURE

	Texture Coral;
	Texture DeepSea;

	//Sprite


	Sprite coralSprite;
	Sprite coralSprite2;
	Sprite deepSeaSprite;



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
		manager = new AssetManager();
		manager.load("medusaAnimation.atlas", TextureAtlas.class);
		textureAtlas = new TextureAtlas(Gdx.files.internal("medusaAnimation.atlas"));


		Up = new Animation(1/11f, textureAtlas.findRegions("JellyFish"));
		Up.setPlayMode(Animation.PlayMode.LOOP);



		//coralSprite2.setScale(0.2f);
		//coralSprite2.setRotation(180.f);

		//coralSprite.setPosition(coralPositionX1, coralPositionY1);
		//coralSprite2.setPosition(coralPositionX2, coralPositionY2);



		Coral = new Texture ("coral_pixel.png");
		coralSprite = new Sprite(Coral);
		Koral=new Coral(coralSprite);
		Koral2=new Coral(coralSprite);
		stage.addActor(Koral);
		MC=new MainCharacter(Up);
		stage.addActor(MC);

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

		}
	}


