package com.mygdx.game;
package com.rtype.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;



public class MainCharacter extends Actor {
	@Override
	public void draw(Batc)
}

public class MyGdxGame extends Game {

	SpriteBatch batch;
	Texture img;
	Texture medusa;
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		medusa = new Texture ("jellyFish_1.png");

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(medusa,300,300);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
