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


import com.dao.InterviewMaterialsDao;
import com.entity.InterviewResourcesEntity;
import com.service.InterviewResourcesService;
import com.entity.vo.InterviewMaterialsVO;
import com.entity.view.InterviewResourcesView;

@Service("InterviewResourcesService")
public class InterviewResourcesServiceImpl extends ServiceImpl<InterviewMaterialsDao, InterviewResourcesEntity> implements InterviewResourcesService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<InterviewResourcesEntity> page = this.selectPage(
                new Query<InterviewResourcesEntity>(params).getPage(),
                new EntityWrapper<InterviewResourcesEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<InterviewResourcesEntity> wrapper) {
		  Page<InterviewResourcesView> page =new Query<InterviewResourcesView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<InterviewMaterialsVO> selectListVO(Wrapper<InterviewResourcesEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public InterviewMaterialsVO selectVO(Wrapper<InterviewResourcesEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<InterviewResourcesView> selectListView(Wrapper<InterviewResourcesEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public InterviewResourcesView selectView(Wrapper<InterviewResourcesEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
