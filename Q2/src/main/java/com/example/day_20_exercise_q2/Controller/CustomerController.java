package com.example.day_20_exercise_q2.Controller;

import com.example.day_20_exercise_q2.Model.Customer;
import com.example.day_20_exercise_q2.Response.Response;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/bank")
public class CustomerController {
    ArrayList<Customer> customers = new ArrayList<Customer>();

    @GetMapping("/display-all")
    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    @PostMapping("/add")
    public Response addCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return new Response("User added successfully");
    }

    @PutMapping("/update")
    public Response updateCustomer(@RequestBody Customer customer) {
        for (Customer c : customers) {
            if (c.getId() == customer.getId()) {
                c.setUserName(customer.getUserName());
                c.setId(customer.getId());
                c.setBalance(customer.getBalance());
                return new Response("User updated successfully");
            }
        }
        return new Response("User not found");
    }

    @DeleteMapping("/delete/{index}")
    public Response deleteCustomer(@PathVariable int index) {
        customers.remove(index);
        return new Response("User deleted successfully");
    }

    @PutMapping("/deposit/{id}/{amount}")
    public Response depositCustomer(@PathVariable int amount, @PathVariable int id) {
        for (Customer c : customers) {
            if (c.getId() == id) {
                c.setBalance(c.getBalance() + amount);
                return new Response("User deposit successfully");
            }
        }
        return new Response("User not found");
    }

    @PutMapping("/withdraw/{id}/{amount}")
    public Response withdrawCustomer(@PathVariable int id, @PathVariable int amount) {
        for (Customer c : customers) {
            if (c.getId() == id && c.getBalance() >= amount) {
                c.setBalance(c.getBalance() - amount);
                return new Response("User withdraw successfully");
            }
        }
        return new Response("User not found");
    }
}
