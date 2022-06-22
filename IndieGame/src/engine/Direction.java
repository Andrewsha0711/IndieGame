package engine;

public class Direction {
	public boolean left = false;
	public boolean right = false;
	public boolean up = false;
	public boolean down = false;
	
	public Direction() {
		this.left = false;
		this.right = false;
		this.down = false;
		this.up = false;
	}
	
	public void setLeft(boolean value) {
		this.left = value;
		if(value) {
			this.right = !value;
		}
	}
	public void setRight(boolean value) {
		this.right = value;
		if(value) {
			this.left = !value;
		}
	}
	public void setUp(boolean value) {
		this.up = value;
		if(value)
		this.down = !value;
	}
	public void setDown(boolean value) {
		this.down = value;
		if(value)
		this.up = !value;
	}
	
	public void setStanding() {
		this.down = false;
		this.left = false;
		this.right = false;
		this.up = false;
	}
}
