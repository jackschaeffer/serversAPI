package com.jackroblox.serversapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jackroblox.serversapi.dao.ServerDAO;
import com.jackroblox.serversapi.entity.ReservedServer;

@Service 
public class ServerServiceImpl implements ServerService {
	
	
	private ServerDAO serverDAO;
	
	@Autowired
	public ServerServiceImpl(ServerDAO serverDao) {
		serverDAO = serverDao;
	}

	
	
	@Override
	@Transactional
	public List<ReservedServer> findAny() {
		return serverDAO.findAny();
	}
	
	@Override
	@Transactional
	public List<ReservedServer> findByCategory(String category) {
		return serverDAO.findByCategory(category);
	}

	@Override
	@Transactional
	public ReservedServer findByUserId(long userId) {
		return serverDAO.findByUserId(userId);
	}

	@Override
	@Transactional
	public void save(ReservedServer server) {
		serverDAO.save(server);
	}

	@Override
	@Transactional
	public void deleteByUserId(long userId) {
		serverDAO.deleteByUserId(userId);
	}

	@Override
	@Transactional
	public void incrementPlayerCount(long userId, int incrementBy) {
		serverDAO.incrementPlayerCount(userId, incrementBy);
		
	}


}
