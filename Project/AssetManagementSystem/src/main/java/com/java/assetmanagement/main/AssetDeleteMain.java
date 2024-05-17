package com.java.assetmanagement.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.assetmanagement.dao.AssetManagementServiceImpl;
import com.java.assetmanagement.myexceptions.AssetNotFoundException;

public class AssetDeleteMain {

	public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        AssetManagementServiceImpl assetService = new AssetManagementServiceImpl();

        System.out.println("Enter asset ID to delete:");
        int asset_Id = scanner.nextInt();

        try {
        	if (assetService.checkAssetExists(asset_Id)) {
            boolean deleted = assetService.deleteAsset(asset_Id);
            if (deleted) {
                System.out.println("Asset deleted successfully.");
            } 
          }
        	else {
        		throw new AssetNotFoundException("Delete function cannot be performed...");
        	}

        }
        catch (ClassNotFoundException e) {
            System.out.println("Error: Class not found.");
        }
        catch (SQLException e) {
            System.out.println("Error executing SQL query");
        }
        catch (AssetNotFoundException e) {
        	System.out.println("Asset is not Found. "+e.getMessage());
        }
        finally {
            scanner.close();
        }
    }

	
}
