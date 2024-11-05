package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.InterviwInformationEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.InterviwInformationVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.InterviwInformationView;


/**
 * 课程信息
 *
 * @author 
 * @email 
 * @date 2021-03-04 10:22:19
 */
public interface InterviwInformationService extends IService<InterviwInformationEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<InterviwInformationVO> selectListVO(Wrapper<InterviwInformationEntity> wrapper);
   	
   	InterviwInformationVO selectVO(@Param("ew") Wrapper<InterviwInformationEntity> wrapper);
   	
   	List<InterviwInformationView> selectListView(Wrapper<InterviwInformationEntity> wrapper);
   	
   	InterviwInformationView selectView(@Param("ew") Wrapper<InterviwInformationEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<InterviwInformationEntity> wrapper);
   	
}

