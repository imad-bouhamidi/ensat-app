package com.ensat.app.business.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the etudiant_session database table.
 * 
 */
@Entity
@Table(name="etudiant_session")
@NamedQuery(name="EtudiantSession.findAll", query="SELECT e FROM EtudiantSession e")
public class EtudiantSession implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Integer abscence;
	private Integer evaluation;
	private String remarque;
	private Session session;
	private Etudiant etudiant;

	public EtudiantSession() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Integer getAbscence() {
		return this.abscence;
	}

	public void setAbscence(Integer abscence) {
		this.abscence = abscence;
	}


	public Integer getEvaluation() {
		return this.evaluation;
	}

	public void setEvaluation(Integer evaluation) {
		this.evaluation = evaluation;
	}


	public String getRemarque() {
		return this.remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}


	//bi-directional many-to-one association to Session
	@ManyToOne(fetch=FetchType.LAZY)
	public Session getSession() {
		return this.session;
	}

	public void setSession(Session session) {
		this.session = session;
	}


	//bi-directional many-to-one association to Etudiant
	@ManyToOne(fetch=FetchType.LAZY)
	public Etudiant getEtudiant() {
		return this.etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

}