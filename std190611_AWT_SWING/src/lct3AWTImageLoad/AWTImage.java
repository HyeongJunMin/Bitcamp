package lct3AWTImageLoad;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class AWTImage extends Frame implements WindowListener {
	Image jpgImg = null;
	Image jpgImg2 = null;
	Image pngImg = null;
	public AWTImage() {
		super("Image");
		
		setLayout(null);

		
//		setBackground(new Color(160,240,160));
		setBounds(800, 200, 640, 480);
		setVisible(true);
		
		addWindowListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		jpgImg = tk.getImage("house.jpg");
		pngImg = tk.getImage("bird.png");
		jpgImg2 = tk.getImage("d:\\tmp\\pig.png");
		Image im = tk.getImage("\\\\192.168.0.66\\공유\\girl.jpg");
		
		int width = jpgImg.getWidth(this);
		int height = jpgImg.getHeight(this);
		
		//이미지를 화면 중앙에 출력
		g.drawImage(jpgImg, (getWidth()-width)/2, ( getHeight()-height)/2, this);
		
		//이미지 위에 이미지를 출력
		g.drawImage(pngImg, 50, 80, this);
		g.drawImage(jpgImg2, 50, 80, this);
//		g.drawImage(im, 60, 80, this);
	}	
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}
}
