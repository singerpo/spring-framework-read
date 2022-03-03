/*
 * Copyright 2002-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;

/**
 * handler的适配器，将dispatcherHandler与调用处理程序联合在一起，以便支持各种类型的处理器
 *
 * 存在适配器的原因是SpringMVC并没有对处理器做任何限制，处理器可以以任意合理的方式来表现，可以是一个类，也可以是一个方法
 * 还可以是别的合理的方式，使用适配器可以将各种类型的处理器都可以用来执行处理
 *
 * MVC framework SPI, allowing parameterization of the core MVC workflow.
 *
 * <p>Interface that must be implemented for each handler type to handle a request.
 * This interface is used to allow the {@link DispatcherServlet} to be indefinitely
 * extensible. The {@code DispatcherServlet} accesses all installed handlers through
 * this interface, meaning that it does not contain code specific to any handler type.
 *
 * <p>Note that a handler can be of type {@code Object}. This is to enable
 * handlers from other frameworks to be integrated with this framework without
 * custom coding, as well as to allow for annotation-driven handler objects that
 * do not obey any specific Java interface.
 *
 * <p>This interface is not intended for application developers. It is available
 * to handlers who want to develop their own web workflow.
 *
 * <p>Note: {@code HandlerAdapter} implementors may implement the {@link
 * org.springframework.core.Ordered} interface to be able to specify a sorting
 * order (and thus a priority) for getting applied by the {@code DispatcherServlet}.
 * Non-Ordered instances get treated as lowest priority.
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @see org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter
 * @see org.springframework.web.servlet.handler.SimpleServletHandlerAdapter
 */
public interface HandlerAdapter {

	/**
	 * 判断是否可以使用某个handler
	 * Given a handler instance, return whether or not this {@code HandlerAdapter}
	 * can support it. Typical HandlerAdapters will base the decision on the handler
	 * type. HandlerAdapters will usually only support one handler type each.
	 * <p>A typical implementation:
	 * <p>{@code
	 * return (handler instanceof MyHandler);
	 * }
	 * @param handler the handler object to check
	 * @return whether or not this object can use the given handler
	 */
	boolean supports(Object handler);

	/**
	 * 执行处理器，返回ModelAndView结果
	 * Use the given handler to handle this request.
	 * The workflow that is required may vary widely.
	 * @param request current HTTP request
	 * @param response current HTTP response
	 * @param handler the handler to use. This object must have previously been passed
	 * to the {@code supports} method of this interface, which must have
	 * returned {@code true}.
	 * @throws Exception in case of errors
	 * @return a ModelAndView object with the name of the view and the required
	 * model data, or {@code null} if the request has been handled directly
	 */
	@Nullable
	ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception;

	/**
	 * 返回请求的最新更新时间，如果不支持该操作，则返回-1即可
	 * Same contract as for HttpServlet's {@code getLastModified} method.
	 * Can simply return -1 if there's no support in the handler class.
	 * @param request current HTTP request
	 * @param handler the handler to use
	 * @return the lastModified value for the given handler
	 * @deprecated as of 5.3.9 along with
	 * {@link org.springframework.web.servlet.mvc.LastModified}.
	 */
	@Deprecated
	long getLastModified(HttpServletRequest request, Object handler);

}
