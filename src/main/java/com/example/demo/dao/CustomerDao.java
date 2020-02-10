package com.example.demo.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.dto.UpdateCustomerdto;
import com.example.demo.model.Customer;
import com.example.demo.util.ConnectionUtil;

public class CustomerDao {
	Connection con =null;
	 PreparedStatement pst = null;
     public List<Customer> viewCustomer() throws Exception{
    	    List<Customer> list = new ArrayList<Customer>();
    	    try {
    	        con = ConnectionUtil.getConnection();
    	        String sql = "select * from customer";
    	        pst = con.prepareStatement(sql);
    	        ResultSet rs = pst.executeQuery();
    	        while(rs.next()) {
    	            
    	        	Customer details =new Customer();
    	        	details.setId(rs.getInt("id"));
    	            details.setName(rs.getString("name"));
    	            details.setAge(rs.getInt("age"));
    	            list.add(details);
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	        throw new Exception("cannot  View customer",e);
    	    }
    	   
    	    finally {
       			ConnectionUtil.close(con, pst);
       		}
    	    return list;
    	}
       public void insertCustomer(Customer c) throws Exception{
    	   

   		try {
   			con = ConnectionUtil.getConnection();
   			String sql = "insert into customer(id,name,age) values ( ?,?,?)";
   			pst = con.prepareStatement(sql);
   			pst.setInt(1, c.getId());
   			pst.setString(2, c.getName());
   			pst.setInt(3, c.getAge());
            pst.executeUpdate();
   			System.out.println("\nsuccessfully inserted");
   		} catch (SQLException e) {
   			e.printStackTrace();
   			throw new Exception("Unable to insert ", e);
   		} finally {
   			ConnectionUtil.close(con, pst);
   		}
    	    	   
       }
       public  boolean deleteCustomer(int id) throws Exception {
   		// userId = id;
    	   int result;
   		PreparedStatement pst = null;
   		Connection con = null;
   		try {
   			con = ConnectionUtil.getConnection();
   			String sql = "delete from customer where id= ?";
   			pst = con.prepareStatement(sql);
   			pst.setInt(1, id);
   			result=pst.executeUpdate();
   			if (result != 0) 
   			{
   				return true;
   			}
   		} catch (Exception e) {
   			throw new Exception(e);
   		} finally {
   			ConnectionUtil.close(con, pst);
   		}
   		    return false;

   	}
       public  boolean updateCustomerdao(UpdateCustomerdto uc) throws Exception {
       	   int result;
      		PreparedStatement pst = null;
      		Connection con = null;
      		boolean flag=true;
      		try {
      			con = ConnectionUtil.getConnection();
      			String sql = "update customer set age=(?) where id=(?)";
      			pst = con.prepareStatement(sql);
      			pst.setInt(1, uc.getAge());
      			pst.setInt(2,uc.getId());
      			result=pst.executeUpdate();
      			System.out.println(result);
      		    if(result>0)
      		    	flag=true;
      		    else 
      		    	flag=false;
      			
      		} catch (Exception e) {
      			throw new Exception(e);
      		} finally {
      			ConnectionUtil.close(con, pst);
      		}
      		System.out.println(flag);
      		return flag;
      		

      	}
     
}
