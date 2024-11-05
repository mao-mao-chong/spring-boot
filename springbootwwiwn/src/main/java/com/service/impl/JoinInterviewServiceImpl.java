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


import com.dao.JoinInterviewDao;
import com.entity.JoinInterviewEntity;
import com.service.JoinInterviewService;
import com.entity.vo.JoinInterviewVO;
import com.entity.view.JoinInterviewView;

@Service("JoinInterviewService")
public class JoinInterviewServiceImpl extends ServiceImpl<JoinInterviewDao, JoinInterviewEntity> implements JoinInterviewService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JoinInterviewEntity> page = this.selectPage(
                new Query<JoinInterviewEntity>(params).getPage(),
                new EntityWrapper<JoinInterviewEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JoinInterviewEntity> wrapper) {
		  Page<JoinInterviewView> page =new Query<JoinInterviewView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JoinInterviewVO> selectListVO(Wrapper<JoinInterviewEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JoinInterviewVO selectVO(Wrapper<JoinInterviewEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JoinInterviewView> selectListView(Wrapper<JoinInterviewEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JoinInterviewView selectView(Wrapper<JoinInterviewEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
