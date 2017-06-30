package com.ebergstein.logreg.services;

import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ebergstein.logreg.models.Role;
import com.ebergstein.logreg.models.User;
import com.ebergstein.logreg.repositories.RoleRepository;
import com.ebergstein.logreg.repositories.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private AuthenticationManager authenticationManager;
    private UserDetailsService userDetailsService;
    
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder, AuthenticationManager authenticationManager, UserDetailsService userDetailsService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        
}
    
    
    // 1
    public User saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        return userRepository.save(user);
    }
   
   // 2 
    public User saveWithUserAndAdminRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findAll());
        System.out.println(user.getRoles().get(0).getName());
        System.out.println(user.getRoles().get(1).getName());
        return userRepository.save(user);
    }  
    
    // 3
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public User updateUser(User user){
    	Role admin = findRole("ROLE_ADMIN");
    	if(user.getRoles().contains(admin)){
    		user.setRoles((List<Role>) roleRepository.findAll());
    	}
    	else{
    		user.setRoles(roleRepository.findByName("ROLE_USER"));
    	}
    	return userRepository.save(user);
    }
    
    public User promoteUser(User user){
    	user.setRoles((List<Role>) roleRepository.findAll());
    	return userRepository.save(user);
    }
    
    public List<User> getAllUsers(){
    	return (List<User>) userRepository.findAll();
    }
    
    public User getOneUser(Long id){
    	return (User) userRepository.findOne(id);
    }
    
    public void destroyUser(Long id){
    	userRepository.delete(id);
    }
    
    public Role findRole(String name){
    	return(Role) roleRepository.findOneByName(name);
    }
    /*
    public void authenticate(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
  }*/
}