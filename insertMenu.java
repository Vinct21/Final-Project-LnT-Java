import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.sql.*;
import java.sql.DriverManager;
//AB336

public class insertMenu extends JPanel implements ActionListener{
	Random ran = new Random();
	JLabel labelinsert, labelnama, labelharga, labelstock, labelkode, Ket1;
	JTextField NamaText, HargaText, StockText;
	JButton Submit;
	
	DataBase db = new DataBase();


	
	public insertMenu() {
		in();
		setLayout(null);
		
		add(labelinsert);
		labelinsert.setBounds(190, 15, 150, 80);
		
		
		add(labelnama);
		labelnama.setBounds(175, 70, 150, 80);
		
		add(NamaText);
		NamaText.setBounds(152, 120, 150, 20);
		
		add(labelharga);
		labelharga.setBounds(175, 120, 150, 80);
		
		add(HargaText);
		HargaText.setBounds(152, 170, 150, 20);
		
		add(labelstock);
		labelstock.setBounds(175, 170, 150, 80);
		
		add(StockText);
		StockText.setBounds(152, 220, 150, 20);
		
		add(Submit);
		Submit.setBounds(152, 270, 150, 60);
		Submit.addActionListener(this);
		
		add(Ket1);
		Ket1.setBounds(116,240,500,20);
		
		add(labelkode);
		labelkode.setBounds(152, 370, 500, 20);
		
			
	}

	public void in() {
		labelinsert = new JLabel("Insert Menu");
		labelnama = new JLabel("Input Nama Menu");
		labelharga = new JLabel("Input Harga Menu");
		labelstock = new JLabel("Input Stock Menu");
		labelkode = new JLabel("");
		Ket1 = new JLabel("");
		NamaText = new JTextField();
		HargaText = new JTextField();
		StockText = new JTextField();
		Submit = new JButton("Submit");
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Submit) {
			int No = 0;
			String NamMenu = NamaText.getText();
			String HarMenu = HargaText.getText();
			String StoMenu = StockText.getText();
			String id = generateID();
			Boolean oho1 = null, oho2 = null, oho3 = null;
			
			
			if (NamMenu.length() < 3 ) {
				Ket1.setText("Nama Menu minimal terdiri dari 3 huruf alfabet");
			}else {
				oho1 = true;
			}
			
			if (HarMenu.length() < 4 ) {
				Ket1.setText("Harga Menu minimal terdiri dari 4 huruf digit");
			}else {
				oho2 = true;
			}
			
			if (StoMenu.length() < 1 ||StoMenu.equals("0") ) {
				Ket1.setText("Harga Menu minimal terdiri dari 1 huruf digit");
			}else {
				oho3 = true;
			}
			
			if (oho1==true && oho2==true && oho3==true) {
				labelkode.setText("Kode: " + id);
				System.out.println(id);
				System.out.println(NamMenu);
				System.out.println(HarMenu);
				System.out.println(StoMenu);
				db.insertmenu(No, id, NamMenu, HarMenu, StoMenu);
			}
			
		}
		
	}

	String generateID() {
        String id="";
        char r = (char) (ran.nextInt(26) + 'A');
        char ra = (char) (ran.nextInt(26) + 'A');
        id+= r;
        id+= ra;
        id+= "-";
        for(int a=0;a<3;a++) id+=(int)(Math.random()*10);
        
  
        return id;
    }
	
	
}
