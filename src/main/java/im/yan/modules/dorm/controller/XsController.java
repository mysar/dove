package im.yan.modules.dorm.controller;

import java.util.Arrays;
import java.util.Map;

import im.yan.common.utils.PageUtils;
import im.yan.common.utils.R;
import im.yan.modules.dorm.entity.XsEntity;
import im.yan.modules.dorm.service.XsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("dorm/xs")
public class XsController {
    @Autowired
    private XsService xsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dorm:xs:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = xsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userId}")
    @RequiresPermissions("dorm:xs:info")
    public R info(@PathVariable("userId") Long userId){
			XsEntity xs = xsService.selectById(userId);

        return R.ok().put("xs", xs);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("dorm:xs:save")
    public R save(@RequestBody XsEntity xs){
			xsService.insert(xs);

        return R.ok();
    }

    /**
     * 自动分配
     */
    @RequestMapping("/zd")
    @RequiresPermissions("dorm:xs:zd")
    public R zd(@RequestBody XsEntity xs){
        xsService.zdfp();

        return R.ok();
    }

    /**
     * 清空自动分配数据
     */
    @RequestMapping("/qxzd")
    @RequiresPermissions("dorm:xs:qxzd")
    public R qxzd(@RequestBody XsEntity xs){
        xsService.qkfp();

        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("dorm:xs:update")
    public R update(@RequestBody XsEntity xs){
			xsService.updateById(xs);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("dorm:xs:delete")
    public R delete(@RequestBody Long[] userIds){
			xsService.deleteBatchIds(Arrays.asList(userIds));

        return R.ok();
    }

}
