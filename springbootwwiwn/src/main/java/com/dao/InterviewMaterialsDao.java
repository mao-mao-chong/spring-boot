package com.dao;

import com.entity.InterviewResourcesEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.InterviewMaterialsVO;
import com.entity.view.InterviewResourcesView;


/**
 * 课程资源
 * 
 * @author 
 * @email 
 * @date 2021-03-04 10:22:19
 */
public interface InterviewMaterialsDao extends BaseMapper<InterviewResourcesEntity> {
	
	List<InterviewMaterialsVO> selectListVO(@Param("ew") Wrapper<InterviewResourcesEntity> wrapper);
	
	InterviewMaterialsVO selectVO(@Param("ew") Wrapper<InterviewResourcesEntity> wrapper);
	
	List<InterviewResourcesView> selectListView(@Param("ew") Wrapper<InterviewResourcesEntity> wrapper);

	List<InterviewResourcesView> selectListView(Pagination page, @Param("ew") Wrapper<InterviewResourcesEntity> wrapper);
	
	InterviewResourcesView selectView(@Param("ew") Wrapper<InterviewResourcesEntity> wrapper);
	
}
