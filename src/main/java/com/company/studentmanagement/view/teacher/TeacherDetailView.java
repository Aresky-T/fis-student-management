package com.company.studentmanagement.view.teacher;

import com.company.studentmanagement.entity.Teacher;
import com.company.studentmanagement.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "teachers/:id", layout = MainView.class)
@ViewController(id = "Teacher.detail")
@ViewDescriptor(path = "teacher-detail-view.xml")
@EditedEntityContainer("teacherDc")
public class TeacherDetailView extends StandardDetailView<Teacher> {
}