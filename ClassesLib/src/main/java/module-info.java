module br.cefsa.edu.classeslib {
    requires derbyclient;
    requires java.sql;

    exports br.cefsa.edu.classeslib.entities;
    exports br.cefsa.edu.classeslib.DAO;
    exports br.cefsa.edu.classeslib.enums;
    exports br.cefsa.edu.classeslib.business;
    exports br.cefsa.edu.classeslib.exception.messages;
}
