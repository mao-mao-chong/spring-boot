package com.dao;

import com.entity.CurriculumVitaeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CurriculumVitaeVO;
import com.entity.view.CurriculumVitaeView;


/**
 * 作业提交
 * 
 * @author 
 * @email 
 * @date 2021-03-04 10:22:19
 */
public interface CurriculumVitaeDao extends BaseMapper<CurriculumVitaeEntity> {
	
	List<CurriculumVitaeVO> selectListVO(@Param("ew") Wrapper<CurriculumVitaeEntity> wrapper);
	
	CurriculumVitaeVO selectVO(@Param("ew") Wrapper<CurriculumVitaeEntity> wrapper);
	
	List<CurriculumVitaeView> selectListView(@Param("ew") Wrapper<CurriculumVitaeEntity> wrapper);

	List<CurriculumVitaeView> selectListView(Pagination page, @Param("ew") Wrapper<CurriculumVitaeEntity> wrapper);
	
	CurriculumVitaeView selectView(@Param("ew") Wrapper<CurriculumVitaeEntity> wrapper);
	
}
