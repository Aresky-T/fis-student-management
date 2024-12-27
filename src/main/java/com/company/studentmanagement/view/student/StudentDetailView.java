package com.company.studentmanagement.view.student;

import com.company.studentmanagement.entity.Student;
import com.company.studentmanagement.entity.Transcript;
import com.company.studentmanagement.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.core.DataManager;
import io.jmix.flowui.model.CollectionContainer;
import io.jmix.flowui.model.CollectionPropertyContainer;
import io.jmix.flowui.model.DataContext;
import io.jmix.flowui.view.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route(value = "students/:id", layout = MainView.class)
@ViewController(id = "Student.detail")
@ViewDescriptor(path = "student-detail-view.xml")
@EditedEntityContainer("studentDc")
public class StudentDetailView extends StandardDetailView<Student> {

    private static final Logger log = LoggerFactory.getLogger(StudentDetailView.class);
    @ViewComponent
    private CollectionPropertyContainer<Transcript> transcriptsDc;

    @ViewComponent
    private DataContext dataContext;

    @Autowired
    private DataManager dataManager;

    @Subscribe
    public void onBeforeShow(final BeforeShowEvent event){
    }

//    @Subscribe(id = "transcriptsDc", target = Target.DATA_CONTAINER)
//    public void onTranscriptsDcCollectionChange(final CollectionContainer.CollectionChangeEvent<Transcript> event) {
//        Student student = getEditedEntity();
//        List<Transcript> transcripts = student.getTranscripts();
//        log.info("Transcripts: {}", transcripts);
//        for (Transcript ts : transcripts){
//            if (student.getTranscripts().stream().noneMatch(item -> item.equals(ts))){
//                Transcript transcript = dataContext.create(Transcript.class);
//                transcript.setId(ts.getId());
//                transcript.setStudent(student);
//                transcript.setSemester(ts.getSemester());
//                transcript.setCourseClass(ts.getCourseClass());
//                transcript.setProcessScore(ts.getProcessScore());
//                transcript.setExamScore(ts.getExamScore());
//                transcript.setFinalScore(ts.getFinalScore());
//                transcript.setLetterGrade(ts.getLetterGrade());
//                transcriptsDc.getMutableItems().add(transcript);
//            }
//        }
//    }
}