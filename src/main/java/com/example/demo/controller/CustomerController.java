package com.example.demo.controller;
import com.example.demo.service.CustomerService;
import com.example.demo.dto.UpdateCustomerdto;
import com.example.demo.model.Customer;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/customer")
public class CustomerController
{
	
	CustomerService cs= new CustomerService();
	@GetMapping(value="/view")
	public List<Customer> view() throws Exception{
  
        return cs.CustomerView();
	}
	@PostMapping(value="/insert")
	public String insert(@RequestBody Customer c) throws Exception{
		cs.CustomerInsert(c);
		return "inserted";
	}
	@DeleteMapping(value="/delete/{id}")
	public String delete(@PathVariable int id) throws Exception {
		boolean res=cs.deleteCustomer(id);
		if(!res)
		{
			return "error in deletion";
		}		
		return "user deleted";
	}

	@PutMapping(value="/updateAge")
	public String update(@RequestBody UpdateCustomerdto uc ) throws Exception {
		boolean res=cs.updateCustomer(uc);
		if(!res)
		{
			return "error in updation";
		}		
		return "user age updated";
	}

}
