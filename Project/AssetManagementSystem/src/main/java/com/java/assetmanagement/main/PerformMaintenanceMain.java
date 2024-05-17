package com.java.assetmanagement.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.assetmanagement.dao.AssetManagementServiceImpl;
import com.java.assetmanagement.myexceptions.AssetNotFoundException;

public class PerformMaintenanceMain {
	
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        AssetManagementServiceImpl assetService = new AssetManagementServiceImpl();

	        System.out.println("Perform Maintenance:");
	        System.out.println("Enter asset ID:");
	        int asset_Id = scanner.nextInt();
	        scanner.nextLine();
	        try {
	        if(assetService.checkAssetExists(asset_Id)) {
	        System.out.println("Enter maintenance date :");
	        String maintenanceDate = scanner.nextLine().trim();
	        
	        System.out.println("Enter maintenance description:");
	        String description = scanner.nextLine().trim();
	        
	        System.out.println("Enter maintenance cost:");
	        double cost = scanner.nextDouble();

	            boolean maintenancePerformed = assetService.performMaintenance(asset_Id, maintenanceDate, description, cost);
	            if (maintenancePerformed) {
	                System.out.println("Maintenance recorded successfully.");
	            } else {
	                System.out.println("Failed to record maintenance.");
	            }
	        }
	        else {
	        	 throw new AssetNotFoundException("Maintenance function cannot be performed... "); 
	        }
	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println("Error performing maintenance: " + e.getMessage());
	        }
	        catch (AssetNotFoundException e) {
	        	System.out.println("Asset is not Found. "+e.getMessage());
	        }
	        finally {
	        	scanner.close();
	        }
	        
	    }
	
}
