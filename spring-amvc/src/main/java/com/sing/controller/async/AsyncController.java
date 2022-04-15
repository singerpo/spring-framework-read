package com.sing.controller.async;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.concurrent.Callable;

/**
 * @author songbo
 * @since 2022-04-08
 */
@Controller
public class AsyncController {
	@ResponseBody
	@RequestMapping(value = "/webAsyncTask",produces = "text/plain;charset=utf-8")
	public WebAsyncTask<String> webAsyncTask() {
		System.out.println("webAsyncTask 处理器主线程进入");
		WebAsyncTask<String> task = new WebAsyncTask<>(new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("webAsyncTask 处理执行中...");
				Thread.sleep(5*1000L);
				return "久等了,出结果了";
			}
		});

		System.out.println("webAsyncTask 处理器主线程退出");
		return task;
	}

	@ResponseBody
	@RequestMapping(value = "/callable",produces = "text/plain;charset=utf-8")
	public Callable<String> callable() {
		System.out.println("callable 处理器主线程进入");
		Callable<String> callable = new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("callable 处理执行中...");
				Thread.sleep(5*1000L);
				return "久等了,出结果了";
			}
		};

		System.out.println("callable 处理器主线程退出");
		return callable;
	}
}
