package in.xebia.rest.util;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * Abstract base class for entities. Allows parameterisation of id type, chooses auto-generation and implements
 * {@link #equals(Object)} and {@link #hashCode()} based on that id. 
 * Also adds the date created and last modified fields for all entities.
 * 
*/

@MappedSuperclass
public abstract class AbstractEntity<PK extends Serializable> extends AbstractPersistable<PK> {

	private static final long serialVersionUID = -3028114538116703612L;
	
	@Column(nullable = false)
	private Date dateCreated;
	
	@Column(nullable = false)
	private Date lastModified;
	
	@PrePersist
	public void onCreate() {
		this.dateCreated = this.lastModified = new Date();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.lastModified = new Date();
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	
	public PK getId() {
		return super.getId();
	}
	
	public void setId(PK id) {
		super.setId(id);
	}
}
