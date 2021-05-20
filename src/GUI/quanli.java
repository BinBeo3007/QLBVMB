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

public class quanli extends JPanel {
	/**
	 * Create the panel.
	 */
	public quanli() {
		setBackground(new Color(37, 98, 181));
		setBounds(100, 100, 1150, 801);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1150, 800);
		add(panel);
		panel.setLayout(null);
		
		JPanel pn_title = new JPanel();
		pn_title.setBackground(new Color(37, 98, 181));
		pn_title.setBounds(0, 0, 1149, 147);
		panel.add(pn_title);
		pn_title.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ThikBai Airline");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 69));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(336, 23, 475, 99);
		pn_title.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\plane-art-blue-sky-clouds-besthqwallpapers.com-1920x1080 (2).jpg"));
		lblNewLabel.setBounds(0, 0, 1149, 623);
		pn_title.add(lblNewLabel);
		
		JPanel pn_menu = new JPanel();
		pn_menu.setBorder(new LineBorder(new Color(37, 98, 181), 5));
		pn_menu.setBackground(Color.WHITE);
		pn_menu.setBounds(0, 147, 278, 653);
		panel.add(pn_menu);
		pn_menu.setLayout(null);
		
		JPanel pn_chuyenbay = new JPanel();
		pn_chuyenbay.setBackground(new Color(37, 98, 181));
		pn_chuyenbay.setBounds(10, 92, 258, 70);
		pn_menu.add(pn_chuyenbay);
		pn_chuyenbay.setLayout(null);
		
		JLabel lb_chuyenbay = new JLabel("Chuy\u1EBFn bay");
		lb_chuyenbay.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\airplane (1).png"));
		lb_chuyenbay.setHorizontalAlignment(SwingConstants.CENTER);
		lb_chuyenbay.setForeground(Color.WHITE);
		lb_chuyenbay.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb_chuyenbay.setBounds(0, 0, 258, 70);
		pn_chuyenbay.add(lb_chuyenbay);
		
		JPanel pn_nv = new JPanel();
		pn_nv.setLayout(null);
		pn_nv.setBackground(new Color(37, 98, 181));
		pn_nv.setBounds(10, 254, 258, 70);
		pn_menu.add(pn_nv);
		
		JLabel lb_nv = new JLabel("Nh\u00E2n vi\u00EAn");
		lb_nv.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\team (1).png"));
		lb_nv.setHorizontalAlignment(SwingConstants.CENTER);
		lb_nv.setForeground(Color.WHITE);
		lb_nv.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb_nv.setBounds(0, 0, 258, 70);
		pn_nv.add(lb_nv);
		
		JPanel pn_view = new JPanel();
		pn_view.setBorder(new LineBorder(new Color(37, 98, 181), 5));
		pn_view.setBackground(Color.WHITE);
		pn_view.setBounds(278, 147, 871, 653);
		panel.add(pn_view);
		pn_view.setLayout(null);
		
		JPanel pn_kh = new JPanel();
		pn_kh.setLayout(null);
		pn_kh.setBackground(new Color(37, 98, 181));
		pn_kh.setBounds(10, 173, 258, 70);
		pn_menu.add(pn_kh);
		
		JLabel lb_kh = new JLabel("Kh\u00E1ch h\u00E0ng");
		lb_kh.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\customer (1).png"));
		lb_kh.setHorizontalAlignment(SwingConstants.CENTER);
		lb_kh.setForeground(Color.WHITE);
		lb_kh.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb_kh.setBounds(0, 0, 258, 70);
		pn_kh.add(lb_kh);
		
		
		JPanel pn_thongke = new JPanel();
		pn_thongke.setLayout(null);
		pn_thongke.setBackground(new Color(37, 98, 181));
		pn_thongke.setBounds(10, 11, 258, 70);
		pn_menu.add(pn_thongke);
		
		JLabel lb_thongke = new JLabel("Th\u1ED1ng K\u00EA");
		lb_thongke.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\stats (1).png"));
		lb_thongke.setHorizontalAlignment(SwingConstants.CENTER);
		lb_thongke.setForeground(Color.WHITE);
		lb_thongke.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb_thongke.setBounds(0, 0, 258, 70);
		pn_thongke.add(lb_thongke);
		
		JPanel pn_hd = new JPanel();
		pn_hd.setLayout(null);
		pn_hd.setBackground(new Color(37, 98, 181));
		pn_hd.setBounds(10, 416, 258, 70);
		pn_menu.add(pn_hd);
		
		JLabel lb_hd = new JLabel("H\u00F3a \u0110\u01A1n");
		lb_hd.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\invoices (1).png"));
		lb_hd.setHorizontalAlignment(SwingConstants.CENTER);
		lb_hd.setForeground(Color.WHITE);
		lb_hd.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb_hd.setBounds(0, 0, 258, 70);
		pn_hd.add(lb_hd);
		
		JPanel pn_ve = new JPanel();
		pn_ve.setLayout(null);
		pn_ve.setBackground(new Color(37, 98, 181));
		pn_ve.setBounds(10, 335, 258, 70);
		pn_menu.add(pn_ve);
		
