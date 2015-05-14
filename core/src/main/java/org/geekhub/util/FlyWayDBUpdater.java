package org.geekhub.util;


import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.FlywayException;

import javax.sql.DataSource;

/**
 * Created by helldes on 13.05.2015.
 */
public class FlyWayDBUpdater {
    private DataSource dataSource;

    public FlyWayDBUpdater(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void updaterDB(){
        try {
            Flyway flyway = new Flyway();
            flyway.setDataSource(dataSource);
            flyway.migrate();
        }catch (FlywayException e){
           e.printStackTrace();
        }
    }
}
