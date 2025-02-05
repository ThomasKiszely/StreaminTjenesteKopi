module com.thomas.streamintjenestekopi {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.thomas.streamintjenestekopi to javafx.fxml;
    exports com.thomas.streamintjenestekopi;
}