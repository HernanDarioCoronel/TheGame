package Main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Main.GameObjects.GameObject;

public class KeyInput extends KeyAdapter {

	private GameObject player1;
	private boolean[] keydown;

	public KeyInput(GameObject player1) {
		this.player1 = player1;
		keydown = new boolean[4];
		keydown[0] = false;
		keydown[1] = false;
		keydown[2] = false;
		keydown[3] = false;
	}
	
	public void keyTyped(KeyEvent e) {keyPressed(e);}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		float velocity = this.player1.getVelocity();
		System.out.println(key);
		if (key == KeyEvent.VK_W) {
			this.player1.addYVelocity(-velocity);
			this.keydown[0] = true;
		}
		if (key == KeyEvent.VK_S) {
			this.player1.addYVelocity(velocity);
			this.keydown[1] = true;
		}
		if (key == KeyEvent.VK_A) {
			this.player1.addXVelocity(-velocity);
			this.keydown[2] = true;
		}
		if (key == KeyEvent.VK_D) {
			this.player1.addXVelocity(velocity);
			this.keydown[3] = true;
		}

	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_W) {
			this.keydown[0] = false;
		}
		if (key == KeyEvent.VK_S) {
			this.keydown[1] = false;
		}
		if (key == KeyEvent.VK_A) {
			this.keydown[2] = false;
		}
		if (key == KeyEvent.VK_D) {
			this.keydown[3] = false;
		}

		if (!this.keydown[0] && !this.keydown[1]) {
			this.player1.setVelY(0);
		}
		if (!this.keydown[2] && !this.keydown[3]) {
			this.player1.setVelX(0);
		}
	}

}
