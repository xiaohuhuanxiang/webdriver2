package com.demo.seleniumandroid;

import junit.framework.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.android.AndroidDriver;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class demoseleniumTestng  {
	WebDriver driver ;

	@BeforeTest
	public void setUp() {
		// �����ֻ��˵�webdriver������Ϊ����ˣ�û������ǰ̨Ӧ��
		try {
			//��webdriver
			// ����adb ��������http://jingyan.baidu.com/article/17bd8e52f514d985ab2bb800.html
Runtime.getRuntime().exec( "adb shell am start -a android.intent.action.MAIN " +	"-n org.openqa.selenium.android.app/.MainActivity");
/*���ӷ����webdriver�������õĶ˿�Ϊ8080����������п����˻�ʹ���˸ö˿ڣ���Ҫ�رգ�http://localhost:8080/exit������Ȼ���Ӳ��Ϸ����webdriver   */
 Runtime.getRuntime().exec("adb -s HC51BWWE0103 forward tcp:8080 tcp:8080");
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver = new AndroidDriver();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test  
    public void testBaidu() {        
		driver.get("http://m.baidu.com/");
		System.out.println("title:"+driver.getTitle());//title:�ٶ�һ��
			WebElement element = driver.findElement(By.name("word"));
			element.sendKeys("hello");
			
			element.submit();
			
			System.out.println("title:"+driver.getTitle());//title:hello - �ٶ�
   }  


}
