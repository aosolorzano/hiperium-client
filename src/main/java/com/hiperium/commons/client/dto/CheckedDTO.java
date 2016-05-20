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
 * This is a POJO class that will be used to transmit the values of an checked
 * lists of the user interface.
 * 
 * @author Andres Solorzano
 * 
 */
@XmlRootElement
public class CheckedDTO implements Serializable {

	/** The property serialVersionUID. */
	private static final long serialVersionUID = 3582440137588212611L;

	/** The property id. */
	@NotNull
	private Long id;

	/** The property name. */
	@NotNull
	private boolean value;

	/**
	 * Default constructor.
	 */
	public CheckedDTO() {
		super();
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
	 * @return the value
	 */
	public boolean isValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(boolean value) {
		this.value = value;
	}

}
