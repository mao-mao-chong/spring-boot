package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PlaceEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PlaceVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PlaceView;


/**
 * 班级
 *
 * @author 
 * @email 
 * @date 2021-03-04 10:22:19
 */
public interface PlaceService extends IService<PlaceEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PlaceVO> selectListVO(Wrapper<PlaceEntity> wrapper);
   	
   	PlaceVO selectVO(@Param("ew") Wrapper<PlaceEntity> wrapper);
   	
   	List<PlaceView> selectListView(Wrapper<PlaceEntity> wrapper);
   	
   	PlaceView selectView(@Param("ew") Wrapper<PlaceEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PlaceEntity> wrapper);
   	
}

