package ChuyenManHinh;

import bean.DanhMucBean;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;


import GUI.datve;
import GUI.KHForm;
import GUI.KMGUI;
import GUI.pn_dangnhap;
import GUI.SanBayGUI;
import GUI.VeGUI;
import GUI.thongtin_chuyenbay;
import GUI.NhanVienGUI;
import GUI.NhanVienGUI;
import GUI.KhachHangGUI;
import GUI.quanli;
import GUI.temp;
import GUI.thongke;
import GUI.MayBayGUI;
import GUI.ChuyenBayGUI;
import GUI.DiaDiemGUI;
import GUI.DuongBayGUI;
import GUI.HoaDonGUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChuyenManHinh {
	private JPanel rootscr;
	private JPanel scr;
	private String selected ="";
	
	private List<DanhMucBean> list=null;
	
	public ChuyenManHinh(JPanel rootscr) {
		this.rootscr=rootscr;
	}
	public ChuyenManHinh(JPanel rootscr,JPanel scr) {
		this.rootscr=rootscr;
		this.scr=scr;
	}
	
	public void screenBanVe() {
		JPanel node =new KHForm();
		scr.removeAll();
		scr.setLayout(new BorderLayout());
		scr.add(node);
		scr.validate();
		scr.repaint();
	}
	public void screenQL() {
		JPanel node =new quanli();
		scr.removeAll();
		scr.setLayout(new BorderLayout());
		scr.add(node);
		scr.validate();
		scr.repaint();
	}
	

	public void setViews(String link,JPanel pnitem, JLabel lbitem) {
		selected =link;
		
		
		
			rootscr.removeAll();
			rootscr.setLayout(new BorderLayout());
			rootscr.add(new temp());
			rootscr.validate();
			rootscr.repaint();
		
	}
	
	public void outView() {
		JPanel node =new pn_dangnhap();
		scr.removeAll();
		scr.setLayout(new BorderLayout());
		scr.add(node);
		scr.validate();
		scr.repaint();
	}
	
	public void setEvent(List<DanhMucBean> listitem) {
		this.list=listitem;
		
		for(DanhMucBean item : listitem) {
			item.getJlb().addMouseListener(new LabelEvent(item.getKind(),item.getJpn(),item.getJlb()));
		}
	}
	
	class LabelEvent implements MouseListener{
		private JPanel node;
		private String kind;
		
		private JPanel pnitem;
		private JLabel lbitem;
		
		public LabelEvent() {
	        
	    }

	    public LabelEvent(String kind, JPanel pnitem, JLabel lbitem) {
	        this.kind = kind;
	        this.pnitem = pnitem;
	        this.lbitem = lbitem;
	    }

		@Override
		public void mouseClicked(MouseEvent e) {
			
			switch(kind) {
				case"thongtin_chuyenbay":
					node=new thongtin_chuyenbay();
					break;
				case"datve":
					node=new datve();
					break;
				case"hoadon":
					node=new HoaDonGUI();
					break;
				case"nhanvien":
					node=new NhanVienGUI();
					break;
				case"khachhang":
					node=new KhachHangGUI();
					break;

				case"ve":
					node=new VeGUI();
					break;
				case"chuyenbay":
					node=new ChuyenBayGUI();
					break;
				case"thongke":
					node = new thongke();
					break;
					
				case"maybay":
					node =new MayBayGUI();
					break;
				case"duongbay":
					node =new DuongBayGUI();
					break;
				case"sanbay":
					node =new SanBayGUI();
					break;
				case"diadiem":
					node =new DiaDiemGUI();
					break;
				case"khuyenmai":
					node =new KMGUI();
					break;
				default:
					node=new temp();
					break;
					
			}
				
					rootscr.removeAll();
					rootscr.setLayout(new BorderLayout());
					rootscr.add(node);
					rootscr.invalidate();
					rootscr.validate();
					rootscr.repaint();
					setChangeBG(selected);
				
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			selected=kind;
			pnitem.setBackground(Color.RED);
			lbitem.setBackground(Color.RED);
			setChangeBG(selected);
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			pnitem.setBackground(Color.RED);
			lbitem.setBackground(Color.RED);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			if(!selected.equalsIgnoreCase(kind)) {
				pnitem.setBackground(new Color(37, 98, 181));
				lbitem.setBackground(new Color(37, 98, 181));
			}
		}
		private void setChangeBG(String sl) {
			for(DanhMucBean item : list) {
				if(item.getKind().equalsIgnoreCase(sl)) {
					item.getJpn().setBackground(Color.RED);
					item.getJlb().setBackground(Color.RED);
				}
				else {
					item.getJpn().setBackground(new Color(37, 98, 181));
					item.getJlb().setBackground(new Color(37, 98, 181));
				}
			}
		}
		
		private void outUser() {
			
			
		}
	}
}
