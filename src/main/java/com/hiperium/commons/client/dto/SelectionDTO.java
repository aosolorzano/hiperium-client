/**
 * Product  : Hiperium Project
 * Architect: Andres Solorzano.
 * Created  : 08-05-2009 - 23:30:00
 * 
 * The contents of this file are copyrighted by Andres Solorzano 
 * and it is protected by the license: "GPL V3." You can find a copy of this 
 * license at: http://www.hiperium.com/about/licence.html
 * 
 * Copyright 2014 Andres Solorzano. All rights reserved.
 * 
 */
package com.hiperium.commons.client.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This is a POJO class that will be used to transmit the values of an selection
 * combo for the user interface.
 * 
 * @author Andres Solorzano
 * 
 */
@XmlRootElement
public class SelectionDTO implements Serializable {

	/**
	 * The property serialVersionUID.
	 */
	private static final long serialVersionUID = -542053555840860067L;

	/** The property id. */
	@NotNull
	private Long id;

	/** The property name. */
	@NotNull
	private String name;

	/**
	 * Default constructor.
	 */
	public SelectionDTO() {
		super();
	}

	/**
	 * 
	 * Class constructor.
	 * 
	 * @param value
	 * @param label
	 */
	public SelectionDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * Gets the id property value.
	 * 
	 * @return the id property value.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the value to the id property.
	 * 
	 * @param id
	 *            the id to set.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the name property value.
	 * 
	 * @return the name property value.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value to the name property.
	 * 
	 * @param name
	 *            the name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SelectionDTO [id=" + id + ", name=" + name + "]";
	}

}
