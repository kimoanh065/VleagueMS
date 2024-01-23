package View_Manager;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.ui.HorizontalAlignment;
import org.jfree.data.KeyToGroupMap;
import org.jfree.data.category.DefaultCategoryDataset;

import Connection.DBController;
import View_User.MainGUI_User;

import java.awt.Color;

public class Chart extends JFrame {
	
	Vector vD, vT;
	
	public static Vector getPoint() {
	    Vector vD = new Vector();
	    Connection con = new DBController().getConnection();
	    String sql = "SELECT t1.ID, Point, footballname football FROM vleague.rank as t1 join vleague.footballteam as t2 on t1.ID = t2.ID ORDER BY Point DESC";
	    try {
	        PreparedStatement stm = con.prepareStatement(sql);
	        ResultSet rs = stm.executeQuery();
	        while (rs.next()) {
	            Vector vtemp = new Vector();
	            vtemp.add(rs.getString(1));
	            vtemp.add(rs.getString(2));
	            vtemp.add(rs.getString(3));
	            
	            vD.add(vtemp);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return vD;
	}
	
	

	public Chart() {
		Container con = getContentPane();
		
		JPanel pnmain = new JPanel();
		pnmain.setBackground(new Color(245, 255, 250));
		
		JButton jbback = new JButton("Trở lại");
        jbback.setFont(new Font("Courier New", Font.BOLD, 14));
        jbback.setIcon(new ImageIcon(Chart.class.getResource("/iconbutton/arrow_back.png")));
        jbback.setFocusable(false);
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		vT = getPoint();
		
		for (int i = 0; i < vT.size(); i++) {
			Vector vtemp = (Vector) vT.get(i);
			int pointValue = Integer.parseInt((String) vtemp.get(1));
			dataset.addValue(pointValue, (String)vtemp.get(2) , (String) vtemp.get(0));
		}
		
		JFreeChart chart = ChartFactory.createBarChart(
                "", // Tiêu đề biểu đồ
                "Teams", // Label trục x
                "Points", // Label trục y
                dataset // Dữ liệu
                
        );
		
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(1200,600));
		
		jbback.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new Rank();
			}
		});
		 		
		pnmain.add(chartPanel);
		pnmain.add(jbback);
		
		con.add(pnmain);
		
		ImageIcon logo = new ImageIcon(getClass().getResource("/iconbutton/bar_chart.png"));
		this.setIconImage(logo.getImage());
		
		setTitle("Biểu đồ");
		setSize(1280,750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		
	}
	public static void main(String[] args) {
		new Chart();
	}
}
