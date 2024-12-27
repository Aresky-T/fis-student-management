package com.company.studentmanagement.view.transcript;

import com.company.studentmanagement.entity.Transcript;
import com.company.studentmanagement.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "transcripts", layout = MainView.class)
@ViewController(id = "Transcript.list")
@ViewDescriptor(path = "transcript-list-view.xml")
@LookupComponent("transcriptsDataGrid")
@DialogMode(width = "64em")
public class TranscriptListView extends StandardListView<Transcript> {
}