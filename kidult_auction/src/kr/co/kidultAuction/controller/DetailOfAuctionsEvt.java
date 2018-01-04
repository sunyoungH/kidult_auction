package kr.co.kidultAuction.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import kr.co.kidultAuction.dao.UserDAO_YW;
import kr.co.kidultAuction.view.AuctionMainFrm;
import kr.co.kidultAuction.view.DetailOfAuctionsFrm;
import kr.co.kidultAuction.view.LoginFrm;
import kr.co.kidultAuction.vo.AddBidVO;

public class DetailOfAuctionsEvt extends WindowAdapter implements ActionListener {
	
	private DetailOfAuctionsFrm doa;
	
	private AuctionMainFrm amf;
	
	
	public DetailOfAuctionsEvt(DetailOfAuctionsFrm doa) {
		this.doa=doa;
		this.amf=amf;
	}//DetailOfAuctionsEvt
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		// �޾ƿ� �̹��� ��� ������
		if(ae.getSource()==doa.getBtnFrontImg()) {
			ImageIcon front=new ImageIcon("C:/dev/git/kidult_auction/kidult_auction/src/kr/co/kidultAuction/img/front_img.png");
			doa.getLblDlmg().setIcon(front);
		}
		if(ae.getSource()==doa.getBtnBackImg()) {
			ImageIcon back=new ImageIcon("C:/dev/git/kidult_auction/kidult_auction/src/kr/co/kidultAuction/img/daum.png");
			doa.getLblDlmg().setIcon(back);
		}
		if(ae.getSource()==doa.getBtnLeftImg()) {
			ImageIcon left=new ImageIcon("C:/dev/git/kidult_auction/kidult_auction/src/kr/co/kidultAuction/img/flower_img.jpg");
			doa.getLblDlmg().setIcon(left);
		}
		if(ae.getSource()==doa.getBtnRightImg()) {
			ImageIcon right=new ImageIcon("C:/dev/git/kidult_auction/kidult_auction/src/kr/co/kidultAuction/img/cancel.JPG");
			doa.getLblDlmg().setIcon(right);
		}
		
		ImageIcon icon=new ImageIcon("C:/dev/git/kidult_auction/kidult_auction/src/kr/co/kidultAuction/img/bid.png");
		String msg=doa.getLblDItemName().getText().trim()+
				"\n"+doa.getLblDsPrice().getText().trim()+
				"   "+doa.getLblUserPrice().getText().trim();
		Object bid="";
		System.out.println(AuctionMainFrm.User_id);
		if(ae.getSource() == doa.getBtnBid()) {
//			if(AuctionMainFrm.User_id == null) {
//				JOptionPane.showMessageDialog(null, "�α���");
//				return;
//			}
			
			
			while(bid !=null) {
				bid=JOptionPane.showInputDialog(null,msg,"�����ϱ�",0,icon,null,"��������");
			String bidprice=(String)bid;
			int start_price=Integer.parseInt(doa.getLblUserPrice().getText().trim().replace("��", "").replace(",", ""));
			
			if (!bidprice.matches("^.*[a-zA-Z��-����-�R]+.*$"))  {
				int temp=Integer.parseInt( bidprice);
			if (Integer.parseInt(bidprice) > start_price )  {
					
					int bidInserted=0;
					AddBidVO abv=new AddBidVO();
					abv.setBid_price(Integer.parseInt(bidprice));
					
					UserDAO_YW u_dao=UserDAO_YW.getInstance();
					try {
						bidInserted= u_dao.insertBidPrice(abv);
					} catch (SQLException e) {
						e.printStackTrace();
					} // catch
					
					JOptionPane.showMessageDialog(null, "���� �����Ǿ����ϴ�.");
					return;
				
			}else {
					JOptionPane.showMessageDialog(null, "������ �����Ͽ����ϴ�. ������ Ȯ�����ּ���.");
				}//end else
			}//end while
			}
			}//end if
	}//actionPerformed
}//class
