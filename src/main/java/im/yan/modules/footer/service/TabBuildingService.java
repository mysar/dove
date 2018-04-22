package im.yan.modules.footer.service;

import com.baomidou.mybatisplus.service.IService;
import im.yan.common.utils.PageUtils;
import im.yan.modules.footer.entity.TabBuildingEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-04-07 17:54:59
 */
public interface TabBuildingService extends IService<TabBuildingEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

