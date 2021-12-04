package com.buubiu.service.service.impl;

import com.buubiu.entity.UserContainer;
import com.buubiu.service.ContainerService;
import com.buubiu.service.TechService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @comment:
 * @author: buubiu
 * @create: 2021/12/1 16:19
 */
@Service
public class TechServiceImpl implements TechService {

	@Value("${user-container-json-path}")
	private String userContainerJsonPath;

	@Autowired
	private ContainerService containerService;

	@Override
	public void start(String userId) {
		List<String> containerIds = this.getContainerIds(userId);
		for (String containerId : containerIds) {
			containerService.start(containerId);
		}
	}

	@Override
	public void stop(String userId) {
		List<String> containerIds = this.getContainerIds(userId);
		for (String containerId : containerIds) {
			containerService.stop(containerId);
		}
	}

	@Override
	public void restart(String userId) {
		List<String> containerIds = this.getContainerIds(userId);
		for (String containerId : containerIds) {
			containerService.restart(containerId);
		}
	}

	private List<String> getContainerIds(String userId) {
		List<String> containerIds = new ArrayList<>();
		Gson gson = new Gson();
		try {
			JsonReader jsonReader = new JsonReader(new FileReader(userContainerJsonPath + "user-container.json"));
			Type listType = new TypeToken<ArrayList<UserContainer>>(){}.getType();
			List<UserContainer> userContainers = gson.fromJson(jsonReader, listType);

			containerIds = userContainers.stream().filter(u -> userId.equals(u.getUserId()))
				.map(UserContainer::getContainerId).collect(
					Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return containerIds;
	}
}
