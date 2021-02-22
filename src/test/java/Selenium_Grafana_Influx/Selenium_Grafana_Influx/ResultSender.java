package Selenium_Grafana_Influx.Selenium_Grafana_Influx;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;

public class ResultSender {

    private static final InfluxDB INFLXUDB = InfluxDBFactory.connect("http://localhost:8086", "root", "root");
    private static final String DATABASE = "selenium_test_results";

    static{
        INFLXUDB.setDatabase(DATABASE);
    }

    public static void send(final Point point){
        INFLXUDB.write(point);
    }

}