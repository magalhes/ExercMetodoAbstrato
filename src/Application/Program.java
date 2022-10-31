package Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> list = new ArrayList<>();
		System.out.println("Enter the number of tax payers: ");
		int n = sc.nextInt();
		for(int i = 1; i<=n; i++) {
			System.out.println("Tax payer #"+ i +"data: ");
			System.out.println("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			System.out.println("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("Anual income: ");
			Double anualIncome = sc.nextDouble();
			if(ch == 'i') {
				System.out.println("Health expenditures: ");
				double healtExpenditures = sc.nextDouble();
				list.add(new Individual(name, anualIncome, healtExpenditures));
				
			}else {
				System.out.println("Number of employees: ");
				int numberOfEmplyees = sc.nextInt();
				list.add(new Company(name, anualIncome, numberOfEmplyees));
			}
			
		}
		System.out.println();
		
		System.out.println("TAXES PAID: ");
		double soma = 0.0;
		for(TaxPayer tax : list) {
			double tp = tax.tax();
			System.out.println(tax.getName()+":   $ "  +  String.format("%.2f", tax.tax()));
			soma+= tp;
		}
		
			System.out.println("TOTAL TAXES: $" + "  $ "  +  String.format("%.2f", soma ));

	}

}
