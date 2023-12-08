module com.messagegui {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.messagegui to javafx.fxml;
    exports com.messagegui;

    //com.messagegui does not export main.messagegui.Controller to module javafx.fxml
    //	at java.base/jdk.internal.reflect.Reflection.newIllegalAccessException(Reflection.java:394)
    //	at java.base/java.lang.reflect.AccessibleObject.checkAccess(AccessibleObject.java:709)
    opens com.messagegui.Controller to javafx.fxml;
    exports com.messagegui.Controller;
}