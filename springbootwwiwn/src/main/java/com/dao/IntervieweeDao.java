package com.dao;

import com.entity.IntervieweeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.IntervieweeVO;
import com.entity.view.IntervieweeView;


/**
 * 学生
 * 
 * @author 
 * @email 
 * @date 2021-03-04 10:22:19
 */
public interface IntervieweeDao extends BaseMapper<IntervieweeEntity> {
	
	List<IntervieweeVO> selectListVO(@Param("ew") Wrapper<IntervieweeEntity> wrapper);
	
	IntervieweeVO selectVO(@Param("ew") Wrapper<IntervieweeEntity> wrapper);
	
	List<IntervieweeView> selectListView(@Param("ew") Wrapper<IntervieweeEntity> wrapper);

	List<IntervieweeView> selectListView(Pagination page, @Param("ew") Wrapper<IntervieweeEntity> wrapper);
	
	IntervieweeView selectView(@Param("ew") Wrapper<IntervieweeEntity> wrapper);
	
}
