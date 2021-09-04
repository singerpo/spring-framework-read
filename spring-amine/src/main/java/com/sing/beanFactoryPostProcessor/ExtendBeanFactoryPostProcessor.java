package com.sing.beanFactoryPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class ExtendBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // GenericBeanDefinition xxService = (GenericBeanDefinition) beanFactory.getBeanDefinition("xxService");
        // //扩展之后xxService消失掉，yyService成为spring bean
        // xxService.setBeanClass(yyService.class);

		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(TestBfp.class);
		BeanDefinitionRegistry beanDefinitionRegistry = (BeanDefinitionRegistry)beanFactory;
		beanDefinitionRegistry.registerBeanDefinition("testBfp",rootBeanDefinition);

    }
}