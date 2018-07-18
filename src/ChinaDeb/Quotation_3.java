/**
 * CaseName：报价 - 华南
 * Note: 2条物资 - 按分项报价
 * Time：20180718
 * Creator: ZJ
 * */

package ChinaDeb;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Quotation_3 {

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
		user.clear();
		user.sendKeys("huanan123");
		// 获取输入框默认提示信息
		String user_info = user.getAttribute("placeholder");
		System.out.println(user_info);
		// 获取输入的内容
		String user_value = user.getAttribute("value");
		System.out.println(user_value);
		// 判断输入框是否为可输入状态
		boolean enable = user.isEnabled();
		System.out.println(enable);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("huanan123");
		driver.findElement(By.className("loginBtn")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.findElement(By.className("help")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 层级定位报价管理按钮
//		WebElement element = driver.findElement(By.className("menuB"));
//		List<WebElement> elements = element.findElements(By.tagName("li"));
//		elements.get(1).click();
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

	}
	
	public void quoataionFeedback(){
				
		// 定位待反馈询价单按钮
//		WebElement element = driver.findElement(By.className("workbenchL_menu"));
//		List<WebElement> elements = element.findElements(By.tagName("li"));
//		elements.get(0).click();
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		/**
		 * 待反馈询价单
		 * */
		driver.get("http://192.168.6.108:1111/view/provider/quoteManage/waiteFeedback/waiteFeedback.html");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 点击查看按钮（第一条单据）
		driver.findElement(By.className("Tab_set")).click();
		this.sleep(1000);
		
		/**
		 * 选择物资 - 多选框CheckBox
		 * */ 
		WebElement products = driver.findElement(By.className("tableBox"));
		List<WebElement> inputs = products.findElements(By.tagName("input"));
		for (WebElement input:inputs){
			input.click();
			System.out.println(input.isSelected());
			this.sleep(1000);							
		}
		

		/**
		 * 点击反馈询价按钮
		 * */
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[1]/a[1]")).click();
		this.sleep(2000);
		
		
		/**
		 * 输入报价反馈名称
		 * */
		driver.findElement(By.name("offerFeedbackName")).sendKeys("Feedback03");
		
		/**
		 * 是否参与 - 选择“是”
		 * 是：/html/body/div[1]/div[2]/div/div[2]/div/div[6]/input[1]
		 * 否：/html/body/div[1]/div[2]/div/div[2]/div/div[6]/input[2]
		 * */
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[6]/input[1]")).click();
		this.sleep(1000);
		
		/**
		 * 第一个物资
		 * 可供数量
		 * */
		driver.findElement(By.id("offerNum_1")).sendKeys("100");
		this.sleep(1000);
		
		/**
		 * 单价
		 * */
		WebElement price = driver.findElement(By.id("materialPrice_1"));
		price.clear();
		price.sendKeys("1000");
		this.sleep(1000);
		
		/**
		 * 运费
		 * */
		WebElement freight = driver.findElement(By.id("materialFreight_1"));
		freight.clear();
		freight.sendKeys("200");
		this.sleep(1000);
		
		/**
		 * 安装费
		 * */		
		WebElement installCharge = driver.findElement(By.name("installationCharge"));
		installCharge.clear();
		installCharge.sendKeys("200");
		this.sleep(1000);
		
		/**
		 * 服务费
		 * */
		WebElement serviceCharge = driver.findElement(By.name("serviceCharge"));
		serviceCharge.clear();
		serviceCharge.sendKeys("200");
		this.sleep(1000);
		
		/**
		 * 其他费用
		 * */		
		WebElement otherPrice = driver.findElement(By.id("otherPrice_1"));
		otherPrice.clear();
		otherPrice.sendKeys("200");
		this.sleep(1000);
		
		/**
		 * 总价
		 * */
		WebElement total = driver.findElement(By.id("totalAmountText_1"));
		total.clear();
		total.sendKeys("20000");
		this.sleep(1000);
		
		/**
		 * 交货期
		 * */
		driver.findElement(By.className("dateIpt")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
		// 切换到iFrame再跳出
		WebElement iframeEnd = driver.findElement(By.xpath("/html/body/div[3]/iframe"));
		driver.switchTo().frame(iframeEnd);
		driver.findElement(By.xpath("/html/body/div/div[3]/table/tbody/tr[6]/td[4]")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().defaultContent();
		this.sleep(2000);
		
		/**
		 * 品牌
		 * */
		driver.findElement(By.name("brandName")).sendKeys("MONOCLE");
		this.sleep(1000);
		
		/**
		 * 备注
		 * */
		driver.findElement(By.name("remark")).sendKeys("Test remark");
		this.sleep(1000);
		
		
		/**
		 * 第二个物资
		 * 可供数量
		 * */
		driver.findElement(By.id("offerNum_2")).sendKeys("200");
		this.sleep(1000);
		
		/**
		 * 单价
		 * */
		WebElement price_2 = driver.findElement(By.id("materialPrice_2"));
		price_2.clear();
		price_2.sendKeys("2000");
		this.sleep(1000);
		
		/**
		 * 运费
		 * */
		WebElement freight_2 = driver.findElement(By.id("materialFreight_2"));
		freight_2.clear();
		freight_2.sendKeys("300");
		this.sleep(1000);
		
		/**
		 * 安装费
		 * */		
		WebElement installCharge_2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[7]/div[2]/div[2]/form/div/table/tbody/tr/td[4]/input"));
		installCharge_2.clear();
		installCharge_2.sendKeys("300");
		this.sleep(1000);
		
		/**
		 * 服务费
		 * */
		WebElement serviceCharge_2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[7]/div[2]/div[2]/form/div/table/tbody/tr/td[5]/input"));
		serviceCharge_2.clear();
		serviceCharge_2.sendKeys("300");
		this.sleep(1000);
		
		/**
		 * 其他费用
		 * */		
		WebElement otherPrice_2 = driver.findElement(By.id("otherPrice_2"));
		otherPrice_2.clear();
		otherPrice_2.sendKeys("300");
		this.sleep(1000);
		
		/**
		 * 总价
		 * */
		WebElement total_2 = driver.findElement(By.id("totalAmountText_2"));
		total_2.clear();
		total_2.sendKeys("30000");
		this.sleep(1000);
		
		/**
		 * 交货期
		 * */
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[7]/div[2]/div[2]/form/div/table/tbody/tr/td[9]/div/input[2]")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
		// 切换到iFrame再跳出
		WebElement iframeEnd_2 = driver.findElement(By.xpath("/html/body/div[3]/iframe"));
		driver.switchTo().frame(iframeEnd_2);
		driver.findElement(By.xpath("/html/body/div/div[3]/table/tbody/tr[6]/td[4]")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.switchTo().defaultContent();
		this.sleep(2000);
		
		/**
		 * 品牌
		 * */
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[7]/div[2]/div[2]/form/div/table/tbody/tr/td[10]/input")).sendKeys("UNICO");
		this.sleep(1000);
		
		/**
		 * 备注
		 * */
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[7]/div[2]/div[2]/form/div/table/tbody/tr/td[11]/input")).sendKeys("Test remark_2");
		this.sleep(1000);
		
		
		/**
		 * 联系人姓名
		 * */
		driver.findElement(By.name("offerName")).sendKeys("华南报价员");
		this.sleep(1000);
		
		/**
		 * 手机号码
		 * */
		driver.findElement(By.name("offerPhone")).sendKeys("13955557777");
		this.sleep(1000);
		
		/**
		 * 联系电话
		 * */
		driver.findElement(By.name("offerMobile")).sendKeys("82845976");
		this.sleep(1000);
		
		/**
		 * 邮箱
		 * */
		driver.findElement(By.name("offerEmail")).sendKeys("hnbjy@163.com");
		this.sleep(1000);
		
		/**
		 * 点击保存
		 * */
		driver.findElement(By.className("solidBtn")).click();
		this.sleep(1000);
	}
	
	private void sleep(int i) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		//实例化对象
		Quotation_3 action = new Quotation_3();
		action.InitDriver();
		action.InputBox();
		action.quoataionFeedback();
	}
}


