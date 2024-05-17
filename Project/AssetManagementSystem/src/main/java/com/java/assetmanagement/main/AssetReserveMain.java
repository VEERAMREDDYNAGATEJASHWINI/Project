package com.java.assetmanagement.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.assetmanagement.dao.AssetManagementServiceImpl;
import com.java.assetmanagement.myexceptions.AssetNotFoundException;
import com.java.assetmanagement.myexceptions.AssetNotMaintainException;

public class AssetReserveMain {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AssetManagementServiceImpl assetService = new AssetManagementServiceImpl();

        System.out.println("Enter asset ID to reserve:");
        int asset_Id = scanner.nextInt();

        try {
            if (assetService.checkAssetExists(asset_Id)) {
            	if (!assetService.checkAssetMaintenance(asset_Id)) {
                    throw new AssetNotMaintainException();
                }
                System.out.println("Enter employee ID to reserve:");
                int employeeId = scanner.nextInt();
                scanner.nextLine(); 
                
                System.out.println("Enter reservation date:");
                String reservationDate = scanner.nextLine().trim();

                System.out.println("Enter start date :");
                String startDate = scanner.nextLine().trim();

                System.out.println("Enter end date :");
                String endDate = scanner.nextLine().trim();

                boolean reserved = assetService.AssetReserveMain(asset_Id, employeeId, reservationDate, startDate, endDate);
                if (reserved) {
                    System.out.println("Asset reserved successfully");
                } else {
                    System.out.println("Failed to reserve asset");
                }
            } else {
            	throw new AssetNotFoundException("Reserve function cannot be performed... ");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Class not found.");
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        } 
        catch (AssetNotFoundException e) {
            System.out.println("Asset not found. "+e.getMessage());
        }
        catch (AssetNotMaintainException e) {
        	System.out.println("Asset is not Maintained. "+e.getMessage());
        }finally {
            scanner.close();
        }
    }

}
