package com.jackroblox.serversapi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jackroblox.serversapi.entity.ReservedServer;

@Repository
public class ServerDAOJpaImpl implements ServerDAO {
	

	private EntityManager entityManager;
	
	@Autowired
	public ServerDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	
	// =========================================		
	//	FIND ANY SERVERS
	// =========================================	
	// Return any top servers that are NOT full 
	// Server limit is 20 players
	// Search for servers with 17 or less for better lobby selection
	
	@Override
	public List<ReservedServer> findAny() {
		
		Query query = entityManager.createQuery(
				"from ReservedServer rs WHERE rs.players<=17 ORDER BY rs.players DESC");
		
		query.setMaxResults(50);

		List<ReservedServer> servers = query.getResultList();
		
		return servers;
		
	}

	
	
	
	// =========================================		
	//	FIND SERVERS BY CATEGORY 
	// =========================================	
	// Return top servers by category
	// Server limit is 20 players
	// Search for servers with 17 or less for better lobby selection
	
	@Override
	public List<ReservedServer> findByCategory(String category) {
		
		Query query = entityManager.createQuery(
				"from ReservedServer rs WHERE rs.category=:category ORDER BY rs.players DESC");
		
		query.setParameter("category", category);
		query.setMaxResults(50);

		List<ReservedServer> servers = query.getResultList();
		
		return servers;
		
	}
	
	
	
	
	// =========================================		
	//	FIND SERVER BY USERID
	// =========================================	
	// Return server by userId
	// UserId is the primary key
	
	@Override
	public ReservedServer findByUserId(int userId) {
		
		ReservedServer server = 
				entityManager.find(ReservedServer.class, userId);
		
		return server;
	}

	// =========================================		
	//	SAVE SERVER TO DB
	// =========================================	
	// Save server to db
	// Will update or save depending if User Id exists 
	
	@Override
	public void save(ReservedServer reservedServer) {
		
		System.out.println("DAO");
		
		entityManager.merge(reservedServer);

	}
	
	
	// =========================================		
	//	DELETE SERVER FROM DB
	// =========================================	
	// Delete server from db by user id
	// UserId is the primary key

	@Override
	public void deleteByUserId(int userId) {
		
		Query query = entityManager.createQuery(
				"delete from ReservedServer where userId=:userId");
		
		query.setParameter("userId", userId);
		
		query.executeUpdate();

	}


	// =========================================		
	//	INCREMENT PLAYER COUNT
	// =========================================	
	// Increment the server player count
	// Will increment or decrement depending on value passed in
	
	@Override
	public void incrementPlayerCount(int userId, int incrementBy) {
		
		Query query = entityManager.createQuery
				("UPDATE ReservedServer rs "
						+ "set rs.players = rs.players + :incrementBy "
						+ "WHERE rs.userId = :userId");
		
		query.setParameter("userId", userId);
		query.setParameter("incrementBy", incrementBy);
		
		query.executeUpdate();
	}

}
