package examples.gui.resizer;

import java.awt.Color;

import br.com.etyllica.context.Application;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.core.input.mouse.MouseButton;
import br.com.etyllica.layer.GeometricLayer;
import br.com.etyllica.sdk.selection.Resizer;

public class ResizerApplication extends Application {

	private Resizer resizer;

	private GeometricLayer overlay = null;

	private GeometricLayer blueComponent;

	private GeometricLayer redComponent;
	
	private GeometricLayer yellowComponent;
	
	public ResizerApplication(int w, int h) {
		super(w, h);
	}

	@Override
	public void load() {

		resizer = new Resizer(this);

		blueComponent = new GeometricLayer(40, 100, 200, 80);

		redComponent = new GeometricLayer(40, 200, 200, 80);
		
		yellowComponent = new GeometricLayer(300, 100, 200, 80);
	}

	@Override
	public void draw(Graphic g) {

		g.setColor(Color.BLUE);
		g.drawRect(blueComponent);

		g.setColor(Color.RED);
		g.drawRect(redComponent);
		
		g.setColor(Color.YELLOW);
		g.fillRect(yellowComponent);
		g.setColor(Color.BLACK);
		g.drawRect(yellowComponent);

		drawOverlay(g);
		
		resizer.draw(g);
		
	}

	private void drawOverlay(Graphic g) {

		if(overlay == null)
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

		if(blueComponent.colideRectPoint(mx, my)) {
			overlay = blueComponent;
		} else if(redComponent.colideRectPoint(mx, my)) {
			overlay = redComponent;
		} else if(yellowComponent.colideRectPoint(mx, my)) {
			overlay = yellowComponent;
		}else {
			overlay = null;
		}
		
		if(event.isButtonDown(MouseButton.MOUSE_BUTTON_LEFT)) {

			if(blueComponent.colideRectPoint(mx, my)) {
				
				resizer.select(blueComponent);
				
			} else if(redComponent.colideRectPoint(mx, my)) {
				
				resizer.select(redComponent);
				
			}  else if(yellowComponent.colideRectPoint(mx, my)) {
				
				resizer.select(yellowComponent);
				
			} else if(!resizer.isDragged()) {
				
				resizer.deselect();
			}
		}
		
		resizer.handleEvent(event);

		return null;
	}

	@Override
	public GUIEvent updateKeyboard(KeyEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

}
