package com.entity.view;

import com.entity.CurriculumVitaeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 作业提交
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-04 10:22:19
 */
@TableName("zuoyetijiao")
public class CurriculumVitaeView extends CurriculumVitaeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CurriculumVitaeView(){
	}
 
 	public CurriculumVitaeView(CurriculumVitaeEntity curriculumVitaeEntity){
 	try {
			BeanUtils.copyProperties(this, curriculumVitaeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
