package com.migu.schedule;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.migu.schedule.constants.ReturnCodeKeys;

public class ScheduleTest {
	
	private Schedule schedule;
	private int resultcode = 0;

	@Before
	public void setUp() throws Exception {
		schedule = new Schedule();
		resultcode = 0;
		schedule.init();
	}

	/**
	 * 初始化成功，返回E001
	 */
	@Test
	public void initTest() {
		assertEquals(ReturnCodeKeys.E001, schedule.init());
	}

	/**
	 * 注册节点成功(节点id输入正常值)，返回E003
	 */
	@Test
	public void registerNodeTest() {
		resultcode = schedule.registerNode(5);
		assertEquals(ReturnCodeKeys.E003, resultcode);
	}

	/**
	 * 注册节点测试(nodeid = 0)，非法，返回E004
	 */
	@Test
	public void registerNodeByNodeIdZeroTest() {
		resultcode = schedule.registerNode(0);
		assertEquals(ReturnCodeKeys.E004, resultcode);
	}
	
	/**
	 * 注册节点测试(nodeid = -1)，非法，返回E004
	 */
	@Test
	public void registerNodeByNodeIdMinusTest() {
		resultcode = schedule.registerNode(-1);
		assertEquals(ReturnCodeKeys.E004, resultcode);
	}
	
	/**
	 * 注册节点测试(nodeid = 5 已注册过)，返回E005
	 */
	@Test
	public void registerNodeByNodeIdTest() {
		resultcode = schedule.registerNode(5);
		assertEquals(ReturnCodeKeys.E003, resultcode);
		resultcode = schedule.registerNode(5);
		assertEquals(ReturnCodeKeys.E005, resultcode);
	}
	
	/**
	 * 注销节点(nodeid = 5 已注册过)，返回E006
	 */
	@Test
	public void unregisterNodeTest() {
		resultcode = schedule.registerNode(5);
		assertEquals(ReturnCodeKeys.E003, resultcode);
		resultcode = schedule.unregisterNode(5);
		assertEquals(ReturnCodeKeys.E006, resultcode);
	}
	
	/**
	 * 注销节点(nodeid = 0)，返回E004
	 */
	@Test
	public void unregisterNodeByNodeIdZeroTest() {
		resultcode = schedule.unregisterNode(0);
		assertEquals(ReturnCodeKeys.E004, resultcode);
	}
	
	/**
	 * 注销节点(nodeid = -1)，返回E004
	 */
	@Test
	public void unregisterNodeByNodeIdMinusTest() {
		resultcode = schedule.unregisterNode(-1);
		assertEquals(ReturnCodeKeys.E004, resultcode);
	}
	
	/**
	 * 注销节点(nodeid = 3 不存在)，返回E007
	 */
	@Test
	public void unregisterNodeByNodeIdNotTest() {
		resultcode = schedule.unregisterNode(3);
		assertEquals(ReturnCodeKeys.E007, resultcode);
	}
	
	/**
	 * 添加任务成功，返回E008
	 */
	@Test
	public void addTaskTest() {
		resultcode = schedule.addTask(1, 30);
		assertEquals(ReturnCodeKeys.E008, resultcode);
	}
	
	/**
	 * 添加任务，任务id输入0，非法，返回E009
	 */
	@Test
	public void addTaskTaskIdZeroTest() {
		resultcode = schedule.addTask(0, 30);
		assertEquals(ReturnCodeKeys.E009, resultcode);
	}
	
	/**
	 * 添加任务，任务id输入-1，非法，返回E009
	 */
	@Test
	public void addTaskTaskIdMinusTest() {
		resultcode = schedule.addTask(-1, 30);
		assertEquals(ReturnCodeKeys.E009, resultcode);
	}
	
	/**
	 * 添加任务，任务id已存在，非法，返回E010
	 */
	@Test
	public void addTaskTaskIdByTaskIdTest() {
		resultcode = schedule.addTask(2, 30);
		assertEquals(ReturnCodeKeys.E008, resultcode);
		resultcode = schedule.addTask(2, 30);
		assertEquals(ReturnCodeKeys.E010, resultcode);
	}
	
	/**
	 * 删除任务成功，返回E011
	 */
	@Test
	public void deleteTaskTest() {
		resultcode = schedule.addTask(1, 30);
		assertEquals(ReturnCodeKeys.E008, resultcode);
		resultcode = schedule.deleteTask(1);
		assertEquals(ReturnCodeKeys.E011, resultcode);
	}
	
	/**
	 * 删除任务，任务id输入0，非法，返回E009
	 */
	@Test
	public void deleteTaskTaskIdZeroTest() {
		resultcode = schedule.deleteTask(0);
		assertEquals(ReturnCodeKeys.E009, resultcode);
	}
	
	/**
	 * 删除任务，任务id输入-1，非法，返回E009
	 */
	@Test
	public void deleteTaskTaskIdMiunsTest() {
		resultcode = schedule.deleteTask(-1);
		assertEquals(ReturnCodeKeys.E009, resultcode);
	}
	
	/**
	 * 删除任务，任务id输入不存在的，返回E012
	 */
	@Test
	public void deleteTaskTaskIdNotTest() {
		resultcode = schedule.addTask(4, 30);
		assertEquals(ReturnCodeKeys.E008, resultcode);
		resultcode = schedule.deleteTask(3);
		assertEquals(ReturnCodeKeys.E012, resultcode);
	}
	
	/**
	 * 任务调度，任务id输入0非法，返回E002	
	 */
	@Test
	public void scheduleTaskTaskIdZeroTest() {
		resultcode = schedule.scheduleTask(0);
		assertEquals(ReturnCodeKeys.E002, resultcode);
	}
	
	/**
	 * 任务调度，任务id输入-1非法，返回E002	
	 */
	@Test
	public void scheduleTaskTaskIdMinusTest() {
		resultcode = schedule.scheduleTask(-1);
		assertEquals(ReturnCodeKeys.E002, resultcode);
	}
	
	/**
	 * 查询任务状态，集合为空，返回E016
	 */
	@Test
	public void queryTaskStatusListNullTest() {
		resultcode = schedule.queryTaskStatus(null);
		assertEquals(ReturnCodeKeys.E016, resultcode);
	}
	
}
