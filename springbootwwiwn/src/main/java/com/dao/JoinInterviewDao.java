package com.dao;

import com.entity.JoinInterviewEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JoinInterviewVO;
import com.entity.view.JoinInterviewView;


/**
 * 学生选课
 * 
 * @author 
 * @email 
 * @date 2021-03-04 10:22:19
 */
public interface JoinInterviewDao extends BaseMapper<JoinInterviewEntity> {
	
	List<JoinInterviewVO> selectListVO(@Param("ew") Wrapper<JoinInterviewEntity> wrapper);
	
	JoinInterviewVO selectVO(@Param("ew") Wrapper<JoinInterviewEntity> wrapper);
	
	List<JoinInterviewView> selectListView(@Param("ew") Wrapper<JoinInterviewEntity> wrapper);

	List<JoinInterviewView> selectListView(Pagination page, @Param("ew") Wrapper<JoinInterviewEntity> wrapper);
	
	JoinInterviewView selectView(@Param("ew") Wrapper<JoinInterviewEntity> wrapper);
	
}
