package com.java.assetmanagement.main;

import java.sql.Date;

import java.util.Scanner;
import com.java.assetmanagement.dao.AssetManagementService;
import com.java.assetmanagement.dao.AssetManagementServiceImpl;
import com.java.assetmanagement.model.Assets;

public class AssetAddMain {
	public static void main(String[] args) throws ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        AssetManagementService assetService = new AssetManagementServiceImpl();

        System.out.println("Enter asset details:");
        System.out.print("Asset ID: ");
        int asset_Id = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Type: ");
        String type = sc.nextLine();
        System.out.print("Serial Number: ");
        int serialNumber = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Purchase Date: ");
        String purchaseDate = sc.nextLine();
        System.out.print("Location: ");
        String location = sc.nextLine();
        System.out.print("Status: ");
        String status = sc.nextLine();
        System.out.print("Owner ID: ");
        int owner_Id = sc.nextInt();
        sc.nextLine(); 

        Assets asset = new Assets(asset_Id, name, type, serialNumber, Date.valueOf(purchaseDate), location, status, owner_Id);
        boolean added = assetService.assetAdd(asset);
		if (added) {
		    System.out.println("Asset added successfully.");
		} else {
		    System.out.println("Failed to add asset.");
		}

        
    }
}
