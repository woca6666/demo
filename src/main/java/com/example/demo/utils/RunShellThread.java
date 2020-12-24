package com.example.demo.utils;

import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class RunShellThread extends Thread {

	// 执行shell 脚本
	public static String executeShell(String shpath) {
		String ss = "";
		if (!StringUtils.isEmpty(shpath)) {
			String command2 = shpath;
			final List<String> strList = new ArrayList<String>();
			BufferedReader in = null;
			try {
				final Process process2 = Runtime.getRuntime().exec(command2);
				// 处理InputStream的线程
				new Thread() {

					@Override
					public void run() {
						BufferedReader in = new BufferedReader(new InputStreamReader(process2.getInputStream()));
						String line = null;
						try {
							while ((line = in.readLine()) != null) {
								strList.add(line.toString().trim());
							}
						}
						catch (IOException e) {
							e.printStackTrace();
						}
						finally {
							try {
								in.close();
							}
							catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}.start();
				process2.waitFor();

			}
			catch (IOException e) {
				e.printStackTrace();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			finally {
				if (in != null) {
					try {
						in.close();
					}
					catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			ss = String.join(",", strList);
		}
		return ss;
	}

	// 超时退出
	/**
	 * @param shell
	 *            shell命令
	 * @param timeout
	 *            执行超时时间设置
	 * @author jipf
	 */
	public static void execOutTime(String shell, long timeout) {
		try {
			/** 切换用户执行shell脚本 */
			Process process = Runtime.getRuntime().exec(shell);
			ExecutorService executorService = Executors.newFixedThreadPool(2);
			Future<String> future1 = executorService.submit(() -> {
				return handlerProcessBlock(process.getInputStream());
			});
			Future<String> future2 = executorService.submit(() -> {
				return handlerProcessBlock(process.getErrorStream());
			});
			executorService.shutdown();// 任务执行完毕退出
			if (process.waitFor(timeout, TimeUnit.SECONDS)) {// 程序在限定时间内执行完毕
				/* 退出码为0时 属于正常退出 **/
				if (process.exitValue() != 0) {// 执行shell出错 记录错误信息
					System.out.println(future2.get());
				}
			} else {
				System.out.println("exec time out!");// 执行shell超时
				executorService.shutdownNow();// 终止线程池任务执行
				process.destroy();// kill 子进程
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void execOutTime(String[] shell, long timeout) {
		try {
			/** 切换用户执行shell脚本 */
			Process process = Runtime.getRuntime().exec(shell);
			ExecutorService executorService = Executors.newFixedThreadPool(2);
			Future<String> future1 = executorService.submit(() -> {
				return handlerProcessBlock(process.getInputStream());
			});
			Future<String> future2 = executorService.submit(() -> {
				return handlerProcessBlock(process.getErrorStream());
			});
			executorService.shutdown();// 任务执行完毕退出
			if (process.waitFor(timeout, TimeUnit.SECONDS)) {// 程序在限定时间内执行完毕
				/* 退出码为0时 属于正常退出 **/
				if (process.exitValue() != 0) {// 执行shell出错 记录错误信息
					System.out.println(future2.get());
				}
			} else {
				System.out.println("exec time out!");// 执行shell超时
				executorService.shutdownNow();// 终止线程池任务执行
				process.destroy();// kill 子进程
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 处理阻塞问题 清理缓冲区 防止进程阻塞
	 * 子线程向缓冲区中写数据，若java虚拟机没有及时的读取缓冲区中的数据，导致缓冲区满了，则主线程会阻塞，此时就会卡住
	 * 
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	private static String handlerProcessBlock(InputStream inputStream) {
		BufferedReader reader = null;
		try {
			StringBuffer sb = new StringBuffer();
			String buff;
			reader = new BufferedReader(new InputStreamReader(inputStream));
			while ((buff = reader.readLine()) != null) {
				sb.append(buff.trim()).append("\n");
			}
			return sb.toString();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (reader != null) {
				try {
					reader.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "";
	}

	// 执行命令
	public static String shell(String ipAddress) {
		String line;
		String log = "";
		try {
			Process pro = Runtime.getRuntime().exec(ipAddress);
			pro.waitFor();
			BufferedReader buf = new BufferedReader(new InputStreamReader(pro.getInputStream()));
			while ((line = buf.readLine()) != null) {
				log += (line.toString().trim() + "\n");
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return log;
	}

	// 执行命令
	public static String shell(List<String> list) {
		String[] strArray = list.toArray(new String[list.size()]);
		String line;
		String mun = "";
		try {
			Process pro = Runtime.getRuntime().exec(strArray);
			pro.waitFor();
			BufferedReader buf = new BufferedReader(new InputStreamReader(pro.getInputStream()));
			while ((line = buf.readLine()) != null) {
				mun = (line.toString().trim() + "\n");
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return mun;
	}

}