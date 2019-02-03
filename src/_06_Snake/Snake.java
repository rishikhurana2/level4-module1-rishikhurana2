package _06_Snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Snake {
	public static final Color SNAKE_COLOR = Color.BLUE;
	public static final int BODY_SIZE = 50;

	private SnakeSegment head;
	private ArrayList<SnakeSegment> snake;

	private Direction currentDirection;

	private boolean canMove = true;

	public Snake(Location location) {
		snake = new ArrayList<SnakeSegment>();
		head = new SnakeSegment(location, BODY_SIZE);
		snake.add(head);

		currentDirection = Direction.RIGHT;
	}

	public void feed() {
		//1. add a new SnakeSegment object to the snake
		snake.add(new SnakeSegment(getHeadLocation(), BODY_SIZE));
	}

	public Location getHeadLocation() {
		//2. return the location of the snake's head
		return head.getLocation();
	}

	public void update() {
		//1. use a switch statement to check on the currentDirection
		//   of the snake and calculate its next x and y position.
		
			int x = getHeadLocation().x;
			int y = getHeadLocation().y;
			//System.out.println(currentDirection);
			//System.out.println("First x: " + x);
			switch(currentDirection) {
			case LEFT:
				x = x - 1;
				break;
			case RIGHT:
				x = x + 1;
				break;
			case UP:
				y = y - 1;
				break;
			case DOWN:
				y = y + 1;
				break;
			}
			//System.out.println("Changed x: " + x);
			//System.out.println(y);
		//2. Iterate through the SnakeSegments in reverse order
			head.setLocation(new Location(x,y));
		for (int i = snake.size()-1; i > 0; i--) {
		//2a. Update each snake segment to the location of the segment 
		//    in front of it.
			snake.get(i).setLocation(snake.get(i - 1).getLocation());
		//3. set the location of the head to the new location calculated in step 1
		//4. set canMove to true
		}
		canMove = true;
	}

	public void setDirection(Direction d) {
		//1. set the current direction equal to the passed in Direction only if canMove is true.
		//   set canMove equal to false.
		//   make sure the snake cannot completely reverse directions.
		if (canMove) { 
			if ((currentDirection == Direction.RIGHT && d != Direction.LEFT) ||
			(currentDirection == Direction.UP && d != Direction.DOWN) || 
			(currentDirection == Direction.LEFT && d != Direction.RIGHT) || 
			(currentDirection == Direction.DOWN && d != Direction.UP)) {
					//System.out.println("Direction Changed");
					currentDirection = d;
					
				}
		}
		canMove = false;
	}

	public void reset(Location loc) {
		//1. clear the snake
		snake.clear();
		//2. set the location of the head
		head.setLocation(loc);
		//3. add the head to the snake
		snake.add(head);
	}

	public boolean isOutOfBounds() {
		//1. complete the method so it returns true if the head of the snake is outsize of the window
		//   and false otherwise
		boolean outOfBounds = false;	
		if (getHeadLocation().x < -1 || getHeadLocation().x > 15 || getHeadLocation().y < 0 || getHeadLocation().y > 12)  {
			outOfBounds = true;
		}
		return outOfBounds;
	}
	
	public boolean isHeadCollidingWithBody() {
		//1. complete the method so it returns true if the head is located
		//   in the same location as any other body segment
		boolean isHeadColliding = false;
		//int snakeTailIndex = snake.size() - 1;
		for (int i = snake.size() - 1; i > 0; i--) {
			if (getHeadLocation() == snake.get(i).getLocation()) {
				isHeadColliding = true;
			}
		}
		//System.out.println("(real)Head Position: " + getHeadLocation().x + ", " + getHeadLocation().y);
		//System.out.println("Head2 Poistion: " + snake.get(0).getLocation().x + ", " + snake.get(0).getLocation().y);
		//System.out.println("Tail Position: " + snake.get(snake.size() - 1).getLocation().x + ", " + snake.get(snake.size() - 1).getLocation().y);
		return isHeadColliding;
	}

	public boolean isLocationOnSnake(Location loc) {
		//1. complete the method so it returns true if the passed in
		//   location is located on the snake
		boolean isLocOnSnake = false;
		for (int i = 0; i < snake.size(); i++) {
			if (snake.get(i).getLocation() == loc) {
				isLocOnSnake = true;
			}
			else {
				isLocOnSnake = false;
			}
		}
		return isLocOnSnake;
	}

	public void draw(Graphics g) {
		for (SnakeSegment s : snake) {
			s.draw(g);
		}
	}
}
