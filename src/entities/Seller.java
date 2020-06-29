package entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Seller implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String email;
	private Date birthdate;
	private double basesalary;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Department department;
	
	public Seller() {
		
	}
	
	public Seller(int id, String name, String email, Date birthdate, double basesalary, Department department) {
		this.id=id;
		this.name=name;
		this.email=email;
		this.birthdate=birthdate;
		this.basesalary=basesalary;
		this.department=department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public double getBasesalary() {
		return basesalary;
	}

	public void setBasesalary(double basesalary) {
		this.basesalary = basesalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seller other = (Seller) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public String toString() {
		return "ID: "+id+
				", Name: "+name+
				", Email: "+email+
				", BirthDate: "+sdf.format(birthdate)+
				", Base Salary: "+basesalary+
				", Department ID: "+department.getId()+
				", Department Name: "+department.getName();
				
	}
	
}
