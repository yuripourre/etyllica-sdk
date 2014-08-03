package examples.gui;

import java.awt.Color;

import br.com.etyllica.context.Application;
import br.com.etyllica.core.event.Action;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.core.graphics.SVGColor;
import br.com.etyllica.gui.Button;
import br.com.etyllica.gui.label.TextLabel;
import br.com.etyllica.theme.EtyllicTheme;
import br.com.etyllica.theme.ThemeManager;
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
		
		Button buttonWhite = new Button(20,offsetY+30,120,40);
		buttonWhite.setLabel(new TextLabel("WHITE!"));
		buttonWhite.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "turnWhite"));
		add(buttonWhite);		
		
		Button buttonBlue = new Button(20,offsetY+80,120,40);
		buttonBlue.setLabel(new TextLabel("BLUE!"));
		buttonBlue.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "turnBlue"));
		add(buttonBlue);
		
		Button buttonSeaGreen = new Button(20,offsetY+130,120,40);
		buttonSeaGreen.setLabel(new TextLabel("SEA GREEN!"));
		buttonSeaGreen.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "turnSeaGreen"));
		add(buttonSeaGreen);
		
		Button buttonOrchid = new Button(20,offsetY+180,120,40);
		buttonOrchid.setRoundness(10);
		buttonOrchid.setLabel(new TextLabel("ORCHID!"));
		buttonOrchid.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "turnOrchid"));
		add(buttonOrchid);
		
		Button buttonOrange = new Button(20,offsetY+230,120,40);
		buttonOrange.setRoundness(10);
		buttonOrange.setLabel(new TextLabel("ORANGE!"));
		buttonOrange.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "turnOrange"));
		add(buttonOrange);
		
		Button buttonCrimson = new Button(20,offsetY+280,120,40);
		buttonCrimson.setRoundness(10);
		buttonCrimson.setLabel(new TextLabel("CRIMSON!"));
		buttonCrimson.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "turnCrimson"));
		add(buttonCrimson);
		
		Button defaultTheme = new Button(420,offsetY+30,120,40);
		defaultTheme.setLabel(new TextLabel("Default Theme"));
		defaultTheme.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "changeToDefaultTheme"));
		add(defaultTheme);
		
		Button monoTheme = new Button(420,offsetY+90,120,40);
		monoTheme.setLabel(new TextLabel("Mono Theme"));
		monoTheme.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "changeToMonoTheme"));
		add(monoTheme);
		
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
	public void draw(Graphic g) {
		
		g.setColor(color);
		g.fillRect(x, y, w, h);
		
	}

	@Override
	public GUIEvent updateMouse(PointerEvent event) {
		// TODO Auto-generated method stub
		return GUIEvent.NONE;
	}

	@Override
	public GUIEvent updateKeyboard(KeyEvent event) {
		
		if(event.isKeyDown(KeyEvent.TSK_0)) {
			changeToDefaultTheme();
		}
		
		if(event.isKeyDown(KeyEvent.TSK_1)) {
			changeToMonoTheme();
		}
		
		// TODO Auto-generated method stub
		return GUIEvent	.NONE;
	}

}
