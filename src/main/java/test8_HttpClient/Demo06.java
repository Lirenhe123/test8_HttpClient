package test8_HttpClient;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Demo06 {
	public static void main(String[] args)throws Exception {
        CloseableHttpClient httpClient=HttpClients.createDefault(); // ����httpClientʵ��
        HttpGet httpGet=new HttpGet("http://central.maven.org/maven2/"); // ����httpgetʵ��
       
        //��ʱ����
        //�����ʱ�ͽ���һЩ����ҵ��
        RequestConfig config=RequestConfig.custom()
                .setConnectTimeout(10)//����5000�Ͳ��ᱨ��
                .setSocketTimeout(10)
                .build();
        httpGet.setConfig(config);
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
        CloseableHttpResponse response=httpClient.execute(httpGet); // ִ��http get����
        HttpEntity entity=response.getEntity(); // ��ȡ����ʵ��
        System.out.println("��ҳ���ݣ�"+EntityUtils.toString(entity, "utf-8")); // ��ȡ��ҳ����
        response.close(); // response�ر�
        httpClient.close(); // httpClient�ر�
    }
}
