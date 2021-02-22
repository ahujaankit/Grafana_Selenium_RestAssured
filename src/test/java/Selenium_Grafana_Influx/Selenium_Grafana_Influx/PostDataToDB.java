/*
 * package Selenium_Grafana_Influx.Selenium_Grafana_Influx;
 * 
 * import java.util.concurrent.TimeUnit;
 * 
 * import org.influxdb.dto.Point; import org.testng.ITestContext; import
 * org.testng.ITestResult;
 * 
 * public class PostDataToDB {
 * 
 * public void sendTestResult(ITestResult iTestResult, String status) throws
 * NoSuchFieldException, SecurityException { Point point =
 * Point.measurement("testResult") .time(System.currentTimeMillis(),
 * TimeUnit.MILLISECONDS) .tag("applicationName", "www.amazon.com")
 * .tag("method", iTestResult.getMethod().getMethodName()) .tag("status",
 * status) .tag("responsetime",
 * TestCases.class.getDeclaredField("timer").toString()) .addField("duration",
 * (iTestResult.getEndMillis() - iTestResult.getStartMillis())) .build();
 * ResultSender.send(point); }
 * 
 * public void sendTestMethodStatus(ITestResult iTestResult, String status) {
 * System.out.println("Failing test cases 123"); Point point =
 * Point.measurement("testmethod") .time(System.currentTimeMillis(),
 * TimeUnit.MILLISECONDS) .tag("testclass",
 * iTestResult.getTestClass().getName()) .tag("name", iTestResult.getName())
 * .tag("description", iTestResult.getMethod().getDescription()) .tag("result",
 * status) .addField("duration", (iTestResult.getEndMillis() -
 * iTestResult.getStartMillis())) .build(); ResultSender.send(point); }
 * 
 * public void sendTestClassStatus(ITestContext iTestContext) { Point point =
 * Point.measurement("testclass") .time(System.currentTimeMillis(),
 * TimeUnit.MILLISECONDS) .tag("name",
 * iTestContext.getAllTestMethods()[0].getTestClass().getName())
 * .addField("duration", (iTestContext.getEndDate().getTime() -
 * iTestContext.getStartDate().getTime())) .build(); ResultSender.send(point); }
 * 
 * }
 */