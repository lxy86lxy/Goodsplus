package com.example.Goods.util;

import android.os.Handler;
import android.os.Looper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

//网络请求工具类
public class HttpUtil {

    public  void sendHttpRequest(final String address, final HttpBack back){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection=null;
                try {
                    URL url=new URL(address);
                    connection=(HttpURLConnection)url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    connection.setDoInput(true);
                    connection.setDoOutput(false);
//                    connection.connect();
                    InputStream in=connection.getInputStream();
                    //字节流效率更高
                    BufferedReader reader=new BufferedReader(new InputStreamReader(in));
                    StringBuilder response=new StringBuilder();
                    String line;
                    while ((line=reader.readLine())!=null){
                        response.append(line);
//                        .append('\n');//增加可读性
                    }
                    if (back!=null){
                        //java中的回调机制
                        back.onFinish(response.toString());
                    }
                }catch (Exception e){
                    if (back!=null){
                        back.onError(e);
                    }
                }finally {
                    if (connection!=null){
                        connection.disconnect();
                    }
                }
            }
        }).start();

    }



//
//    public  String sendRequest(final String address){
//
//                HttpURLConnection connection=null;
//                try {
//                    URL url=new URL(address);
//                    connection=(HttpURLConnection)url.openConnection();
//                    connection.setRequestMethod("GET");
//                    connection.setConnectTimeout(8000);
//                    connection.setReadTimeout(8000);
//                    connection.setDoInput(true);
//                    connection.setDoOutput(false);
////                    connection.connect();
//                    InputStream in=connection.getInputStream();
//                    //字节流效率更高
//                    BufferedReader reader=new BufferedReader(new InputStreamReader(in));
//                    StringBuilder response=new StringBuilder();
//                    String line;
//                    while ((line=reader.readLine())!=null){
//                        response.append(line);
////                        .append('\n');//增加可读性
//                    }
//                    return response.toString();
//                }catch (Exception e){
//                    e.printStackTrace();
//                    return e.getMessage();
//                }finally {
//                    if (connection!=null){
//                        connection.disconnect();
//                    }
//                }
//            }



//    HashMap<String, String> map = new HashMap<>();
//    map.put("username", "你的用户名");
//    map.put("password", "用户的密码");
//    sendPostNetRequest("https://www.wanandroid.com/user/login", map);
    public void sendPostNetRequest(String mUrl, HashMap<String, String> params,final HttpBack back) {
        //开启子线程执行网络请求
        new Thread( () -> {
            HttpURLConnection connection=null;
            try {
                URL url = new URL(mUrl);//这一行可能会导致 MalformedURLException(url格式异常)，所以要try catch掉
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");//设置请求方式为POST
                connection.setConnectTimeout(8000);//设置最大连接时间，单位为毫 秒，超出这个设定的时间将会导致连接超时
                connection.setReadTimeout(8000);//设置最大的读取时间，单位为毫秒， 超出这个设定的时间将会导致读取超时
                connection.setDoOutput(true);//允许输入流
                connection.setDoInput(true);//允许输出流
                StringBuilder dataToWrite = new StringBuilder();//构建参数值
                for (String key : params.keySet()) {
                    dataToWrite.append(key).append("=").append(params.get(key)).append("&");//拼接参 数
                }connection.connect();//正式连接
                 OutputStream outputStream = connection.getOutputStream();//开启输入流
                 outputStream.write(dataToWrite.substring(0, dataToWrite.length() - 1).getBytes());//去除最后一个&
                 InputStream in = connection.getInputStream();//从接口处获取输入流
                BufferedReader reader=new BufferedReader(new InputStreamReader(in));
                StringBuilder response=new StringBuilder();
                String line;
                while ((line=reader.readLine())!=null){
                    response.append(line);
                }
                if (back!=null){
                    //java中的回调机制
                    back.onFinish(response.toString());
                }
            }catch (Exception e){
                e.printStackTrace();
                if (back!=null){
                    back.onError(e);
                }
            }finally {
                if (connection!=null){
                    connection.disconnect();
                }
            }
    }).start();
    }
//  public void funHttp(String address){
//      new Thread(new Runnable() {
//          @Override
//          public void run() {
//              HttpURLConnection connection = null;
//              try {
//                  URL url = new URL(address);
//                  connection = (HttpURLConnection) url.openConnection();
//                  connection.setRequestMethod("GET");
//                  connection.setConnectTimeout(8000);
//                  connection.setReadTimeout(8000);
//                  connection.setDoInput(true);
//                  connection.setDoOutput(true);
//                  connection.connect();
//                  InputStream in = connection.getInputStream();
//                  //字节流效率更高
//                  BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//                  StringBuilder response = new StringBuilder();
//                  String line;
//                  while ((line = reader.readLine()) != null) {
//                      response.append(line);
////                        .append('\n');//增加可读性
//                  }
//              } catch (Exception e) {
//                  e.printStackTrace();
//              } finally {
//                  if (connection != null) {
//                      connection.disconnect();
//                  }
//              }
//          }
//      }
//          ).start();
//      }
}
