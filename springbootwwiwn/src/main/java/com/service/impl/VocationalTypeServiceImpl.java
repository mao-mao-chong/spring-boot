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


import com.dao.VocationalTypeDao;
import com.entity.VocationalTypeEntity;
import com.service.VocationalTypeService;
import com.entity.vo.VocationalTypeVO;
import com.entity.view.VocationalTypeView;

@Service("VocationalTypeService")
public class VocationalTypeServiceImpl extends ServiceImpl<VocationalTypeDao, VocationalTypeEntity> implements VocationalTypeService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<VocationalTypeEntity> page = this.selectPage(
                new Query<VocationalTypeEntity>(params).getPage(),
                new EntityWrapper<VocationalTypeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<VocationalTypeEntity> wrapper) {
		  Page<VocationalTypeView> page =new Query<VocationalTypeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<VocationalTypeVO> selectListVO(Wrapper<VocationalTypeEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public VocationalTypeVO selectVO(Wrapper<VocationalTypeEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<VocationalTypeView> selectListView(Wrapper<VocationalTypeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public VocationalTypeView selectView(Wrapper<VocationalTypeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
