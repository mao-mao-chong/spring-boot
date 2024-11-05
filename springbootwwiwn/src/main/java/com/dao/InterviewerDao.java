package com.dao;

import com.entity.InterviewerEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.InterviewerVO;
import com.entity.view.InterviewerView;


/**
 * 教师
 * 
 * @author 
 * @email 
 * @date 2021-03-04 10:22:19
 */
public interface InterviewerDao extends BaseMapper<InterviewerEntity> {
	
	List<InterviewerVO> selectListVO(@Param("ew") Wrapper<InterviewerEntity> wrapper);
	
	InterviewerVO selectVO(@Param("ew") Wrapper<InterviewerEntity> wrapper);
	
	List<InterviewerView> selectListView(@Param("ew") Wrapper<InterviewerEntity> wrapper);

	List<InterviewerView> selectListView(Pagination page, @Param("ew") Wrapper<InterviewerEntity> wrapper);
	
	InterviewerView selectView(@Param("ew") Wrapper<InterviewerEntity> wrapper);
	
}
