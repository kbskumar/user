package com.example.demo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
	public class Controller {
	@Autowired
		private Services service;
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST,value="/signup")
	public void addUser(@RequestBody User u)
	{
	service.addUser(u);	
	}
	
	@GetMapping("/getuser")
	public List<User> getusers(){
		return service.u.findAll();
	}
	

	@GetMapping("/getuser/{id}")
    public User getCouponById(@PathVariable(value = "id") String id){
        return service.getUser(id);
    }
	@DeleteMapping("/deleteuser/{id}")
    public String deleteUser(@PathVariable String id){
        service.deleteUser(id);
        return "deleted successfully";
	}
	@PutMapping("/updateuser/{id}")
    public String updateUser(@PathVariable(value = "id") String id,@RequestBody User user){
        service.updateUser(id,user);
        return "done";
    }
	
}
	


