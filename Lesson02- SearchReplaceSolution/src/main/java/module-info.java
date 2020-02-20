module org.openjfx.lesson02searchreplace {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens org.openjfx.lesson02searchreplace to javafx.fxml;
    exports org.openjfx.lesson02searchreplace;
}