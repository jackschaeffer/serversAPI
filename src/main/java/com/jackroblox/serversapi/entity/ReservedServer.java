package com.jackroblox.serversapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reservedServer")
public class ReservedServer {
	
	@Id
	@Column(name="user_id")
	private long userId;
	
	@Column(name="username")
	private String username;
	
	@Column(name="server_code")
	private String serverCode;
	
	@Column(name="category")
	private String category;
	
	@Column(name="players")
	private int players;
	
	public ReservedServer() {
		
	}
	
	public ReservedServer(long userId, String username, String serverCode, String category, int players) {
		this.userId = userId;
		this.username = username;
		this.serverCode = serverCode;
		this.category = category;
		this.players = players;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getServerCode() {
		return serverCode;
	}

	public void setServerCode(String serverCode) {
		this.serverCode = serverCode;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPlayers() {
		return players;
	}

	public void setPlayers(int players) {
		this.players = players;
	}

	@Override
	public String toString() {
		return "ReservedServer [userId=" + userId + ", username=" + username + ", serverCode=" + serverCode
				+ ", category=" + category + ", players=" + players + "]";
	}

	
}
