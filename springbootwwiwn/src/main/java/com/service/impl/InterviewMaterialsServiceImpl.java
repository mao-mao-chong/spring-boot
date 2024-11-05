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


import com.dao.InterviewResourcesDao;
import com.entity.InterviewMaterialsEntity;
import com.service.InterviewMaterialsService;
import com.entity.vo.InterviewResourcesVO;
import com.entity.view.InterviewMaterialsView;

@Service("InterviewMaterialsService")
public class InterviewMaterialsServiceImpl extends ServiceImpl<InterviewResourcesDao, InterviewMaterialsEntity> implements InterviewMaterialsService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<InterviewMaterialsEntity> page = this.selectPage(
                new Query<InterviewMaterialsEntity>(params).getPage(),
                new EntityWrapper<InterviewMaterialsEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<InterviewMaterialsEntity> wrapper) {
		  Page<InterviewMaterialsView> page =new Query<InterviewMaterialsView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<InterviewResourcesVO> selectListVO(Wrapper<InterviewMaterialsEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public InterviewResourcesVO selectVO(Wrapper<InterviewMaterialsEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<InterviewMaterialsView> selectListView(Wrapper<InterviewMaterialsEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public InterviewMaterialsView selectView(Wrapper<InterviewMaterialsEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
