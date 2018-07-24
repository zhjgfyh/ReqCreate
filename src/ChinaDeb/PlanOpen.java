/**
 * CaseName���ɹ��ƻ����� - ����
 * Time��20180724
 * Creator: ZJ
 * */

package ChinaDeb;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class PlanOpen {
	
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
	 * ��¼
	 * */
	public void InputBox(){
		WebElement user = driver.findElement(By.id("name"));
		user.sendKeys("sqw123");
		// ��ȡ�����Ĭ����ʾ��Ϣ
		String user_info = user.getAttribute("placeholder");
		System.out.println(user_info);
		// ��ȡ���������
		String user_value = user.getAttribute("value");
		System.out.println(user_value);
		// �ж�������Ƿ�Ϊ������״̬
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
		 * �������̨
		 * */
		driver.findElement(By.className("help")).click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**
		 * �㼶��λ�ɹ�����ť
		 * */ 
		WebElement element = driver.findElement(By.className("menuB"));
		List<WebElement> elements = element.findElements(By.tagName("li"));
		elements.get(1).click();
		this.sleep(2000);
	}
	

	public void RequestPlan(){
		/**
		 * ��λ�ɹ��ƻ�����ť
		 * */ 
		WebElement element = driver.findElement(By.className("workbenchL_menu"));
		List<WebElement> elements = element.findElements(By.tagName("li"));
		elements.get(2).click();
		
		/**
		 * �����ɹ��ƻ�
		 * */ 
		driver.get("http://192.168.6.108:1111/view/purchaseManage/procurementPlan/addPurchaseApply.html");
		this.sleep(1000);
		
		/**
		 * ��Ӳɹ�����
		 * */ 
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div[1]/div/a")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**
		 * ѡ��ɹ����� - ��ѡ��CheckBox
		 * */ 
		driver.findElement(By.className("custom-checkbox")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**
		 * ���ȷ��
		 * */ 
		driver.findElement(By.xpath("//*[@id='tip']/li[3]/button[1]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**
		 * �����һ��
		 * */ 
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div[2]/a[1]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/**
		 * ����ɹ��ƻ����
		 * */ 
		driver.findElement(By.name("planCodeId")).sendKeys("Plan-JC-072401");
		this.sleep(1000);
			
		/**
		 * ����ɹ��ƻ�����
		 * */ 
		driver.findElement(By.name("planName")).sendKeys("�ɹ��ƻ�-����-072401");
		this.sleep(1000);
		
		/**
		 * ������ʹ�������������
		 * */ 
		
		/**
		 * ˰�� - 3%
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
		 * �ƻ���ֹ����
		 * */ 
		driver.findElement(By.xpath("//*[@id='Form']/div[6]/input[2]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**
		 * �л���iFrame������
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
		 * ѯ�۷�ʽ
		 * */ 
		driver.findElement(By.className("open")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**
		 * ��ע
		 * */
		driver.findElement(By.name("remark")).sendKeys("����ѯ��");
		this.sleep(2000);
		
		/**
		 * ������水ť
		 * */ 
		driver.findElement(By.xpath("//*[@id='Form']/div[12]/a[2]")).click();
		this.sleep(2000);
	}


	private void sleep(int i) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args){
		/**
		 * ʵ��������
		 * */
		PlanOpen action = new PlanOpen();
		action.InitDriver();
		action.InputBox();
		action.RequestPlan();
	}

}