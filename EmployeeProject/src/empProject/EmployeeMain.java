package empProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Employee> list = new ArrayList<>();
		
		System.out.print("Enter the numer of employee: ");
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			System.out.print("OutSourced (y/n)");
			char choose = sc.next().charAt(0);
			sc.nextLine();

			System.out.print("Name: ");
			String name = sc.nextLine();

			System.out.print("Hours:");
			int hours = sc.nextInt();
			sc.nextLine();

			System.out.println("Value per Hour: ");
			double valuePerHour = sc.nextDouble();

			if (choose == 'n') {
				list.add(new Employee(name, hours, valuePerHour));
			} else if (choose == 'y') {
				System.out.println("Additional Charge");
				double addCharge = sc.nextDouble();
				list.add(new OutSourced(name, hours, valuePerHour, addCharge));
			}
		}
		System.out.println("PAYMENT:");
		for (Employee employee : list) {
			System.out.println(employee.getName() + " - R$" + String.format("%.2f", employee.payment()));
		}
		sc.close();
	}
}