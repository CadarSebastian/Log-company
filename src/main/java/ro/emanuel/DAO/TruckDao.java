package ro.emanuel.DAO;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.emanuel.DBHelper.DBHelper;
import ro.emanuel.POJO.Truck;
public class TruckDao {

	//getById c,returneaza un truck
		public static Truck getByTruckid(int truckid) throws SQLException,IOException  {
			Connection conn=DBHelper.getConnection();
			String query="select * from trucks where truckid=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, truckid);

			ResultSet rs=ps.executeQuery();

			while(rs.next()) {
				Truck truck=new Truck(rs.getInt("truckid"),
						rs.getString("brand"),
						rs.getInt("capacity"),
						rs.getInt("accidents"));
				DBHelper.closeConnection();
				return truck;
			}
			DBHelper.closeConnection();
			return null;

		}
		// returneaza all trucks
		public static ArrayList<Truck> getAllTrucks() throws SQLException {

			Connection conn=DBHelper.getConnection();
			String query="select * from trucks ";
			PreparedStatement ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			ArrayList<Truck>trucks=new ArrayList<>();
			while(rs.next()) {
				Truck truck=new Truck(rs.getInt("truckid"),rs.getString("brand"),
						rs.getInt("capacity"),rs.getInt("accidents"));
				trucks.add(truck);		}
			conn.close();
			return trucks;



		}




		public static void create(Truck d) throws SQLException {
			TruckDao.create(d.getBrand(),d.getCapacity(),d.getAccidents());
		}


		public static void create(String brand, int capacity,int accidents) throws SQLException {
			// instructiunea sql
			String insert = "insert into trucks (brand, capacity, accidents)" + "value(?,?,?)";

			// conexiune
			Connection con = DBHelper.getConnection();

			// prepared statement
			PreparedStatement stmt = con.prepareStatement(insert);
			stmt.setString(1, brand);
			stmt.setInt(2, capacity);
			stmt.setInt(3, accidents);

			// executie stmt
			stmt.executeUpdate();

			DBHelper.closeConnection();
		}

		public static void update(Truck t) throws SQLException {

			String update = "update trucks set brand=?, capacity=?, accidents=? where truckid=?";

			// conexiune
			Connection con = DBHelper.getConnection();

			// prepared statement
			PreparedStatement stmt = con.prepareStatement(update);
			stmt.setString(1, t.getBrand());
			stmt.setInt(2, t.getCapacity());
			stmt.setInt(3, t.getAccidents());
			stmt.setInt(4, t.getTruckid());

			// executie stmt
			stmt.executeUpdate();

			DBHelper.closeConnection();
		}

		public static void delete(Truck t) throws SQLException {
			TruckDao.delete(t.getTruckid());
		}

		public static void delete(int truckid) throws SQLException {
			String delete = "delete from trucks where truckid=?";
			// conexiune
			Connection con = DBHelper.getConnection();

			// prepared statement
			PreparedStatement stmt = con.prepareStatement(delete);
			stmt.setInt(1, truckid);

			// executie stmt
			stmt.executeUpdate();

			DBHelper.closeConnection();
		}




}
