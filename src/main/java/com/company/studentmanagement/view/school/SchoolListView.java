package com.company.studentmanagement.view.school;

import com.company.studentmanagement.entity.School;
import com.company.studentmanagement.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "schools", layout = MainView.class)
@ViewController(id = "School.list")
@ViewDescriptor(path = "school-list-view.xml")
@LookupComponent("schoolsDataGrid")
@DialogMode(width = "64em")
public class SchoolListView extends StandardListView<School> {
}