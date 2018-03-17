package com.example.projectsapi;

import org.flywaydb.core.api.callback.BaseFlywayCallback;
import java.sql.Connection;

public class SeedDB extends BaseFlywayCallback {
    public void afterMigrate(Connection connection) {
        /*
        * GET from employees-api all EMPLOYEES where POSITION is 4
        * For each employee, add project from own region
        * */
    }
}
