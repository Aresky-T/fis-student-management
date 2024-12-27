package com.company.studentmanagement.view.managementclass;

import com.company.studentmanagement.entity.ManagementClass;
import com.company.studentmanagement.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "managementClasses", layout = MainView.class)
@ViewController(id = "ManagementClass.list")
@ViewDescriptor(path = "management-class-list-view.xml")
@LookupComponent("managementClassesDataGrid")
@DialogMode(width = "64em")
public class ManagementClassListView extends StandardListView<ManagementClass> {
}