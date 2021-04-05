package com.example.demo;
import java.util.List;

//import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
//import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
//import static org.springframework.data.mongodb.core.query.Update.update;

//import java.util.List;

//import org.springframework.data.mongodb.core.query.Query;

@Service
public class Services {
	@Autowired
	UserInterface u;
	public void addUser(User user) 
	{
		u.save(user);
	}
	public List<User> getusers(){
        return u.findAll();
    }
    public User getUser(String id){
        return u.findById(id).orElseThrow(()->new ResourceNotFoundException("The record with "+id+"is not found"));
    }
	public void deleteUser(String id){
        u.delete(getUser(id));
    }
	public void updateUser(String id,User user){
        User u = getUser(id);
        u.setName(user.getName());
		u.setMobileno(user.getMobileno());
		u.setPassword(user.getPassword());
        
    }
}
