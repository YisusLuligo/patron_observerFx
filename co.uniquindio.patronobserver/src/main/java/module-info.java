module co.uniquindio.patronobserver.patronobserverapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens co.uniquindio.patronobserver.patronobserverapp to javafx.fxml;
    exports co.uniquindio.patronobserver.patronobserverapp;
    opens co.uniquindio.patronobserver.patronobserverapp.controller;
    exports co.uniquindio.patronobserver.patronobserverapp.controller;
}