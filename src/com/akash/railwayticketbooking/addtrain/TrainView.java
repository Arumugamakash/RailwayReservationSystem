package com.akash.railwayticketbooking.addtrain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.akash.railwayticketbooking.login.LoginView;
import com.akash.railwayticketbooking.model.Train;

public class TrainView {
	Scanner sc = new Scanner(System.in);
	private TrainModel trainModel;

	public TrainView() {
		trainModel = new TrainModel(this);
	}

	public void start() {
		System.out.println("\nFeatures....");
		while (true) {
			System.out.println("\n1.AddTrain\n3.Add Train Routes\n4.Exit\nEnter your choice");
			String choice = sc.nextLine();
			switch (choice) {
			case "1":
				addTrain();
				break;
			case "2":
				getTrain();
				break;
			case "3":
				checkRoutes();
				break;
			case "4":
				System.out.println("ThanYou for using");
				LoginView loginView = new LoginView();
				loginView.start();
			default:
				System.out.println("Invalid choice pls try again");
				start();
			}
		}
	}

	private void addTrain() {
		System.out.println("Enter Train Number");
		int trainNo = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Train Name");
		String trainName = sc.nextLine();
		System.out.println("Enter Depature Time");
		String depature = sc.nextLine();
		System.out.println("Enter arrival Time");
		String arrival = sc.nextLine();
		System.out.println("Enter Total Seats");
		int seats = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Fare Ammount");
		double fare = sc.nextDouble();
		sc.nextLine();
		trainModel.addTrain(trainNo, trainName, depature, arrival, seats, fare);
	}

	private void getTrain() {
		trainModel.getAllTrain();
	}

	private void checkRoutes() {
		System.out.println("Enter your TrainNumber");
		int trainNumer = sc.nextInt();
		sc.nextLine();
		trainModel.checkTrain(trainNumer);
	}

	public void addTrainRoutes(Train train) {
		System.out.println();
		List<String> routes = new ArrayList<String>();
		System.out.println("Enter Your Depature point");
		routes.add(sc.nextLine());
		for (int i = 0; i < 3; i++) {
			System.out.println("Enter your Routes");
			routes.add(sc.nextLine());
		}
		System.out.println("Enter Your Arrival point");
		routes.add(sc.nextLine());
		trainModel.addTrainRoutes(routes);

	}

}
