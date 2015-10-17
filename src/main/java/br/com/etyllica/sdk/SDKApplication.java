package br.com.etyllica.sdk;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import br.com.etyllica.core.context.Application;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.gui.selection.Resizer;
import br.com.etyllica.layer.Layer;
import br.com.etyllica.sdk.component.RectangleContainer;

public class SDKApplication extends Application {

	private Resizer resizer;

	private RectangleContainer blueComponent;
	private RectangleContainer redComponent;
	private RectangleContainer yellowComponent;
	
	private List<Layer> layers;

	public SDKApplication(int w, int h) {
		super(w, h);
	}

	@Override
	public void load() {

		resizer = new Resizer(this);

		layers = new ArrayList<Layer>();
				
		blueComponent = new RectangleContainer(40, 100, 200, 80);
		blueComponent.setBorderColor(Color.BLUE);
		layers.add(blueComponent);

		redComponent = new RectangleContainer(40, 200, 200, 80);
		redComponent.setBorderColor(Color.RED);
		layers.add(redComponent);

		yellowComponent = new RectangleContainer(300, 100, 200, 80);
		yellowComponent.setColor(Color.YELLOW);
		yellowComponent.setBorderColor(Color.BLACK);
		layers.add(yellowComponent);
		
		resizer.setLayers(layers);
	}

	@Override
	public void draw(Graphic g) {

		for(Layer component: layers) {
			component.draw(g);
		}

		resizer.draw(g);
	}

	@Override
	public void updateMouse(PointerEvent event) {
		resizer.handleEvent(event);
	}

	@Override
	public void updateKeyboard(KeyEvent event) {
		resizer.handleKeyEvent(event);
	}

}
