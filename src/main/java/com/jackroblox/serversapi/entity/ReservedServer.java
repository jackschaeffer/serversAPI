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
	private int userId;
	
	@Column(name="server_code")
	private String serverCode;
	
	@Column(name="category")
	private String category;
	
	@Column(name="players")
	private int players;
	
	public ReservedServer() {
		
	}
	
	public ReservedServer(int userId, String serverCode, String category, int players) {
		this.userId = userId;
		this.serverCode = serverCode;
		this.category = category;
		this.players = players;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
		return "ReservedServer [userId=" + userId + ", serverCode=" + serverCode + ", category=" + category
				+ ", players=" + players + "]";
	}
	
	
	
	
}
