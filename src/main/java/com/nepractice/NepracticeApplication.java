package com.nepractice;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
public class NepracticeApplication {
	private final CustomerJpaRepository customerJpaRepository;
	public NepracticeApplication(CustomerJpaRepository customerJpaRepository){
		this.customerJpaRepository = customerJpaRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(NepracticeApplication.class, args);
	}
	@GetMapping
	public List<Customer> getCustomers() {
		return customerJpaRepository.findAll();
	}
	record NewCustomerRequest(String name,String email,Integer age){}
	@PostMapping
    public String addCustomer(@RequestBody NewCustomerRequest request){
        Customer customer = new Customer();
        customer.setName(request.name);
        customer.setEmail(request.email);
        customer.setAge(request.age);
        customerJpaRepository.save(customer);
        return "Customer saved successfully";
    }
	@DeleteMapping("{customer_id}")
	public String deleteCusomer(@PathVariable("customer_id") Integer id){
		 customerJpaRepository.deleteById(id);
		 return "Customer deleted successfully!";
	}
	record UpdateCustomerRequest(String name,String email,Integer age){}
	@PutMapping("{customer_id}")
	public String updateCustomer(@PathVariable("customer_id") Integer id,UpdateCustomerRequest customer ){
		Customer existingcustomer = customerJpaRepository.findById(id)
						.orElseThrow(() -> new EntityNotFoundException(("Customer Not Found")));
		System.out.println(existingcustomer);
		return "Customer updated successfully!";
	}







    // dummy codes
	@GetMapping("/greet")
	public GreetResponse greet(){
		GreetResponse response = new GreetResponse(
				"Hello",
				List.of("Java","GOlang"),
				new Person("AiE",30000,18)
		);
		return response;
	}

	record Person(String name,double cash,int age){
		
	};
	record GreetResponse(
			String greet,
			List<String> favPrograms,
			Person person
	){

	}
}
