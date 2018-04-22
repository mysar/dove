package im.yan.modules.dorm.service;

import com.baomidou.mybatisplus.service.IService;
import im.yan.common.utils.PageUtils;
import im.yan.modules.dorm.entity.DormEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-03-21 21:18:19
 */
public interface DormService extends IService<DormEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

