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


import com.dao.PlaceDao;
import com.entity.PlaceEntity;
import com.service.PlaceService;
import com.entity.vo.PlaceVO;
import com.entity.view.PlaceView;

@Service("PlaceService")
public class PlaceServiceImpl extends ServiceImpl<PlaceDao, PlaceEntity> implements PlaceService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PlaceEntity> page = this.selectPage(
                new Query<PlaceEntity>(params).getPage(),
                new EntityWrapper<PlaceEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PlaceEntity> wrapper) {
		  Page<PlaceView> page =new Query<PlaceView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<PlaceVO> selectListVO(Wrapper<PlaceEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PlaceVO selectVO(Wrapper<PlaceEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PlaceView> selectListView(Wrapper<PlaceEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PlaceView selectView(Wrapper<PlaceEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
