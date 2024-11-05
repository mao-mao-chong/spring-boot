package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.CurriculumVitaeDao;
import com.entity.CurriculumVitaeEntity;
import com.service.CurriculumVitaeService;
import com.entity.vo.CurriculumVitaeVO;
import com.entity.view.CurriculumVitaeView;

@Service("CurriculumVitaeService")
public class CurriculumVitaeServiceImpl extends ServiceImpl<CurriculumVitaeDao, CurriculumVitaeEntity> implements CurriculumVitaeService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CurriculumVitaeEntity> page = this.selectPage(
                new Query<CurriculumVitaeEntity>(params).getPage(),
                new EntityWrapper<CurriculumVitaeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CurriculumVitaeEntity> wrapper) {
		  Page<CurriculumVitaeView> page =new Query<CurriculumVitaeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<CurriculumVitaeVO> selectListVO(Wrapper<CurriculumVitaeEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CurriculumVitaeVO selectVO(Wrapper<CurriculumVitaeEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CurriculumVitaeView> selectListView(Wrapper<CurriculumVitaeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CurriculumVitaeView selectView(Wrapper<CurriculumVitaeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
