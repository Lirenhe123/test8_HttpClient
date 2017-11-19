package test8_HttpClient;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Demo04 {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient=HttpClients.createDefault(); // ����httpClientʵ��
        HttpGet httpGet=new HttpGet("http://img.eeyy.com/uploadfile/2017/0814/20170814060221168.jpg"); // ����httpgetʵ��
        
        //��Ҫ��ǰѧ��������ͷ��Ϣ
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0"); // ��������ͷ��ϢUser-Agent
       
        CloseableHttpResponse response=httpClient.execute(httpGet); // ִ��http get����
        HttpEntity entity=response.getEntity(); // ��ȡ����ʵ��
        
        //��ȡcontentType,��ͬ����ַ��ȡ�����������ǲ�ͬ�ģ������Ϳ����Ȼ�ȡcontentType���ж��Ƿ���
        	//��Ҫ���������ݣ�������Ҫ�Ĺ���
        if(entity!=null){
        	String contentType=entity.getContentType().getValue();
            System.out.println("contentType:"+contentType);
            
            InputStream is=entity.getContent();
            FileUtils.copyToFile(is, new File("tfboys.jpg"));
            
            //���ģ��ȡͼƬ����Ҫ����ñ���ͼƬ������
        }
        
        
	}
}
