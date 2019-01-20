package _06_Snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

// Go through the methods and complete the steps in this class
// and the Snake class

public class _00_SnakeGame implements ActionListener, KeyListener {
	public static final Color BORDER_COLOR = Color.WHITE;
	public static final Color BACKGROUND_COLOR = Color.BLACK;
	public static final Color FOOD_COLOR = Color.RED;
	public static final int WIDTH = 15;
	public static final int HEIGHT = 12;
	public static final int WINDOW_SCALE = 50;
	public static final int WINDOW_WIDTH = WINDOW_SCALE * WIDTH;
	public static final int WINDOW_HEIGHT = WINDOW_SCALE * HEIGHT;

	private JFrame window;
	private JPanel panel;

	private Snake snake;

	private Timer timer;

	private Location foodLocation;

	public _00_SnakeGame() {
		snake = new Snake(new Location(WIDTH / 2, HEIGHT / 2));

		window = new JFrame("Snake");
		panel = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;

				g2.setColor(BACKGROUND_COLOR);
				g2.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

				g2.setColor(FOOD_COLOR);
				g2.drawOval(foodLocation.x * WINDOW_SCALE, foodLocation.y * WINDOW_SCALE, Snake.BODY_SIZE,
						Snake.BODY_SIZE);
				snake.draw(g);
			}
		};

		panel.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		window.add(panel);

		timer = new Timer(0, this);

		window.pack();
		window.addKeyListener(this);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);

		setFoodLocation();

		startGame();
	}

	public void startGame() {
		//1. Save the instructions for the game in the following string variable.
		String instructions = "1. Eat the food to grow \n 2. Don't run into a wall or your own tail, or you die";
		
		String[] options = new String[] { "Expert", "Moderate", "Beginner" };
		int input = JOptionPane.showOptionDialog(null, instructions, "Snake", 0, -1, null, options, 0);

		String choice = options[input];
		
		//2. Use a switch statement to determine which difficulty was chosen.
		//   Use timer.setDelay(delay) with different numbers to change the speed
		//   of the game. The smaller the number, the faster it goes.
		switch(choice) {
		case "Expert": {
			timer.setDelay(50);
		}
		case "Moderate": {
			timer.setDelay(100);
		}
		case "Beginner": {
			timer.setDelay(200);
		}
		}
		//3. start the timer
		timer.start();
	}

	public static void main(String[] args) {
		new _00_SnakeGame();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//1. Use a switch statement on e.getKeyCode()
		//   to determine which key was pressed.
		switch(e.getKeyCode()) {
		// if an arrow key is pressed, set the snake's 
		// direction accordingly
		case KeyEvent.VK_UP: {
			snake.setDirection(Direction.UP);
			break;
		}
		case KeyEvent.VK_DOWN: {
			snake.setDirection(Direction.DOWN);
			break;
		}
		case KeyEvent.VK_LEFT: {
			snake.setDirection(Direction.LEFT);
			break;
		}
		case KeyEvent.VK_RIGHT: {
			snake.setDirection(Direction.RIGHT);
			break;
		}
		// if the space key is pressed, call the snake's feed method
		case KeyEvent.VK_SPACE: {
			snake.feed();
			break;
		}
		}
	}

	private void setFoodLocation() {
		//1. Create a new Location object that is set to a random location
			Random r1 = new Random();
			Random r2 = new Random();
			int x = r1.nextInt(WINDOW_WIDTH);
			int y = r2.nextInt(WINDOW_HEIGHT);
			Location l = new Location(x,y);
		//2. set the foodLocation variable equal to the Location object you just created.
		//   use the snake's isLocationOnSnake method to make sure you don't put the food on the snake
		if (!snake.isLocationOnSnake(l)) {
			foodLocation = l;
		}
	}

	private void gameOver() {
		
		//1. stop the timer
		timer.stop();
		//2. tell the user their snake is dead
		int UserChoice = JOptionPane.showConfirmDialog(null,"Your Snake is Dead. Do you want to play again?", "Game Over", 0);
		//Yes = 0
		//No = 1
		//3. ask them if they want to play again.
		//4. if they want to play again
		//   reset the snake and the food and start the timer
		//   else, exit the game
		if (UserChoice == 0) {
			timer.start();
			snake.reset(new Location(WINDOW_WIDTH/2, WINDOW_HEIGHT/2));
			setFoodLocation();
		} else if (UserChoice == 1) {
			window.setDefaultCloseOperation(window.getDefaultCloseOperation());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//1. update the snake
		snake.update();
		//2. if the snake is colliding with its own body 
		//   or if the snake is out of bounds, call gameOver
		if (snake.isOutOfBounds()) {
			gameOver();
			System.out.println("Game Over");
		}
		//3. if the location of the head is equal to the location of the food,
		// 	 feed the snake and set the food location
		if (snake.getHeadLocation() == foodLocation) {
			snake.feed();
			setFoodLocation();
		}
		//4. call panel.repaint();
		panel.repaint();
	}
}
