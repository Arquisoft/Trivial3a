package modelo;

import java.util.List;

import business.game.tablero.jugadores.impl.Jugador;

public class Sala {
	private List<Jugador> players;
	private int maxPlayers;
	private String name;
	private String password;
	
	public Sala(List<Jugador> players, int maxPlayers, String name,
			String password) {
		super();
		this.players = players;
		this.maxPlayers = maxPlayers;
		this.name = name;
		this.password = password;
	}
	public List<Jugador> getPlayers() {
		return players;
	}
	public void setPlayers(List<Jugador> players) {
		this.players = players;
	}
	public int getMaxPlayers() {
		return maxPlayers;
	}
	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
