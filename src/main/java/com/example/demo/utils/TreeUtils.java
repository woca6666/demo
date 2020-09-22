package com.example.demo.utils;

import com.example.demo.pojo.base.Menu;
import com.example.demo.pojo.base.TreeBean;

import java.util.ArrayList;
import java.util.List;


public class TreeUtils {

	/**
	 * 树状形式查询父节点以及下面的所有子节点
	 * 
	 * @param menuList
	 * @param parentId
	 * @return
	 */
	public static List<Menu> listMenuChildren(List<Menu> menuList, int parentId) {
		List<Menu> childMenu = new ArrayList<Menu>();
		for (Menu menu : menuList) {
			int menuId = menu.getId();
			int pid = menu.getPid();
			if (parentId == pid) {
				List<Menu> c_node = listMenuChildren(menuList, menuId);
				if (c_node != null && c_node.size() > 0) {
					childMenu.addAll(c_node);
				}
				childMenu.add(menu);
			}
		}
		if (childMenu.size() > 0) {
			return childMenu;
		} else {
			return new ArrayList<>();
		}
	}

	/**
	 * 树状形式查询父节点以及下面的所有子节点
	 * 
	 * @param menuList
	 * @param parentId
	 * @return
	 */
	public static List<Menu> treeMenu(List<Menu> menuList, int parentId) {
		List<Menu> childMenu = new ArrayList<Menu>();
		for (Menu menu : menuList) {
			int menuId = menu.getId();
			int pid = menu.getPid();
			if (parentId == pid) {
				List<Menu> c_node = treeMenu(menuList, menuId);
				if (c_node != null && c_node.size() > 0) {
					menu.setNodes(c_node);
				}
				childMenu.add(menu);
			}
		}
		if (childMenu.size() > 0) {
			return childMenu;
		} else {
			return new ArrayList<>();
		}
	}

	/**
	 * 树状形式查询父节点以及下面的所有子节点
	 * 
	 * @param treeList
	 * @param parentId
	 * @return
	 */

	public static List<TreeBean> treeTreeBean(List<TreeBean> treeList, int parentId) {
		List<TreeBean> childMenu = new ArrayList<TreeBean>();
		for (TreeBean tree : treeList) {
			int id = tree.getId();
			int pid = tree.getPid();
			if (parentId == pid) {
				List<TreeBean> c_node = treeTreeBean(treeList, id);
				if (c_node != null && c_node.size() > 0) {
					tree.setChildren(c_node);
				}
				childMenu.add(tree);
			}
		}
		if (childMenu.size() > 0) {
			return childMenu;
		} else {
			return new ArrayList<>();
		}
	}

	public static List<TreeBean> treeTreeBeanNew(List<TreeBean> treeList, int parentId) {
		List<TreeBean> childMenu = new ArrayList<TreeBean>();
		for (TreeBean tree : treeList) {
			int id = tree.getId();
			int pid = tree.getPid();
			if (parentId == pid) {
				List<TreeBean> bean = new ArrayList<TreeBean>();
				for (TreeBean treeList2 : treeList) {
					Integer pid2 = treeList2.getPid();
					if (id == pid2) {
						bean.add(treeList2);
					}
				}
				tree.setChildren(bean);
				childMenu.add(tree);
			}
		}
		if (childMenu.size() > 0) {
			return childMenu;
		} else {
			return new ArrayList<>();
		}
	}

}
