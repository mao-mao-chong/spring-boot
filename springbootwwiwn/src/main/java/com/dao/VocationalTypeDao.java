package com.dao;

import com.entity.VocationalTypeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.VocationalTypeVO;
import com.entity.view.VocationalTypeView;


/**
 * 课程类型
 * 
 * @author 
 * @email 
 * @date 2021-03-04 10:22:19
 */
public interface VocationalTypeDao extends BaseMapper<VocationalTypeEntity> {
	
	List<VocationalTypeVO> selectListVO(@Param("ew") Wrapper<VocationalTypeEntity> wrapper);
	
	VocationalTypeVO selectVO(@Param("ew") Wrapper<VocationalTypeEntity> wrapper);
	
	List<VocationalTypeView> selectListView(@Param("ew") Wrapper<VocationalTypeEntity> wrapper);

	List<VocationalTypeView> selectListView(Pagination page, @Param("ew") Wrapper<VocationalTypeEntity> wrapper);
	
	VocationalTypeView selectView(@Param("ew") Wrapper<VocationalTypeEntity> wrapper);
	
}
