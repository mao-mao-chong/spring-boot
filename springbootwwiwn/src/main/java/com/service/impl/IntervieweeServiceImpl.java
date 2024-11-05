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


import com.dao.IntervieweeDao;
import com.entity.IntervieweeEntity;
import com.service.IntervieweeService;
import com.entity.vo.IntervieweeVO;
import com.entity.view.IntervieweeView;

@Service("IntervieweeService")
public class IntervieweeServiceImpl extends ServiceImpl<IntervieweeDao, IntervieweeEntity> implements IntervieweeService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<IntervieweeEntity> page = this.selectPage(
                new Query<IntervieweeEntity>(params).getPage(),
                new EntityWrapper<IntervieweeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<IntervieweeEntity> wrapper) {
		  Page<IntervieweeView> page =new Query<IntervieweeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<IntervieweeVO> selectListVO(Wrapper<IntervieweeEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public IntervieweeVO selectVO(Wrapper<IntervieweeEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<IntervieweeView> selectListView(Wrapper<IntervieweeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public IntervieweeView selectView(Wrapper<IntervieweeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
