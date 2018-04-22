package im.yan.modules.dorm.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import im.yan.modules.dorm.entity.DormEntity;
import im.yan.modules.dorm.service.DormService;
import im.yan.common.utils.PageUtils;
import im.yan.common.utils.R;


@RestController
@RequestMapping("dorm/dorm")
public class DormController {

    @Autowired
    private DormService dormService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dorm:dorm:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = dormService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{dormId}")
    @RequiresPermissions("dorm:dorm:info")
    public R info(@PathVariable("dormId") Integer dormId){
			DormEntity dorm = dormService.selectById(dormId);

        return R.ok().put("dorm", dorm);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("dorm:dorm:save")
    public R save(@RequestBody DormEntity dorm){
			dormService.insert(dorm);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("dorm:dorm:update")
    public R update(@RequestBody DormEntity dorm){
			dormService.updateById(dorm);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("dorm:dorm:delete")
    public R delete(@RequestBody Integer[] dormIds){
			dormService.deleteBatchIds(Arrays.asList(dormIds));

        return R.ok();
    }

}
