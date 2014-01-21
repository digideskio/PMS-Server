/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.model.project;

/**
 * Platform
 *
 * TODO Write something about this class
 * 
 * @author ty
 * @version 1.0 2013
 **/

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.WhereJoinTable;

import com.media2359.euphoria.view.dto.project.PlatformDTO;

@Entity 
@Table(name = "platform") 
public class Platform {
	@Id
	@GeneratedValue(generator = "platformGenerator")     
	@GenericGenerator(name = "platformGenerator", strategy = "increment") 
	@Column(name = "platform_key")
	private Integer platformKey;
	
	@Column(name = "platform_id")
	private String platformId;

	/**
	 * 
	 */
	public Platform() {
		// TODO Auto-generated constructor stub
	}
	
	public Platform(PlatformDTO platFormDto){
		this.platformKey=platFormDto.getPlatformKey();
		this.platformId=platFormDto.getPlatformId();
	}

	public Integer getPlatformKey() {
		return platformKey;
	}

	public void setPlatformKey(Integer platformKey) {
		this.platformKey = platformKey;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	
	public PlatformDTO createPlatformDTO(){
		PlatformDTO platformDto = new PlatformDTO();
		platformDto.setPlatformKey(this.getPlatformKey());
		platformDto.setPlatformId(this.getPlatformId());
		
		return platformDto;
	}

	@Override
	public String toString() {
		return "Platform [platformKey=" + platformKey + ", platformId="
				+ platformId + "]";
	}

}
