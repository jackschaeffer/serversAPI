package com.jackroblox.serversapi.service;

import java.util.List;

import com.jackroblox.serversapi.entity.ReservedServer;

public interface ServerService {
	
public List<ReservedServer> findAny();
	
	public List<ReservedServer> findByCategory(String category);
	
	public ReservedServer findByUserId(long userId);
	
	public void save(ReservedServer reservedServer);
	
	public void incrementPlayerCount(long userId, int incrementBy);
	
	public void deleteByUserId(long userId);

}
