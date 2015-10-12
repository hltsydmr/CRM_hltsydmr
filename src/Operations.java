import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Operations {

	public void addCustomer(Customer customer){
		
		try{
		
			Class.forName(DbSettings.driver);
			String url = DbSettings.protocol + DbSettings.dbName +";create=true";
			Connection conn = DriverManager.getConnection(url, DbSettings.username, DbSettings.password);
			String addSql = "INSERT INTO tableCustomer (name,surname,company,department,position,phone,email) VALUES (?,?,?,?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(addSql);
			ps.setString(1, customer.getName().toLowerCase());
			ps.setString(2, customer.getSurname().toLowerCase());
			ps.setString(3, customer.getCompany());
			ps.setString(4, customer.getDepartment());
			ps.setString(5, customer.getPosition());
			ps.setString(6, customer.getPhone());
			ps.setString(7, customer.getEmail());
			ps.executeUpdate();
			ps.close();
			conn.close();
			System.out.println(customer.getName().substring(0, 20));
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public List<Customer> listCustomers(){
		
		List<Customer> ListOfCustomers = new ArrayList<Customer>();
		
		try{
			
			Class.forName(DbSettings.driver);
			String url = DbSettings.protocol + DbSettings.dbName +";create=true";
			Connection conn = DriverManager.getConnection(url, DbSettings.username, DbSettings.password);
			
			String listSql = "SELECT * FROM tableCustomer";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(listSql);
			
			while(rs.next()){
				Customer cst = new Customer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
				ListOfCustomers.add(cst);
			}
			statement.close();
			conn.close();
		}
		
		catch(Exception e){
			ListOfCustomers = null;
			e.printStackTrace();
		}
		
		return ListOfCustomers;
		
	}
	
	public List<Customer> findCustomer(String key){
		
		List<Customer> findList = new ArrayList<Customer>();
		
		try{
			
			Class.forName(DbSettings.driver);
			String url = DbSettings.protocol + DbSettings.dbName +";create=true";
			Connection conn = DriverManager.getConnection(url, DbSettings.username, DbSettings.password);
			//key="%"+key+"%";
			System.out.println(key);
			String findSql = "SELECT * FROM tableCustomer WHERE name LIKE '%"+key.toLowerCase()+"%' OR surname LIKE '%"+key.toLowerCase()+"%'";// AND surname=?
			System.out.println(key);
			PreparedStatement ps = conn.prepareStatement(findSql);
			//ps.setString(1, key);
			//ps.setString(2, key.trim());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Customer c = new Customer(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
				findList.add(c);
			}
		}
		
		catch(Exception e){
			System.out.println("jhgfd");
			findList = null;
			e.printStackTrace();
		}
		
		return findList;
		
	}
	
	public Customer getCustomer(String id){
		
		Customer c=null;
		try{
		Class.forName(DbSettings.driver);
		String url = DbSettings.protocol + DbSettings.dbName +";create=true";
		Connection conn = DriverManager.getConnection(url, DbSettings.username, DbSettings.password);
		
		String findSql = "SELECT * FROM tableCustomer WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(findSql);
		ps.setInt(1, Integer.parseInt(id));
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
		c = new Customer(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
		System.out.println(c.getName()+","+c.getId());
		}
		}
	
		catch(Exception e){
			e.printStackTrace();
			c=null;
		}
	
		return c;
	}
	
	public void delete(String id){
		try{
			Class.forName(DbSettings.driver);
			String url = DbSettings.protocol + DbSettings.dbName +";create=true";
			Connection conn = DriverManager.getConnection(url, DbSettings.username, DbSettings.password);
			
			String findSql = "DELETE FROM tableCustomer WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(findSql);
			ps.setInt(1, Integer.parseInt(id));
			ps.execute();
			
			}
		
			catch(Exception e){
				e.printStackTrace();
			}
	}
	
}
