package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JoinInterviewEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JoinInterviewVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JoinInterviewView;


/**
 * 学生选课
 *
 * @author 
 * @email 
 * @date 2021-03-04 10:22:19
 */
public interface JoinInterviewService extends IService<JoinInterviewEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JoinInterviewVO> selectListVO(Wrapper<JoinInterviewEntity> wrapper);
   	
   	JoinInterviewVO selectVO(@Param("ew") Wrapper<JoinInterviewEntity> wrapper);
   	
   	List<JoinInterviewView> selectListView(Wrapper<JoinInterviewEntity> wrapper);
   	
   	JoinInterviewView selectView(@Param("ew") Wrapper<JoinInterviewEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JoinInterviewEntity> wrapper);
   	
}

