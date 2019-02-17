package ballgame;
import java.awt.*;
import javax.swing.*;

public class BallGame extends JFrame{
	
	Image ball = Toolkit.getDefaultToolkit().getImage("img/ball.png");
	Image table = Toolkit.getDefaultToolkit().getImage("img/table.jpg");
	
	double x = 100;
	double y = 100;
	
	double degree = 3.14/3;		// ���ȣ��˴�Ϊ60��
	
	// �����ڵķ���
	public void paint(Graphics g) {
		System.out.println("���ڱ�����һ��");
		g.drawImage(table,0,0,null);		// ��ͼ˳��Խ��ͼƬԽ����
		g.drawImage(ball,(int)x,(int)y,null);
		
		x = x + 10*Math.cos(degree);
		y = y + 10*Math.sin(degree);
		
		if (y > 500-40-30 || y < 40+40) {	// ���������Ϊ40
			degree = -degree;
		}
		if (x < 40 || x > 856-30-40) {
			degree = 3.14-degree;
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
		BallGame game = new BallGame();
		game.launchFrame();
	}
}
