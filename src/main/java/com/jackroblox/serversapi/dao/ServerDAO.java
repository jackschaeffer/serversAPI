package com.jackroblox.serversapi.dao;

import java.util.List;

import com.jackroblox.serversapi.entity.ReservedServer;

public interface ServerDAO {
	
	public List<ReservedServer> findAny();
	
	public List<ReservedServer> findByCategory(String category);
	
	public ReservedServer findByUserId(int userId);
	
	public void incrementPlayerCount(int userId, int incrementBy);
	
	public void save(ReservedServer reservedServer);
	
	public void deleteByUserId(int userId);

}
