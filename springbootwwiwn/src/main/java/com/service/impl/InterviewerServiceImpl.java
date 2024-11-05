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


import com.dao.InterviewerDao;
import com.entity.InterviewerEntity;
import com.service.InterviewerService;
import com.entity.vo.InterviewerVO;
import com.entity.view.InterviewerView;

@Service("InterviewerService")
public class InterviewerServiceImpl extends ServiceImpl<InterviewerDao, InterviewerEntity> implements InterviewerService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<InterviewerEntity> page = this.selectPage(
                new Query<InterviewerEntity>(params).getPage(),
                new EntityWrapper<InterviewerEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<InterviewerEntity> wrapper) {
		  Page<InterviewerView> page =new Query<InterviewerView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<InterviewerVO> selectListVO(Wrapper<InterviewerEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public InterviewerVO selectVO(Wrapper<InterviewerEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<InterviewerView> selectListView(Wrapper<InterviewerEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public InterviewerView selectView(Wrapper<InterviewerEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
