package com.weborder;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Order {
	// public static int randNum(int a, int b) {
	// Random rd = new Random();
	// return rd.nextInt(b + 1 - a) + a;
	// }

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"/Users/akmaljonhamrokulov/Documents/selenium dependencies/drivers/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

		Thread.sleep(1000);
		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");

		Thread.sleep(1000);
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");

		driver.findElement(By.name("ctl00$MainContent$login_button")).click();

		driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[3]")).click();
		;

		Random r = new Random();
		int res = r.nextInt(100) + 1;
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("" + res);
		Random r2 = new Random();
		int middleNameLength = r2.nextInt(15);

		int a = 97; // letter ‘a’
		int z = 122; // letter ‘z’
		Random r3 = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < middleNameLength; i++) {
			int randomLetterInt = r3.nextInt(z - a + 1) + a;
			sb.append((char) randomLetterInt);
		}
		String middleName = sb.toString(); // get a random middleName
		// System.out.println(middleName);
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys("John " + middleName + " Smith");

		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("123 Any st");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("Anytown");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys("Virginia");

		Random r31 = new Random();
		int result = r31.nextInt(12345) + 30000;
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys("" + result);

		Random r32 = new Random();
		int target = r32.nextInt(3) + 1;

		if (target == 1) {
			driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_cardList\"]/tbody/tr/td[1]/label"))
					.click();
			// driver.findElement(By.xpath(“//*[@id=\“ctl00_MainContent_fmwOrder_cardList_0\“]”)).isSelected();
			StringBuilder cardNumber = new StringBuilder("4");
			for (int i = 0; i < 15; i++) {
				cardNumber.append(r.nextInt(10));
			}
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(cardNumber);
		} else if (target == 2) {
			driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_cardList_1\"]")).click();
			// driver.findElement(By.xpath(“//*[@id=\“ctl00_MainContent_fmwOrder_cardList_1\“]”)).isSelected();
			StringBuilder cardNumber = new StringBuilder("5");
			for (int i = 0; i < 15; i++) {
				cardNumber.append(r.nextInt(10));
			}
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(cardNumber);
		} else {
			driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_cardList_2\"]")).click();
			// driver.findElement(By.xpath(“//*[@id=\“ctl00_MainContent_fmwOrder_cardList_2\“]”)).isSelected();
			StringBuilder cardNumber = new StringBuilder("5");
			for (int i = 0; i < 15; i++) {
				cardNumber.append(r.nextInt(10));
			}
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(cardNumber);
		}
		
		int m = r.nextInt(12)+1;  // get month for expiration date
        String month = "" + m;
        if (m < 10) {
            month = 0 + month;
        }
        int y = r.nextInt(100);// get year for expiration date
        String year = "" + y;
        if (y < 10) {
            year = 0 + year;
        }
        
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox1\"]")).sendKeys(month + "/" + year);// input expiration date

        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_InsertButton\"]")).click();
        
        String expected="New Order has been successfully added";
        
        String actual= driver.getPageSource();
        if(actual.contains(expected)) {
            System.out.println("pass");
        }else {
            System.out.println("fail");
            System.out.println("Expected:\t"+expected);
            System.out.println("Actual:\t"+actual);
        }
    }

	}

