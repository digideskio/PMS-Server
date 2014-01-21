package com.media2359.euphoria.view.client.core;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface AllocationGridColorCellImages extends ClientBundle {
	  
	@Source("allocation_free.png")
	  ImageResource Free();
	
	@Source("allocation_exc.png")
	  ImageResource Exceeded();
	
	@Source("allocation_sel.png")
	  ImageResource Selected();
	
	@Source("allocation_sel_exc.png")
	  ImageResource SelectExceeded();
	
	@Source("allocation_appr.png")
	  ImageResource AllocationApproved();

	}
