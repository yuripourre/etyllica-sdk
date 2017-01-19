package br.com.etyllica.theme.mono;

import br.com.etyllica.core.graphics.Graphics;
import br.com.etyllica.gui.base.BaseButton;
import br.com.etyllica.gui.theme.Theme;

public class BorderButton extends BaseButton {

	public BorderButton(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	@Override
	public void draw(Graphics g){
		
		Theme theme = getTheme();		

		if(!disabled) {

			if(!mouseOver) {

				g.setColor(theme.getBaseColor());

			} else {

				if(clicked) {
					g.setColor(theme.getActiveSelectionColor());
				} else {
					g.setColor(theme.getSelectionColor());
				}

			}

		} else {
			g.setColor(theme.getButtonDisabledColor());
		}

		g.fillRect(x,y,w,h);
		
		g.setColor(theme.getBorderColor());
		
		g.drawRect(x,y,w,h);
		
		drawLabel(g);
	}

}
