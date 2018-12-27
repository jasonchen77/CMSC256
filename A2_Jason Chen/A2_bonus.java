import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This program draws the binary tree
 * @author Jason Chen
 *
 */
public class A2_bonus extends JPanel{

	@Override
	public void paintComponent(Graphics g) {
	    //draws the tree
		g.drawOval(200, 0, 25, 25);
		g.drawString("1", 210, 15);
		g.drawLine(200, 20, 180, 30);
		g.drawOval(170, 30, 25, 25);
		g.drawString("2", 180, 45);
		g.drawLine(220, 20, 240, 30);
		g.drawOval(230, 30, 25, 25);
		g.drawString("3", 240, 45);
		g.drawLine(170, 50, 150, 60);
		g.drawOval(140, 60, 25,	25);
		g.drawString("4", 150, 75);
		g.drawLine(180, 55, 190, 60);
		g.drawOval(180, 60, 25, 25);
		g.drawString("5", 190, 75);
		g.drawLine(235, 52, 230, 60);
		g.drawOval(220, 60, 25, 25);
		g.drawString("6", 230, 75);
	}

	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		jFrame.add(new A2_bonus());
		jFrame.setSize(500, 500);
		jFrame.setVisible(true);
	}

	
}
