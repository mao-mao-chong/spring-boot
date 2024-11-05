package com.entity.view;

import com.entity.IntervieweeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 学生
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-04 10:22:19
 */
@TableName("xuesheng")
public class IntervieweeView extends IntervieweeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public IntervieweeView(){
	}
 
 	public IntervieweeView(IntervieweeEntity intervieweeEntity){
 	try {
			BeanUtils.copyProperties(this, intervieweeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
