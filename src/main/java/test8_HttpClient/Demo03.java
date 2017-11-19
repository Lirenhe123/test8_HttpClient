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
		CloseableHttpClient httpClient=HttpClients.createDefault(); // 创建httpClient实例
        HttpGet httpGet=new HttpGet("http://www.tuicool.com/"); // 创建httpget实例
        
        //需要提前学会获得请求头信息
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0"); // 设置请求头消息User-Agent
       
        CloseableHttpResponse response=httpClient.execute(httpGet); // 执行http get请求
        HttpEntity entity=response.getEntity(); // 获取返回实体
        
        //获取contentType,不同的网址获取的内容类型是不同的，这样就可以先获取contentType，判断是否是
        	//需要的类型内容，将不需要的过滤
        String contentType=entity.getContentType().getValue();
        System.out.println("contentType:"+contentType);
        
        //获取Status
        StatusLine statusLine=response.getStatusLine();
        System.out.println(statusLine.toString());
        System.out.println(statusLine.getStatusCode());
        
        
        
//        System.out.println("网页内容："+EntityUtils.toString(entity, "utf-8")); // 获取网页内容
        response.close(); // response关闭
        httpClient.close(); // httpClient关闭
        
	}
	
}
