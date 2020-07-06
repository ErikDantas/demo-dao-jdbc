package application;

import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import dao.DaoFactory;
import dao.SellerDao;
import entities.Department;
import entities.Seller;

public class Program {

	public static void main(String[] args) throws HeadlessException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SellerDao sellerdao = DaoFactory.createSellerDao();
		int aux = 0;
		do {
			
			aux = Integer.parseInt(JOptionPane.showInputDialog("Choose: \n"
					+ "1 - Seller \n"
					+ "2 - Department \n"
					+ "3 - Exit \n\n"));
			if(aux ==1) {
				int auxseller = Integer.parseInt(JOptionPane.showInputDialog("Choose the option: \n"
						+ "1 - Find All \n"
						+ "2 - Find By ID \n"
						+ "3 - Find By Department \n"
						+ "4 - Insert a new Seller \n"
						+ "5 - Update a Seller \n"
						+ "6 - Delete a Seller by ID \n"));
				switch(auxseller) {
					case 1:
						List<Seller> listseller = sellerdao.findAll();
						for (Seller obj : listseller) {
							System.out.println(obj);
						}
						break;
					case 2:
						Seller seller = sellerdao.findById(Integer.parseInt(JOptionPane.showInputDialog
								("Insert an ID.\n")));
						System.out.println(seller);
						break;
					case 3:
						int tempdepid = Integer.parseInt(JOptionPane.showInputDialog("Insert the Department Id: "));
						Department dep = new Department(tempdepid,null);
						List<Seller> list = sellerdao.findByDepartment(dep);
						for (Seller obj : list) {
							System.out.println(obj);
						}
						break;
					case 4:
						String name = JOptionPane.showInputDialog("Inser the new seller name: ");
						String email = JOptionPane.showInputDialog("Inser the new seller email: ");
						Date birthdate = sdf.parse(JOptionPane.showInputDialog("Inser the new seller birthdate: "));
						double basesalary = Double.parseDouble(JOptionPane.showInputDialog("Inser the new seller base salary: "));
						int departmentid = Integer.parseInt(JOptionPane.showInputDialog("Inser the new seller department ID: "));
						String depname = JOptionPane.showInputDialog("Inser the new seller department name: ");
						Department depinsert = new Department(departmentid, depname);
						Seller sellerinsert = new Seller(0, name, email, birthdate, basesalary, depinsert);
						sellerdao.insert(sellerinsert);
				}
			}
		}while(aux!=3);
		

	}

}
