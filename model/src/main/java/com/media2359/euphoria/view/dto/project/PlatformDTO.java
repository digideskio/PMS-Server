/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.view.dto.project;

import java.io.Serializable;

public class PlatformDTO implements Serializable {
	
	private Integer platformKey;
	private String platformId;

	public PlatformDTO() {

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

	
	
}
