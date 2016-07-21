package br.com.etyllica.theme.mono;

import java.awt.Color;

import br.com.etyllica.gui.base.BaseButton;
import br.com.etyllica.theme.etyllic.EtyllicTheme;

public class EtyllicMonoTheme extends EtyllicTheme {
	
	public EtyllicMonoTheme(){
		super();
		
		this.borderColor = Color.BLACK;
		this.baseColor = Color.WHITE;
		this.selectionColor = Color.GRAY;
	}
	
	@Override
	public BaseButton createButton(int x, int y, int w, int h){
		BaseButton button = new BorderButton(x, y, w, h);
		return button;
	}
	
}
