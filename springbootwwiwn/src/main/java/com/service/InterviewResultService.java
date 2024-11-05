package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.InterviewResultEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.InterviewResultVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.InterviewResultView;


/**
 * 作业评分
 *
 * @author 
 * @email 
 * @date 2021-03-04 10:22:19
 */
public interface InterviewResultService extends IService<InterviewResultEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<InterviewResultVO> selectListVO(Wrapper<InterviewResultEntity> wrapper);
   	
   	InterviewResultVO selectVO(@Param("ew") Wrapper<InterviewResultEntity> wrapper);
   	
   	List<InterviewResultView> selectListView(Wrapper<InterviewResultEntity> wrapper);
   	
   	InterviewResultView selectView(@Param("ew") Wrapper<InterviewResultEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<InterviewResultEntity> wrapper);
   	
}

