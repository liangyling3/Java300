package ballgame;
import java.awt.*;
import javax.swing.*;

public class BallGame2 extends JFrame{
	
	Image ball = Toolkit.getDefaultToolkit().getImage("img/ball.png");
	Image table = Toolkit.getDefaultToolkit().getImage("img/table.jpg");
	
	double x = 100;
	double y = 100;
	boolean right =  true;
	
	// 画窗口的方法
	public void paint(Graphics g) {
		System.out.println("窗口被画了一次");
		g.drawImage(table,0,0,null);		// 画图顺序越后，图片越顶层
		g.drawImage(ball,(int)x,(int)y,null);
		
		if (right) {
			x += 10;
		} else {
			x -= 10;
		}
		
		if (x > 856-40-30) {	// 40：桌子边框；30：小球直径
			right = false;
		} 
		if (x < 40) {
			right = true;
		}
	}
	
	// 窗口加载
	void launchFrame() {
		setSize(856,500);
		setLocation(400,160);
		setVisible(true);
		
		// 重画窗口
		while(true) {
			repaint();
			try {
				Thread.sleep(40);		// 40ms
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}
	
	// 程序执行的入口
	public static void main (String[] args) {
		System.out.println("嘤嘤嘤");
		BallGame2 game = new BallGame2();
		game.launchFrame();
	}
}
