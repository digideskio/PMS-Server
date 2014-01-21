package com.media2359.euphoria.view.client.manpower.common;

import com.google.gwt.editor.client.Editor.Path;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;
import com.media2359.euphoria.view.dto.project.PlatformDTO;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface PlatformDTOProperties extends
PropertyAccess<PlatformDTO> {
@Path("platformKey")
ModelKeyProvider<PlatformDTO> platformKey();

LabelProvider<PlatformDTO> platformId();
}
