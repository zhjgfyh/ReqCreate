/**
 * CaseName������ - ����
 * Note: 2������ - �������
 * Time��20180718
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
	 * ��ʼ��driver
	 * */
	public void InitDriver(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ZJ\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://192.168.6.108:1111/view/auth/login.html");
		driver.manage().window().maximize();
	}
	
	/**
	 * �����
	 * */
	public void InputBox(){
		WebElement user = driver.findElement(By.id("name"));
		user.clear();
		user.sendKeys("huanan123");
		// ��ȡ�����Ĭ����ʾ��Ϣ
		String user_info = user.getAttribute("placeholder");
		System.out.println(user_info);
		// ��ȡ���������
		String user_value = user.getAttribute("value");
		System.out.println(user_value);
		// �ж�������Ƿ�Ϊ������״̬
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
		
		// �㼶��λ���۹���ť
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
				
		// ��λ������ѯ�۵���ť
//		WebElement element = driver.findElement(By.className("workbenchL_menu"));
//		List<WebElement> elements = element.findElements(By.tagName("li"));
//		elements.get(0).click();
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		/**
		 * ������ѯ�۵�
		 * */
		driver.get("http://192.168.6.108:1111/view/provider/quoteManage/waiteFeedback/waiteFeedback.html");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// ����鿴��ť����һ�����ݣ�
		driver.findElement(By.className("Tab_set")).click();
		this.sleep(1000);
		
		/**
		 * ѡ������ - ��ѡ��CheckBox
		 * */ 
		WebElement products = driver.findElement(By.className("tableBox"));
		List<WebElement> inputs = products.findElements(By.tagName("input"));
		for (WebElement input:inputs){
			input.click();
			System.out.println(input.isSelected());
			this.sleep(1000);							
		}
		

		/**
		 * �������ѯ�۰�ť
		 * */
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[1]/a[1]")).click();
		this.sleep(2000);
		
		
		/**
		 * ���뱨�۷�������
		 * */
		driver.findElement(By.name("offerFeedbackName")).sendKeys("Feedback03");
		
		/**
		 * �Ƿ���� - ѡ���ǡ�
		 * �ǣ�/html/body/div[1]/div[2]/div/div[2]/div/div[6]/input[1]
		 * ��/html/body/div[1]/div[2]/div/div[2]/div/div[6]/input[2]
		 * */
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[6]/input[1]")).click();
		this.sleep(1000);
		
		/**
		 * ��һ������
		 * �ɹ�����
		 * */
		driver.findElement(By.id("offerNum_1")).sendKeys("100");
		this.sleep(1000);
		
		/**
		 * ����
		 * */
		WebElement price = driver.findElement(By.id("materialPrice_1"));
		price.clear();
		price.sendKeys("1000");
		this.sleep(1000);
		
		/**
		 * �˷�
		 * */
		WebElement freight = driver.findElement(By.id("materialFreight_1"));
		freight.clear();
		freight.sendKeys("200");
		this.sleep(1000);
		
		/**
		 * ��װ��
		 * */		
		WebElement installCharge = driver.findElement(By.name("installationCharge"));
		installCharge.clear();
		installCharge.sendKeys("200");
		this.sleep(1000);
		
		/**
		 * �����
		 * */
		WebElement serviceCharge = driver.findElement(By.name("serviceCharge"));
		serviceCharge.clear();
		serviceCharge.sendKeys("200");
		this.sleep(1000);
		
		/**
		 * ��������
		 * */		
		WebElement otherPrice = driver.findElement(By.id("otherPrice_1"));
		otherPrice.clear();
		otherPrice.sendKeys("200");
		this.sleep(1000);
		
		/**
		 * �ܼ�
		 * */
		WebElement total = driver.findElement(By.id("totalAmountText_1"));
		total.clear();
		total.sendKeys("20000");
		this.sleep(1000);
		
		/**
		 * ������
		 * */
		driver.findElement(By.className("dateIpt")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
		// �л���iFrame������
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
		 * Ʒ��
		 * */
		driver.findElement(By.name("brandName")).sendKeys("MONOCLE");
		this.sleep(1000);
		
		/**
		 * ��ע
		 * */
		driver.findElement(By.name("remark")).sendKeys("Test remark");
		this.sleep(1000);
		
		
		/**
		 * �ڶ�������
		 * �ɹ�����
		 * */
		driver.findElement(By.id("offerNum_2")).sendKeys("200");
		this.sleep(1000);
		
		/**
		 * ����
		 * */
		WebElement price_2 = driver.findElement(By.id("materialPrice_2"));
		price_2.clear();
		price_2.sendKeys("2000");
		this.sleep(1000);
		
		/**
		 * �˷�
		 * */
		WebElement freight_2 = driver.findElement(By.id("materialFreight_2"));
		freight_2.clear();
		freight_2.sendKeys("300");
		this.sleep(1000);
		
		/**
		 * ��װ��
		 * */		
		WebElement installCharge_2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[7]/div[2]/div[2]/form/div/table/tbody/tr/td[4]/input"));
		installCharge_2.clear();
		installCharge_2.sendKeys("300");
		this.sleep(1000);
		
		/**
		 * �����
		 * */
		WebElement serviceCharge_2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[7]/div[2]/div[2]/form/div/table/tbody/tr/td[5]/input"));
		serviceCharge_2.clear();
		serviceCharge_2.sendKeys("300");
		this.sleep(1000);
		
		/**
		 * ��������
		 * */		
		WebElement otherPrice_2 = driver.findElement(By.id("otherPrice_2"));
		otherPrice_2.clear();
		otherPrice_2.sendKeys("300");
		this.sleep(1000);
		
		/**
		 * �ܼ�
		 * */
		WebElement total_2 = driver.findElement(By.id("totalAmountText_2"));
		total_2.clear();
		total_2.sendKeys("30000");
		this.sleep(1000);
		
		/**
		 * ������
		 * */
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[7]/div[2]/div[2]/form/div/table/tbody/tr/td[9]/div/input[2]")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
		// �л���iFrame������
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
		 * Ʒ��
		 * */
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[7]/div[2]/div[2]/form/div/table/tbody/tr/td[10]/input")).sendKeys("UNICO");
		this.sleep(1000);
		
		/**
		 * ��ע
		 * */
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[7]/div[2]/div[2]/form/div/table/tbody/tr/td[11]/input")).sendKeys("Test remark_2");
		this.sleep(1000);
		
		
		/**
		 * ��ϵ������
		 * */
		driver.findElement(By.name("offerName")).sendKeys("���ϱ���Ա");
		this.sleep(1000);
		
		/**
		 * �ֻ�����
		 * */
		driver.findElement(By.name("offerPhone")).sendKeys("13955557777");
		this.sleep(1000);
		
		/**
		 * ��ϵ�绰
		 * */
		driver.findElement(By.name("offerMobile")).sendKeys("82845976");
		this.sleep(1000);
		
		/**
		 * ����
		 * */
		driver.findElement(By.name("offerEmail")).sendKeys("hnbjy@163.com");
		this.sleep(1000);
		
		/**
		 * �������
		 * */
		driver.findElement(By.className("solidBtn")).click();
		this.sleep(1000);
	}
	
	private void sleep(int i) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		//ʵ��������
		Quotation_3 action = new Quotation_3();
		action.InitDriver();
		action.InputBox();
		action.quoataionFeedback();
	}
}


