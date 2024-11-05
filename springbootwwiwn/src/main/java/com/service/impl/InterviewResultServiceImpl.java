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


import com.dao.InterviewResultDao;
import com.entity.InterviewResultEntity;
import com.service.InterviewResultService;
import com.entity.vo.InterviewResultVO;
import com.entity.view.InterviewResultView;

@Service("InterviewResultService")
public class InterviewResultServiceImpl extends ServiceImpl<InterviewResultDao, InterviewResultEntity> implements InterviewResultService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<InterviewResultEntity> page = this.selectPage(
                new Query<InterviewResultEntity>(params).getPage(),
                new EntityWrapper<InterviewResultEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<InterviewResultEntity> wrapper) {
		  Page<InterviewResultView> page =new Query<InterviewResultView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<InterviewResultVO> selectListVO(Wrapper<InterviewResultEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public InterviewResultVO selectVO(Wrapper<InterviewResultEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<InterviewResultView> selectListView(Wrapper<InterviewResultEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public InterviewResultView selectView(Wrapper<InterviewResultEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
