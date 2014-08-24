package br.com.etyllica.sdk;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import br.com.etyllica.context.Application;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.core.input.mouse.MouseButton;
import br.com.etyllica.gui.selection.Resizer;
import br.com.etyllica.layer.GeometricLayer;
import br.com.etyllica.layer.Layer;
import br.com.etyllica.sdk.component.Container;
import br.com.etyllica.sdk.component.RectangleContainer;

public class SDKApplication extends Application {

	private Resizer resizer;

	private RectangleContainer blueComponent;

	private RectangleContainer redComponent;

	private RectangleContainer yellowComponent;
	
	private List<RectangleContainer> components;
	
	private Layer overlay = new Layer();
	
	private GeometricLayer selection = new GeometricLayer();

	public SDKApplication(int w, int h) {
		super(w, h);
	}

	@Override
	public void load() {

		resizer = new Resizer(this);

		components = new ArrayList<RectangleContainer>();
				
		blueComponent = new RectangleContainer(40, 100, 200, 80);
		blueComponent.setBorderColor(Color.BLUE);
		components.add(blueComponent);

		redComponent = new RectangleContainer(40, 200, 200, 80);
		redComponent.setBorderColor(Color.RED);
		components.add(redComponent);

		yellowComponent = new RectangleContainer(300, 100, 200, 80);
		yellowComponent.setColor(Color.YELLOW);
		yellowComponent.setBorderColor(Color.BLACK);
		components.add(yellowComponent);
	}

	@Override
	public void draw(Graphic g) {

		for(Container component: components) {
			component.draw(g);
		}

		drawOverlay(g);

		resizer.draw(g);
	}

	private void drawOverlay(Graphic g) {

		if(overlay.isVisible() == false)
			return;

		g.setColor(Color.BLACK);
		g.setAlpha(60);
		g.fillRect(overlay);
		g.resetOpacity();
	}

	@Override
	public GUIEvent updateMouse(PointerEvent event) {

		int mx = event.getX();
		int my = event.getY();

		if(!resizer.isSelected()) {
			
			for(Container component: components) {
				if(component.colide(mx, my)) {
					overlay.setVisible(true);
					overlay.copy(component.getBounds());
					break;
				}
			}			
		}
		
		if(event.isButtonDown(MouseButton.MOUSE_BUTTON_LEFT)) {

			if(!resizer.isSelected()) {

				for(Container component: components) {
					if(component.colide(mx, my)) {
						
						selection.copy(component.getBounds());
						
						resizer.select(selection);
						resizer.setListener(component);
						
						overlay.setVisible(false);
						
						break;
					}
				}
				
			} else if(!resizer.isDragged()) {

				resizer.deselect();
			}

		}

		resizer.handleEvent(event);

		return GUIEvent.NONE;
	}

	@Override
	public GUIEvent updateKeyboard(KeyEvent event) {
		
		resizer.handleKeyEvent(event);
		
		return GUIEvent.NONE;
	}

}
