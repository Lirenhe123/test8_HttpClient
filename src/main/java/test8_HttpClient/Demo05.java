package test8_HttpClient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Demo05 {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient=HttpClients.createDefault(); // ����httpClientʵ��
	       
		//����
		HttpGet httpGet=new HttpGet("https://movie.douban.com/explore#!"
				+ "type=movie&tag=%E7%83%AD%E9%97%A8&sort=recommend&"
				+ "page_limit=20&page_start=20"); // ����httpgetʵ��
        HttpHost proxy=new HttpHost("27.46.74.26", 9999);//����������Ѵ���Ȼ����ȡ
        
        RequestConfig requestConfig=RequestConfig.custom().setProxy(proxy).build();
        httpGet.setConfig(requestConfig);
        
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
        CloseableHttpResponse response=httpClient.execute(httpGet); // ִ��http get����
        HttpEntity entity=response.getEntity(); // ��ȡ����ʵ��
        System.out.println("��ҳ���ݣ�"+EntityUtils.toString(entity, "utf-8")); // ��ȡ��ҳ����
        response.close(); // response�ر�
        httpClient.close(); // httpClient�ر�
        
	}
}
