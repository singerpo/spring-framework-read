package com.sing.supplier;

import com.sing.service.IndexService;

/**
 * 在BeanFactoryPostProcessor里面添加供应器
 *     GenericBeanDefinition xxService = (GenericBeanDefinition) beanFactory.getBeanDefinition("xxService");
 *     xxService.setBeanClass(xxService.class);
 * 	   xxService.setInstanceSupplier(CreateSupplier::createIndexService);
 * @author songbo
 * @date 2021-11-20
 */
public class CreateSupplier {

	public static IndexService createIndexService(){
		return new IndexService();
	}
}
