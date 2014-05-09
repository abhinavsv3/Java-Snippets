import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.applet.*;
/*
 <applet code = "Font1" width=300 height=300>
 </applet>

*/

public class Font1 extends Applet implements ActionListener
{
		Button bfont;
		Font f;
		public void init()
		{
			bfont = new Button("Font");
			bfont.addActionListener(this);
			add(bfont);
		}
		public void start(){}
		public void stop(){}
		public void destroy(){}
		public void paint(Graphics g)
		{
				Dimension d = this.getSize();
				f = new Font("Times New Roman",Font.BOLD,18);
				g.setFont(f);
				centerText("This is the Center String",d.getWidth(),d.getHeight(),g);
		}
		void centerText(String s, double w,double h,Graphics g)
		{
			FontMetrics fm =g.getFontMetrics();
			double x = (w-fm.stringWidth(s))/2;
			double y=fm.getAscent()+(h-(fm.getAscent()+fm.getDescent()))/2;
			
			g.drawString(s,(int)x,(int)y);
			
		}
		public void actionPerformed(ActionEvent ae)
		{
			
			if(ae.getActionCommand().equals("Font"))
			{
					Dialog d = new Dialog(new Frame());
					d.setVisible(true);
					d.setLayout(new FlowLayout());
					d.setSize(300,300);
					List ll = new List();
					List type = new List(4,false);
					GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
					String ar[] = ge.getAvailableFontFamilyNames();
					for(int i=0;i<ar.length;i++)
					{
						ll.add(ar[i]);
					}
					type.add("Plain");
					type.add("Bold");
					type.add("Italics");
					
					d.add(ll);
					d.add(type);
			}
		}
}
