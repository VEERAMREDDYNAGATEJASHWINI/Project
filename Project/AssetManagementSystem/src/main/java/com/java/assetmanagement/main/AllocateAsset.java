package com.java.assetmanagement.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.assetmanagement.dao.AssetManagementServiceImpl;
import com.java.assetmanagement.myexceptions.AssetNotFoundException;
import com.java.assetmanagement.myexceptions.AssetNotMaintainException;

public class AllocateAsset {
	public static void main(String[] args) throws AssetNotMaintainException {
        Scanner scanner = new Scanner(System.in);
        AssetManagementServiceImpl assetService = new AssetManagementServiceImpl();

        System.out.println("Enter asset ID to allocate:");
        int assetId = scanner.nextInt();

        try {
            if (assetService.checkAssetExists(assetId)) {
            	if (!assetService.checkAssetMaintenance(assetId)) {
                    throw new AssetNotFoundException("Asset with ID " + assetId + " requires maintenance but has not been maintained for two years.");
                }
            	System.out.println("Enter employee ID to allocate:");
                int employeeId = scanner.nextInt();
                System.out.println("Enter allocation date :");
                String allocationDate = scanner.next();
                boolean allocated = assetService.allocateAsset(assetId, employeeId, allocationDate);
                if (allocated) {
                    System.out.println("Asset allocated successfully");
                } 
            }
            else {
            	throw new AssetNotFoundException("Allocate assetS function cannot be performed...");
            }
        } catch (ClassNotFoundException e) {
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
