package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.SellerDao;
import db.DB;
import db.DbException;
import entities.Department;
import entities.Seller;

public class SellerDaoJDBC implements SellerDao {

	Connection conn = null;
	
	public SellerDaoJDBC(Connection conn) {
		this.conn=conn;
	}
	
	
	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs=null;
		try {
			st = conn.prepareStatement("select seller.*, department.name as depname "
					+ "from seller inner join department on seller.departmentId=department.Id "
					+ "where seller.Id=?");
			st.setInt(1, id);
			rs = st.executeQuery();
			while(rs.next()) {
				Department dep = new Department();
				Seller seller = new Seller();
				dep.setId(rs.getInt("DepartmentId"));
				dep.setName(rs.getString("depname"));
				seller.setId(rs.getInt("Id"));
				seller.setName(rs.getString("Name"));
				seller.setBirthdate(rs.getDate("BirthDate"));
				seller.setEmail(rs.getString("Email"));
				seller.setBasesalary(rs.getDouble("BaseSalary"));
				seller.setDepartment(dep);
				return seller;
			}
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		

		
		return null;
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
