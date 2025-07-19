package com.spotify.api.listeners;

import com.spotify.api.util.LoggerUtil;
import org.slf4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.time.LocalDateTime;

public class TestNGListener implements ITestListener {

    private static final Logger logger = LoggerUtil.getLogger(TestNGListener.class);

    public void onTestStart(ITestResult result) {
        logger.info("Test is getting started ..YAY !!{}", result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        logger.info("Test is passed ..YAY !!{}", result.getMethod().getMethodName());
    }

    public void onTestFailure(ITestResult result) {
        logger.error("Test is failed ..SAD !! {}", result.getMethod().getMethodName());
        logger.error("Failure exception", result.getThrowable());
    }

    public void onTestSkipped(ITestResult result) {
        logger.warn("Test is skipped ..CHECK !! {}",result.getMethod().getMethodName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
        logger.info("-------------------- TESTNG SUITE START --------------------");
        logger.info(" Suite: {} started at {}", context.getName(), LocalDateTime.now());
        logger.info("------------------------------------------------------------\n");
    }

    public void onFinish(ITestContext context) {
        logger.info("-------------------- TESTNG SUITE COMPLETED --------------------");
        logger.info(" Suite: {} Completed at {}", context.getName(), LocalDateTime.now());
        logger.info("-----------------------------------------------------------\n");
    }
}
