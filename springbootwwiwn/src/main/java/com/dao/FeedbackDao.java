package com.dao;

import com.entity.FeedbackEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FeedbackVO;
import com.entity.view.FeedbackView;


/**
 * 课程评价
 * 
 * @author 
 * @email 
 * @date 2021-03-04 10:22:19
 */
public interface FeedbackDao extends BaseMapper<FeedbackEntity> {
	
	List<FeedbackVO> selectListVO(@Param("ew") Wrapper<FeedbackEntity> wrapper);
	
	FeedbackVO selectVO(@Param("ew") Wrapper<FeedbackEntity> wrapper);
	
	List<FeedbackView> selectListView(@Param("ew") Wrapper<FeedbackEntity> wrapper);

	List<FeedbackView> selectListView(Pagination page, @Param("ew") Wrapper<FeedbackEntity> wrapper);
	
	FeedbackView selectView(@Param("ew") Wrapper<FeedbackEntity> wrapper);
	
}
