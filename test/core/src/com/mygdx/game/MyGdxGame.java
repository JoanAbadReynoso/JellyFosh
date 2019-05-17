package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class MyGdxGame extends Game {

	private Stage stage;
	SpriteBatch batch;

	BitmapFont font;
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

		font = new BitmapFont();
		font.setColor(Color.CORAL);



		deepSeaSprite = new Sprite(DeepSea);


		//coralSprite2.setScale(0.2f);
		//coralSprite2.setRotation(180.f);

		//coralSprite.setPosition(coralPositionX1, coralPositionY1);
		//coralSprite2.setPosition(coralPositionX2, coralPositionY2);

		texturaPlayer = new Texture("jellyFish_1.png");
		MedusaSprite = new Sprite(texturaPlayer);
		MC=new MainCharacter(MedusaSprite);
		stage.addActor(MC);
		MC.collisionMedusa = new Rectangle(MC.xPosicion,MC.yPosicion,MC.anchoMedusa,MC.altoMedusa);


		Coral = new Texture ("coral_pixel.png");
		coralSprite = new Sprite(Coral);
		coralSprite2 = new Sprite(Coral);
		Koral=new Coral(coralSprite);
		Koral2=new Coral(coralSprite);

		stage.addActor(Koral);
		stage.addActor(Koral2);

		Koral.coralCollision= new Rectangle(Koral.coralPositionX1,Koral.coralPositionY1,Koral.anchoCoral,Koral.altoCoral);;

	}

	@Override
	public void render () {
		super.render();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		deepSeaSprite.draw(batch);

		if(MC.collisionMedusa.overlaps(Koral.coralCollision))
		{
			MC.viva = false;
			Koral.velocidadCoral = 0;
		}





		//System.out.println(Koral.coralCollision);
		//	System.out.println(MC.collisionMedusa);

		//coralSprite.draw(batch);
		//coralSprite2.draw(batch);
		font.draw(batch,"SCORE: ",Gdx.graphics.getWidth()/1.4f,Gdx.graphics.getHeight()/1.05f);
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


