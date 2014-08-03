package br.com.etyllica.sdk.selection;

import java.awt.BasicStroke;
import java.awt.Color;

import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.core.input.mouse.MouseButton;
import br.com.etyllica.core.input.mouse.MouseState;
import br.com.etyllica.core.input.mouse.MouseStateChanger;
import br.com.etyllica.gui.stroke.DashedStroke;
import br.com.etyllica.layer.GeometricLayer;

public class Resizer {

	private GeometricLayer selected;
	
	private ResizerPoint selectedArea;
		
	private ResizerPoint[] points;
	
	private MouseStateChanger changer;
	
	private int buttonSize = 20;
	
	private final DashedStroke dash = new DashedStroke();
	
	private final BasicStroke resetStroke = new BasicStroke(1);
	
	public Resizer(MouseStateChanger context) {
		super();
		
		changer = context;
		
		points = new ResizerPoint[8];
		for(int i=0;i<8; i++)
			points[i] = new ResizerPoint(0, 0, 1, 1);
		
		selectedArea = new ResizerPoint(0, 0, 1, 1);
		selectedArea.setState(MouseState.MOVE);
	}
	
	public void reselect() {
		select(selected);
	}
	
	public void select(GeometricLayer selected) {
		
		this.selected = selected;
		
		selectedArea.copy(selected);
		
		int inc = 0;
		
		for(int b=0; b<9; b++) {
			
			int i = b%3;
			int j = b/3;

			if(i==1 && j==1) {
				inc = -1;
				continue;
			}
			
			int bx = selected.getX()+i*(selected.getW()/2) - buttonSize/2;
			int by = selected.getY()+j*(selected.getH()/2) - buttonSize/2;

			points[b+inc].setBounds(bx, by, buttonSize, buttonSize);
						
		}
		
		points[0].setState(MouseState.ARROW_NW_SE);
		points[1].setState(MouseState.ARROW_VERTICAL);
		points[2].setState(MouseState.ARROW_NE_SW);
		points[3].setState(MouseState.ARROW_HORIZONTAL);
		points[4].setState(MouseState.ARROW_HORIZONTAL);
		points[5].setState(MouseState.ARROW_NE_SW);
		points[6].setState(MouseState.ARROW_VERTICAL);
		points[7].setState(MouseState.ARROW_NW_SE);		
		
	}
	
	public void draw(Graphic g) {

		if(selected == null)
			return;
		
		g.setColor(Color.BLACK);

		g.setStroke(dash);

		g.drawRect(selected);

		for(ResizerPoint point: points) {

			g.fillRect(point);
		}
		
		g.setStroke(resetStroke);
	}

	public void handleEvent(PointerEvent event) {
		
		if(selected == null)
			return;
		
		int mx = event.getX();
		int my = event.getY();

		boolean changed = false;

		if(selected.colideRectPoint(mx, my)) {
			
			changer.changeMouseState(MouseState.MOVE);
			
			moveSelected(event);
			
		} else {

			for(int b=0; b < 8; b++) {

				if(points[b].colideRectPoint(mx, my)) {
					changer.changeMouseState(points[b].getState());
					changed = true;
				}
						
			}
		}
		
		if(!changed) {
			changer.changeMouseState(MouseState.NORMAL);
		}
		
	}
	
	private boolean dragged = false;
	
	private int initialX = 0;
	private int initialY = 0;
	
	private void moveSelected(PointerEvent event) {
		
		if(event.isDraggedButton(MouseButton.MOUSE_BUTTON_LEFT)) {
			
			if(!dragged) {
				initialX = selected.getX();
				initialY = selected.getY();
						
				dragged = true;
			}
			
			selected.setX(initialX+event.getAmountX());
			selected.setY(initialY+event.getAmountY());
			
			reselect();
		}
		
		if(dragged && event.isButtonUp(MouseButton.MOUSE_BUTTON_LEFT)) {

			dragged = false;			
		}
		
	}
	
}
