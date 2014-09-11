package br.com.etyllica.sdk.component;

import java.awt.Color;

import br.com.etyllica.collision.CollisionDetector;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.core.graphics.SVGColor;
import br.com.etyllica.layer.GeometricLayer;

public class RectangleContainer implements Container {

	private Color color = SVGColor.TRANSPARENT;
	
	private Color borderColor = Color.BLACK;
	
	private GeometricLayer rectangle;
	
	public RectangleContainer(int w, int h) {
		super();
		
		final int defaultWidth = 200;
		final int defaultHeight = 50;
		
		rectangle = new GeometricLayer(w/2-defaultWidth/2, h/2-defaultHeight/2);
	}
	
	public RectangleContainer(int x, int y, int w, int h) {
		super();
				
		rectangle = new GeometricLayer(x, y, w, h);
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
	public void draw(Graphic g) {
		g.setColor(color);
		g.fillRect(rectangle);
		
		g.setColor(borderColor);
		g.drawRect(rectangle);
	}

	@Override
	public boolean colide(int mouseX, int mouseY) {
		return CollisionDetector.colideRectPoint(rectangle, mouseX, mouseY);
	}

	@Override
	public GeometricLayer getBounds() {
		return rectangle;
	}

	@Override
	public void onResize(int x, int y, int w, int h) {
		rectangle.setBounds(x, y, w, h);
	}

}
