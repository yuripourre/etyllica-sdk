package br.com.etyllica.sdk;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import br.com.etyllica.awt.components.chooser.FileChooser;
import br.com.etyllica.awt.components.chooser.SelectFileListener;
import br.com.etyllica.core.context.Application;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.MouseButton;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.graphics.Graphics;
import br.com.etyllica.gui.selection.Resizer;
import br.com.etyllica.layer.ImageLayer;
import br.com.etyllica.layer.Layer;
import br.com.etyllica.layer.StaticLayer;
import br.com.etyllica.loader.image.ImageLoader;
import br.com.etyllica.sdk.component.RectangleContainer;
import br.com.etyllica.util.PathHelper;

public class FileExample extends Application implements SelectFileListener {

	private Resizer resizer;
	
	private FileChooser fc;

	private RectangleContainer blueComponent;
	private RectangleContainer redComponent;
	private RectangleContainer yellowComponent;
		
	private List<Layer> layers;
	
	private int px, py;

	public FileExample(int w, int h) {
		super(w, h);
	}

	@Override
	public void load() {

		resizer = new Resizer(this);

		layers = new ArrayList<Layer>();
		
		ImageLayer hello = new ImageLayer(200,100,"hello.png");
		layers.add(hello);
		
		blueComponent = new RectangleContainer(40, 100, 200, 80);
		blueComponent.setBorderColor(Color.BLUE);
		layers.add(blueComponent);

		redComponent = new RectangleContainer(40, 200, 200, 80);
		redComponent.setBorderColor(Color.RED);
		layers.add(redComponent);

		yellowComponent = new RectangleContainer(300, 100, 200, 80);
		yellowComponent.setColor(Color.YELLOW);
		yellowComponent.setBorderColor(Color.BLACK);
		layers.add(yellowComponent);

		fc = new FileChooser(this.parent.getComponent(), PathHelper.currentDirectory());
		fc.setListener(this);
		
		resizer.setLayers(layers);
	}

	@Override
	public void draw(Graphics g) {

		for(Layer component: layers) {
			component.draw(g);
		}

		resizer.draw(g);
	}

	@Override
	public void updateMouse(PointerEvent event) {
	
		if(event.isButtonDown(MouseButton.MOUSE_BUTTON_RIGHT)) {
			px = event.getX();
			py = event.getY();
			fc.openDialog();
		}
		
		resizer.handleEvent(event);
	}
	
	@Override
	public void updateKeyboard(KeyEvent event) {
		resizer.handleKeyEvent(event);
	}
	
	@Override
	public void onSelectFile(String path) {
		System.out.println("Selected: "+path);
		
		StaticLayer image = ImageLoader.getInstance().loadImage(path, true);
		System.out.println(image.getPath());
		
		ImageLayer layer = new ImageLayer(px, py);
		layer.cloneLayer(image);
		
		layers.add(layer);
	}

	@Override
	public void onCancel() {
		// TODO Auto-generated method stub
		
	}

}
