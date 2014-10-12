public interface Moveable {
	public void setDisplacement(int dx, int dy);
	public void invertDisplacement();
	public void updateCoordinates();
	public void updateHitPoints(int hp);
	public int getHitPoints();
}