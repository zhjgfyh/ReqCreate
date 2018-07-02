package ChinaDeb;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;

public class ConsultPrice {

public WebDriver driver;
	
	/**
	 * 初始化driver
	 * */
	public void InitDriver(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ZJ\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://192.168.6.108:1111/view/auth/login.html");
		driver.manage().window().maximize();
	}
	
	/**
	 * 输入框
	 * */
	public void InputBox(){
		WebElement user = driver.findElement(By.id("name"));
		user.sendKeys("tdn123");
		user.clear();
		user.sendKeys("sqw123");
		// 获取输入框默认提示信息
		String user_info = user.getAttribute("placeholder");
		System.out.println(user_info);
		// 获取输入的内容
		String user_value = user.getAttribute("value");
		System.out.println(user_value);
		// 判断输入框是否为可输入状态
		boolean enable = user.isEnabled();
		System.out.println(enable);
		driver.findElement(By.name("password")).sendKeys("sqw123");
		driver.findElement(By.className("loginBtn")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.className("help")).click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 层级定位采购管理按钮
		WebElement element = driver.findElement(By.className("menuB"));
		List<WebElement> elements = element.findElements(By.tagName("li"));
		elements.get(1).click();
		this.sleep(2000);
	}
	

	public void purchaseRequest(){
		// 定位询比价采购按钮
		//WebElement element = driver.findElement(By.className("workbenchL_menu"));
		//List<WebElement> elements = element.findElements(By.tagName("li"));
		//elements.get(3).click();
		
		// 询价单管理
		driver.get("http://192.168.6.108:1111/view/purchaseManage/enquiryManage/inquiryList/waitingCreate.html");
		this.sleep(3000);
		
		//driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/table/tbody/tr[1]/td[8]/div/a")).click();
		//this.sleep(1000);
		
		Set<String> handles = driver.getWindowHandles(); 
		for(String s:handles){
			System.out.println(s);
			driver.switchTo().window(s);
		}
		driver.findElement(By.linkText("已揭示")).click();
		
		//WebElement checkout = driver.findElement(By.className("yjs_tbody_cont"));
		//List<WebElement> checkouts = checkout.findElements(By.className("look"));
		//checkouts.get(1).click();

	}
	
	private void sleep(int i) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		//实例化对象
		ConsultPrice action = new ConsultPrice();
		action.InitDriver();
		action.InputBox();
		action.purchaseRequest();
	}
}
