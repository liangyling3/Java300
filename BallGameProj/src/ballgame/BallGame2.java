package ballgame;
import java.awt.*;
import javax.swing.*;

public class BallGame2 extends JFrame{
	
	Image ball = Toolkit.getDefaultToolkit().getImage("img/ball.png");
	Image table = Toolkit.getDefaultToolkit().getImage("img/table.jpg");
	
	double x = 100;
	double y = 100;
	boolean right =  true;
	
	// �����ڵķ���
	public void paint(Graphics g) {
		System.out.println("���ڱ�����һ��");
		g.drawImage(table,0,0,null);		// ��ͼ˳��Խ��ͼƬԽ����
		g.drawImage(ball,(int)x,(int)y,null);
		
		if (right) {
			x += 10;
		} else {
			x -= 10;
		}
		
		if (x > 856-40-30) {	// 40�����ӱ߿�30��С��ֱ��
			right = false;
		} 
		if (x < 40) {
			right = true;
		}
	}
	
	// ���ڼ���
	void launchFrame() {
		setSize(856,500);
		setLocation(400,160);
		setVisible(true);
		
		// �ػ�����
		while(true) {
			repaint();
			try {
				Thread.sleep(40);		// 40ms
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}
	
	// ����ִ�е����
	public static void main (String[] args) {
		System.out.println("������");
		BallGame2 game = new BallGame2();
		game.launchFrame();
	}
}
