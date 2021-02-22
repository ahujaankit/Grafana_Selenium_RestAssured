package Selenium_Grafana_Influx.Selenium_Grafana_Influx;

import org.influxdb.dto.Point;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.util.concurrent.TimeUnit;

public class ExecutionListener implements ITestListener {
	
	String status = "";
	TestCases testcases = new TestCases();

	public void onTestStart(ITestResult iTestResult) {

	}

	public void onTestSuccess(ITestResult iTestResult) {
		if (Settings.testMode.equals("API_Testing")) {
			status = String.valueOf(Settings.statusCode);
			this.sendTestResult(iTestResult, status);
		}
		if (Settings.testMode.equals("UI_Testing")) {
			this.sendTestMethodStatus(iTestResult, "PASS");
			this.sendTestResult(iTestResult, "PASS");
		}
	}

	public void onTestFailure(ITestResult iTestResult) {
		if (Settings.testMode.equals("API_Testing")) {
			status = String.valueOf(Settings.statusCode);
			this.sendTestResult(iTestResult, status);
		}
		if (Settings.testMode.equals("UI_Testing")) {
			this.sendTestMethodStatus(iTestResult, "FAIL");
			this.sendTestResult(iTestResult, "FAIL");
		}
	}

	public void onTestSkipped(ITestResult iTestResult) {
		if (Settings.testMode.equals("API_Testing")) {
			Settings.timer = 0;
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%    Test Skipped %%%%%%%%%%%%%%%%%%%%%%%%%%%");
			status = String.valueOf(Settings.statusCode);
			this.sendTestResult(iTestResult, status);
		}
		if (Settings.testMode.equals("UI_Testing")) {
			Settings.timer = 0;
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%    Test Skipped %%%%%%%%%%%%%%%%%%%%%%%%%%%");
			this.sendTestMethodStatus(iTestResult, "SKIPPED");
			this.sendTestResult(iTestResult, "SKIPPED");
		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

	}

	public void onStart(ITestContext iTestContext) {

	}

	public void onFinish(ITestContext iTestContext) {
		this.sendTestClassStatus(iTestContext);

	}

	private void sendTestResult(ITestResult iTestResult, String status) {
		Point point = Point.measurement("testResult").time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
				.addField("applicationName", "www.amazon.com :- " + Settings.testMode)
				.addField("method", iTestResult.getMethod().getMethodName()).addField("status", status)
				.addField("responseTime", Settings.timer)
				.addField("duration", (iTestResult.getEndMillis() - iTestResult.getStartMillis())).build();
		ResultSender.send(point);
	}

	private void sendTestMethodStatus(ITestResult iTestResult, String status) {
		Point point = Point.measurement("testmethod").time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
				.tag("testclass", iTestResult.getTestClass().getName()).tag("name", iTestResult.getName())
				.tag("description", iTestResult.getMethod().getDescription()).tag("result", status)
				.addField("duration", (iTestResult.getEndMillis() - iTestResult.getStartMillis())).build();
		ResultSender.send(point);
	}

	private void sendTestClassStatus(ITestContext iTestContext) {
		Point point = Point.measurement("testclass").time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
				.tag("name", iTestContext.getAllTestMethods()[0].getTestClass().getName())
				.addField("duration", (iTestContext.getEndDate().getTime() - iTestContext.getStartDate().getTime()))
				.build();
		ResultSender.send(point);
	}

}