package com.buubiu.service;

/**
 * @comment:
 * @author: buubiu
 * @create: 2021/12/1 16:18
 */
public interface TechService {

	/**
	 * 启动容器
	 * @author: buubiu
	 * @create: 2021/12/1 19:50
	 * @param userId 用户ID
	 */
	void start(String userId);

	/**
	 * 停止容器
	 * @author: buubiu
	 * @create: 2021/12/1 19:50
	 * @param userId 用户ID
	 */
	void stop(String userId);

	/**
	 * 重启容器
	 * @author: buubiu
	 * @create: 2021/12/1 19:50
	 * @param userId 用户ID
	 */
	void restart(String userId);

}
