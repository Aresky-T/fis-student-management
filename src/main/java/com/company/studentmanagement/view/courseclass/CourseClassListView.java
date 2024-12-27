package com.company.studentmanagement.view.courseclass;

import com.company.studentmanagement.entity.CourseClass;
import com.company.studentmanagement.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "courseClasses", layout = MainView.class)
@ViewController(id = "CourseClass.list")
@ViewDescriptor(path = "course-class-list-view.xml")
@LookupComponent("courseClassesDataGrid")
@DialogMode(width = "64em")
public class CourseClassListView extends StandardListView<CourseClass> {
}