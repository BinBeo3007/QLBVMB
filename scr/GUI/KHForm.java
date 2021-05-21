package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import ChuyenManHinh.ChuyenManHinh;
import bean.DanhMucBean;
import javax.swing.ImageIcon;

public class KHForm extends JPanel {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KHForm frame = new KHForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the panel.
	 */
	public KHForm() {
		setBackground(Color.WHITE);
		setBounds(100, 100, 1181, 800);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(37, 98, 181)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1181, 800);
		add(panel);
		panel.setLayout(null);
		
		JPanel pn_title = new JPanel();
		pn_title.setBackground(new Color(37, 98, 181));
		pn_title.setBounds(0, 0, 1181, 160);
		panel.add(pn_title);
		pn_title.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("ThikBai Airline");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 69));
		lblNewLabel_1_1.setBounds(439, 22, 475, 99);
		pn_title.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\plane-art-blue-sky-clouds-besthqwallpapers.com-1920x1080 (2).jpg"));
		lblNewLabel_2.setBounds(0, 0, 1181, 594);
		pn_title.add(lblNewLabel_2);
		
		JPanel pn_menu = new JPanel();
		pn_menu.setBorder(new LineBorder(new Color(37, 98, 181), 5));
		pn_menu.setBackground(Color.WHITE);
		pn_menu.setBounds(0, 161, 278, 634);
		panel.add(pn_menu);
		pn_menu.setLayout(null);
		
		JPanel pn_thongtin_chuyenbay = new JPanel();
		pn_thongtin_chuyenbay.setBackground(new Color(37, 98, 181));
		pn_thongtin_chuyenbay.setBounds(10, 11, 258, 70);
		pn_menu.add(pn_thongtin_chuyenbay);
		pn_thongtin_chuyenbay.setLayout(null);
		
		JLabel lb_thongtin_chuyenbay = new JLabel("Th\u00F4ng tin chuy\u1EBFn bay");
		lb_thongtin_chuyenbay.setHorizontalAlignment(SwingConstants.CENTER);
		lb_thongtin_chuyenbay.setForeground(Color.WHITE);
		lb_thongtin_chuyenbay.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb_thongtin_chuyenbay.setBounds(0, 0, 258, 70);
		pn_thongtin_chuyenbay.add(lb_thongtin_chuyenbay);
		
		JPanel pn_datve = new JPanel();
		pn_datve.setLayout(null);
		pn_datve.setBackground(new Color(37, 98, 181));
		pn_datve.setBounds(10, 92, 258, 70);
		pn_menu.add(pn_datve);
		
		JLabel lb_datve = new JLabel("\u0110\u1EB7t v\u00E9");
		lb_datve.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\plane-ticket (1).png"));
		lb_datve.setBackground(Color.WHITE);
		lb_datve.setHorizontalAlignment(SwingConstants.CENTER);
		lb_datve.setForeground(Color.WHITE);
		lb_datve.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb_datve.setBounds(0, 0, 258, 70);
		pn_datve.add(lb_datve);
		
		JPanel pn_view = new JPanel();
		pn_view.setBorder(new LineBorder(new Color(37, 98, 181), 5));
		pn_view.setBackground(Color.WHITE);
		pn_view.setBounds(276, 161, 905, 634);
		panel.add(pn_view);
		pn_view.setLayout(null);
		
		ChuyenManHinh control= new ChuyenManHinh(pn_view,panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Bin\\Downloads\\plane-art-blue-sky-clouds-besthqwallpapers.com-1920x1080 (2).jpg"));
		lblNewLabel.setBounds(-141, 0, 1046, 635);
		pn_view.add(lblNewLabel);
		control.setViews("thongtin_chuyenbay",pn_thongtin_chuyenbay,lb_thongtin_chuyenbay);

		List<DanhMucBean> listitem= new ArrayList<DanhMucBean>();
		listitem.add(new DanhMucBean("thongtin_chuyenbay",pn_thongtin_chuyenbay,lb_thongtin_chuyenbay));
		listitem.add(new DanhMucBean("datve",pn_datve,lb_datve));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\plane-art-blue-sky-clouds-besthqwallpapers.com-1920x1080 (2).jpg"));
		lblNewLabel_1.setBounds(0, 0, 278, 634);
		pn_menu.add(lblNewLabel_1);
		control.setEvent(listitem);
		control.setEvent(listitem);

	}

}
