package com.java.assetmanagement.main;

import java.util.Scanner;

import com.java.assetmanagement.dao.AssetManagementServiceImpl;

public class WithdrawReservationMain {
	
	 public static void main(String[] args) {
	        try (Scanner sc = new Scanner(System.in)) {
				AssetManagementServiceImpl assetService = new AssetManagementServiceImpl();

				System.out.println("Enter reservation ID to withdraw:");
				int reservation_Id = sc.nextInt();

				try {
				    boolean withdrawn = assetService.withdrawReservation(reservation_Id);
				    if (withdrawn) {
				        System.out.println("Reservation withdrawn successfully");
				    } else {
				        System.out.println("Failed to withdraw reservation,Invalid ReservationId");
				    }
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	    }
	
}
