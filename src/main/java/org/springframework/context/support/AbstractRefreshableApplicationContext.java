package org.springframework.context.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 *  创建 beanFactory 、 刷新beanFactory、获取 beanFactory
 *  创建好beanFactory -> 给beanFactory 中设置 beanDefinition -> 把beanFactory中放入到上下文中
 * @author derekyi
 * @date 2020/11/28
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

	private DefaultListableBeanFactory beanFactory;

	/**
	 * 创建beanFactory并加载BeanDefinition
	 *
	 * @throws BeansException
	 */
	protected final void refreshBeanFactory() throws BeansException {
		DefaultListableBeanFactory beanFactory = createBeanFactory();
		loadBeanDefinitions(beanFactory);
		this.beanFactory = beanFactory;
	}

	/**
	 * 创建bean工厂
	 *
	 * @return
	 */
	protected DefaultListableBeanFactory createBeanFactory() {
		return new DefaultListableBeanFactory();
	}

	/**
	 * 加载BeanDefinition
	 * 为什么 loadBeanDefinitions 要定义为抽象方法？ 因为除 XMLPathContext 外 ，还有其他类型的Context？
	 * @param beanFactory
	 * @throws BeansException
	 */
	protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException;

	public DefaultListableBeanFactory getBeanFactory() {
		return beanFactory;
	}
}
