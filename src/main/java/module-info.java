module cs.project {
    requires javafx.controls;
    requires javafx.fxml;

    exports cs.project;
    opens cs.project to javafx.fxml;
}