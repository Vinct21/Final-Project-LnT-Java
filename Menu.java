import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import babi.dbConnection;

public class Menu extends JFrame {
	
	JTabbedPane tab = new JTabbedPane();
	
	JPanel insert = new insertMenu();
	JPanel view = new ViewMenu();
	JPanel update = new UpdateMenu();
	JPanel delete = new DeleteMenu();
	
	Random ran = new Random();
	String id;
		
	public Menu(){
		
		tab.add(insert,"Insert Menu");
		tab.add(view,"View Menu");
		tab.add(update,"Update Menu");
		tab.add(delete,"Delete Menu");
		
		add(tab);
		
		setTitle("Database PT. Pudding");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		

		
		
	}

	DataBase db = new DataBase();
		
	
	public static void main(String[] args) {
		new Menu();
	}

	
	
	
}
