package br.com.etyllica.sdk.component;

import java.awt.Color;

import br.com.etyllica.awt.SVGColor;
import br.com.etyllica.core.graphics.Graphics;
import br.com.etyllica.layer.Layer;

public class RectangleContainer extends Layer {

	private Color color = SVGColor.TRANSPARENT;
	private Color borderColor = Color.BLACK;
		
	public RectangleContainer(int x, int y, int w, int h) {
		super(x,y,w,h);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	@Override
	public void draw(Graphics g) {
		int sw = (int)(utilWidth()*scaleX);
		int sh = (int)(utilHeight()*scaleY);
				
		int offsetX = (int)(utilWidth()*(1-scaleX))/2;
		int offsetY = (int)(utilHeight()*(1-scaleY))/2;
		
		g.setColor(color);
		g.fillRect(x+offsetX, y+offsetY, sw, sh);
		
		g.setColor(borderColor);
		g.drawRect(x+offsetX, y+offsetY, sw, sh);
	}
}
