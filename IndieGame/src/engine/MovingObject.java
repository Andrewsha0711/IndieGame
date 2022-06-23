package engine;

public class MovingObject {
	private RectArea area;
	
	// Положение
	private int x;
	private int y;
	public Direction direction;
	private boolean isWalking;
	
	//Размер модельки
	public int width = 0;
	public int thickness = 0;
	
	public MovingObject(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.direction = new Direction();
	}
	
	
	public void setArea(RectArea area) {
		this.area = area;
	}
	
	public RectArea getArea() {
		return this.area;
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
	
	public void checkArea(int width, int height) {
		if(!(this.x > this.area.leftL.x && this.x + width < this.area.rightL.x) ||
				!(this.y > this.area.leftU.y && this.y + height < this.area.rightL.y)) {
			this.area = this.area.getConnected(this.x, this.y, width, height);
		}
	}
	
	public boolean move(int distance) {
		if(this.direction.left) {
			if(distance > 0) {
				if(this.area.isImpassable(this.x - distance, this.y, this.thickness, this.width)) {
					this.x -= distance;
					this.checkArea(this.thickness, this.width);
				}
			}
		}
		if(this.direction.right) {
			if(distance > 0) {
				if(this.area.isImpassable(this.x + distance, this.y, this.thickness, this.width)) {
					this.x += distance;	
					this.checkArea(this.thickness, this.width);
				}
			}
		}
		if(this.direction.up) {
			if(distance > 0) {
				if(this.area.isImpassable(this.x, this.y - distance, this.width, this.thickness)) {
					this.y -= distance;
					this.checkArea(this.width, this.thickness);
				}
			}
		}
		if(this.direction.down) {
			if(distance > 0) {
				if(this.area.isImpassable(this.x, this.y + distance, this.width, this.thickness)) {
					this.y += distance;
					this.checkArea(this.width, this.thickness);
				}
			}
		}
		
		return this.isWalking;
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
