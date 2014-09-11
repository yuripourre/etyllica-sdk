package examples.gui;

import java.util.HashMap;
import java.util.Map;

import br.com.etyllica.context.Application;
import br.com.etyllica.core.Configuration;
import br.com.etyllica.core.event.Action;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.gui.Button;
import br.com.etyllica.gui.label.MultiLangLabel;
import br.com.etyllica.gui.label.TextLabel;
import br.com.etyllica.i18n.Language;

public class MultiLanguageApplication extends Application {

	private MultiLangLabel label;
	
	public MultiLanguageApplication(int w, int h) {
		super(w, h);
	}
		
	@Override
	public void load() {

		//Enable Accessibility Features
		Configuration.getInstance().setTimerClick(true);
		
		Map<Language, String> texts = new HashMap<Language, String>();
		
		texts.put(Language.ENGLISH_USA, "Good Morning!");
		texts.put(Language.PORTUGUESE_BRAZIL, "Bom dia!");
		texts.put(Language.JAPANESE, "Ohayou!");
		texts.put(Language.FRENCH, "Bonjour!");
		
		label = new MultiLangLabel(120, 150, texts);
		add(label);
				
		Button portugueseButton = new Button(280, 100, 200, 40);
		portugueseButton.setLabel(new TextLabel("Portuguese"));
		portugueseButton.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "changeLanguage", Language.PORTUGUESE_BRAZIL));
		
		this.add(portugueseButton);
		
		Button japaneseButton = new Button(280, 150, 200, 40);
		japaneseButton.setLabel(new TextLabel("Japanese"));
		japaneseButton.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "changeLanguage", Language.JAPANESE));
		
		this.add(japaneseButton);
		
		Button englishButton = new Button(280, 200, 200, 40);
		englishButton.setLabel(new TextLabel("English"));
		englishButton.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "changeLanguage", Language.ENGLISH_USA));
		
		this.add(englishButton);
		
		Button frenchButton = new Button(280, 250, 200, 40);
		frenchButton.setLabel(new TextLabel("French"));
		frenchButton.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "changeLanguage", Language.FRENCH));
		
		this.add(frenchButton);
		
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

		if(event.isKeyDown(KeyEvent.TSK_1)) {
			changeLanguage(Language.PORTUGUESE_BRAZIL);
		}
		if(event.isKeyDown(KeyEvent.TSK_2)) {
			changeLanguage(Language.JAPANESE);
		}
		if(event.isKeyDown(KeyEvent.TSK_3)) {
			changeLanguage(Language.ENGLISH_USA);
		}
		
		return null;
	}

}