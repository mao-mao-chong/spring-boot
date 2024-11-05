package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.InterviewResourcesEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.InterviewMaterialsVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.InterviewResourcesView;


/**
 * 课程资源
 *
 * @author 
 * @email 
 * @date 2021-03-04 10:22:19
 */
public interface InterviewResourcesService extends IService<InterviewResourcesEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<InterviewMaterialsVO> selectListVO(Wrapper<InterviewResourcesEntity> wrapper);
   	
   	InterviewMaterialsVO selectVO(@Param("ew") Wrapper<InterviewResourcesEntity> wrapper);
   	
   	List<InterviewResourcesView> selectListView(Wrapper<InterviewResourcesEntity> wrapper);
   	
   	InterviewResourcesView selectView(@Param("ew") Wrapper<InterviewResourcesEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<InterviewResourcesEntity> wrapper);
   	
}

