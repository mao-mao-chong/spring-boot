package com.dao;

import com.entity.InterviewResultEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.InterviewResultVO;
import com.entity.view.InterviewResultView;


/**
 * 作业评分
 * 
 * @author 
 * @email 
 * @date 2021-03-04 10:22:19
 */
public interface InterviewResultDao extends BaseMapper<InterviewResultEntity> {
	
	List<InterviewResultVO> selectListVO(@Param("ew") Wrapper<InterviewResultEntity> wrapper);
	
	InterviewResultVO selectVO(@Param("ew") Wrapper<InterviewResultEntity> wrapper);
	
	List<InterviewResultView> selectListView(@Param("ew") Wrapper<InterviewResultEntity> wrapper);

	List<InterviewResultView> selectListView(Pagination page, @Param("ew") Wrapper<InterviewResultEntity> wrapper);
	
	InterviewResultView selectView(@Param("ew") Wrapper<InterviewResultEntity> wrapper);
	
}
