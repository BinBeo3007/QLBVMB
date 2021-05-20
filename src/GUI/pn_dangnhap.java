package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import ChuyenManHinh.ChuyenManHinh;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class pn_dangnhap extends JPanel {
	private JTextField txtTiKhon;
	private JPasswordField textField;

	/**
	 * Create the panel.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pn_dangnhap frame = new pn_dangnhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public pn_dangnhap() {
		setBackground(new Color(151, 198, 252));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 255, 255), 5, true));
		panel.setBackground(new Color(151, 198, 252));
		panel.setBounds(42, 71, 500, 500);
		add(panel);
		panel.setLayout(null);
		
		JLabel lb_logo = new JLabel("");
		lb_logo.setBounds(0, 0, 500, 500);
		panel.add(lb_logo);
		lb_logo.setBackground(new Color(0, 0, 0));
		lb_logo.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\logothikbai.png"));
		
		JPanel pn_dangnhap = new JPanel();
		pn_dangnhap.setBorder(new LineBorder(new Color(255, 255, 255), 5, true));
		pn_dangnhap.setBackground(new Color(151, 198, 252));
		pn_dangnhap.setBounds(549, 71, 334, 500);
		add(pn_dangnhap);
		pn_dangnhap.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0110\u0103ng nh\u1EADp");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(22, 80, 282, 61);
		pn_dangnhap.add(lblNewLabel);
		
		txtTiKhon = new JTextField();
		txtTiKhon.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtTiKhon.setToolTipText("Xin nh\u1EADp t\u00E0i kho\u1EA3n v\u00E0o !");
		txtTiKhon.setText("T\u00E0i kho\u1EA3n");
		txtTiKhon.setForeground(new Color(0, 0, 0));
		txtTiKhon.setBounds(22, 191, 282, 61);
		pn_dangnhap.add(txtTiKhon);
		txtTiKhon.setColumns(24);
		
		textField = new JPasswordField();
		textField.setToolTipText("Xin nh\u1EADp m\u1EADt kh\u1EA9u v\u00E0o !");
		textField.setText("12345678");
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Tahoma", Font.BOLD, 24));
		textField.setColumns(24);
		textField.setBounds(22, 290, 282, 61);
		pn_dangnhap.add(textField);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		panel_1.setBackground(new Color(151, 198, 252));
		panel_1.setBounds(85, 386, 159, 43);
		pn_dangnhap.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnNewButton.setBounds(10, 11, 139, 23);
		btnNewButton.setIcon(new ImageIcon(pn_dangnhap.class.getResource("/org/eclipse/jface/wizard/images/page.png")));
		btnNewButton.setSelectedIcon(null);
		panel_1.add(btnNewButton);
		btnNewButton.setBackground(new Color(135, 206, 250));
	
		
	}
}
