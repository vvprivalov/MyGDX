package ru.geekbrains;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private MyAnim anim;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		anim = new MyAnim("coin-sprite-animation.png");

	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);

		anim.setTime(Gdx.graphics.getDeltaTime());

		int x = Gdx.input.getX() - anim.draw().getRegionWidth()/2;
		int y = Gdx.graphics.getHeight() - (Gdx.input.getY() + anim.draw().getRegionHeight()/2);


		batch.begin();
		batch.draw(anim.draw(), x, y);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		anim.dispose();
	}
}
