package im.yan.modules.dorm.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import im.yan.common.utils.PageUtils;
import im.yan.common.utils.Query;

import im.yan.modules.dorm.dao.DormDao;
import im.yan.modules.dorm.entity.DormEntity;
import im.yan.modules.dorm.service.DormService;


@Service("dormService")
public class DormServiceImpl extends ServiceImpl<DormDao, DormEntity> implements DormService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DormEntity> page = this.selectPage(
                new Query<DormEntity>(params).getPage(),
                new EntityWrapper<DormEntity>()
        );

        return new PageUtils(page);
    }

}
