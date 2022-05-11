import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdateMenu extends JPanel implements ActionListener {

	JLabel labelupdate = new JLabel("Update Menu");
	JLabel labelkode = new JLabel("Input Kode Menu :");
	JTextField kode = new JTextField();
	JLabel hargaterbaru = new JLabel("Harga Menu Terbaru");
	JTextField hargater = new JTextField();
	JLabel stockterbaru = new JLabel("Stock Menu Terbaru");
	JTextField stockter = new JTextField();
	JButton Submit = new JButton("Submit");
	JLabel Ket1 = new JLabel("");
	
	DataBase db = new DataBase();
	
public UpdateMenu() {
		
//		init();
		setLayout(null);
		
		add(labelupdate);
		labelupdate.setBounds(210, 15, 150, 80);
		
		add(labelkode);
		labelkode.setBounds(80, 67, 150, 20);

		add(kode);
		kode.setBounds(210, 70, 150, 20);
		
		/////////////////////////////////////////////////////////////////////////
		
		add(hargaterbaru);
		hargaterbaru.setBounds(80, 150, 150, 80);
		
		add(hargater);
		hargater.setBounds(210, 183, 150, 20);
		
		add(stockterbaru);
		stockterbaru.setBounds(80, 180, 150, 80);
		
		add(stockter);
		stockter.setBounds(210, 213, 150, 20);
		
		add(Submit);
		Submit.setBounds(152, 290, 150, 40);
		Submit.addActionListener(this);
	}

@Override
	public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if (e.getSource() == Submit) {
		String id = kode.getText();
		String Hater = hargater.getText();
		String Stoter = stockter.getText();
		Boolean oho1 = null, oho2 = null, oho3 = null;
		
		if (Hater.length() < 4 ) {
			Ket1.setText("Harga Menu minimal terdiri dari 4 huruf digit");
		}else {
			oho1 = true;
		}
		
		if (Stoter.length() < 1 ||Stoter.equals("0") ) {
			Ket1.setText("Stock Menu minimal terdiri dari 1 huruf digit");
		}else {
			oho2 = true;
		}
		
		if (id.length() == 6) {
			db.selectmenu(id);
			oho3 = true;
		}
		
		if (oho1==true && oho2==true && oho3==true) {
			
			System.out.println(id);
			System.out.println(Hater);
			System.out.println(Stoter);
			db.updatemenu(id, Hater, Stoter);
		}
		
		
	}
}
	
}
