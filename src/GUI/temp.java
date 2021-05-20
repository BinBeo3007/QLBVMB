package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

public class temp extends JPanel {

	/**
	 * Create the panel.
	 */
	public temp() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 866, 668);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblChoMngBn = new JLabel("CH\u00C0O M\u1EEANG B\u1EA0N TR\u1EDE L\u1EA0I");
		lblChoMngBn.setHorizontalAlignment(SwingConstants.CENTER);
		lblChoMngBn.setForeground(Color.WHITE);
		lblChoMngBn.setFont(new Font("Sitka Subheading", Font.BOLD, 44));
		lblChoMngBn.setBounds(73, 85, 676, 143);
		panel.add(lblChoMngBn);
		
		JLabel lblNewLabel = new JLabel("H\u1EC6 TH\u1ED0NG THIKBAY AIRLINE ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 44));
		lblNewLabel.setBounds(91, 0, 676, 143);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\plane-art-blue-sky-clouds-besthqwallpapers.com-1920x1080 (2).jpg"));
		lblNewLabel_1.setBounds(0, 0, 866, 668);
		panel.add(lblNewLabel_1);
		
		JLabel label = new JLabel("New label");
		label.setBounds(61, 184, 396, 134);
		panel.add(label);

	}

}
