package Main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Main.GameObjects.GameObject;

public class KeyInput extends KeyAdapter {

	private GameObject player1;
	
	public KeyInput(GameObject player1) {
		this.player1 = player1;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		moveGameObject(this.player1, key, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D);

	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		moveGameObject(this.player1, key, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D);
	}

	private static void moveGameObject(GameObject go, int key, int up, int down, int left, int right) {
		if (key == up) {
			go.setyPos(go.getyPos() - go.getVelocity());
		} else if (key == down) {
			go.setyPos(go.getyPos() + go.getVelocity());
		} else if (key == left) {
			go.setxPos(go.getxPos() - go.getVelocity());
		} else if (key == right) {
			go.setxPos(go.getxPos() + go.getVelocity());
		}else if(key == KeyEvent.VK_ESCAPE) {
			System.exit(1);
		}
	}

}
