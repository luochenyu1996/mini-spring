package org.springframework.core.io;

/**
 * 资源加载器接口
 *
 * 根据地址字符串加载资源配置文件
 * @author derekyi
 * @date 2020/11/25
 */
public interface ResourceLoader {

	Resource getResource(String location);
}
