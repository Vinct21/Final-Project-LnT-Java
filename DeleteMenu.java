import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeleteMenu extends JPanel implements ActionListener{

	JLabel labeldelete = new JLabel("Delete Menu");
	JLabel labelkode = new JLabel("Input Kode Menu :");
	JTextField kode = new JTextField();
	JButton Delete = new JButton("Delete");
	
	DataBase db = new DataBase();
	
public DeleteMenu() {
		
//		init();
		setLayout(null);
		
		add(labeldelete);
		labeldelete.setBounds(190, 15, 150, 80);
		
		add(labelkode);
		labelkode.setBounds(80, 67, 150, 20);

		add(kode);
		kode.setBounds(210, 70, 150, 20);
		
		
		/////////////////////////////////////////////////////////////////////////
		
		add(Delete);
		Delete.setBounds(152, 290, 150, 40);
		Delete.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String id = kode.getText();
		if (id.length() == 6) {
			db.deletemenu(id);
		}
}
	
}
