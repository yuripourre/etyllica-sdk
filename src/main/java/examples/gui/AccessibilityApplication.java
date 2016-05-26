package examples.gui;

import br.com.etyllica.core.Configuration;
import br.com.etyllica.core.context.Application;
import br.com.etyllica.core.graphics.Graphics;
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
		
		addView(button);
		
		loading = 100;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
