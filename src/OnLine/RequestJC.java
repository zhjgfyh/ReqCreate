/**
 * ����
 * */

package OnLine;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RequestJC {
	
	public WebDriver driver;
	
	/**
	 * ��ʼ��driver
	 * */
	public void InitDriver(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ZJ\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://101.251.248.154/view/auth/login.html");
		driver.manage().window().maximize();
	}
	
	/**
	 * �����
	 * */
	public void InputBox(){
		WebElement user = driver.findElement(By.id("name"));
		user.sendKeys("scbgr");
		this.sleep(1000);
		driver.findElement(By.name("password")).sendKeys("scbgr");
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
		
		// �㼶��λ�ɹ�����ť
		WebElement element = driver.findElement(By.className("menuB"));
		List<WebElement> elements = element.findElements(By.tagName("li"));
		elements.get(1).click();
	}
	

	public void purchaseRequest(){
		// ��λ�ɹ��������ť
		WebElement element = driver.findElement(By.className("workbenchL_menu"));
		List<WebElement> elements = element.findElements(By.tagName("li"));
		elements.get(1).click();
		
		// �����ɹ�����
		driver.get("http://101.251.248.154/view/purchaseManage/purchaseRequest/createPurReq.html");
		driver.findElement(By.className("btnLeft")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// �������б�
		driver.findElement(By.xpath("//*[@id='tip']/li[2]/div[2]/ul/li[1]")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**
		 * driver.findElement(By.xpath("//*[@id='tip']/li[2]/div[2]/ul[2]/li[1]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id='tip']/li[2]/div[2]/ul[3]/li[2]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 * */
		
		// ѡ������
		driver.findElement(By.xpath("//*[@id='tip']/li[2]/div[3]/table[2]/tbody/tr[1]/td[1]/div/label")).click();
		driver.findElement(By.className("depBtn")).click();

		
		/**
		 * ����ɹ������� 
		 * */
		driver.findElement(By.className("whiteMsgIpt")).sendKeys("TEST-JC-070601");
		this.sleep(1000);
		
		//ѡ��ɹ�������� - ���ɺ�ͬ
		WebElement resultType = driver.findElement(By.name("purchaseResul"));
		Select downList = new Select(resultType);
		downList.selectByValue("10012");
		this.sleep(1000);
		
		// ����ɹ�����
		driver.findElement(By.name("purchaseNum")).sendKeys("100");
		this.sleep(1000);
		
		// ���������
		driver.findElement(By.name("countMoney")).sendKeys("9999.99");
		this.sleep(2000);
		
		// ������startTime
		driver.findElement(By.id("d4311")).click();
		this.sleep(2000);
		
		// �л���iFrame������
		WebElement iframeStart = driver.findElement(By.xpath("/html/body/div[3]/iframe"));
		driver.switchTo().frame(iframeStart);
		driver.findElement(By.xpath("//*[@id='dpTodayInput']")).click();
		this.sleep(2000);
		driver.switchTo().defaultContent();
		this.sleep(2000);
		
		// ������endTime
		driver.findElement(By.id("d4312")).click();
		this.sleep(2000);
				
		// �л���iFrame������
		WebElement iframeEnd = driver.findElement(By.xpath("/html/body/div[3]/iframe"));
		driver.switchTo().frame(iframeEnd);
		driver.findElement(By.id("dpTodayInput")).click();
		driver.switchTo().defaultContent();
		this.sleep(2000);
		
		// ѡ���ջ���λ(�ӱ������������޹�˾��17)
		WebElement receiveEnt = driver.findElement(By.name("receivingEnterpriseId"));
		Select downList2 = new Select(receiveEnt);
		downList2.selectByValue("17");
		this.sleep(1000);
		
		// ѡ����㵥λ
		WebElement payEnt = driver.findElement(By.name("payEnterpriseId"));
		Select downList3 = new Select(payEnt);
		downList3.selectByValue("17");
		this.sleep(1000);
		
		// ѡ���ջ���ַ
		driver.findElement(By.className("city-picker-span")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/form/div[11]/div/div/div/div[2]/div[1]/dl[1]/dd/a[1]")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/form/div[11]/div/div/div/div[2]/div[2]/dl/dd/a[1]")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/form/div[11]/div/div/div/div[2]/div[3]/dl/dd/a[1]")).click();
		driver.findElement(By.name("receiveAddress")).sendKeys("BJ-HD-X11");
		this.sleep(1000);
		
		// ѡ������λ
		WebElement needEnt = driver.findElement(By.name("needEnterpriseId"));
		Select downList4 = new Select(needEnt);
		downList4.selectByValue("17");
		this.sleep(1000);
		
		// ������ϵ������
		driver.findElement(By.name("linkmanName")).sendKeys("��С��");
		this.sleep(1000);
		
		// �����ֻ�����
		driver.findElement(By.name("linkmanPhone")).sendKeys("1891112345");
		this.sleep(1000);
		
		// ��������
		driver.findElement(By.name("email")).sendKeys("1891112345@qq.com");
		this.sleep(1000);
		
		// ���뱸ע
		driver.findElement(By.name("remark")).sendKeys("ShenQing");
		this.sleep(1000);
		
		// �������
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div[2]/a[1]")).click();
		
	}
	
	private void sleep(int i) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		//ʵ��������
		RequestJC action = new RequestJC();
		action.InitDriver();
		action.InputBox();
		action.purchaseRequest();
	}

}

