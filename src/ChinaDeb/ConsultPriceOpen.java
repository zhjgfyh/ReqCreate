/**
 * CaseName��ѯ�۵��Ĵ��� - ����
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

public class ConsultPriceOpen {

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
		
		// �㼶��λ�ɹ�������ť
		WebElement element = driver.findElement(By.className("menuB"));
		List<WebElement> elements = element.findElements(By.tagName("li"));
		elements.get(1).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public void purchaseRequest(){
				
		// ѯ�۵�����
		driver.get("http://192.168.6.108:1111/view/purchaseManage/enquiryManage/inquiryList/waitingCreate.html");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		// ����ѯ�۵�����һ�����ݣ�
		driver.findElement(By.className("Tab_set")).click();
		this.sleep(2000);
		
		// ѯ�۵����
		driver.findElement(By.name("consultCode")).sendKeys("XJD-Open-FX-072401-����ר��-��");
		this.sleep(2000);
		
		// ѯ�۵�����
		driver.findElement(By.name("consultName")).sendKeys("ѯ�۵�-����-FX-072401-����ר��-��");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// ���۽�ֹʱ��
		driver.findElement(By.id("offerendTime")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
		/**
		 * �л���iFrame������
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
		
		/**
		 * ���۷�ʽ
		 * �ܼۣ�//*[@id="addConsultPrice"]/div[4]/input[1]
		 * ���//*[@id="addConsultPrice"]/div[4]/input[2]
		 * */ 
		driver.findElement(By.xpath("//*[@id='addConsultPrice']/div[4]/input[2]")).click();
		this.sleep(2000);
		
		// �۸����� - ������
		driver.findElement(By.xpath("//*[@id='addConsultPrice']/div[5]/input[1]")).click();
		this.sleep(2000);
		
		// �Ƿ�˰
		driver.findElement(By.xpath("//*[@id='addConsultPrice']/div[6]/input[1]")).click();
		this.sleep(2000);
		
		// ˰�� - 4%
		WebElement rate = driver.findElement(By.name("taxRate"));
		Select rateOpt = new Select(rate);
		rateOpt.selectByValue("4");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// �������� - ����������ʱ��� 
		driver.findElement(By.xpath("//*[@id='addConsultPrice']/div[8]/input[2]")).click();
		this.sleep(2000);
		
		// �ʱ��� ����
		driver.findElement(By.name("guaranteeMoneyRate")).sendKeys("5");
		this.sleep(1000);
		
		/**
		 * �Ƿ񷢲�ѯ�۹���
		 * �� - //*[@id="addConsultPrice"]/div[11]/input[1]
		 * �� - //*[@id="addConsultPrice"]/div[11]/input[2]
		 * */
		driver.findElement(By.xpath("//*[@id='addConsultPrice']/div[11]/input[1]")).click();
		this.sleep(1000);
		
		/**
		 * ����ƽ̨ - ������
		 * */
		driver.findElement(By.name("publishing")).click();
		this.sleep(2000);
		
		// ��ϵ������
		driver.findElement(By.name("contactName")).sendKeys("����");
		this.sleep(1000);
		
		// �ֻ�����
		driver.findElement(By.name("contactPhone")).sendKeys("13910733251");
		this.sleep(2000);
		
		// ��ϵ�绰
		driver.findElement(By.name("telephone")).sendKeys("68475361");
		this.sleep(1000);
		
		// ����
		driver.findElement(By.name("email")).sendKeys("alltesting@163.com");
		this.sleep(1000);
		
		// ��ע
		driver.findElement(By.name("remark")).sendKeys("����ѯ�۵�");
		this.sleep(1000);
		

		// �������
		driver.findElement(By.xpath("//*[@id='addConsultPrice']/div[21]/a[1]")).click();
		this.sleep(1000);

		
		/**
		 * �л����ѽ�ʾ�б�
		 * 
		Set<String> handles = driver.getWindowHandles(); 
		for(String s:handles){
			System.out.println(s);
			driver.switchTo().window(s);
		}
		driver.findElement(By.linkText("�ѽ�ʾ")).click();
		
		 * */
		
	}
	
	private void sleep(int i) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		//ʵ��������
		ConsultPriceOpen action = new ConsultPriceOpen();
		action.InitDriver();
		action.InputBox();
		action.purchaseRequest();
	}
}
