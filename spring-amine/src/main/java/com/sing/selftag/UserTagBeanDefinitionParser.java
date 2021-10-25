package com.sing.selftag;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 *
 * @see org.springframework.context.config.PropertyPlaceholder BeanDefinitionParser
 */
public class UserTagBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
	// 返回属性值所对应的对象
	@Override
	protected Class<?> getBeanClass(Element element) {
		return UserTag.class;
	}

	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		// 获取标签具体的属性值
		String username = element.getAttribute("username");
		String email = element.getAttribute("email");
		String password = element.getAttribute("password");
		if(StringUtils.hasText(username)){
			builder.addPropertyValue("username",username);
		}
		if(StringUtils.hasText(email)){
			builder.addPropertyValue("email",email);
		}
		if(StringUtils.hasText(password)){
			builder.addPropertyValue("password",password);
		}
	}
}
