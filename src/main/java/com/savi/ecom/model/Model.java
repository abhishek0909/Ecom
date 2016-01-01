package com.savi.ecom.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.util.Assert;

/**
 * The Class Model.
 */
@MappedSuperclass
public abstract class Model extends AbstractPersistable<Long>{

	@Version
    private int version;

    /**
     *  All objects will have a unique UUID which allows for the decoupling from DB generated ids
     *
     */
    @Column(length=36)
    private String uuid;	
	
	/** The created date. */
	private Date createdDate;
	
	/** The modified date. */
	private Date modifiedDate;

	public Model() {
        this(UUID.randomUUID());
    }

    public Model(UUID guid) {
        Assert.notNull(guid, "UUID is required");
        setUuid(guid.toString());
        this.createdDate = new Date();
    }

    public UUID getUuid() {
        return UUID.fromString(uuid);
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int hashCode() {
        return getUuid().hashCode();
    }
	
    public Object getIdentifier() {
        return getUuid().toString();
    }

	
	public int getVersion() {
        return version;
    }
	
	/**
	 * Gets the created date.
	 *
	 * @return the created date
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Sets the created date.
	 *
	 * @param createdDate the new created date
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Gets the modified date.
	 *
	 * @return the modified date
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * Sets the modified date.
	 *
	 * @param modifiedDate the new modified date
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
