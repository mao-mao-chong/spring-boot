package com.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.InterviewResourcesEntity;
import com.entity.view.InterviewResourcesView;

import com.service.InterviewResourcesService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;


/**
 * 课程资源
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-04 10:22:19
 */
@RestController
@RequestMapping("/interviewResources")
public class InterviewResourcesController {
    @Autowired
    private InterviewResourcesService interviewResourcesService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, InterviewResourcesEntity kechengziyuan, HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			kechengziyuan.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			kechengziyuan.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<InterviewResourcesEntity> ew = new EntityWrapper<InterviewResourcesEntity>();
		PageUtils page = interviewResourcesService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kechengziyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, InterviewResourcesEntity kechengziyuan, HttpServletRequest request){
        EntityWrapper<InterviewResourcesEntity> ew = new EntityWrapper<InterviewResourcesEntity>();
		PageUtils page = interviewResourcesService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kechengziyuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( InterviewResourcesEntity kechengziyuan){
       	EntityWrapper<InterviewResourcesEntity> ew = new EntityWrapper<InterviewResourcesEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kechengziyuan, "kechengziyuan")); 
        return R.ok().put("data", interviewResourcesService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(InterviewResourcesEntity kechengziyuan){
        EntityWrapper<InterviewResourcesEntity> ew = new EntityWrapper<InterviewResourcesEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kechengziyuan, "kechengziyuan")); 
		InterviewResourcesView kechengziyuanView =  interviewResourcesService.selectView(ew);
		return R.ok("查询课程资源成功").put("data", kechengziyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        InterviewResourcesEntity kechengziyuan = interviewResourcesService.selectById(id);
        return R.ok().put("data", kechengziyuan);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        InterviewResourcesEntity kechengziyuan = interviewResourcesService.selectById(id);
        return R.ok().put("data", kechengziyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody InterviewResourcesEntity kechengziyuan, HttpServletRequest request){
    	kechengziyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kechengziyuan);
        interviewResourcesService.insert(kechengziyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody InterviewResourcesEntity kechengziyuan, HttpServletRequest request){
    	kechengziyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kechengziyuan);
        interviewResourcesService.insert(kechengziyuan);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody InterviewResourcesEntity kechengziyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kechengziyuan);
        interviewResourcesService.updateById(kechengziyuan);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        interviewResourcesService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<InterviewResourcesEntity> wrapper = new EntityWrapper<InterviewResourcesEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			wrapper.eq("jiaoshigonghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			wrapper.eq("xuehao", (String)request.getSession().getAttribute("username"));
		}

		int count = interviewResourcesService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