		JLabel lb_ve = new JLabel("V\u00E9");
		lb_ve.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\plane-ticket (1).png"));
		lb_ve.setHorizontalAlignment(SwingConstants.CENTER);
		lb_ve.setForeground(Color.WHITE);
		lb_ve.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb_ve.setBounds(0, 0, 258, 70);
		pn_ve.add(lb_ve);
		
		
		
		JPanel pn_maybay = new JPanel();
		pn_maybay.setLayout(null);
		pn_maybay.setBackground(new Color(37, 98, 181));
		pn_maybay.setBounds(10, 578, 57, 64);
		pn_menu.add(pn_maybay);
		
		JLabel lb_maybay = new JLabel("");
		lb_maybay.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\plane (1).png"));
		lb_maybay.setHorizontalAlignment(SwingConstants.CENTER);
		lb_maybay.setForeground(Color.WHITE);
		lb_maybay.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb_maybay.setBounds(0, 0, 56, 64);
		pn_maybay.add(lb_maybay);
		
		
		
		JPanel pn_duongbay = new JPanel();
		pn_duongbay.setLayout(null);
		pn_duongbay.setBackground(new Color(37, 98, 181));
		pn_duongbay.setBounds(77, 578, 57, 64);
		pn_menu.add(pn_duongbay);
		
		JLabel lb_duongbay = new JLabel("");
		lb_duongbay.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\global (1).png"));
		lb_duongbay.setHorizontalAlignment(SwingConstants.CENTER);
		lb_duongbay.setForeground(Color.WHITE);
		lb_duongbay.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb_duongbay.setBounds(0, 0, 56, 64);
		pn_duongbay.add(lb_duongbay);
		
		JPanel pn_sanbay = new JPanel();
		pn_sanbay.setLayout(null);
		pn_sanbay.setBackground(new Color(37, 98, 181));
		pn_sanbay.setBounds(144, 578, 57, 64);
		pn_menu.add(pn_sanbay);
		
		JLabel lb_sanbay = new JLabel("");
		lb_sanbay.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\airport (1).png"));
		lb_sanbay.setHorizontalAlignment(SwingConstants.CENTER);
		lb_sanbay.setForeground(Color.WHITE);
		lb_sanbay.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb_sanbay.setBounds(0, 0, 56, 64);
		pn_sanbay.add(lb_sanbay);
		
		JPanel pn_diadiem = new JPanel();
		pn_diadiem.setLayout(null);
		pn_diadiem.setBackground(new Color(37, 98, 181));
		pn_diadiem.setBounds(211, 578, 57, 64);
		pn_menu.add(pn_diadiem);
		
		JLabel lb_diadiem = new JLabel("");
		lb_diadiem.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\location (1).png"));
		lb_diadiem.setHorizontalAlignment(SwingConstants.CENTER);
		lb_diadiem.setForeground(Color.WHITE);
		lb_diadiem.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb_diadiem.setBounds(0, 0, 56, 64);
		pn_diadiem.add(lb_diadiem);
		
		
		JPanel pn_khuyenmai = new JPanel();
		pn_khuyenmai.setLayout(null);
		pn_khuyenmai.setBackground(new Color(37, 98, 181));
		pn_khuyenmai.setBounds(10, 497, 258, 70);
		pn_menu.add(pn_khuyenmai);
		
		JLabel lb_khuyenmai = new JLabel("Khuy\u1EBFn M\u00E3i");
		lb_khuyenmai.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\coupon (1).png"));
		lb_khuyenmai.setHorizontalAlignment(SwingConstants.CENTER);
		lb_khuyenmai.setForeground(Color.WHITE);
		lb_khuyenmai.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb_khuyenmai.setBounds(0, 0, 258, 70);
		pn_khuyenmai.add(lb_khuyenmai);
		
		ChuyenManHinh control= new ChuyenManHinh(pn_view,panel);
		control.setViews("thongke",pn_thongke,lb_thongke);
		
		List<DanhMucBean> listitem= new ArrayList<DanhMucBean>();
		listitem.add(new DanhMucBean("thongke",pn_thongke,lb_thongke));
		listitem.add(new DanhMucBean("nhanvien",pn_nv,lb_nv));
		listitem.add(new DanhMucBean("khachhang",pn_kh,lb_kh));
		listitem.add(new DanhMucBean("ve",pn_ve,lb_ve));
		listitem.add(new DanhMucBean("hoadon",pn_hd,lb_hd));
		listitem.add(new DanhMucBean("chuyenbay",pn_chuyenbay,lb_chuyenbay));
		listitem.add(new DanhMucBean("maybay",pn_maybay,lb_maybay));
		listitem.add(new DanhMucBean("duongbay",pn_duongbay,lb_duongbay));
		listitem.add(new DanhMucBean("sanbay",pn_sanbay,lb_sanbay));
		listitem.add(new DanhMucBean("diadiem",pn_diadiem,lb_diadiem));
		listitem.add(new DanhMucBean("khuyenmai",pn_khuyenmai,lb_khuyenmai));
		control.setEvent(listitem);
	}
}
