package com.java.assetmanagement.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.assetmanagement.model.Assets;
import com.java.assetmanagement.dao.AssetManagementServiceImpl;
import com.java.assetmanagement.myexceptions.AssetNotFoundException;
import com.java.assetmanagement.util.DBConnUtil;
import com.java.assetmanagement.util.DBPropertyUtil;

public class AssetManagementServiceImpl implements AssetManagementService {

		Connection connection;
		PreparedStatement pst;
		@Override
		public boolean addAsset(Assets asset) throws ClassNotFoundException {
			 try {
			        String connStr = DBPropertyUtil.connectionString("db");
			        connection = DBConnUtil.getConnection(connStr);
			        String cmd = "INSERT INTO assets (assetId, name, type, serialNumber, purchaseDate, location, status, ownerId) " +
			                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			        pst = connection.prepareStatement(cmd);
			        pst.setInt(1, asset.getAssetId());  
			        pst.setString(2, asset.getName());
			        pst.setString(3, asset.getType());
			        pst.setInt(4, asset.getSerialNumber());
			        pst.setDate(5, (java.sql.Date) asset.getPurchaseDate());
			        pst.setString(6, asset.getLocation());
			        pst.setString(7, asset.getStatus());
			        pst.setInt(8, asset.getOwnerId());

			        int rowsAffected = pst.executeUpdate();
			        return rowsAffected > 0;
			    } catch (SQLException e) {
			        e.printStackTrace();
			        return false; 
			    }
		}
		
		@Override
		public boolean updateAsset(Assets asset) throws ClassNotFoundException,AssetNotFoundException {
		    try {
		    	if (checkAssetExists(asset.getAssetId())) {
		        String connStr = DBPropertyUtil.connectionString("db");
		        connection = DBConnUtil.getConnection(connStr);
		        String cmd = "UPDATE assets "+
		        				"SET name = ?, type = ?, serialNumber = ?, purchaseDate = ?, location = ?, status = ?, ownerId = ? " +
		                     "WHERE assetId = ?";
		        pst = connection.prepareStatement(cmd);
		        pst.setString(1, asset.getName());
		        pst.setString(2, asset.getType());
		        pst.setInt(3, asset.getSerialNumber());
		        pst.setDate(4, (java.sql.Date) asset.getPurchaseDate());
		        pst.setString(5, asset.getLocation());
		        pst.setString(6, asset.getStatus());
		        pst.setInt(7, asset.getOwnerId());
		        pst.setInt(8, asset.getAssetId());
		        pst.executeUpdate();
		        return true;
		    	}
		        else{
		    		throw new AssetNotFoundException("Asset is not found");
		        }
		     }
		  catch (SQLException e) {
		        e.printStackTrace();
		        return false;
		    }   
	}

		@Override
		public boolean deleteAsset(int assetId) throws ClassNotFoundException,AssetNotFoundException{
		    try {
		    	if (!checkAssetExists(assetId)) {
		    		throw new AssetNotFoundException("Asset is not found");
		        }
		        String connStr = DBPropertyUtil.connectionString("db");
		        connection = DBConnUtil.getConnection(connStr);
		        String cmd = "DELETE FROM assets WHERE assetId = ?";
		        pst = connection.prepareStatement(cmd);
		        pst.setInt(1, assetId);
		        pst.executeUpdate();
		        return true;
		        
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return false;
		    }catch (AssetNotFoundException e) {
		        e.printStackTrace();
		        return false;
		    }
		    
		    
		}


		@Override
		public boolean allocateAsset(int assetId, int employeeId, String allocationDate) throws ClassNotFoundException,AssetNotFoundException{
		    try {
		    	if (!checkAssetExists(assetId)) {
		    		throw new AssetNotFoundException("Asset is not found");
		        }
		        String connStr = DBPropertyUtil.connectionString("db");
		        connection = DBConnUtil.getConnection(connStr);
		        String cmd = "INSERT INTO assetAllocations (assetId, employeeId, allocationDate) VALUES (?, ?, ?)";
		        pst = connection.prepareStatement(cmd);
		        pst.setInt(1, assetId);
		        pst.setInt(2, employeeId);
		        pst.setDate(3, java.sql.Date.valueOf(allocationDate));
		        pst.executeUpdate();
		        return true;
		       
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return false;
		    }
		}


