package engine;

public class MovingObject {
	// Положение
	private int x;
	private int y;
	public Direction direction;
	
	public MovingObject(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.direction = new Direction();
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public void move(int x, int y) {
		this.x += x;
		this.y += y;
	}
	
	public void setDirection(Direction direction) {
		this.direction.setLeft(direction.left);
		this.direction.setRight(direction.right);
		this.direction.setUp(direction.up);
		this.direction.setDown(direction.down);
	}
	
	public Direction getDirection() {
		return this.direction;
	}
	
	public void move(int distance) {
		if(this.direction.left) {
			if(distance > 0) {
				this.x -= distance;
			}
			if(distance < 0) {
				this.x += distance;
			}
		}
		if(this.direction.right) {
			if(distance > 0) {
				this.x += distance;
			}
			if(distance < 0) {
				this.x -= distance;
			}
		}
		if(this.direction.up) {
			if(distance > 0) {
				this.y -= distance;
			}
			if(distance < 0) {
				this.y += distance;
			}
		}
		if(this.direction.down) {
			if(distance > 0) {
				this.y += distance;
			}
			if(distance < 0) {
				this.y -= distance;
			}
		}
	}
	
	
	
	
	
//	//TODO: дополнить для диагоналей?
//	public void move(int distance, Direction direction) {
//		if(direction == Direction.LEFT) {
//			this.left = true;
//			this.right = false;
//			if(distance > 0) {
//				this.x -= distance;
//			}
//			if(distance < 0) {
//				this.x += distance;
//			}
//		}
//		if(direction == Direction.RIGHT) {
//			if(distance > 0) {
//				this.x += distance;
//			}
//			if(distance < 0) {
//				this.x -= distance;
//			}
//		}
//		if(direction == Direction.UP) {
//			if(distance > 0) {
//				this.y -= distance;
//			}
//			if(distance < 0) {
//				this.y += distance;
//			}
//		}
//		if(direction == Direction.DOWN) {
//			if(distance > 0) {
//				this.y += distance;
//			}
//			if(distance < 0) {
//				this.y -= distance;
//			}
//		}
//	}
}
