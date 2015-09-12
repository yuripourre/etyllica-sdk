package examples.gui;

import br.com.etyllica.core.Configuration;
import br.com.etyllica.core.context.Application;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.gui.Button;

public class AccessibilityApplication extends Application {

	private Button button;
	
	public AccessibilityApplication(int w, int h) {
		super(w, h);
	}
		
	@Override
	public void load() {

		//Enable Accessibility Features
		Configuration.getInstance().setTimerClick(true);
		
		button = new Button(80, 80, 200, 40);
		
		this.add(button);
		
		loading = 100;
	}

	@Override
	public void draw(Graphic g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GUIEvent updateMouse(PointerEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GUIEvent updateKeyboard(KeyEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

}