		@Override
		public boolean deallocateAsset(int assetId, int employeeId, String returnDate) throws ClassNotFoundException, AssetNotFoundException {
		    try {
		    	if (!checkAssetExists(assetId)) {
		    		throw new AssetNotFoundException("Asset is not found");
		        }
		        String connStr = DBPropertyUtil.connectionString("db");
		        connection = DBConnUtil.getConnection(connStr);
		        String cmd = "UPDATE assetAllocations SET returnDate = ? WHERE assetId = ? AND employeeId = ?";
		        pst = connection.prepareStatement(cmd);
		        pst.setDate(1, java.sql.Date.valueOf(returnDate));
		        pst.setInt(2, assetId);
		        pst.setInt(3, employeeId);
		        pst.executeUpdate();
		        return true;
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return false;
		    }
		}


		@Override
		public boolean performMaintenance(int assetId, String maintenanceDate, String description, double cost) throws ClassNotFoundException, SQLException,AssetNotFoundException {
		    try {
		        String connStr = DBPropertyUtil.connectionString("db");
		        connection = DBConnUtil.getConnection(connStr);

		        String cmd = "INSERT INTO maintenanceRecords (assetId, maintenanceDate, description, cost) VALUES (?, ?, ?, ?)";
		        pst = connection.prepareStatement(cmd);
		        pst.setInt(1, assetId);
		        pst.setDate(2, java.sql.Date.valueOf(maintenanceDate));
		        pst.setString(3, description);
		        pst.setDouble(4, cost);

		        int rowsAffected = pst.executeUpdate();
		        return rowsAffected > 0;
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return false;
		    }
		}

		@Override
		public boolean reserveAsset(int assetId, int employeeId, String reservationDate, String startDate, String endDate) throws ClassNotFoundException,AssetNotFoundException {
		    try {
		    	if (!checkAssetExists(assetId)) {
		    		throw new AssetNotFoundException("Asset is not found");
		        }
		        String connStr = DBPropertyUtil.connectionString("db");
		        connection = DBConnUtil.getConnection(connStr);
		        String cmd = "INSERT INTO reservations (assetId, employeeId, reservationDate, startDate, endDate, status) VALUES (?, ?, ?, ?, ?, ?)";
		        pst = connection.prepareStatement(cmd);
		        pst.setInt(1, assetId);
		        pst.setInt(2, employeeId);
		        pst.setDate(3, java.sql.Date.valueOf(reservationDate));
		        pst.setDate(4, java.sql.Date.valueOf(startDate));
		        pst.setDate(5, java.sql.Date.valueOf(endDate));
		        pst.setString(6, "Confirmed");
		        pst.executeUpdate();
		        return true;
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return false;
		    }
		}

		@Override
		public boolean withdrawReservation(int reservationId) throws ClassNotFoundException {
		    try {
		        String connStr = DBPropertyUtil.connectionString("db");
		        connection = DBConnUtil.getConnection(connStr);
		        String cmd = "DELETE FROM reservations WHERE reservationId = ?";
		        pst = connection.prepareStatement(cmd);
		        pst.setInt(1, reservationId);
		        int rowsAffected = pst.executeUpdate();
		        return rowsAffected > 0;
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return false;
		    }
		}


		@Override
		public boolean checkAssetExists(int assetId) throws ClassNotFoundException, SQLException, ClassNotFoundException {
			try {
		    	 String connStr = DBPropertyUtil.connectionString("db");
			    connection = DBConnUtil.getConnection(connStr);
		        String cmd = "SELECT COUNT(*) FROM assets WHERE assetId = ?";
		        pst = connection.prepareStatement(cmd);
		        pst.setInt(1, assetId);
		        ResultSet rs = pst.executeQuery();
		        if (rs.next() && rs.getInt(1) > 0) {
		            return true;
		        } else {
		            return false;
		        }
			}
			finally {
		        if (pst != null) {
		            pst.close();
		        }
		}
			}

		@Override
		public boolean checkAssetMaintenance(int assetId) throws ClassNotFoundException, SQLException {
			try {
		        // Establish database connection
		        String connStr = DBPropertyUtil.connectionString("db");
		        connection = DBConnUtil.getConnection(connStr);
		        
		        // SQL query to check maintenance records for the asset within the last two years
		        String cmd = "SELECT COUNT(*) FROM maintenanceRecords WHERE assetId = ? AND maintenanceDate >= DATE_SUB(CURDATE(), INTERVAL 2 YEAR)";
		        pst = connection.prepareStatement(cmd);
		        pst.setInt(1, assetId);
		        ResultSet rs = pst.executeQuery();

		        // If there are maintenance records within the last two years, set isMaintained to true
		        if (rs.next()) {
		            int count = rs.getInt(1);
		            if (count > 0) {
		                return true;
		            }
		        }
		        else{
		        	return false;
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
			return false; 
		}

		@Override
		public boolean assetAdd(Assets asset) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean AssetReserveMain(int asset_Id, int employeeId, String reservationDate, String startDate,
				String endDate) {
			// TODO Auto-generated method stub
			return false;
		}

		
	}
	
	

