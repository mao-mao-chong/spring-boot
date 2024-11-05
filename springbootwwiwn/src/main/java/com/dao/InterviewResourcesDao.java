package com.dao;

import com.entity.InterviewMaterialsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.InterviewResourcesVO;
import com.entity.view.InterviewMaterialsView;


/**
 * 作业布置
 * 
 * @author 
 * @email 
 * @date 2021-03-04 10:22:19
 */
public interface InterviewResourcesDao extends BaseMapper<InterviewMaterialsEntity> {
	
	List<InterviewResourcesVO> selectListVO(@Param("ew") Wrapper<InterviewMaterialsEntity> wrapper);
	
	InterviewResourcesVO selectVO(@Param("ew") Wrapper<InterviewMaterialsEntity> wrapper);
	
	List<InterviewMaterialsView> selectListView(@Param("ew") Wrapper<InterviewMaterialsEntity> wrapper);

	List<InterviewMaterialsView> selectListView(Pagination page, @Param("ew") Wrapper<InterviewMaterialsEntity> wrapper);
	
	InterviewMaterialsView selectView(@Param("ew") Wrapper<InterviewMaterialsEntity> wrapper);
	
}
