package Main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	public static double HEALTH = 100;

	private int score = 0;
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	private int level = 1;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	public void incrementLevel() {
		this.level++;
	}

	public void tick() {
		HEALTH += 0.02;// health regen
		HEALTH = Game.clamp(HEALTH, 0, 100);
		score++;
	}

	public void render(Graphics g) {
		// box shadow
		g.setColor(Color.black);
		g.fillRect(18, 18, 200, 32);

		g.drawString("Level: " + level, 165, 64);
		g.drawString("Score: " + score, 15, 64);

		// box background
		g.setColor(Color.darkGray);
		g.fillRect(15, 15,  200, 32);

		// health bar
		g.setColor(HealthBarColor());
		g.fillRect(15, 15, (int) HEALTH * 2, 32);

	}

	private Color HealthBarColor() {
		double red = 90, green = 255, blue = 50;

		if (HEALTH > 50) {
			red = red * (2.8 * (1 - (HEALTH - 50) / 50));
		}
		if (HEALTH <= 50) {
			red = 255;
			green = green * (HEALTH / 50);
		}

		return new Color((int) red, (int) green, (int) blue);
	}

}