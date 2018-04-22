package im.yan.modules.footer.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import im.yan.common.utils.PageUtils;
import im.yan.common.utils.Query;
import im.yan.modules.footer.dao.TabClassDao;
import im.yan.modules.footer.entity.TabClassEntity;
import im.yan.modules.footer.service.TabClassService;
import org.springframework.stereotype.Service;
import java.util.Map;


@Service("tabClassService")
public class TabClassServiceImpl extends ServiceImpl<TabClassDao, TabClassEntity> implements TabClassService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TabClassEntity> page = this.selectPage(
                new Query<TabClassEntity>(params).getPage(),
                new EntityWrapper<TabClassEntity>()
        );

        return new PageUtils(page);
    }

}
