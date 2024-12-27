package com.company.studentmanagement.view.transcript;

import com.company.studentmanagement.entity.CourseClass;
import com.company.studentmanagement.entity.Transcript;
import com.company.studentmanagement.view.main.MainView;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import io.jmix.core.entity.EntityPropertyChangeEvent;
import io.jmix.core.event.EntityChangedEvent;
import io.jmix.flowui.component.valuepicker.EntityPicker;
import io.jmix.flowui.model.DataContext;
import io.jmix.flowui.view.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;

@Route(value = "transcripts/:id", layout = MainView.class)
@ViewController(id = "Transcript.detail")
@ViewDescriptor(path = "transcript-detail-view.xml")
@EditedEntityContainer("transcriptDc")
public class TranscriptDetailView extends StandardDetailView<Transcript> {

    private static final Logger log = LoggerFactory.getLogger(TranscriptDetailView.class);

    @ViewComponent
    private TextField semesterField;

    @Subscribe("courseClassField")
    public void onCourseClassFieldComponentValueChange(final AbstractField.ComponentValueChangeEvent<EntityPicker<CourseClass>, CourseClass> event) {
        log.info("Changing transcript form...");
        Transcript transcript = getEditedEntity();

        if(transcript.getSemester() == null && transcript.getCourseClass() != null){
            transcript.setSemester(transcript.getCourseClass().getSemester());
        }
    }
}