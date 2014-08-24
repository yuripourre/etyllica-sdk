package br.com.etyllica.sdk.component;

import br.com.etyllica.core.Drawable;
import br.com.etyllica.gui.selection.ResizerListener;
import br.com.etyllica.layer.GeometricLayer;

public interface Container extends Drawable, ResizerListener {

	public GeometricLayer getBounds();
	
	public boolean colide(int mouseX, int mouseY);

}
