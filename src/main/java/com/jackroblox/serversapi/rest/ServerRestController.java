package com.jackroblox.serversapi.rest;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jackroblox.serversapi.entity.ReservedServer;
import com.jackroblox.serversapi.service.ServerService;

@RestController
@RequestMapping("/api")
public class ServerRestController {
	
	private ServerService serverService;
	
	@Autowired
	public ServerRestController(ServerService theEmployeeService) {
		serverService = theEmployeeService;
	}

	
	// =========================================	
	// Expose endpoint for getting all top servers
	// =========================================	
	@GetMapping("/servers")
	public List<ReservedServer> findAny(){
		return serverService.findAny();
		
	}
	
	
	// =========================================	
	// Expose endpoint for getting top servers by category
	// =========================================	
	@GetMapping("/servers/category/{category}")
	public List<ReservedServer> getServersByCategory(@PathVariable String category) {
		List<ReservedServer> servers = serverService.findByCategory(category);
		
		if (servers == null) {
			System.out.println("No servers found for category - " + category);
		}
		
		return servers;
	}
	
	
	// =========================================	
	// Expose endpoint for getting server by User Id
	// =========================================	
	@GetMapping("/servers/{userId}")
	public ReservedServer getServer(@PathVariable long userId) {
		ReservedServer server = serverService.findByUserId(userId);
		
		if (server == null) {
			System.out.println("Server not found for User Id - " + userId);
		}
		
		return server;
	}
	
	
	// =========================================	
	// Expose endpoint for saving a server
	// =========================================	
	@PostMapping("/servers")
	public boolean addServer(@RequestBody ReservedServer server) {
		
		serverService.save(server);
		
		return true;
	}
	
	
	// =========================================	
	// Expose endpoint for incrementing player count of a server
	// =========================================	
	@PutMapping("/servers/{userId}")
	public boolean incrementPlayerCount(@PathVariable long userId, @RequestBody String inputJson) {
		
		JSONObject jsonObj = new JSONObject(inputJson);
		
		int incrementBy = jsonObj.getInt("incrementBy");
		
		ReservedServer server = serverService.findByUserId(userId);
		
		if (server == null) {
			System.out.println("Server not found for User Id - " + userId);
		}
	
		
		serverService.incrementPlayerCount(userId, incrementBy);
		
		return true;
	}
	
	// =========================================	
	// Expose endpoint for deleting a server
	// =========================================	
	@DeleteMapping("/servers/{userId}")
	public boolean deleteServer(@PathVariable long userId) {
		ReservedServer server = serverService.findByUserId(userId);
		
		if (server == null) {
			System.out.println("Server not found for User Id - " + userId);
		}
		
		serverService.deleteByUserId(userId);
		
		return true;
	}
	
	
	
}
