package com.company.studentmanagement.view.courseclass;

import com.company.studentmanagement.entity.CourseClass;
import com.company.studentmanagement.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "courseClasses/:id", layout = MainView.class)
@ViewController(id = "CourseClass.detail")
@ViewDescriptor(path = "course-class-detail-view.xml")
@EditedEntityContainer("courseClassDc")
public class CourseClassDetailView extends StandardDetailView<CourseClass> {
}