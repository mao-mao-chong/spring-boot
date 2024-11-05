package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CurriculumVitaeEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CurriculumVitaeVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CurriculumVitaeView;


/**
 * 作业提交
 *
 * @author 
 * @email 
 * @date 2021-03-04 10:22:19
 */
public interface CurriculumVitaeService extends IService<CurriculumVitaeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CurriculumVitaeVO> selectListVO(Wrapper<CurriculumVitaeEntity> wrapper);
   	
   	CurriculumVitaeVO selectVO(@Param("ew") Wrapper<CurriculumVitaeEntity> wrapper);
   	
   	List<CurriculumVitaeView> selectListView(Wrapper<CurriculumVitaeEntity> wrapper);
   	
   	CurriculumVitaeView selectView(@Param("ew") Wrapper<CurriculumVitaeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CurriculumVitaeEntity> wrapper);
   	
}

