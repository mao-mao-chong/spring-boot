package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FeedbackEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FeedbackVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FeedbackView;


/**
 * 课程评价
 *
 * @author 
 * @email 
 * @date 2021-03-04 10:22:19
 */
public interface FeedbackService extends IService<FeedbackEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FeedbackVO> selectListVO(Wrapper<FeedbackEntity> wrapper);
   	
   	FeedbackVO selectVO(@Param("ew") Wrapper<FeedbackEntity> wrapper);
   	
   	List<FeedbackView> selectListView(Wrapper<FeedbackEntity> wrapper);
   	
   	FeedbackView selectView(@Param("ew") Wrapper<FeedbackEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FeedbackEntity> wrapper);
   	
}

