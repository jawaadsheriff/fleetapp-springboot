package com.sheriff.fleetapp.security.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sheriff.fleetapp.models.User;
import com.sheriff.fleetapp.security.models.Role;
import com.sheriff.fleetapp.security.services.RoleService;
import com.sheriff.fleetapp.services.UserService;

@Controller
public class RoleController {

	@Autowired private RoleService roleService;
	
	@Autowired private UserService userService;
	
	@GetMapping("/role")
	public String getRoles(Model model){
		model.addAttribute("roles", roleService.getRoles());
		return "role";
	}
	
	@PostMapping("/role/addNew")
	public String saveRole(Role role) {
		roleService.saveRoles(role);
		return "redirect:/role";
	}
	
	@RequestMapping("/role/findById")
	@ResponseBody
	public Optional<Role> findRoleById(int id) {
		return roleService.findRoleById(id);
	}
	
	@RequestMapping(method = {RequestMethod.GET, RequestMethod.PUT}, value = "/role/update")
	public String updateRole(Role role) {
		roleService.saveRoles(role);
		return "redirect:/role";
	}
	
	@RequestMapping(value = "/role/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String deleteRole(Integer id) {
		roleService.deleteRole(id);
		return "redirect:/role";
	}

	@GetMapping(value = "/security/user/edit/{id}")
	public String editUser(@PathVariable Integer id, Model model) {
		User user = userService.findUserById(id).orElse(null);
		model.addAttribute("user", user);
		model.addAttribute("userRoles", roleService.getUserRoles(user));
		model.addAttribute("userNotRoles", roleService.getUserNotRoles(user));
		return "/userEdit";
	}
	
	@RequestMapping("/security/role/assign/{userId}/{roleId}")
	public String assignRole(@PathVariable Integer userId, @PathVariable Integer roleId) {
		roleService.assignRole(userId, roleId);
		return "redirect:/security/user/edit/"+userId;
	}
	
	@RequestMapping("/security/role/unassign/{userId}/{roleId}")
	public String unassignRole(@PathVariable Integer userId, @PathVariable Integer roleId) {
		roleService.unassignRole(userId, roleId);
		return "redirect:/security/user/edit/"+userId;
	}
	
}
