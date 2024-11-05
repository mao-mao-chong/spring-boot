package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.InterviewerEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.InterviewerVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.InterviewerView;


/**
 * 教师
 *
 * @author 
 * @email 
 * @date 2021-03-04 10:22:19
 */
public interface InterviewerService extends IService<InterviewerEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<InterviewerVO> selectListVO(Wrapper<InterviewerEntity> wrapper);
   	
   	InterviewerVO selectVO(@Param("ew") Wrapper<InterviewerEntity> wrapper);
   	
   	List<InterviewerView> selectListView(Wrapper<InterviewerEntity> wrapper);
   	
   	InterviewerView selectView(@Param("ew") Wrapper<InterviewerEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<InterviewerEntity> wrapper);
   	
}

