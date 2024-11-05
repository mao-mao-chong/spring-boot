package com.dao;

import com.entity.InterviwInformationEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.InterviwInformationVO;
import com.entity.view.InterviwInformationView;


/**
 * 课程信息
 * 
 * @author 
 * @email 
 * @date 2021-03-04 10:22:19
 */
public interface InterviwInformationDao extends BaseMapper<InterviwInformationEntity> {
	
	List<InterviwInformationVO> selectListVO(@Param("ew") Wrapper<InterviwInformationEntity> wrapper);
	
	InterviwInformationVO selectVO(@Param("ew") Wrapper<InterviwInformationEntity> wrapper);
	
	List<InterviwInformationView> selectListView(@Param("ew") Wrapper<InterviwInformationEntity> wrapper);

	List<InterviwInformationView> selectListView(Pagination page, @Param("ew") Wrapper<InterviwInformationEntity> wrapper);
	
	InterviwInformationView selectView(@Param("ew") Wrapper<InterviwInformationEntity> wrapper);
	
}
