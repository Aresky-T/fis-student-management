package com.company.studentmanagement.view.managementclass;

import com.company.studentmanagement.entity.ManagementClass;
import com.company.studentmanagement.entity.Student;
import com.company.studentmanagement.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.model.CollectionContainer;
import io.jmix.flowui.model.InstanceContainer;
import io.jmix.flowui.view.*;

import java.util.List;
import java.util.Optional;

@Route(value = "managementClasses/:id", layout = MainView.class)
@ViewController(id = "ManagementClass.detail")
@ViewDescriptor(path = "management-class-detail-view.xml")
@EditedEntityContainer("managementClassDc")
public class ManagementClassDetailView extends StandardDetailView<ManagementClass> {

    @Subscribe(id = "managementClassStudentsDc", target = Target.DATA_CONTAINER)
    public void onManagementClassStudentsDcCollectionChange(final CollectionContainer.CollectionChangeEvent<Student> event) {
        updateManagementClassNumberOfStudents();
    }

    @Subscribe(id = "managementClassStudentsDc", target = Target.DATA_CONTAINER)
    public void onManagementClassStudentsDcItemChange(final InstanceContainer.ItemChangeEvent<Student> event) {
        updateManagementClassNumberOfStudents();
    }

    private void updateManagementClassNumberOfStudents(){
        ManagementClass cls = getEditedEntity();
        int stdCount = Optional.ofNullable(cls.getStudents())
                .map(List::size).orElse(0);

        cls.setTotalStudents(Math.max(stdCount, 0));
    }
}