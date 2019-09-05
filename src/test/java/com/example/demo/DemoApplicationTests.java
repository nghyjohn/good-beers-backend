package com.example.demo;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.apache.http.HttpEntity;  
import org.apache.http.NameValuePair;  
import org.apache.http.client.entity.UrlEncodedFormEntity;  
import org.apache.http.client.methods.CloseableHttpResponse;  
import org.apache.http.client.methods.HttpGet;  
import org.apache.http.client.methods.HttpPost;  
import org.apache.http.entity.StringEntity;  
import org.apache.http.impl.client.CloseableHttpClient;  
import org.apache.http.impl.client.HttpClients;  
import org.apache.http.message.BasicNameValuePair;  
import org.apache.http.protocol.HTTP;  
import org.apache.http.util.EntityUtils; 

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests
 {  
    @Test  
    public void TestHttpConnectionToGoodBeer() throws Exception {  
        
		CloseableHttpClient httpclient = null;  
        CloseableHttpResponse response = null;  
        try {  
            httpclient = HttpClients.createDefault();    
            // 创建httpget.      
            HttpGet httpget = new HttpGet("http://spring-boot-ionic-example-dev.13.94.25.165.nip.io/good-beers");    
            // 执行get请求.      
            response = httpclient.execute(httpget);    
            // 获取响应实体      
            HttpEntity entity = response.getEntity();    
        
            // 打印响应状态  
			System.out.println();			
            System.out.println("-------------Connection Test Result:-------------");
			if (response.getStatusLine().getStatusCode()==200){
			System.out.println("-->>>Current Connection is OK!");
			System.out.println();
			}else {System.out.println("-->>>Can not connect to the Good Beer App! error code:"+response.getStatusLine().getStatusCode());  
			System.out.println();			
			}
			assertTrue(response.getStatusLine().getStatusCode()==200);
			
        } catch (Exception e) {  
            throw e;  
        }finally{  
            httpclient.close();  
            response.close();  
        }  
    }  
      
    @Test 
    public void TestHttpGETValueMatch()throws Exception {  
        
		CloseableHttpClient httpclient = null;  
        CloseableHttpResponse response = null;  
        try {  
            httpclient = HttpClients.createDefault();    
            // 创建httpget.      
            HttpGet httpget = new HttpGet("http://spring-boot-ionic-example-dev.13.94.25.165.nip.io/good-beers");    
            // 执行get请求.      
            response = httpclient.execute(httpget);    
            // 获取响应实体      
            HttpEntity entity = response.getEntity(); 
			System.out.println();					
			System.out.println("-------------Response Jason Testing:------------- ");
            if (response.getStatusLine().getStatusCode()==200 && entity != null) {    
                // 打印响应内容      
                  
				System.out.println("-->>>Get Response Jason!");
				System.out.println();
				System.out.println("-->>>Response content: " + EntityUtils.toString(entity));  
				assertTrue(1==1);  
            }  else {
				System.out.println("-->>>Content dont contain keyword!");
				System.out.println();
			assertTrue(1==0); }
        } catch (Exception e) {  
            throw e;  
        }finally{  
            httpclient.close();  
            response.close();  
        }  
    }  
 }