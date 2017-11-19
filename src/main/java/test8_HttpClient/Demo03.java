package test8_HttpClient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Demo03 {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient=HttpClients.createDefault(); // ����httpClientʵ��
        HttpGet httpGet=new HttpGet("http://www.tuicool.com/"); // ����httpgetʵ��
        
        //��Ҫ��ǰѧ��������ͷ��Ϣ
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0"); // ��������ͷ��ϢUser-Agent
       
        CloseableHttpResponse response=httpClient.execute(httpGet); // ִ��http get����
        HttpEntity entity=response.getEntity(); // ��ȡ����ʵ��
        
        //��ȡcontentType,��ͬ����ַ��ȡ�����������ǲ�ͬ�ģ������Ϳ����Ȼ�ȡcontentType���ж��Ƿ���
        	//��Ҫ���������ݣ�������Ҫ�Ĺ���
        String contentType=entity.getContentType().getValue();
        System.out.println("contentType:"+contentType);
        
        //��ȡStatus
        StatusLine statusLine=response.getStatusLine();
        System.out.println(statusLine.toString());
        System.out.println(statusLine.getStatusCode());
        
        
        
//        System.out.println("��ҳ���ݣ�"+EntityUtils.toString(entity, "utf-8")); // ��ȡ��ҳ����
        response.close(); // response�ر�
        httpClient.close(); // httpClient�ر�
        
	}
	
}
