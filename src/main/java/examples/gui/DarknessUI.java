package examples.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;

import br.com.etyllica.awt.SVGColor;
import br.com.etyllica.core.context.Application;
import br.com.etyllica.core.context.UpdateIntervalListener;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.graphics.Graphics;

/**
 * Concept based on Star Trek: Into Darkness - Surveillance UI
 *  
 * http://www.rudyvessup.com/work/star-trek-into-darkness-survellience-ui/
 * 
 */

public class DarknessUI extends Application implements UpdateIntervalListener {

	private int mx = 0;
	
	private int my = 0;
	
	public DarknessUI(int w, int h) {
		super(w, h);
	}	

	private Shape centerCircle;
	
	private Arc2D rightArc;
	
	private Arc2D leftArc;

	private Shape rightLine;
	
	private Arc2D centerLeftArc;
	
	private Arc2D centerRightArc;
	
	private double markAngle = 0;
	
	private final int radius = 80;
	
	private final int circularSpacing = 5;
	
	private final double rightStart = 270+circularSpacing;

	private final double rightExtent = 180-circularSpacing*2;
	
	private final double leftArcStart = 90+circularSpacing;
	
	private final double leftExtent = 180-circularSpacing*2;
	
	public void timeUpdate(long now) {
		
		createUI(mx, my);
		
		markAngle+=2;
		
		int circularSpacing = 12;
		
		centerLeftArc.setAngleStart(90+circularSpacing+markAngle);
		
		centerRightArc.setAngleStart(270+circularSpacing+markAngle);
		
	}
	
	@Override
	public void load() {
		
		double aw = radius;//Arc Width
		double ah = radius;//Arc Height
		
		leftArc = new Arc2D.Double(mx-radius, my-radius, aw*2, ah*2, leftArcStart, leftExtent, Arc2D.OPEN);
		
		rightArc = new Arc2D.Double(mx-radius, my-radius, aw*2, ah*2, rightStart, rightExtent, Arc2D.OPEN);
		
		createUI(mx, my);
		
		updateAtFixedRate(50, this);
		
		loading = 100;
	}
	
	private void createUI(int mx, int my) {
		
		BasicStroke basicStroke = new BasicStroke(10f);
		
		double aw = radius;
		double ah = radius;
		
		double centerRadius = radius-20;

		//Center Circle
		centerCircle = new Ellipse2D.Double(mx-centerRadius, my-centerRadius, centerRadius*2, centerRadius*2);
		
		//Right Arc
		rightArc.setArc(mx-radius, my-radius, aw*2, ah*2, rightStart, rightExtent, Arc2D.OPEN);
		
		rightLine = basicStroke.createStrokedShape(rightArc);//Contour Line
		
		//Left Arc
		leftArc.setArc(mx-radius, my-radius, aw*2, ah*2, leftArcStart, leftExtent, Arc2D.OPEN);

		buildCenterPart(mx, my, radius-50);
		
	}
	
	private void buildCenterPart(int cx, int cy, int radius) {
		
		int circularSpacing = 16;
		
		double rightStart = 270+circularSpacing+markAngle;

		double rightExtent = 180-circularSpacing*2;
		
		centerRightArc = new Arc2D.Double(cx-radius, cy-radius, radius*2, radius*2, rightStart, rightExtent, Arc2D.OPEN);

		//Left Arc
		double leftArcStart = 90+circularSpacing+markAngle;
		
		double leftExtent = 180-circularSpacing*2;
		
		centerLeftArc = new Arc2D.Double(cx-radius, cy-radius, radius*2, radius*2, leftArcStart, leftExtent, Arc2D.OPEN);
		
	}

	@Override
	public void draw(Graphics g) {

		g.setColor(new Color(0x17, 0x17, 0x17));
		
		g.fillRect(0, 0, w, h);
		
		g.setAlpha(80);
		
		g.setColor(SVGColor.GHOST_WHITE);

		g.setLineWidth(10f);
		g.draw(leftArc);
		
		g.setLineWidth(1f);
		g.draw(rightLine);
		
		g.setLineWidth(2f);
		g.draw(centerCircle);
		
		g.setLineWidth(8f);		

		g.draw(centerLeftArc);
		
		g.draw(centerRightArc);
				
	}

	@Override
	public void updateMouse(PointerEvent event) {
		
		mx = event.getX();
		my = event.getY();
		
	}

}
