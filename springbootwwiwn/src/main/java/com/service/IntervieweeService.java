package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.IntervieweeEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.IntervieweeVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.IntervieweeView;


/**
 * 学生
 *
 * @author 
 * @email 
 * @date 2021-03-04 10:22:19
 */
public interface IntervieweeService extends IService<IntervieweeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<IntervieweeVO> selectListVO(Wrapper<IntervieweeEntity> wrapper);
   	
   	IntervieweeVO selectVO(@Param("ew") Wrapper<IntervieweeEntity> wrapper);
   	
   	List<IntervieweeView> selectListView(Wrapper<IntervieweeEntity> wrapper);
   	
   	IntervieweeView selectView(@Param("ew") Wrapper<IntervieweeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<IntervieweeEntity> wrapper);
   	
}

