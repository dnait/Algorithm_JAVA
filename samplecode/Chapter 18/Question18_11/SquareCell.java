package Question18_11;

public class SquareCell {
	public int zerosRight = 0;
	public int zerosBelow = 0;
	public SquareCell(int right, int below) {
		zerosRight = right;
		zerosBelow = below;
	}
	
	public void setZerosRight(int right) {
		zerosRight = right;
	}
	
	public void setZerosBelow(int below) {
		zerosBelow = below;
	}
}
