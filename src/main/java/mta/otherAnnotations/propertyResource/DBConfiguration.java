package mta.otherAnnotations.propertyResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:dbTestProperResource.properties")
@PropertySource(value = "classpath:rootTestProperResource.properties", ignoreResourceNotFound = true)
public class DBConfiguration {
    @Autowired
    Environment env;
    // Tu dong chay phuong thuc ngay khi khoi dong chuong
    @Bean
    public DBConnection getDBConnection() {
        System.out.println("Getting DBConnection Bean for App: " + env.getProperty("APP_NAME"));        
        DBConnection dbConnection = new DBConnection();
        return dbConnection;
    }
}
