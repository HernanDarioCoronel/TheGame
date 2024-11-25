package Main.GameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import Main.Game;
import Main.HUD;
import Main.Handler;
import Main.IdEnum;

public class Player extends GameObject {

	Handler handler;

	public Player(int xInitPos, int yInitPos, int width, int height, int velocity, IdEnum id, Handler handler) {
		super(xInitPos, yInitPos, width, height, velocity, id);
		this.handler = handler;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		super.tick();

		this.xPos = (int)Game.clamp(this.xPos, 0, Game.WIDTH - (int) (this.width * 1.5));
		this.yPos = (int)Game.clamp(this.yPos, 0, Game.HEIGHT - (this.height * 2));
		
		handler.addObject(new Trail(xPos, yPos, width, height, velocity, id, handler, Color.LIGHT_GRAY, 0.02f));

		collision();
	}

	public void collision() {
		for (GameObject go : handler.objectList) {
			if (go.getId() == IdEnum.BasicEnemy && getBounds().intersects(go.getBounds())) {
				HUD.HEALTH -= 2;
			}
		}
	}

	@Override
	public void render(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		g.setColor(Color.green);
		g2d.fill(getBounds());

	}

}
