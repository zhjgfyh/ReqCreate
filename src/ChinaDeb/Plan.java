/**
 * CaseName：采购计划创建
 * Time：20180702
 * Creator: ZJ
 * */

package ChinaDeb;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Plan {
	
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
	 * 登录
	 * */
	public void InputBox(){
		WebElement user = driver.findElement(By.id("name"));
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
		
		/**
		 * 点击工作台
		 * */
		driver.findElement(By.className("help")).click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**
		 * 层级定位采购管理按钮
		 * */ 
		WebElement element = driver.findElement(By.className("menuB"));
		List<WebElement> elements = element.findElements(By.tagName("li"));
		elements.get(1).click();
		this.sleep(2000);
	}
	

	public void RequestPlan(){
		/**
		 * 定位采购计划管理按钮
		 * */ 
		WebElement element = driver.findElement(By.className("workbenchL_menu"));
		List<WebElement> elements = element.findElements(By.tagName("li"));
		elements.get(2).click();
		
		/**
		 * 创建采购计划
		 * */ 
		driver.get("http://192.168.6.108:1111/view/purchaseManage/procurementPlan/addPurchaseApply.html");
		this.sleep(1000);
		
		/**
		 * 添加采购申请
		 * */ 
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div[1]/div/a")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**
		 * 选择采购申请 - 多选框CheckBox
		 * */ 
		driver.findElement(By.className("custom-checkbox")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**
		 * 点击确定
		 * */ 
		driver.findElement(By.xpath("//*[@id='tip']/li[3]/button[1]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**
		 * 点击下一步
		 * */ 
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div[2]/a[1]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/**
		 * 输入采购计划编号
		 * */ 
		driver.findElement(By.name("planCodeId")).sendKeys("Plan-JC-070515");
		this.sleep(1000);
			
		/**
		 * 输入采购计划名称
		 * */ 
		driver.findElement(By.name("planName")).sendKeys("采购计划-集采-070515");
		this.sleep(1000);
		
		/**
		 * 概算金额使用申请带过来的
		 * */ 
		
		/**
		 * 税率 - 3%
		 * */ 
		WebElement rate = driver.findElement(By.xpath("//*[@id='Form']/div[5]/select"));
		Select rateOpt = new Select(rate);
		rateOpt.selectByValue("3");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		/**
		 * 计划截止日期
		 * */ 
		driver.findElement(By.xpath("//*[@id='Form']/div[6]/input[2]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**
		 * 切换到iFrame再跳出
		 * */ 
		WebElement planDeadline = driver.findElement(By.xpath("/html/body/div[3]/iframe"));
		this.sleep(2000);
		driver.switchTo().frame(planDeadline);
		this.sleep(2000);
		driver.findElement(By.xpath("//*[@id='dpTodayInput']")).click();
		this.sleep(2000);
		driver.switchTo().defaultContent();
		this.sleep(1000);
		
		/**
		 * 询价方式
		 * */ 
		driver.findElement(By.className("borderStyl")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**
		 * 选择供应商
		 * */ 
		driver.findElement(By.xpath("//*[@id='tip']/li[2]/div[2]/table/tbody/tr[1]/td[7]/a")).click();
		this.sleep(2000);
		driver.findElement(By.xpath("//*[@id='tip']/li[2]/div[2]/table/tbody/tr[2]/td[7]/a")).click();
		this.sleep(2000);
		driver.findElement(By.xpath("//*[@id='tip']/li[2]/div[2]/table/tbody/tr[3]/td[7]/a")).click();
		this.sleep(2000);
		
		/**
		 * 点击确定按钮
		 * */ 
		driver.findElement(By.className("hasChoseBtn")).click();
		this.sleep(2000);
		
		/**
		 * 点击保存按钮
		 * */ 
		driver.findElement(By.xpath("//*[@id='Form']/div[12]/a[2]")).click();
		this.sleep(2000);
	}


	private void sleep(int i) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args){
		/**
		 * 实例化对象
		 * */
		Plan action = new Plan();
		action.InitDriver();
		action.InputBox();
		action.RequestPlan();
	}

}