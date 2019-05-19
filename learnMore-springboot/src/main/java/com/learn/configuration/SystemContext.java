package com.learn.configuration;


import java.util.Map;

/**
 * 用来传递列表对象的ThreadLocal数据
 * @author Administrator
 *
 */
public class SystemContext {
	/**
	 * 分页大小
	 */
	private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();
	/**
	 * 分页的起始页
	 */
	private static ThreadLocal<Integer> currentPage = new ThreadLocal<Integer>();
	/**
	 * 列表的排序字段
	 */
	private static ThreadLocal<String> sort = new ThreadLocal<String>();
	/**
	 * 列表的排序方式
	 */
	private static ThreadLocal<String> order = new ThreadLocal<String>();
	
	private static ThreadLocal<String> realPath = new ThreadLocal<String>();

	private static ThreadLocal<Map> columnMap = new ThreadLocal<Map>();

	private static ThreadLocal<String> currentLoginName = new ThreadLocal<>();

	public static String getCurrentLoginName() {
		return currentLoginName.get();
	}

	public static void setCurrentLoginName(String currentLoginName) {
		SystemContext.currentLoginName.set(currentLoginName);
	}

	public static Map getColumnMap() {
        return columnMap.get();
    }

    public static void setColumnMap(Map columnMap) {
        SystemContext.columnMap.set(columnMap);
    }

    public static String getRealPath() {
		return realPath.get();
	}
	public static void setRealPath(String _realPath) {
		SystemContext.realPath.set(_realPath);
	}
	public static Integer getPageSize() {
		return pageSize.get();
	}
	public static void setPageSize(Integer _pageSize) {
		pageSize.set(_pageSize);
	}
	public static Integer getCurrentPage() {
		return currentPage.get();
	}
	public static void setCurrentPage(Integer _currentPage) {
		currentPage.set(_currentPage);
	}
	public static String getSort() {
		return sort.get();
	}
	public static void setSort(String _sort) {
		SystemContext.sort.set(_sort);
	}
	public static String getOrder() {
		return order.get();
	}
	public static void setOrder(String _order) {
		SystemContext.order.set(_order);
	}
	
	public static void removePageSize() {
		pageSize.remove();
	}
	
	public static void removeCurrentPage() {
		currentPage.remove();
	}
	
	public static void removeSort() {
		sort.remove();
	}
	
	public static void removeOrder() {
		order.remove();
	}
	
	public static void removeRealPath() {
		realPath.remove();
	}

	public static void removeCurrentLoginName() {
		currentLoginName.remove();
	}
	
}
