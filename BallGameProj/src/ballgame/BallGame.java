package ballgame;
import java.awt.*;
import javax.swing.*;

public class BallGame extends JFrame{
	
	Image ball = Toolkit.getDefaultToolkit().getImage("img/ball.png");
	Image table = Toolkit.getDefaultToolkit().getImage("img/table.jpg");
	
	double x = 100;
	double y = 100;
	
	double degree = 3.14/3;		// 弧度，此处为60°
	
	// 画窗口的方法
	public void paint(Graphics g) {
		System.out.println("窗口被画了一次");
		g.drawImage(table,0,0,null);		// 画图顺序越后，图片越顶层
		g.drawImage(ball,(int)x,(int)y,null);
		
		x = x + 10*Math.cos(degree);
		y = y + 10*Math.sin(degree);
		
		if (y > 500-40-30 || y < 40+40) {	// 标题栏宽度为40
			degree = -degree;
		}
		if (x < 40 || x > 856-30-40) {
			degree = 3.14-degree;
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
		BallGame game = new BallGame();
		game.launchFrame();
	}
}
