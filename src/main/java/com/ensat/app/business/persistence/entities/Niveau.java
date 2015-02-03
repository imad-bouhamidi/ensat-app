package com.ensat.app.business.persistence.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the niveau database table.
 * 
 */
@Entity
@NamedQuery(name="Niveau.findAll", query="SELECT n FROM Niveau n")
public class Niveau implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String code;
	private String libelle;
	private List<Utilisateur> professeurs;
	private List<Filier> filiers;

	public Niveau() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	//bi-directional many-to-many association to Professeur
	@ManyToMany(mappedBy="niveaus")
	public List<Utilisateur> getProfesseurs() {
		return this.professeurs;
	}

	public void setProfesseurs(List<Utilisateur> professeurs) {
		this.professeurs = professeurs;
	}


	//bi-directional many-to-many association to Filier
	@JoinTable(name = "niveau_filier", 
	        joinColumns = { 
	               @JoinColumn(name = "filier_id", referencedColumnName = "id")
	        }, 
	        inverseJoinColumns = { 
	               @JoinColumn(name = "niveau_id", referencedColumnName = "id")
	        }
	 )
	@ManyToMany
	@JoinColumn(name="id")
	public List<Filier> getFiliers() {
		return this.filiers;
	}

	public void setFiliers(List<Filier> filiers) {
		this.filiers = filiers;
	}

}