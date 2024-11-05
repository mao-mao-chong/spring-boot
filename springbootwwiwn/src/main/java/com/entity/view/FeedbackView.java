package com.entity.view;

import com.entity.FeedbackEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 课程评价
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-04 10:22:19
 */
@TableName("kechengpingjia")
public class FeedbackView extends FeedbackEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public FeedbackView(){
	}
 
 	public FeedbackView(FeedbackEntity feedbackEntity){
 	try {
			BeanUtils.copyProperties(this, feedbackEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
