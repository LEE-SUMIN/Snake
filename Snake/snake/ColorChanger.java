package snake;

import java.awt.Color;
//replace method with method object
public abstract class ColorChanger {
	 protected Color getChangeRGB(Color fromRGB, Color toRGB) {
		int newRed = changeFromTo(fromRGB.getRed(),toRGB.getRed());
		int newGreen = changeFromTo(fromRGB.getGreen(), toRGB.getGreen());
		int newBlue = changeFromTo(fromRGB.getBlue(), toRGB.getBlue());
		return new Color(newRed, newGreen, newBlue);
	}

	protected int changeFromTo(int from, int to) {
		int result = from;
		if (from > to)
			result = from - 1;
		else if (from < to)
			result = from + 1;
		return result;
	}
	public Color getChangeColor(Color fromColor) {
		Color toColor=setToColor(fromColor);
		return getChangeRGB(fromColor,toColor);
	}
	//Template method pattern
	protected abstract Color setToColor(Color fromColor);
}
