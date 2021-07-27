package com.mindtree.companyclientapplication.client;

import java.util.Scanner;
import java.util.Set;

import com.mindtree.companyclientapplication.entity.Client;
import com.mindtree.companyclientapplication.entity.Company;
import com.mindtree.companyclientapplication.exception.CompanyClientApplicationException;
import com.mindtree.companyclientapplication.exception.ServiceException;
import com.mindtree.companyclientapplication.service.ClientService;
import com.mindtree.companyclientapplication.service.service.ClientServiceImpl;

public class CompanyClientApplication {

	private static Scanner scanner = new Scanner(System.in);
	private static ClientService service = new ClientServiceImpl();

	public static void main(String[] args) {
		byte choice = 0;
		do {
			System.out.println("1 :add Client");
			System.out.println("2 :Get Clients By Company Id");
			System.out.println("3 :Update Client Budget By Client Id");
			System.out.println("4 :Exit");
			System.out.println("Enter the choice");
			choice = scanner.nextByte();
			try {
				switch (choice) {
				case 1:
					Client client = addClient();
					try {
						client = service.addClient(client);
					} catch (ServiceException e) {
						throw new CompanyClientApplicationException(e);
					}
					System.out.println("Client id :" + client.getClientId() + ", Client Name :" + client.getClientName()
							+ ", Client Budget :" + client.getClientBudget() + ", Company id :"
							+ client.getCompany().getCompanyId());
					break;

				case 2:
					System.out.println("Enter the company id");
					int id = scanner.nextInt();
					Set<Client> clientSet;
					try {
						clientSet = service.getClientsByCompanyId(id);
					} catch (ServiceException e) {
						throw new CompanyClientApplicationException(e);
					}
					displayClientsByCompanyId(clientSet);
					break;
				case 3:
					System.out.println("Enter the Client Id");
					int clientId = scanner.nextInt();
					System.out.println("Enter the Budget");
					long budget = scanner.nextLong();
					Client clientObj;
					try {
						clientObj = service.updateClientBudget(clientId, budget);
					} catch (ServiceException e) {
						throw new CompanyClientApplicationException(e);
					}
					System.out.println("Client id :" + clientObj.getClientId() + ", Client Name :"
							+ clientObj.getClientName() + ", Client Budget :" + clientObj.getClientBudget()
							+ ", Company id :" + clientObj.getCompany().getCompanyId());
					break;
				case 4:
					System.out.println("Successfully Exited!!!");
					break;
				default:
					System.out.println("Invalid Operation");
				}
			} catch (CompanyClientApplicationException e) {
				System.out.println(e.getMessage());
			}
		} while (choice != 4);
	}

	private static void displayClientsByCompanyId(Set<Client> clientList) {
		for (Client client : clientList) {
			System.out.println("Client id :" + client.getClientId() + ", Client Name :" + client.getClientName()
					+ ", Client Budget :" + client.getClientBudget() + ", Company id :"
					+ client.getCompany().getCompanyId());
		}

	}

	private static Client addClient() {
		System.out.println("Enter the client name");
		scanner.nextLine();
		String clientName = scanner.nextLine();
		System.out.println("Enter the client Budget");
		long clientBudget = scanner.nextLong();
		System.out.println("Enter the company id");
		int companyId = scanner.nextInt();
		Client client = new Client(clientName, clientBudget, new Company(companyId));
		return client;
	}
}
