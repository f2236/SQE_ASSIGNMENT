package com.automation.framework.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static void initReport() {
        String path = System.getProperty("user.dir") + "/reports/ExtentReport.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    public static ExtentTest createTest(String testName) {
        test = extent.createTest(testName);
        return test;
    }

    public static void flush() {
        extent.flush();
    }
}
