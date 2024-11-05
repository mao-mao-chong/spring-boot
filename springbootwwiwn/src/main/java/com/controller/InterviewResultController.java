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

import com.entity.InterviewResultEntity;
import com.entity.view.InterviewResultView;

import com.service.InterviewResultService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;


/**
 * 作业评分
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-04 10:22:19
 */
@RestController
@RequestMapping("/interviewResult")
public class InterviewResultController {
    @Autowired
    private InterviewResultService interviewResultService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, InterviewResultEntity zuoyepingfen, HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			zuoyepingfen.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			zuoyepingfen.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<InterviewResultEntity> ew = new EntityWrapper<InterviewResultEntity>();
		PageUtils page = interviewResultService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuoyepingfen), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, InterviewResultEntity zuoyepingfen, HttpServletRequest request){
        EntityWrapper<InterviewResultEntity> ew = new EntityWrapper<InterviewResultEntity>();
		PageUtils page = interviewResultService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuoyepingfen), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( InterviewResultEntity zuoyepingfen){
       	EntityWrapper<InterviewResultEntity> ew = new EntityWrapper<InterviewResultEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zuoyepingfen, "zuoyepingfen")); 
        return R.ok().put("data", interviewResultService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(InterviewResultEntity zuoyepingfen){
        EntityWrapper<InterviewResultEntity> ew = new EntityWrapper<InterviewResultEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zuoyepingfen, "zuoyepingfen")); 
		InterviewResultView zuoyepingfenView =  interviewResultService.selectView(ew);
		return R.ok("查询作业评分成功").put("data", zuoyepingfenView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        InterviewResultEntity zuoyepingfen = interviewResultService.selectById(id);
        return R.ok().put("data", zuoyepingfen);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        InterviewResultEntity zuoyepingfen = interviewResultService.selectById(id);
        return R.ok().put("data", zuoyepingfen);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody InterviewResultEntity zuoyepingfen, HttpServletRequest request){
    	zuoyepingfen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zuoyepingfen);
        interviewResultService.insert(zuoyepingfen);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody InterviewResultEntity zuoyepingfen, HttpServletRequest request){
    	zuoyepingfen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zuoyepingfen);
        interviewResultService.insert(zuoyepingfen);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody InterviewResultEntity zuoyepingfen, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zuoyepingfen);
        interviewResultService.updateById(zuoyepingfen);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        interviewResultService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<InterviewResultEntity> wrapper = new EntityWrapper<InterviewResultEntity>();
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

		int count = interviewResultService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
