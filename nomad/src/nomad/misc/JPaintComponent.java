package nomad.misc;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JComponent;

public class JPaintComponent extends JComponent {

	private int bufferw = 0;
	private int bufferh = 0;
	private Image buffer = null;
	
	public JPaintComponent() {
		addComponentListener(new ComponentAdapter(){
			public void componentResized(ComponentEvent event) {
				buffer = null;
				updateUI();
			}
		});
	}
	
	protected void paintBuffer(Graphics g) {
		// paint buffer
	}
	
	public void repaint() {
		buffer = null;
		super.repaint();
	}
	
    public void paintComponent(final Graphics g) {
    	super.paintComponent(g);				
    	if (buffer==null || bufferw!=getWidth() || bufferh!=getHeight()) {
    		bufferw = getWidth();
    		bufferh = getHeight();
    		buffer = null;
    		if (bufferw>0 && bufferh>0) {
    			buffer = createImage(bufferw, bufferh);
    			paintBuffer(buffer.getGraphics());
    		}
    	}
    	if (buffer!=null)
    		g.drawImage(buffer, 0, 0, JPaintComponent.this);
    	else
    		paintBuffer(g);
    }
}
