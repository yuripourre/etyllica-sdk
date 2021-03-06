package examples.gui;

import java.awt.Color;

import br.com.etyllica.core.context.Application;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.graphics.Graphics;
import br.com.etyllica.theme.plurality.LeftPanel;
import br.com.etyllica.theme.plurality.RightPanel;
import br.com.etyllica.theme.plurality.Selection;
import br.com.etyllica.theme.plurality.TitleArrow;

/**
 * Concept based on Plurality (Movie)
 *  
 * http://www.jamiemartindesign.co.uk/#plurality
 * 
 */

public class PluralityUI extends Application {

	private final static String THEME_NAME = "PLURALITY";
	
	private final static String AUTHOR_NAME = "BY JAMIE MARTIN";
	
	private int mx = 0;

	private int my = 0;

	private int rectW = 210;

	private int rectH = 250;

	private Color backgroundColor = new Color(0x23, 0x27, 0x28);
	
	private TitleArrow title;
	
	private Selection selection;
	
	private LeftPanel leftPanel;
	
	private RightPanel rightPanel;
	
	public PluralityUI(int w, int h) {
		super(w, h);
	}

	@Override
	public void load() {

		int tw = 300;
		int th = 60;
		
		title = new TitleArrow(w/2-tw/2, 80, tw, th);
		
		selection = new Selection(mx-rectW/2, my-rectH/2, rectW, rectH);
		
		leftPanel = new LeftPanel(80, 160, 180, 300);
		
		rightPanel = new RightPanel(480, 160, 180, 300);
		
		loading = 100;
	}

	@Override
	public void draw(Graphics g) {

		g.setColor(backgroundColor);

		g.fillRect(0, 0, w, h);

		g.drawRect(mx-rectW/2, my-rectH/2, rectW, rectH);
		
		title.draw(g);
		
		selection.draw(g);
		
		leftPanel.draw(g);
		
		rightPanel.draw(g);
		
		g.setColor(Color.WHITE);
		
		int offset = -10;
		
		g.setFontSize(40f);
		
		g.drawStringShadow(THEME_NAME, title.getX(), title.getY()+offset, title.getW(), title.getH()+offset, Color.BLACK);
		
		offset = 14;
		
		g.setFontSize(20f);
		
		g.drawStringShadow(AUTHOR_NAME, title.getX(), title.getY()+offset, title.getW(), title.getH()+offset, Color.BLACK);
		
				
	}

	@Override
	public void updateMouse(PointerEvent event) {

		mx = event.getX(); 
		my = event.getY();
		
		selection.setBounds(mx-rectW/2, my-rectH/2, rectW, rectH);
	}

}
