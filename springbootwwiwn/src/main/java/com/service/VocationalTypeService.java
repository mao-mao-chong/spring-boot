package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.VocationalTypeEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.VocationalTypeVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.VocationalTypeView;


/**
 * 课程类型
 *
 * @author 
 * @email 
 * @date 2021-03-04 10:22:19
 */
public interface VocationalTypeService extends IService<VocationalTypeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<VocationalTypeVO> selectListVO(Wrapper<VocationalTypeEntity> wrapper);
   	
   	VocationalTypeVO selectVO(@Param("ew") Wrapper<VocationalTypeEntity> wrapper);
   	
   	List<VocationalTypeView> selectListView(Wrapper<VocationalTypeEntity> wrapper);
   	
   	VocationalTypeView selectView(@Param("ew") Wrapper<VocationalTypeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<VocationalTypeEntity> wrapper);
   	
}

