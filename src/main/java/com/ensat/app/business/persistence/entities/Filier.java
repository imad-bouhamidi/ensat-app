package com.ensat.app.business.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the filier database table.
 * 
 */
@Entity
@NamedQuery(name="Filier.findAll", query="SELECT f FROM Filier f")
public class Filier implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String code;
	private String libelle;
	private List<Etudiant> etudiants;
	private List<Formation> formations;
	private List<Niveau> niveaus;

	public Filier() {
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


	//bi-directional many-to-one association to Etudiant
	@OneToMany(mappedBy="filier")
	public List<Etudiant> getEtudiants() {
		return this.etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	public Etudiant addEtudiant(Etudiant etudiant) {
		getEtudiants().add(etudiant);
		etudiant.setFilier(this);

		return etudiant;
	}

	public Etudiant removeEtudiant(Etudiant etudiant) {
		getEtudiants().remove(etudiant);
		etudiant.setFilier(null);

		return etudiant;
	}


	//bi-directional many-to-one association to Formation
	@OneToMany(mappedBy="filier")
	public List<Formation> getFormations() {
		return this.formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	public Formation addFormation(Formation formation) {
		getFormations().add(formation);
		formation.setFilier(this);

		return formation;
	}

	public Formation removeFormation(Formation formation) {
		getFormations().remove(formation);
		formation.setFilier(null);

		return formation;
	}


	//bi-directional many-to-many association to Niveau
	@ManyToMany(mappedBy="filiers")
	public List<Niveau> getNiveaus() {
		return this.niveaus;
	}

	public void setNiveaus(List<Niveau> niveaus) {
		this.niveaus = niveaus;
	}

}