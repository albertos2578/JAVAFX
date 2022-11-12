module com.mycompany.jdbc_fx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.sql;
    requires java.base;
    requires lombok;
    requires javafx.base;
    requires javafx.graphics;
    
    opens com.mycompany.jdbc_fx to javafx.fxml;
    opens models;
    exports com.mycompany.jdbc_fx;
 
}
