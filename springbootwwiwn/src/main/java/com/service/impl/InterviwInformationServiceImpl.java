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


import com.dao.InterviwInformationDao;
import com.entity.InterviwInformationEntity;
import com.service.InterviwInformationService;
import com.entity.vo.InterviwInformationVO;
import com.entity.view.InterviwInformationView;

@Service("InterviwInformationService")
public class InterviwInformationServiceImpl extends ServiceImpl<InterviwInformationDao, InterviwInformationEntity> implements InterviwInformationService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<InterviwInformationEntity> page = this.selectPage(
                new Query<InterviwInformationEntity>(params).getPage(),
                new EntityWrapper<InterviwInformationEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<InterviwInformationEntity> wrapper) {
		  Page<InterviwInformationView> page =new Query<InterviwInformationView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<InterviwInformationVO> selectListVO(Wrapper<InterviwInformationEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public InterviwInformationVO selectVO(Wrapper<InterviwInformationEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<InterviwInformationView> selectListView(Wrapper<InterviwInformationEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public InterviwInformationView selectView(Wrapper<InterviwInformationEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
