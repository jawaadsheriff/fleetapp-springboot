package com.sheriff.fleetapp.security.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheriff.fleetapp.models.User;
import com.sheriff.fleetapp.repositories.UserRepository;
import com.sheriff.fleetapp.security.models.Role;
import com.sheriff.fleetapp.security.repositories.RoleRepository;

@Service
public class RoleService {

	@Autowired RoleRepository roleRepository;
	
	@Autowired UserRepository userRepository;
	
	public List<Role> getRoles(){
		return roleRepository.findAll();
	}
	
	public void saveRoles(Role role) {
		roleRepository.save(role);
	}
	
	public void deleteRole(Integer id) {
		roleRepository.deleteById(id);
	}
	
	public Optional<Role> findRoleById(int id) {
		return roleRepository.findById(id);
	}
	
	public void assignRole(Integer userId, Integer roleId) {
		User user = userRepository.findById(userId).orElse(null);
		Role role = roleRepository.findById(roleId).orElse(null);
		Set<Role> userRoles = user.getRoles();
		userRoles.add(role);
		user.setRoles(userRoles);
		userRepository.save(user);
	}
	
	public void unassignRole(Integer userId, Integer roleId) {
		User user = userRepository.findById(userId).orElse(null);
		Set<Role> userRoles = user.getRoles();
		userRoles.removeIf(x -> x.getId() == roleId);
		userRepository.save(user);
	}
	
	public Set<Role> getUserRoles(User user){
		return user.getRoles();
	}
	
	public Set<Role> getUserNotRoles(User user){
		return roleRepository.getUserNotRoles(user.getId());
	}
}
