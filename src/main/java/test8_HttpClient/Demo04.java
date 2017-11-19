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
		CloseableHttpClient httpClient=HttpClients.createDefault(); // 创建httpClient实例
        HttpGet httpGet=new HttpGet("http://img.eeyy.com/uploadfile/2017/0814/20170814060221168.jpg"); // 创建httpget实例
        
        //需要提前学会获得请求头信息
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0"); // 设置请求头消息User-Agent
       
        CloseableHttpResponse response=httpClient.execute(httpGet); // 执行http get请求
        HttpEntity entity=response.getEntity(); // 获取返回实体
        
        //获取contentType,不同的网址获取的内容类型是不同的，这样就可以先获取contentType，判断是否是
        	//需要的类型内容，将不需要的过滤
        if(entity!=null){
        	String contentType=entity.getContentType().getValue();
            System.out.println("contentType:"+contentType);
            
            InputStream is=entity.getContent();
            FileUtils.copyToFile(is, new File("tfboys.jpg"));
            
            //大规模获取图片，需要处理好保存图片的命名
        }
        
        
	}
}
