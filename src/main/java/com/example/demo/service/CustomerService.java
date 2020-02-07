package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.dao.CustomerDao;
import com.example.demo.dto.UpdateCustomerdto;
import com.example.demo.model.Customer;

@Service
public class CustomerService {
	
	CustomerDao customerdao =new CustomerDao();
	//Customer details = new Customer();
	
	
	public List<Customer> CustomerView() throws Exception {
		System.out.println("hi");
        List<Customer> list = null;
     
        try
        {
            list = customerdao.viewCustomer();
             StringBuilder cust=new StringBuilder();
 	      cust.append("\n Id\tName\t\n");
 	       for (Customer customer : list) 
 	       {
 	    	  cust.append(customer.getId()).append("\t");
 	    	  cust.append(customer.getName()).append("\t");
 	          cust.append("\n");
 	       }
 	       System.out.println(cust);       
        } 
        catch (Exception e) {
            e.printStackTrace();
        }  
        return customerdao.viewCustomer();
	}
	/*public String CustomerInsert(Customer c) throws Exception{
//	
	// return "successfully inserted from service";
		
	}*/ 
	public void CustomerInsert(Customer c1) throws Exception {
		 customerdao.insertCustomer(c1);
		}
	public  boolean deleteCustomer(int id) throws Exception {
		try {
			
			if (customerdao.deleteCustomer(id)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			throw new Exception(e);
		}

	}
	public  boolean updateCustomer(UpdateCustomerdto uc) throws Exception {
		try {
			
			if (customerdao.updateCustomerdao(uc)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			throw new Exception(e);
		}

	}
}