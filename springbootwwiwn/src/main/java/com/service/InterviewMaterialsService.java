package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.InterviewMaterialsEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.InterviewResourcesVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.InterviewMaterialsView;


/**
 * 作业布置
 *
 * @author 
 * @email 
 * @date 2021-03-04 10:22:19
 */
public interface InterviewMaterialsService extends IService<InterviewMaterialsEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<InterviewResourcesVO> selectListVO(Wrapper<InterviewMaterialsEntity> wrapper);
   	
   	InterviewResourcesVO selectVO(@Param("ew") Wrapper<InterviewMaterialsEntity> wrapper);
   	
   	List<InterviewMaterialsView> selectListView(Wrapper<InterviewMaterialsEntity> wrapper);
   	
   	InterviewMaterialsView selectView(@Param("ew") Wrapper<InterviewMaterialsEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<InterviewMaterialsEntity> wrapper);
   	
}

