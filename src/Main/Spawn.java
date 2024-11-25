package Main;

import java.util.Random;

import Main.GameObjects.BasicEnemy;
import Main.GameObjects.FastEnemy;
import Main.GameObjects.SmartEnemy;

public class Spawn {
	private Handler handler;
	private HUD hud;
	private int scoreKeep = 0;
	private Random rnd;

	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
		this.rnd = new Random();
	}

	public void tick() {
		scoreKeep++;

		if (scoreKeep >= 300) {
			scoreKeep = 0;
			hud.incrementLevel();

			if (hud.getLevel() % 3 == 0) {
				handler.addObject(
						new FastEnemy(rnd.nextInt(16, Game.WIDTH - 16), rnd.nextInt(16, Game.HEIGHT - 16), handler));
			} else if (hud.getLevel() % 5 == 0) {
				handler.addObject(
						new SmartEnemy(rnd.nextInt(20, Game.WIDTH - 20), rnd.nextInt(20, Game.HEIGHT - 20), handler));
			} else {
				handler.addObject(
						new BasicEnemy(rnd.nextInt(10, Game.WIDTH - 10), rnd.nextInt(10, Game.HEIGHT - 10), handler));
			}

		}
	}
}
