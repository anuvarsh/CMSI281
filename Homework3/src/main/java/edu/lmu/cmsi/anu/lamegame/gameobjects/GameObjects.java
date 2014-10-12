


public abstract class GameObjects {
	private Coordinate coords;
	private char label;

	public GameEntityPrototype(int x, int y, char l) {
		this.coords = new Coordinate(x,y);
		this.label = l;
	}

	public char getLabel() {
		return this.label;
	}

	public Coordinate getCoordintes() {
		return this.coords;
	}
}