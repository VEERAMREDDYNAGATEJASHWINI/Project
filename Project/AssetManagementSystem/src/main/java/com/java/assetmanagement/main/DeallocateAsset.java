package com.java.assetmanagement.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.assetmanagement.dao.AssetManagementServiceImpl;
import com.java.assetmanagement.myexceptions.AssetNotFoundException;

public class DeallocateAsset {
	
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        AssetManagementServiceImpl assetService = new AssetManagementServiceImpl();

	        System.out.println("Enter asset ID to deallocate:");
	        int assetId = scanner.nextInt();

	        try {
	            if (assetService.checkAssetExists(assetId)) {
	                System.out.println("Enter employee ID:");
	                int employeeId = scanner.nextInt();
	                System.out.println("Enter return date:");
	                String returnDate = scanner.next();
	                boolean deallocated = assetService.deallocateAsset(assetId, employeeId, returnDate);
	                if (deallocated) {
	                    System.out.println("Asset deallocated successfully");
	                } 
	            } else {
	                throw new AssetNotFoundException("Deallocate function cannot be performed... ");
	            }
	        } catch (ClassNotFoundException e) {
	            System.out.println("Error: Class not found.");
	        } catch (SQLException e) {
	            System.out.println("Error executing SQL query: " + e.getMessage());
	        } catch (AssetNotFoundException e) {
	            System.out.println("Asset not found "+e.getMessage());
	        } finally {
	            scanner.close();
	        }
	    }
	
}
