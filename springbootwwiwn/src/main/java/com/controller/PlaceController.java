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

import com.entity.PlaceEntity;
import com.entity.view.PlaceView;

import com.service.PlaceService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;


/**
 * 班级
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-04 10:22:19
 */
@RestController
@RequestMapping("/place")
public class PlaceController {
    @Autowired
    private PlaceService placeService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, PlaceEntity banji, HttpServletRequest request){
        EntityWrapper<PlaceEntity> ew = new EntityWrapper<PlaceEntity>();
		PageUtils page = placeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, banji), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, PlaceEntity banji, HttpServletRequest request){
        EntityWrapper<PlaceEntity> ew = new EntityWrapper<PlaceEntity>();
		PageUtils page = placeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, banji), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PlaceEntity banji){
       	EntityWrapper<PlaceEntity> ew = new EntityWrapper<PlaceEntity>();
      	ew.allEq(MPUtil.allEQMapPre( banji, "banji")); 
        return R.ok().put("data", placeService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PlaceEntity banji){
        EntityWrapper<PlaceEntity> ew = new EntityWrapper<PlaceEntity>();
 		ew.allEq(MPUtil.allEQMapPre( banji, "banji")); 
		PlaceView banjiView =  placeService.selectView(ew);
		return R.ok("查询班级成功").put("data", banjiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PlaceEntity banji = placeService.selectById(id);
        return R.ok().put("data", banji);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PlaceEntity banji = placeService.selectById(id);
        return R.ok().put("data", banji);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PlaceEntity banji, HttpServletRequest request){
    	banji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(banji);
        placeService.insert(banji);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PlaceEntity banji, HttpServletRequest request){
    	banji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(banji);
        placeService.insert(banji);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PlaceEntity banji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(banji);
        placeService.updateById(banji);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        placeService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<PlaceEntity> wrapper = new EntityWrapper<PlaceEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = placeService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
