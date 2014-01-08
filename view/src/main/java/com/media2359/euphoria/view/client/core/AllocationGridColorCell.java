package com.media2359.euphoria.view.client.core;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safecss.shared.SafeStyles;
import com.google.gwt.safecss.shared.SafeStylesUtils;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

public class AllocationGridColorCell extends AbstractCell<AllocationStatus> {

    /**
     * The HTML templates used to render the cell.
     */
    interface Templates extends SafeHtmlTemplates {

      @SafeHtmlTemplates.Template("<div style=\"{0}\">{1}</div>")
      SafeHtml cell(SafeStyles styles, SafeHtml value);
    }

    /**
     * Create a singleton instance of the templates used to render the cell.
     */
    private static Templates templates = GWT.create(Templates.class);
    private static  AllocationGridColorCellImages images = GWT.create(AllocationGridColorCellImages.class);
    private String imageHtml;
    private ImageResource image;
    @Override
    public void render(Context context, AllocationStatus value, SafeHtmlBuilder sb) {
      if (value == null) 
        return;
      else if(value.equals(AllocationStatus.HOLIDAY)||value.equals(AllocationStatus.LEAVE)){
    	  sb.append(SafeHtmlUtils.fromString(value.toString()));
      }
      else{	      
	      switch (value){
	      	case FREE: image = images.Free();break;
	      	case SELECTED: image = images.Selected();break;
	      	case EXCEEDED: image = images.Exceeded();break;
	      	case SELECTED_EXCEEDED: image = images.SelectExceeded();break;
	      	default: System.out.println("VALUEEEEEEEEEEEEEEEEEEEE   "+value);
	      }
	      imageHtml = AbstractImagePrototype.create(image).getHTML();
	      sb.appendHtmlConstant(imageHtml);
      }
      }
  }