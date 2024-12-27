package com.company.studentmanagement.view.course;

import com.company.studentmanagement.entity.Course;
import com.company.studentmanagement.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "courses/:id", layout = MainView.class)
@ViewController(id = "Course.detail")
@ViewDescriptor(path = "course-detail-view.xml")
@EditedEntityContainer("courseDc")
public class CourseDetailView extends StandardDetailView<Course> {
}