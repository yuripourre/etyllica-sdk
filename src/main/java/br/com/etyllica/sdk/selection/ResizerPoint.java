package br.com.etyllica.sdk.selection;

import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.core.input.mouse.MouseState;
import br.com.etyllica.layer.GeometricLayer;

public class ResizerPoint extends GeometricLayer {

	private MouseState state;
	
	public ResizerPoint(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	//Draw with half size
	public void draw(Graphic g) {
		g.fillRect(x+w/2, y+h/2, w-w/2, h-h/2);
	}

	public MouseState getState() {
		return state;
	}

	public void setState(MouseState state) {
		this.state = state;
	}	
	
}
