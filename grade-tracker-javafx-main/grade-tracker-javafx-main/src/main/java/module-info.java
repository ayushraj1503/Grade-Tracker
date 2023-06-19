module jason {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens MP3 to javafx.fxml;
    exports MP3;
}