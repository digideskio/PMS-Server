package com.media2359.euphoria.view.client.project;

import com.sencha.gxt.cell.core.client.TextButtonCell;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.ui.Image;


public class ViewProjectCell extends TextButtonCell{

    @Override
    public void render(com.google.gwt.cell.client.Cell.Context context, 
            String value, SafeHtmlBuilder sb) {
        SafeHtml html = SafeHtmlUtils.fromTrustedString(new Image("/static/images/arrow.png").toString());
        sb.append(html);
    }
}