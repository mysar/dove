package im.yan.modules.footer.controller;

import java.util.Arrays;
import java.util.Map;

import im.yan.common.utils.PageUtils;
import im.yan.common.utils.R;
import im.yan.modules.footer.entity.TabBuildingEntity;
import im.yan.modules.footer.service.TabBuildingService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-04-07 17:54:59
 */
@RestController
@RequestMapping("footer/tabbuilding")
public class TabBuildingController {
    @Autowired
    private TabBuildingService tabBuildingService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("footer:tabbuilding:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tabBuildingService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{openid}")
    @RequiresPermissions("footer:tabbuilding:info")
    public R info(@PathVariable("openid") Integer openid){
			TabBuildingEntity tabBuilding = tabBuildingService.selectById(openid);

        return R.ok().put("tabBuilding", tabBuilding);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("footer:tabbuilding:save")
    public R save(@RequestBody TabBuildingEntity tabBuilding){
			tabBuildingService.insert(tabBuilding);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("footer:tabbuilding:update")
    public R update(@RequestBody TabBuildingEntity tabBuilding){
			tabBuildingService.updateById(tabBuilding);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("footer:tabbuilding:delete")
    public R delete(@RequestBody Integer[] openids){
			tabBuildingService.deleteBatchIds(Arrays.asList(openids));

        return R.ok();
    }

}
