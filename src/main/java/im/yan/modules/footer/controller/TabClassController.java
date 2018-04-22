package im.yan.modules.footer.controller;

import java.util.Arrays;
import java.util.Map;

import im.yan.common.utils.PageUtils;
import im.yan.common.utils.R;
import im.yan.modules.footer.entity.TabClassEntity;
import im.yan.modules.footer.service.TabClassService;
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
@RequestMapping("footer/tabclass")
public class TabClassController {
    @Autowired
    private TabClassService tabClassService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("footer:tabclass:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tabClassService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{openid}")
    @RequiresPermissions("footer:tabclass:info")
    public R info(@PathVariable("openid") Integer openid){
			TabClassEntity tabClass = tabClassService.selectById(openid);

        return R.ok().put("tabClass", tabClass);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("footer:tabclass:save")
    public R save(@RequestBody TabClassEntity tabClass){
			tabClassService.insert(tabClass);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("footer:tabclass:update")
    public R update(@RequestBody TabClassEntity tabClass){
			tabClassService.updateById(tabClass);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("footer:tabclass:delete")
    public R delete(@RequestBody Integer[] openids){
			tabClassService.deleteBatchIds(Arrays.asList(openids));

        return R.ok();
    }

}
