package com.hhl.message;
import com.hhl.CommonUtil;
import com.hhl.MyX509TrustManager;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;



/**
 * @author HuangHL
 * @date 2017/2/27
 * @see
 */
public class testGetToken1
{
    public void testGetToken1() throws Exception {
        String tokenUrl="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxc0bb68f91a99b46c&secret=2972a0f9b1cb18c35af96d732bbe7b9d";
        // 建立连接
        URL url = new URL(tokenUrl);
        HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();

        // 创建SSLContext对象，并使用我们指定的信任管理器初始化
        TrustManager[] tm = { new MyX509TrustManager() };
        SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
        sslContext.init(null, tm, new java.security.SecureRandom());
        // 从上述SSLContext对象中得到SSLSocketFactory对象
        SSLSocketFactory ssf = sslContext.getSocketFactory();

        httpUrlConn.setSSLSocketFactory(ssf);
        httpUrlConn.setDoOutput(true);
        httpUrlConn.setDoInput(true);

        // 设置请求方式（GET/POST）
        httpUrlConn.setRequestMethod("GET");

        // 取得输入流
        InputStream inputStream = httpUrlConn.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(
                inputStream, "utf-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        // 读取响应内容
        StringBuffer buffer = new StringBuffer();
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            buffer.append(str);
        }
        bufferedReader.close();
        inputStreamReader.close();
        // 释放资源
        inputStream.close();
        httpUrlConn.disconnect();
        // 输出返回结果
        System.out.println(buffer);
    }

    public void testGetToken2() {
        Token token = CommonUtil.getToken("wxc0bb68f91a99b46c", "2972a0f9b1cb18c35af96d732bbe7b9d");
        System.out.println("access_token:"+token.getAccessToken());
        System.out.println("expires_in:"+token.getExpiresIn());
    }

    public static void main(String[] aregs){
        testGetToken1 s = new testGetToken1();
        try
        {
            s.testGetToken1();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        s.testGetToken2();
    }
}
