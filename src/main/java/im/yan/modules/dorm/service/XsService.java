package im.yan.modules.dorm.service;

import com.baomidou.mybatisplus.service.IService;
import im.yan.common.utils.PageUtils;
import im.yan.modules.dorm.entity.XsEntity;

import java.util.Map;

public interface XsService extends IService<XsEntity> {

    PageUtils queryPage(Map<String, Object> params);

    String zdfp();


    String qkfp();
}

