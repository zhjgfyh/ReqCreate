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
		user.sendKeys("tdn123");
		user.clear();
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
		this.sleep(2000);
	}
	

	public void purchaseRequest(){
		// ��λѯ�ȼ۲ɹ���ť
		//WebElement element = driver.findElement(By.className("workbenchL_menu"));
		//List<WebElement> elements = element.findElements(By.tagName("li"));
		//elements.get(3).click();
		
		// ѯ�۵�����
		driver.get("http://192.168.6.108:1111/view/purchaseManage/enquiryManage/inquiryList/waitingCreate.html");
		this.sleep(3000);
		
		//driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/table/tbody/tr[1]/td[8]/div/a")).click();
		//this.sleep(1000);
		
		Set<String> handles = driver.getWindowHandles(); 
		for(String s:handles){
			System.out.println(s);
			driver.switchTo().window(s);
		}
		driver.findElement(By.linkText("�ѽ�ʾ")).click();
		
		//WebElement checkout = driver.findElement(By.className("yjs_tbody_cont"));
		//List<WebElement> checkouts = checkout.findElements(By.className("look"));
		//checkouts.get(1).click();

	}
	
	private void sleep(int i) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		//ʵ��������
		ConsultPrice action = new ConsultPrice();
		action.InitDriver();
		action.InputBox();
		action.purchaseRequest();
	}
}
