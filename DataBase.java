import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class DataBase extends javax.swing.JFrame{

	Connection con;
	Statement st;
	PreparedStatement ps;
	ResultSet rs;

	
	
	public DataBase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pt. pudding","root","");
			st = con.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void insertmenu(int No, String id, String NamMenu, String HarMenu, String StoMenu) {
		try {
			ps =  con.prepareStatement("insert into datamenu values (?,?,?,?,?);");
			ps.setInt(1, 0);
			ps.setString(2, id);
			ps.setString(3, NamMenu);
			ps.setString(4, HarMenu);
			ps.setString(5, StoMenu);
			ps.execute();
		System.out.println("Berhasil");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	public ResultSet selectmenu(String id) {
		try {
			ps = con.prepareStatement("Select * from user");
			rs = ps.executeQuery();
			System.out.println("Berhasil");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return rs;
	}
	


public void updatemenu(String id, String HarMenu, String StoMenu) {
		
		try {
			ps = con.prepareStatement("update datamenu set Harga = ?, Stock = ? where Kode = ?");
			ps.setString(1, HarMenu);
			ps.setString(2, StoMenu);
			ps.setString(3, id);
			ps.execute();
			System.out.println("Berhasil");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Gagal");
		}
	}
	
public void deletemenu(String id) {
	try {
		ps = con.prepareStatement("Delete from datamenu where Kode = ?");
		ps.setString(1, id);
		ps.execute();
		System.out.println("Berhasil");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
