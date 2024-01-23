package View_User;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Sponsor extends JFrame {

	public Sponsor() {
		Container con = getContentPane();
		
		JPanel pnicon = new JPanel();
		pnicon.setBounds(0, 0, 1280, 100);
		pnicon.setOpaque(false);
		pnicon.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		JButton jbhome = new JButton("Trang chủ");
		jbhome.setIcon(new ImageIcon(Sponsor.class.getResource("/iconbutton/home.png")));
		jbhome.setPreferredSize(new Dimension(120,30));
		jbhome.setFocusable(false);
		
		
		JPanel pnmain = new JPanel();
		pnmain.setLayout(new BorderLayout());
		pnmain.setBounds(0, 100, 1280, 750);
		pnmain.setOpaque(false);
		
		JLabel lbbackground = new JLabel();
		lbbackground.setIcon(new ImageIcon(Sponsor.class.getResource("/background/san5.jpg")));
		
		JPanel pnsouth = new JPanel();
		pnsouth.setLayout(new BorderLayout());
		pnsouth.setOpaque(false);
		
		JPanel pncenter = new JPanel();
		pncenter.setLayout(new BorderLayout());
		pncenter.setOpaque(false);
		
		JPanel pncenter1 = new JPanel();
		pncenter1.setBackground(new Color(255, 255, 255,150));
		
		JPanel pncenter2 = new JPanel();
		FlowLayout flpncenter2 = new FlowLayout();
		flpncenter2.setVgap(20);
		flpncenter2.setHgap(20);
		pncenter2.setLayout(flpncenter2);
		pncenter2.setOpaque(false);
		
		JLabel lbsponsor1 = new JLabel("Tài trợ chính");
		lbsponsor1.setForeground(new Color(51, 153, 51));
		lbsponsor1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		
		Dimension sizelabel = new Dimension(400,223);
		
		JLabel lb1 = new JLabel();
		lb1.setIcon(new ImageIcon(Sponsor.class.getResource("/background/Banner-HNQG.png")));
		lb1.setPreferredSize(sizelabel);
		
		JLabel lb2 = new JLabel();
		lb2.setIcon(new ImageIcon(Sponsor.class.getResource("/background/Banner-VDQG.png")));
		lb2.setPreferredSize(sizelabel);
		
		JLabel lb3 = new JLabel();
		lb3.setIcon(new ImageIcon(Sponsor.class.getResource("/background/Banner-CupQG.png")));
		lb3.setPreferredSize(sizelabel);
		
		
		JPanel pnsouth1 = new JPanel();
		pnsouth1.setBackground(new Color(255, 255, 255,150));
		
		
		JLabel lbsponsor2 = new JLabel("Tài trợ đồng hành");
		lbsponsor2.setForeground(new Color(51, 153, 51));
		lbsponsor2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		
		JPanel pnsouth2 = new JPanel();
		FlowLayout flpnsouth2 = new FlowLayout();
		flpnsouth2.setVgap(20);
		flpnsouth2.setHgap(50);
		pnsouth2.setLayout(flpnsouth2);
		pnsouth2.setOpaque(false);
		
		Dimension sizelabel2 = new Dimension(200,111);
		
		JLabel lb4 = new JLabel();
		lb4.setIcon(new ImageIcon(Sponsor.class.getResource("/background/fpt-play.png")));
		lb4.setPreferredSize(sizelabel2);
		
		JLabel lb5 = new JLabel();
		lb5.setIcon(new ImageIcon(Sponsor.class.getResource("/background/dong-luc.png")));
		lb5.setPreferredSize(sizelabel2);
		
		jbhome.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new MainGUI_User();
			}
		});
		
		//ADD
		
		pncenter1.add(lbsponsor1);
		
		pncenter2.add(lb1);
		pncenter2.add(lb2);
		pncenter2.add(lb3);
		
		pncenter.add(pncenter1, BorderLayout.NORTH);
		pncenter.add(pncenter2, BorderLayout.CENTER);
		
		pnsouth1.add(lbsponsor2);
		pnsouth2.add(lb4);
		pnsouth2.add(lb5);
		
		pnsouth.add(pnsouth1, BorderLayout.NORTH);
		pnsouth.add(pnsouth2, BorderLayout.CENTER);
		
		pnmain.add(pncenter, BorderLayout.NORTH);
		pnmain.add(pnsouth, BorderLayout.CENTER);
		
		pnicon.add(jbhome);
		
		con.add(pnmain);
		con.add(pnicon);
		con.add(lbbackground);
		
		
		setTitle("Sponsor");
		setSize(1280,750);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new Sponsor();
	}
}
