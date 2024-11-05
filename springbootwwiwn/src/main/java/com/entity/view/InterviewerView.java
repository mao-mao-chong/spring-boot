package com.entity.view;

import com.entity.InterviewerEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 教师
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-04 10:22:19
 */
@TableName("jiaoshi")
public class InterviewerView extends InterviewerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public InterviewerView(){
	}
 
 	public InterviewerView(InterviewerEntity interviewerEntity){
 	try {
			BeanUtils.copyProperties(this, interviewerEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
