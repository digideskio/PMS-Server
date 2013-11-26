/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.view.client.core;

import com.sencha.gxt.cell.core.client.TextButtonCell;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.ui.Image;

/**
 * ViewCell
 *
 * TODO Write something about this class
 * 
 * @author Praveen
 * @version 1.0 2013
 **/

public class ViewCell extends TextButtonCell{

    @Override
    public void render(com.google.gwt.cell.client.Cell.Context context, 
            String value, SafeHtmlBuilder sb) {
        SafeHtml html = SafeHtmlUtils.fromTrustedString(new Image("/static/images/arrow.png").toString());
        sb.append(html);
    }
}