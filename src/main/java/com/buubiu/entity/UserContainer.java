package com.buubiu.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @comment:
 * @author: buubiu
 * @create: 2021/12/1 16:37
 */
@Data
@ToString
public class UserContainer {

	private String userId;

	private String containerId;

	private String containerName;
}
