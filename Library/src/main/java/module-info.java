module com.anhquoc0304.library {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires javafx.base;
    requires javafx.graphics;

    opens com.anhquoc0304.library to javafx.fxml;
    exports com.anhquoc0304.library;
}
