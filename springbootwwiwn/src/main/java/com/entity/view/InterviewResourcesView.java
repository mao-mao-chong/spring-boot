package com.entity.view;

import com.entity.InterviewResourcesEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 课程资源
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-04 10:22:19
 */
@TableName("kechengziyuan")
public class InterviewResourcesView extends InterviewResourcesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public InterviewResourcesView(){
	}
 
 	public InterviewResourcesView(InterviewResourcesEntity interviewResourcesEntity){
 	try {
			BeanUtils.copyProperties(this, interviewResourcesEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
