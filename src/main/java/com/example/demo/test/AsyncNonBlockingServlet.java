package com.example.demo.test;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.example.demo.utils.Util1.println;


/**
 * 异步+非阻塞servlet
 *
 * @author karl xie
 * Created on 2020-11-30 16:52
 */

@WebServlet(name = "async-non-blocking", urlPatterns = "/async-non-blocking", asyncSupported = true)
public class AsyncNonBlockingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //开启异步上下文
        AsyncContext asyncContext = req.startAsync();
        println("异步上下文执行开始");
        //非阻塞回调
        asyncContext.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent asyncEvent) throws IOException {
                ServletResponse response = asyncContext.getResponse();
              response.getOutputStream().println("hello world1");
                println("异步上下文执行完毕");
            }

            @Override
            public void onTimeout(AsyncEvent asyncEvent) throws IOException {

            }

            @Override
            public void onError(AsyncEvent asyncEvent) throws IOException {

            }

            @Override
            public void onStartAsync(AsyncEvent asyncEvent) throws IOException {

            }
        });

        ServletOutputStream outputStream = resp.getOutputStream();
        //非阻塞I/O
        outputStream.setWriteListener(new WriteListener() {
            @Override
            public void onWritePossible() throws IOException {
                outputStream.println("hello world2");
                println("异步+非阻塞执行完毕");

            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
        //完成操作
        asyncContext.start(() -> {
            println("异步上下文触发结束");
            asyncContext.complete();

        });
    }
}