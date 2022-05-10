package com.face.know;


import java.util.HashMap;
import java.util.Map;

/**
 * JDK新特性
 */
public class JdkFeature {
	/**
	 * JDK8新特性
	 * 一、接口的默认方法
	 * 	Java8 允许我们给接口添加一个非抽象的方法实现，只需要使用default关键字即可，这个特征又叫做扩展方法，
	 * 	示例如下：
	 * 	代码如下：
	 * 	public interface Formula {
	 * 	    double calculate(int a);
	 * 	    default double sqr(int a){
	 * 	        return Math.sqr(a);
	 * 	    }
	 * 	}
	 *
	 * 二、Lambda表达式
	 *
	 * 三、函数式接口（@FunctionalInteface)
	 *  接口添加@FunctionalInteface注解，接口只包含一个抽象方法
	 *
	 * 四、日期
	 * Clock 时钟
	 * TimeZones时区
	 * LocalTime 本地时间
	 * LocalDate 本地日期
	 * LocalDateTime 本地日期时间
	 *
	 * 五、多重注解
	 * 可以使用getAnnotatonByType(xx.class)获取所有的@xx注解
	 *
	 * 六、新的接口
	 * Predicate接口
	 * Function 接口
	 * Supplier 接口
	 * Optional 接口
	 * ComParator接口 增加多种默认方法
	 * Stream接口（ParallelStream并行stream)
	 * 		-filter过滤
	 * 		-sorted排序
	 * 		-match匹配
	 * 		-count计数
	 * 		-reduce规约
	 * 七. Map 提供了一些新的有用的方法来处理一些日常任务
	 * putIfAbsent  如果不存在时进行存储，返回null;如果存在时不进行存储，返回存在的值
	 * computeIfAbsent   如果不存在时进行存储，返回存储的值;如果存在时不进行存储，返回存在的值
	 * computeIfPresent  如果不存在时不进行存储，返回null;如果存在进行存储，返回存储的值
	 * compute
	 * merge
	 * getOrDefault
	 *
	 *
	 *
	 */
	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<>();
		// map.put("11","11");
		System.out.println(map.computeIfPresent("11",(key,value) -> "22"));
	}
}
