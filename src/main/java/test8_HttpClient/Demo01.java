package test8_HttpClient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Demo01 {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault(); // ����httpclientʵ��
        HttpGet httpget = new HttpGet("https://movie.douban.com/explore#!type=movie&tag=%E7%83%AD%E9%97%A8&sort=recommend&page_limit=20&page_start=20"); // ����httpgetʵ��
        //"http://www.tuicool.com/"
        CloseableHttpResponse response = httpclient.execute(httpget); // ִ��get����
        HttpEntity entity=response.getEntity(); // ��ȡ����ʵ��
        System.out.println("��ҳ���ݣ�"+EntityUtils.toString(entity, "utf-8")); // ָ�������ӡ��ҳ����
        response.close(); // �ر������ͷ�ϵͳ��Դ
        httpclient.close();
	}
	
}
