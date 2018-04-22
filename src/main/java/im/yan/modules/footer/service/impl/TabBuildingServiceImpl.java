package im.yan.modules.footer.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import im.yan.common.utils.PageUtils;
import im.yan.common.utils.Query;
import im.yan.modules.footer.dao.TabBuildingDao;
import im.yan.modules.footer.entity.TabBuildingEntity;
import im.yan.modules.footer.service.TabBuildingService;
import org.springframework.stereotype.Service;
import java.util.Map;


@Service("tabBuildingService")
public class TabBuildingServiceImpl extends ServiceImpl<TabBuildingDao, TabBuildingEntity> implements TabBuildingService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TabBuildingEntity> page = this.selectPage(
                new Query<TabBuildingEntity>(params).getPage(),
                new EntityWrapper<TabBuildingEntity>()
        );

        return new PageUtils(page);
    }

}
