package examples.gui.mouse;

import br.com.etyllica.context.Application;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.core.input.mouse.MouseButton;
import br.com.etyllica.core.input.mouse.MouseState;

public class MouseStateApplication extends Application {
		
	public MouseStateApplication(int w, int h) {
		super(w, h);
	}
	
	@Override
	public void load() {
			
	}
	
	@Override
	public void draw(Graphic g) {

	}

	@Override
	public GUIEvent updateMouse(PointerEvent event) {
		
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
		
		
		return null;
	}

	@Override
	public GUIEvent updateKeyboard(KeyEvent event) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
