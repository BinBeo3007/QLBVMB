package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import ChuyenManHinh.ChuyenManHinh;

public class main extends JFrame {

	private JPanel contentPane;
	JPanel panel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
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
	public main() {
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1175, 883);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		panel = new JPanel();
		panel.setBounds(0, 0, 1159, 854);	
		contentPane.add(panel);
		
		
		
		ChuyenManHinh control= new ChuyenManHinh(panel,contentPane);
		panel.setLayout(null);
		contentPane.setLayout(null);
		//control.outView();
		
		//control.screenBanVe();
		control.screenQL();
		
		
	}
}
