package com.media2359.euphoria.view.client.core;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.BrowserEvents;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.dom.client.Style.VerticalAlign;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safecss.shared.SafeStyles;
import com.google.gwt.safecss.shared.SafeStylesUtils;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.ui.AbstractImagePrototype;




public class AllocationGridColorCell extends AbstractCell<AllocationStatus> {


	interface Templates extends SafeHtmlTemplates {

	    @SafeHtmlTemplates.Template("<div><a class=\"{2}\" title=\"{1}\">{0}</a></div>")
	    SafeHtml toolTipCell(SafeHtml value, String tooltip, String style);
	    
	    @SafeHtmlTemplates.Template("<div><a class=\"{1}\">{0}</a></div>")
	    SafeHtml noToolTipCell(SafeHtml value, String style);
	  }
	
    private static  AllocationGridColorCellImages images = GWT.create(AllocationGridColorCellImages.class);
  
    private ImageResource image;
    private static Templates templates = GWT.create(Templates.class);
    
    public static boolean CLICK_ENABLED=true; 
    
    public AllocationGridColorCell(){
    	super(BrowserEvents.MOUSEOVER,BrowserEvents.CLICK);
    }
    @Override
    public void render(Context context, AllocationStatus value, SafeHtmlBuilder sb) {
      if (value == null) 
        return;
      
      String style = null;
      SafeHtml valueHtml = null;
      
      if(value.equals(AllocationStatus.HOLIDAY)||value.equals(AllocationStatus.LEAVE)){
    	  style = SafeStylesUtils.forVerticalAlign(VerticalAlign.MIDDLE).asString();
    	  valueHtml = SafeHtmlUtils.fromString(value.toString());    	  
      }
      else{	      
	      switch (value){
	      	case FREE: image = images.Free();break;
	      	case SELECTED: image = images.Selected();break;
	      	case EXCEEDED: image = images.Exceeded();break;
	      	case SELECTED_EXCEEDED: image = images.SelectExceeded();break;
	      	default: image=images.Free();
	      }
	      style = SafeStylesUtils.forVerticalAlign(VerticalAlign.MIDDLE).asString();
	      valueHtml = AbstractImagePrototype.create(image).getSafeHtml();
      }      
      if(CLICK_ENABLED)
    	  sb.append(templates.toolTipCell(valueHtml, value.getEnabledTooltip(), style));
      else
    	  sb.append(templates.toolTipCell(valueHtml, value.getDisabledTooltip(),style));

      }
    
    
    @Override
    public void onBrowserEvent(Context context, Element parent, AllocationStatus value,
            NativeEvent event, ValueUpdater<AllocationStatus> valueUpdater) {
    	super.onBrowserEvent(context, parent, value, event, valueUpdater);
    	if(CLICK_ENABLED)
	    	if(!event.getType().equals(BrowserEvents.CLICK))
	    		setCursor(parent, value);
	    	else{
	    		AllocationStatus newValue = getNewAllocationStatus(value);
				valueUpdater.update(newValue);
				setCursor(parent, newValue);
	    	}
    	
    
    }
    
    private void setCursor(Element parent, AllocationStatus value){
    	if(!(value.equals(AllocationStatus.LEAVE)||value.equals(AllocationStatus.HOLIDAY)))    			
			parent.getStyle().setCursor(Cursor.POINTER);
		else
			parent.getStyle().setCursor(Cursor.DEFAULT);
    }
    
    private AllocationStatus getNewAllocationStatus(AllocationStatus previousStatus){
		   switch(previousStatus){
			   	case FREE: return AllocationStatus.SELECTED;
			   	case SELECTED: return AllocationStatus.FREE;
			   	case EXCEEDED: return AllocationStatus.SELECTED_EXCEEDED;
			   	case SELECTED_EXCEEDED: return AllocationStatus.EXCEEDED;
			   	default:   return previousStatus;
		   }
		   
	   }
 
    
  }