module br.cefsa.edu.classeslib {
    requires derbyclient;
    requires java.sql;
    requires org.junit.jupiter.api;

    exports br.cefsa.edu.classeslib.entities;
    exports br.cefsa.edu.classeslib.DAO;
    exports br.cefsa.edu.classeslib.enums;
}
