package ro.emanuel.DAO;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.emanuel.DBHelper.DBHelper;
import ro.emanuel.POJO.Shipment;
public class ShipmentDao {

	//getById c,returneaza un shipment
		public static Shipment getByShipmentid(int shipmentid) throws SQLException,IOException  {
			Connection conn=DBHelper.getConnection();
			String query="select * from shipments where shipmentid=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, shipmentid);

			ResultSet rs=ps.executeQuery();

			while(rs.next()) {
				Shipment shipment=new Shipment(rs.getInt("shipmentid"),
						rs.getInt("distance"),
						rs.getInt("weight"),
						rs.getString("destination"));
				DBHelper.closeConnection();
				return shipment;
			}
			DBHelper.closeConnection();
			return null;

		}
		// returneaza all shipments
		public static ArrayList<Shipment> getAllShipments() throws SQLException {

			Connection conn=DBHelper.getConnection();
			String query="select * from shipments ";
			PreparedStatement ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			ArrayList<Shipment>shipments=new ArrayList<>();
			while(rs.next()) {
				Shipment shipment=new Shipment(rs.getInt("shipmentid"),
						rs.getInt("distance"),rs.getInt("weight"),rs.getString("destination"));
				shipments.add(shipment);		}
			conn.close();
			return shipments;



		}




		public static void create(Shipment d) throws SQLException {
			ShipmentDao.create(d.getDistance(),d.getWeight(),d.getDestination());
		}


		public static void create( int distance,int weight,String destination) throws SQLException {
			// instructiunea sql
			String insert = "insert into shipments (distance, weight, destination )" + "value(?,?,?)";

			// conexiune
			Connection con = DBHelper.getConnection();

			// prepared statement
			PreparedStatement stmt = con.prepareStatement(insert);
			stmt.setInt(1, distance);
			stmt.setInt(2, weight);
			stmt.setString(3, destination);

			// executie stmt
			stmt.executeUpdate();

			DBHelper.closeConnection();
		}

		public static void update(Shipment s) throws SQLException {

			String update = "update shipments set distance=?, weight=?, destination=? where shipmentid=?";

			// conexiune
			Connection con = DBHelper.getConnection();

			// prepared statement
			PreparedStatement stmt = con.prepareStatement(update);
			stmt.setInt(1, s.getDistance());
			stmt.setInt(2, s.getWeight());
			stmt.setString(3, s.getDestination());
			stmt.setInt(4, s.getShipmentid());

			// executie stmt
			stmt.executeUpdate();

			DBHelper.closeConnection();
		}

		public static void delete(Shipment s) throws SQLException {
			ShipmentDao.delete(s.getShipmentid());
		}

		public static void delete(int shipmentid) throws SQLException {
			String delete = "delete from shipments where shipmentid=?";
			// conexiune
			Connection con = DBHelper.getConnection();

			// prepared statement
			PreparedStatement stmt = con.prepareStatement(delete);
			stmt.setInt(1, shipmentid);

			// executie stmt
			stmt.executeUpdate();

			DBHelper.closeConnection();
		}




}
