package com.ensat.app.business.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the session database table.
 * 
 */
@Entity
@NamedQuery(name="Session.findAll", query="SELECT s FROM Session s")
public class Session implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Date dateDebut;
	private Date dateFin;
	private List<EtudiantSession> etudiantSessions;
	private Formation formation;

	public Session() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="date_debut")
	public Date getDateDebut() {
		return this.dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="date_fin")
	public Date getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}


	//bi-directional many-to-one association to EtudiantSession
	@OneToMany(mappedBy="session")
	public List<EtudiantSession> getEtudiantSessions() {
		return this.etudiantSessions;
	}

	public void setEtudiantSessions(List<EtudiantSession> etudiantSessions) {
		this.etudiantSessions = etudiantSessions;
	}

	public EtudiantSession addEtudiantSession(EtudiantSession etudiantSession) {
		getEtudiantSessions().add(etudiantSession);
		etudiantSession.setSession(this);

		return etudiantSession;
	}

	public EtudiantSession removeEtudiantSession(EtudiantSession etudiantSession) {
		getEtudiantSessions().remove(etudiantSession);
		etudiantSession.setSession(null);

		return etudiantSession;
	}


	//bi-directional many-to-one association to Formation
	@ManyToOne(fetch=FetchType.LAZY)
	public Formation getFormation() {
		return this.formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

}