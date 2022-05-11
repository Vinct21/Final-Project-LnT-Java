import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ViewMenu extends JPanel implements ActionListener{

	JLabel labelview = new JLabel("View Menu");
	JLabel labelkode = new JLabel("Input Kode Menu :");
	JLabel labelnama = new JLabel("Nama Menu");
	JLabel labelharga = new JLabel("Harga Menu");
	JLabel labelstock = new JLabel("Stock Menu");
	JTextField kode = new JTextField();
	JButton Search = new JButton("Search");
	
	DataBase db = new DataBase();
	
	public ViewMenu() {
		
//		init();
		setLayout(null);
		
		add(labelview);
		labelview.setBounds(190, 15, 150, 80);
		
		add(labelkode);
		labelkode.setBounds(38, 67, 150, 20);

		add(kode);
		kode.setBounds(150, 70, 150, 20);
		
		add(Search);
		Search.setBounds(310, 70, 79, 20);
		Search.addActionListener(this);
		
		//////////////////////////////////////////////////////////////////////////
		
		add(labelnama);
		labelnama.setBounds(190, 90, 150, 80);
		
		add(labelharga);
		labelharga.setBounds(190, 140, 150, 80);
		
		add(labelstock);
		labelstock.setBounds(190, 190, 150, 80);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == Search) {
			String id = kode.getText();
			
			if (id.length() == 6) {
				db.selectmenu(id);
			}
		}
	}

	
	
}
