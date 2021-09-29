package com.face.know;

import java.util.Collections;

/**
 * 集合相关
 */
public class CollectionAbout {
	/**
	 * ArrayList 和 LinkedList 有什么区别？
	 *
	 * ArrayList 和 LinkedList 都实现了List接口，他们有以下的不同点：
	 * 	1.ArrayList是基于索引的数据接口，它的底层是数组。它可以以O(1)时间复杂度对元素进行随机访问。与此对应，
	 * 	LinkedList是以元素列表的形式存储它的数据，每一个元素都和它的前一个和后一个元素链接在一起，在这种情况下，
	 * 	查找摸个元素的时间复杂度是O(n)。
	 * 	2.相对于ArrayList,LinkList的插入、添加、删除操作速度更快，因为当元素被添加到集合任意位置的时候，不需要
	 * 	像数组那样重新计算大小或更新索引。
	 * 	3.LinkedList比ArrayList更占内存，因为LinkedList为每一个节点存储了两个引用一个指向前一个元素，一个指向
	 * 	下一个元素。
	 * 	4.LinkedList适合不会随机访问，插入、删除操作多的场景
	 */

	/**
	 * 高并发中的集合有哪些问题？
	 * 第一代线程安全集合类
	 * Vector、Hashtable
	 * 是怎么保证线程安全的:使用是synchronized修饰方法
	 * 缺点：效率低下
	 *
	 * 第二代线程非安全集合类
	 * ArrayList 、HashMap
	 * 线程不安全，但是性能好，用来替代Vector、HashTable
	 * 使用ArrayList、HashMap,需要线程安全怎么办呢？
	 * 使用Collections.synchronizedList(list);Collections.synchronizedMap(m);
	 * 底层使用synchronized代码块锁 虽然也是锁住了所有代码，但是锁在方法里边，比锁在方法外边性能稍微提高
	 *
	 * 第三代线程安全集合类
	 *  在大量并发情况下如何提高集合的效率和安全呢？
	 *  java.util.concurrent.*
	 *  	ConcurrentHashMap:
	 *  	CopyOnWriteArrayList:
	 *  	CopyOnWriteArraySet: 注意不是CopyOnWriteHashSet*
	 *  	底层大都采用Lock锁（1.8的ConcurrentHashMap不使用Lock锁），保证安全的同时，性能也高
	 *
	 */

	/**
	 *  collection
	 *  	-List
	 *  		-- CopyOnWriteArrayList
	 *  		-- Vector 	Stack
	 *  		-- ArrayList
	 *  		-- LinkedList
	 *  	-Set
	 *  		-- HashSet LinkedHashSet
	 *  		-- SortedSet TreeSet
	 *  		-- EnumSet
	 *  		-- CopyOnWriteArraySet
	 *  		-- ConcurrentSkipListSet
	 *  	-Queue
	 *  		-- Deque
	 *  			--- ArrayDeque
	 *  			--- BlockingDeque   LinkedBlockingDeque
	 *  		-- BlockingQueue
	 *  			--- ArrayBlockingQueue
	 *  			--- PriortityBlockingQueue
	 *  			--- LinkedBlockingQueue
	 *  			--- TransferQueue	LinkedTransferQueue
	 *  			--- SynchronousQueue
	 *  			--- DelayQueue
	 *	Map
	 *		-HashMap  LinkedHashMap
	 *		-TreeMap
	 *		-WeakHashMap
	 *		-IdentifyHashMap
	 *		-ConcurrentHashMap
	 *		-ConcurrentSkipListMap
	 *
	 */

}
