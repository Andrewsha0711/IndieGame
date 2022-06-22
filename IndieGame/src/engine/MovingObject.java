package engine;

public class MovingObject {
	private RectArea area;
	
	// Положение
	private int x;
	private int y;
	public Direction direction;
	
	//Размер модельки
	private int width;
	private int thickness;
	
	public MovingObject(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.thickness = height;
		this.direction = new Direction();
	}
	
	public void setArea(RectArea area) {
		this.area = area;
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
	
	public void checkArea() {
		if(!(this.x > this.area.leftL.x && this.x < this.area.rightL.x)) {
			this.area = this.area.getConnected(this.x, this.y);
		}
	}
	
	public void move(int distance) {
		this.checkArea();
		if(this.direction.left) {
			if(distance > 0) {
				if(this.area.isImpassable(this.x - distance, this.y, this.width))
					this.x -= distance;
			}
			if(distance < 0) {
				if(this.area.isImpassable(this.x + this.thickness + distance, this.y, this.width))
				this.x += distance;
			}
		}
		if(this.direction.right) {
			if(distance > 0) {
				if(this.area.isImpassable(this.x + this.thickness + distance, this.y, this.width))
				this.x += distance;
			}
			if(distance < 0) {
				if(this.area.isImpassable(this.x - distance, this.y, this.width))
				this.x -= distance;
			}
		}
		if(this.direction.up) {
			if(distance > 0) {
				if(this.area.isImpassable(this.x, this.y - distance, this.width))
				this.y -= distance;
			}
			if(distance < 0) {
				if(this.area.isImpassable(this.x, this.y + this.thickness + distance, this.width))
				this.y += distance;
			}
		}
		if(this.direction.down) {
			if(distance > 0) {
				if(this.area.isImpassable(this.x, this.y + this.thickness + distance, this.width))
				this.y += distance;
			}
			if(distance < 0) {
				if(this.area.isImpassable(this.x, this.y - distance, this.width))
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
