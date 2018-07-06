package ChinaDeb;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Select;

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
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 创建询价单（第一条单据）
		driver.findElement(By.className("Tab_set")).click();
		this.sleep(2000);
		
		// 询价单编号
		driver.findElement(By.name("consultCode")).sendKeys("XJD-0706-100");
		this.sleep(2000);
		
		// 询价单名称
		driver.findElement(By.name("consultName")).sendKeys("询价单0706-100");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 报价截止时间
		driver.findElement(By.id("offerendTime")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
		/**
		 * 切换到iFrame再跳出
		 * */ 
		WebElement offerendTime = driver.findElement(By.xpath("/html/body/div[3]/iframe"));
		this.sleep(2000);
		driver.switchTo().frame(offerendTime);
		this.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div[3]/table/tbody/tr[6]/td[4]")).click();
		this.sleep(2000);
		driver.findElement(By.id("dpOkInput")).click();
		this.sleep(2000);
		driver.switchTo().defaultContent();
		this.sleep(1000);
		
		// 价格方式 - 总价（分项：//*[@id="addConsultPrice"]/div[4]/input[2]）
		driver.findElement(By.xpath("//*[@id='addConsultPrice']/div[4]/input[1]")).click();
		this.sleep(2000);
		
		// 价格类型 - 到货价
		driver.findElement(By.xpath("//*[@id='addConsultPrice']/div[5]/input[1]")).click();
		this.sleep(2000);
		
		// 是否含税
		driver.findElement(By.xpath("//*[@id='addConsultPrice']/div[6]/input[1]")).click();
		this.sleep(2000);
		
		// 税率 - 4%
		WebElement rate = driver.findElement(By.name("taxRate"));
		Select rateOpt = new Select(rate);
		rateOpt.selectByValue("4");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 结算条件 - 货到付款并留质保金 
		driver.findElement(By.xpath("//*[@id='addConsultPrice']/div[8]/input[2]")).click();
		this.sleep(2000);
		
		// 质保金 比例
		driver.findElement(By.name("guaranteeMoneyRate")).sendKeys("5");
		this.sleep(1000);
		
		// 联系人姓名
		driver.findElement(By.name("contactName")).sendKeys("张三");
		this.sleep(1000);
		
		// 手机号码
		driver.findElement(By.name("contactPhone")).sendKeys("13910733251");
		this.sleep(1000);

		// 点击保存
		driver.findElement(By.xpath("//*[@id='addConsultPrice']/div[19]/a[1]")).click();
		this.sleep(1000);
		
		/**
		 * 切换到已揭示列表
		 * 
		Set<String> handles = driver.getWindowHandles(); 
		for(String s:handles){
			System.out.println(s);
			driver.switchTo().window(s);
		}
		driver.findElement(By.linkText("已揭示")).click();
		
		 * */
		
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
