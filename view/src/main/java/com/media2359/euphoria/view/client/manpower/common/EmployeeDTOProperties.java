package com.media2359.euphoria.view.client.manpower.common;

import com.google.gwt.editor.client.Editor.Path;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface EmployeeDTOProperties extends
PropertyAccess<EmployeeDTO> {
@Path("employeeKey")
ModelKeyProvider<EmployeeDTO> employeeKey();

LabelProvider<EmployeeDTO> name();
}

