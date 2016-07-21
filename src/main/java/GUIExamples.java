

import examples.gui.ThemeChanger;
import br.com.etyllica.Etyllica;
import br.com.etyllica.core.context.Application;
import br.com.etyllica.sdk.FileExample;
import br.com.etyllica.sdk.SDKApplication;

public class GUIExamples extends Etyllica {

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
		
		initialSetup("../");
		
		//return new ThemeChanger(w, h);
		return new SDKApplication(w, h);
		//return new FileExample(w, h);
		//return new MultiLanguageApplication(w, h);
		//return new AccessibilityApplication(w, h);
		//return new MouseStateApplication(w, h);
		
		//Themes
		//return new DarknessUI(w, h);
		//return new DarknessMedUI(w, h);
		//return new PluralityUI(w, h);
	}
	
}
