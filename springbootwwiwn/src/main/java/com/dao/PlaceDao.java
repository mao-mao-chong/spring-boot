package com.dao;

import com.entity.PlaceEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PlaceVO;
import com.entity.view.PlaceView;


/**
 * 班级
 * 
 * @author 
 * @email 
 * @date 2021-03-04 10:22:19
 */
public interface PlaceDao extends BaseMapper<PlaceEntity> {
	
	List<PlaceVO> selectListVO(@Param("ew") Wrapper<PlaceEntity> wrapper);
	
	PlaceVO selectVO(@Param("ew") Wrapper<PlaceEntity> wrapper);
	
	List<PlaceView> selectListView(@Param("ew") Wrapper<PlaceEntity> wrapper);

	List<PlaceView> selectListView(Pagination page, @Param("ew") Wrapper<PlaceEntity> wrapper);
	
	PlaceView selectView(@Param("ew") Wrapper<PlaceEntity> wrapper);
	
}
