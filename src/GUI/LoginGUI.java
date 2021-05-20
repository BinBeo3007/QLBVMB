package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import BUS.NhanVienBUS;
import BUS.TaiKhoanBUS;
import ChuyenManHinh.ChuyenManHinh;
import DTO.NhanVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtTK;
	private JPasswordField pwd;
	private JPanel panel;
	private JPanel pn_dangnhap;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1167, 838);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new LineBorder(new Color(37, 98, 181)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		init();
		
	}
	public void init() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(255, 255, 255), 10, true));
		panel.setBackground(Color.CYAN);
		panel.setBounds(63, 86, 571, 533);
		contentPane.add(panel);
		
		JLabel lb_logo = new JLabel("");
		lb_logo.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\logothikbai.png"));
		lb_logo.setBackground(Color.BLACK);
		lb_logo.setBounds(10, 11, 561, 511);
		panel.add(lb_logo);
		
		pn_dangnhap = new JPanel();
		pn_dangnhap.setLayout(null);
		pn_dangnhap.setBorder(new LineBorder(new Color(255, 255, 255), 10, true));
		pn_dangnhap.setBackground(Color.CYAN);
		pn_dangnhap.setBounds(658, 86, 419, 533);
		contentPane.add(pn_dangnhap);
		
		JLabel lblNewLabel = new JLabel("\u0110\u0103ng nh\u1EADp");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(57, 80, 282, 61);
		pn_dangnhap.add(lblNewLabel);
		
		txtTK = new JTextField();
		txtTK.setToolTipText("Xin nh\u1EADp t\u00E0i kho\u1EA3n v\u00E0o !");
		txtTK.setText("T\u00E0i kho\u1EA3n");
		txtTK.setForeground(Color.BLACK);
		txtTK.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtTK.setColumns(24);
		txtTK.setBounds(70, 191, 282, 61);
		pn_dangnhap.add(txtTK);
		
		pwd = new JPasswordField();
		pwd.setToolTipText("Xin nh\u1EADp m\u1EADt kh\u1EA9u v\u00E0o !");
		pwd.setText("!@#$%^&*");
		pwd.setForeground(Color.BLACK);
		pwd.setFont(new Font("Tahoma", Font.BOLD, 24));
		pwd.setColumns(24);
		pwd.setBounds(70, 289, 282, 61);
		pn_dangnhap.add(pwd);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(126, 386, 159, 43);
		pn_dangnhap.add(panel_1);
		
		JButton btnlogin = new JButton("");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnlogin.setBackground(Color.WHITE);
		btnlogin.setBounds(10, 11, 139, 23);
		panel_1.add(btnlogin);
	}
	public void login() {
		String tk=txtTK.getText();
		String pass= new String(pwd.getPassword());
		StringBuilder sb =new StringBuilder();
		if(tk.equals("Tài khoản")||tk.equals(""))
			sb.append("Chưa nhập tài khoản !!!\n");
		if(pass.equals("!@#$%^&*")||pass.equals(""))
			sb.append("Chưa nhập mật khẩu !!!");
		if(sb.length()>0) {
			JOptionPane.showMessageDialog(pn_dangnhap,
	 				sb.toString(), "Thông báo",
	 				 JOptionPane.ERROR_MESSAGE);
			return;
		}
		TaiKhoanBUS tkB =new TaiKhoanBUS();
		if(tkB.checkLogin(tk, pass)!=0) {
			
			int role =tkB.getROLEbyTK(tk);
			if(role==0) {
				JOptionPane.showMessageDialog(pn_dangnhap,
		 				"Đăng nhập thất bại", "Thông báo",
		 				 JOptionPane.ERROR_MESSAGE);
				return;
			}
			else {
				if(role ==2) {
					JOptionPane.showMessageDialog(pn_dangnhap,
			 				"Đăng nhập thành công", "Thông báo",
			 				 JOptionPane.ERROR_MESSAGE);
					ChuyenManHinh control= new ChuyenManHinh(panel,contentPane);
					panel.setLayout(null);
					contentPane.setLayout(null);
					control.screenQL();
				}
				else {
					JOptionPane.showMessageDialog(pn_dangnhap,
			 				"Đăng nhập thành công", "Thông báo",
			 				 JOptionPane.ERROR_MESSAGE);
					ChuyenManHinh control= new ChuyenManHinh(panel,contentPane);
					panel.setLayout(null);
					contentPane.setLayout(null);
					control.screenBanVe();
				}
					
			}
			
			return;
		}
		else
			JOptionPane.showMessageDialog(pn_dangnhap,
	 				"Đăng nhập thất bại", "Thông báo",
	 				 JOptionPane.ERROR_MESSAGE);
	}
}
