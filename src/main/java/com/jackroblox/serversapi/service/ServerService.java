package com.jackroblox.serversapi.service;

import java.util.List;

import com.jackroblox.serversapi.entity.ReservedServer;

public interface ServerService {
	
public List<ReservedServer> findAny();
	
	public List<ReservedServer> findByCategory(String category);
	
	public ReservedServer findByUserId(int userId);
	
	public void save(ReservedServer reservedServer);
	
	public void deleteByUserId(int userId);

}
