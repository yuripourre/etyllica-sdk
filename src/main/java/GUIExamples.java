

import br.com.etyllica.EtyllicaFrame;
import br.com.etyllica.context.Application;
import examples.gui.AccessibilityApplication;
import examples.gui.DarknessMedUI;
import examples.gui.DarknessUI;
import examples.gui.ThemeChanger;
import examples.gui.mouse.MouseStateApplication;
import examples.gui.resizer.ResizerApplication;

public class GUIExamples extends EtyllicaFrame {

	public GUIExamples(int w, int h) {
		super(w, h);
		// TODO Auto-generated constructor stub
	}
	
	public GUIExamples() {
		super(800,600);
	}

	public static void main(String[] args) {
		
		GUIExamples gui = new GUIExamples();
		
		gui.init();
		
	}

	@Override
	public Application startApplication() {
		
		//return new ThemeChanger(w, h);
		//return new ResizerApplication(w, h);
		return new AccessibilityApplication(w, h);
		//return new MouseStateApplication(w, h);
		
		//Themes
		//return new DarknessUI(w, h);
		//return new DarknessMedUI(w, h);
		//return new PluralityUI(w, h);
	}
	
}
