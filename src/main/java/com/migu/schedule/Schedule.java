package com.migu.schedule;

import com.migu.schedule.constants.ReturnCodeKeys;
import com.migu.schedule.info.TaskInfo;

import java.util.ArrayList;
import java.util.List;

/*
 * 类名和方法不能修改
 */
public class Schedule {
	/**
	 * 节点id list
	 */
	List<Integer> nodeIdList = new ArrayList<Integer>();
	/**
	 * 任务id list
	 */
	List<Integer> taskIdList = new ArrayList<Integer>();

	/**
	 * 系统初始化
	 * @return E001 成功
	 */
	public int init() {
		nodeIdList.clear();
		taskIdList.clear();
		return ReturnCodeKeys.E001;
	}

	/**
	 * 注册节点
	 * @param nodeId 节点id
	 * @return
	 */
	public int registerNode(int nodeId) {
		//节点id非法
		if (nodeId <= 0)
			return ReturnCodeKeys.E004;
		// 节点id已注册
		if (nodeIdList.contains(nodeId))
			return ReturnCodeKeys.E005;
		nodeIdList.add(nodeId);
		return ReturnCodeKeys.E003;
	}

	/**
	 * 注销节点
	 * @param nodeId
	 * @return
	 */
	public int unregisterNode(int nodeId) {
		// 节点非法
		if (nodeId <= 0)
			return ReturnCodeKeys.E004;
		// 节点不存在
		if (!nodeIdList.contains(nodeId))
			return ReturnCodeKeys.E007;
		nodeIdList.remove( new Integer(nodeId));
		return ReturnCodeKeys.E006;
	}

	/**
	 * 添加任务
	 * @param taskId
	 * @param consumption
	 * @return
	 */
	public int addTask(int taskId, int consumption) {
		// 任务id非法
		if (taskId <= 0)
			return ReturnCodeKeys.E009;
		// 任务已存在
		if (taskIdList.contains(taskId))
			return ReturnCodeKeys.E010;
		// 加入任务列表
		taskIdList.add(new Integer(taskId));
		return ReturnCodeKeys.E008;
	}

	/**
	 * 删除任务
	 * @param taskId
	 * @return
	 */
	public int deleteTask(int taskId) {
		// 任务id非法
		if (taskId <= 0)
			return ReturnCodeKeys.E009;
		// 任务不存在
		if (!taskIdList.contains(taskId))
			return ReturnCodeKeys.E012;
		taskIdList.remove(new Integer(taskId));
		return ReturnCodeKeys.E011;
	}

	/**
	 * 任务调度
	 * @param threshold 系统任务调度阈值
	 * @return
	 */
	public int scheduleTask(int threshold) {
		//阈值 非法
		if(threshold <= 0)
			return ReturnCodeKeys.E002;
		//任务调度
		
		return ReturnCodeKeys.E013;
	}

	/**
	 * 任务状态列表
	 * @param tasks 
	 * @return
	 */
	public int queryTaskStatus(List<TaskInfo> tasks) {
		if(null != tasks){
			for (TaskInfo taskInfo : tasks) {
				 taskInfo.getNodeId();
			}
			return ReturnCodeKeys.E015;
		}else {
			return ReturnCodeKeys.E016;
		}
	}

}
