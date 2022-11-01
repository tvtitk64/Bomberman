module uet.oop.bomberman {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.datatransfer;
    requires java.desktop;
    requires jdk.jfr;


    opens uet.oop.bomberman to javafx.fxml;
    exports uet.oop.bomberman;
}