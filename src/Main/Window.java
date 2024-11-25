package Main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.io.Serial;

import javax.swing.JFrame;

public class Window extends Canvas{

	@Serial
	private static final long serialVersionUID = 7883803474888262873L;
	
	public Window(int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title);
		
		Dimension dim = new Dimension(width, height);
		
		frame.setPreferredSize(dim);
		frame.setMaximumSize(dim);
		frame.setMinimumSize(dim);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();
		
	}

}
