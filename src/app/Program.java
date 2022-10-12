package app;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Nome do departamento: ");
		String name = scan.next();
		System.out.print("Dia do pagamento: ");
		int payDay = scan.nextInt();
		System.out.print("Email: ");
		String email = scan.next();
		System.out.print("Telefone: ");
		String phone = scan.next();
		System.out.print("Quantos funcionários tem o departamento? ");
		int n = scan.nextInt();
		
		Address address = new Address(email, phone);
		Department department = new Department(name, payDay, address);
		
		for(int i = 0; i < n; i++) {
			System.out.printf("Dados do funcionário %d:%n", i + 1);
			System.out.print("Nome: ");
			scan.nextLine();
			String empName = scan.nextLine();
			System.out.print("Salário: ");
			double salary = scan.nextDouble();
			
			Employee employee = new Employee(empName, salary);
			
			department.addEmployee(employee);
			
		}
		System.out.println();
		showReport(department);
		
		scan.close();
		
	}
	
	private static void showReport(Department department) {
		StringBuilder sb = new StringBuilder();
		sb.append("FOLHA DE PAGAMENTO: \n");
		sb.append("Departamento ");
		sb.append(department.getName());
		sb.append(" = R$ ");
		sb.append(String.format("%.2f%n", department.payroll()));
		sb.append("Pagamento realizado no dia ");
		sb.append(department.getPayDay() + "\n");
		sb.append("Funcionários: \n");
		for(Employee employees : department.getEmployee()) {
			sb.append(employees.getName());
			sb.append("\n");
		}
		sb.append("Para dúvidas favor entrar em contato: ");
		sb.append(department.getAddress().getEmail());
		System.out.println(sb.toString());
	}
}
