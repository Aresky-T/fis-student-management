package com.company.studentmanagement.view.student;

import com.company.studentmanagement.entity.Student;
import com.company.studentmanagement.view.main.MainView;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.renderer.Renderer;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;
import io.jmix.core.FileRef;
import io.jmix.core.FileStorage;
import io.jmix.flowui.UiComponents;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;


@Route(value = "students", layout = MainView.class)
@ViewController(id = "Student.list")
@ViewDescriptor(path = "student-list-view.xml")
@LookupComponent("studentsDataGrid")
@DialogMode(width = "64em")
public class StudentListView extends StandardListView<Student> {

    @Autowired
    private UiComponents uiComponents;

    @Autowired
    private FileStorage fileStorage;

    @Supply(to = "studentsDataGrid.studentPic", subject = "renderer")
    private Renderer<Student> studentsDataGridPictureRenderer() {
        return new ComponentRenderer<>(student -> {
            Image image = uiComponents.create(Image.class);
            image.setClassName("student-picture");
            image.setWidth("40px");
            image.setHeight("40px");
            image.setMinWidth("40px");

            FileRef imageFile = student.getPicture();
            if(imageFile != null){
                StreamResource resource = new StreamResource("" , () -> fileStorage.openStream(imageFile));
                image.setSrc(resource);
            } else {
                image.setSrc("https://static.vecteezy.com/system/resources/previews/019/879/186/non_2x/user-icon-on-transparent-background-free-png.png");
            }

            return image;
        });
    }
}