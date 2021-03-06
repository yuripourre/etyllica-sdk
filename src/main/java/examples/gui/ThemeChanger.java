package examples.gui;

import java.awt.Color;

import br.com.etyllica.awt.SVGColor;
import br.com.etyllica.core.context.Application;
import br.com.etyllica.core.event.Action;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.graphics.Graphics;
import br.com.etyllica.gui.Button;
import br.com.etyllica.gui.CheckBox;
import br.com.etyllica.gui.TextField;
import br.com.etyllica.gui.label.TextLabel;
import br.com.etyllica.gui.theme.ThemeManager;
import br.com.etyllica.theme.etyllic.EtyllicTheme;
import br.com.etyllica.theme.mono.EtyllicMonoTheme;

public class ThemeChanger extends Application {

	public ThemeChanger(int w, int h) {
		super(w,h);
	}
	
	/**
	 * Background Color
	 */
	private Color color = Color.WHITE;
	
	@Override
	public void load() {
		
		final int offsetY = 20;
		final int buttonW = 170;
		
		Button buttonWhite = new Button(20,offsetY+30,buttonW,40);
		buttonWhite.setLabel(new TextLabel("WHITE!"));
		buttonWhite.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "turnWhite"));
		addView(buttonWhite);		
		
		Button buttonBlue = new Button(20,offsetY+80,buttonW,40);
		buttonBlue.setLabel(new TextLabel("BLUE!"));
		buttonBlue.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "turnBlue"));
		addView(buttonBlue);
		
		Button buttonSeaGreen = new Button(20,offsetY+130,buttonW,40);
		buttonSeaGreen.setLabel(new TextLabel("SEA GREEN!"));
		buttonSeaGreen.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "turnSeaGreen"));
		addView(buttonSeaGreen);
		
		Button buttonOrchid = new Button(20,offsetY+180,buttonW,40);
		buttonOrchid.setLabel(new TextLabel("ORCHID!"));
		buttonOrchid.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "turnOrchid"));
		addView(buttonOrchid);
		
		Button buttonOrange = new Button(20,offsetY+230,buttonW,40);
		buttonOrange.setLabel(new TextLabel("ORANGE!"));
		buttonOrange.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "turnOrange"));
		addView(buttonOrange);
		
		Button buttonCrimson = new Button(20,offsetY+280,buttonW,40);
		buttonCrimson.setLabel(new TextLabel("CRIMSON!"));
		buttonCrimson.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "turnCrimson"));
		addView(buttonCrimson);
		
		Button defaultTheme = new Button(420,offsetY+30,120,40);
		defaultTheme.setLabel(new TextLabel("Default Theme"));
		defaultTheme.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "changeToDefaultTheme"));
		addView(defaultTheme);
		
		Button monoTheme = new Button(420,offsetY+90,120,40);
		monoTheme.setLabel(new TextLabel("Mono Theme"));
		monoTheme.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "changeToMonoTheme"));
		addView(monoTheme);
		
		CheckBox checkBox = new CheckBox(20,offsetY+330,40,40);
		checkBox.setChecker(new TextLabel("X"));
		addView(checkBox);
		
		TextField textField = new TextField(70,offsetY+330,120,40);		
		addView(textField);
		
		loading = 100;
	}
	
	public void changeToDefaultTheme() {
		
		ThemeManager.getInstance().setTheme(new EtyllicTheme());
		
	}
	
	public void changeToMonoTheme() {
		
		ThemeManager.getInstance().setTheme(new EtyllicMonoTheme());
		
	}
	
	public void turnWhite() {
		color = Color.WHITE;
	}
	
	public void turnBlue() {
		color = Color.BLUE;
	}
	
	public void turnSeaGreen() {
		color = SVGColor.LIGHT_SEA_GREEN;
	}
	
	public void turnOrchid() {
		color = SVGColor.ORCHID;
	}
	
	public void turnOrange() {
		color = SVGColor.ORANGE;
	}
	
	public void turnCrimson() {
		color = SVGColor.CRIMSON;
	}

	@Override
	public void draw(Graphics g) {
		
		g.setColor(color);
		g.fillRect(x, y, w, h);
		
	}

	@Override
	public void updateKeyboard(KeyEvent event) {
		
		if(event.isKeyDown(KeyEvent.VK_0)) {
			changeToDefaultTheme();
		}
		
		if(event.isKeyDown(KeyEvent.VK_1)) {
			changeToMonoTheme();
		}
	}

}
