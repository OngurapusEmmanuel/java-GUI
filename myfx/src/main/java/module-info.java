module emmerh.myfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens emmerh.myfx to javafx.fxml;
    exports emmerh.myfx;
}