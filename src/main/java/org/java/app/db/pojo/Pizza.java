package org.java.app.db.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 128, nullable = false)
	private String nome;
	private String descrizione;
	@Column(unique = true)
	private String foto;
	private float prezzo;

//	public Pizza() { }
	//COSTRUTTORE
	public Pizza(String nome, String descrizione, String foto, float prezzo) {

		setId(id);
		setNome(nome);
		setDescrizione(descrizione);
		setFoto(foto);
		setPrezzo(prezzo);
	}

	//ID
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	//NOME
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	//DESCRIZIONE
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	//FOTO(URL)
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}

	//PREZZO
	public float getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "[" + getId() + "] Pizza: \n"
				+ "nome: " + getNome() + "\n"
				+ "descrizione: " + getDescrizione() + "\n"
				+ "prezzo: " + getPrezzo();
		
	}

}
