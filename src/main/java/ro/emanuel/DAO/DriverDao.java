package ro.emanuel.DAO;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.emanuel.DBHelper.DBHelper;
import ro.emanuel.POJO.Driver;
public class DriverDao {

	//getById ,returneaza un driver
		public static Driver getByDriverid(int driverid) throws SQLException,IOException  {
			Connection conn=DBHelper.getConnection();
			String query="select * from drivers where driverid=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, driverid);

			ResultSet rs=ps.executeQuery();

			while(rs.next()) {
				Driver driver=new Driver(rs.getInt("driverid"),
						rs.getString("name"),
						rs.getInt("age"),
						rs.getInt("hours"));
				DBHelper.closeConnection();
				return driver;
			}
			DBHelper.closeConnection();
			return null;

		}
		// returneaza all drivers
		public static ArrayList<Driver> getAllDrivers() throws SQLException {

			Connection conn=DBHelper.getConnection();
			String query="select * from drivers ";
			PreparedStatement ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			ArrayList<Driver>drivers=new ArrayList<>();
			while(rs.next()) {
				Driver driver=new Driver(rs.getInt("driverid"),rs.getString("name"),
						rs.getInt("age"),rs.getInt("hours"));
				drivers.add(driver);		}
			conn.close();
			return drivers;



		}




		public static void create(Driver d) throws SQLException {
			DriverDao.create(d.getName(),d.getAge(),d.getHours());
		}


		public static void create(String name, int age,int hours) throws SQLException {
			// instructiunea sql
			String insert = "insert into drivers (name, age, hours)" + "value(?,?,?)";

			// conexiune
			Connection con = DBHelper.getConnection();

			// prepared statement
			PreparedStatement stmt = con.prepareStatement(insert);
			stmt.setString(1, name);
			stmt.setInt(2, age);
			stmt.setInt(3, hours);

			// executie stmt
			stmt.executeUpdate();

			DBHelper.closeConnection();
		}

		public static void update(Driver d) throws SQLException {

			String update = "update drivers set name=?, age=?, hours=? where driverid=?";

			// conexiune
			Connection con = DBHelper.getConnection();

			// prepared statement
			PreparedStatement stmt = con.prepareStatement(update);
			stmt.setString(1, d.getName());
			stmt.setInt(2, d.getAge());
			stmt.setInt(3, d.getHours());
			stmt.setInt(4, d.getDriverid());

			// executie stmt
			stmt.executeUpdate();

			DBHelper.closeConnection();
		}
			//Delete 
		public static void delete(Driver d) throws SQLException {
			DriverDao.delete(d.getDriverid());
		}

		public static void delete(int driverid) throws SQLException {
			String delete = "delete from drivers where driverid=?";
			// conexiune
			Connection con = DBHelper.getConnection();

			// prepared statement
			PreparedStatement stmt = con.prepareStatement(delete);
			stmt.setInt(1, driverid);

			// executie stmt
			stmt.executeUpdate();

			DBHelper.closeConnection();
		}




}
