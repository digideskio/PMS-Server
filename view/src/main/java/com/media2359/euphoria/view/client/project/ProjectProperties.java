package com.media2359.euphoria.view.client.project;

import com.google.gwt.editor.client.Editor.Path;
import com.media2359.euphoria.view.dto.project.ProjectDTO;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface ProjectProperties extends PropertyAccess<ProjectDTO> {
	@Path("id")
	ModelKeyProvider<ProjectDTO> key();

	ValueProvider<ProjectDTO, String> name();

	ValueProvider<ProjectDTO, Double> manDaysLeft();

	ValueProvider<ProjectDTO, Integer> milestoneCount();

	ValueProvider<ProjectDTO, Integer> completedMilestoneCount();

}
