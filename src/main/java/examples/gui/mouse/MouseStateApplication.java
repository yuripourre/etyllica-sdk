package examples.gui.mouse;

import br.com.etyllica.core.context.Application;
import br.com.etyllica.core.event.MouseButton;
import br.com.etyllica.core.event.MouseState;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.graphics.Graphics;

public class MouseStateApplication extends Application {
		
	public MouseStateApplication(int w, int h) {
		super(w, h);
	}
	
	@Override
	public void load() {
			
	}
	
	@Override
	public void draw(Graphics g) {

	}

	@Override
	public void updateMouse(PointerEvent event) {
		
		if(event.isButtonDown(MouseButton.MOUSE_BUTTON_RIGHT)) {
			
			changeMouseState(MouseState.WAIT);
			
		}else if(event.isButtonUp(MouseButton.MOUSE_BUTTON_RIGHT)) {
			
			changeMouseState(MouseState.NORMAL);
		}
		
		if(event.isButtonDown(MouseButton.MOUSE_BUTTON_MIDDLE)) {
			
			changeMouseState(MouseState.TEXT);
			
		}else if(event.isButtonUp(MouseButton.MOUSE_BUTTON_MIDDLE)) {
			
			changeMouseState(MouseState.NORMAL);
		}
	}
	
}
