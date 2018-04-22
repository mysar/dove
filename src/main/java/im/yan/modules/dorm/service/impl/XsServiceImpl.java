package im.yan.modules.dorm.service.impl;

import im.yan.common.utils.PageUtils;
import im.yan.modules.dorm.dao.DormDao;
import im.yan.modules.dorm.dao.XsDao;
import im.yan.modules.dorm.entity.XsEntity;
import im.yan.modules.dorm.dao.DxDao;
import im.yan.modules.dorm.entity.DormEntity;
import im.yan.modules.dorm.entity.DxEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import im.yan.common.utils.Query;

import im.yan.modules.dorm.service.XsService;

/**
 * 学生信息服务类
 */
@Service("xsService")
public class XsServiceImpl extends ServiceImpl<XsDao, XsEntity> implements XsService {

    private static final Logger logger = LoggerFactory.getLogger(XsServiceImpl.class);

    @Autowired
    private XsDao xsDao;
    @Autowired
    private DormDao dormDao;
    @Autowired
    private DxDao dxDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XsEntity> page = this.selectPage(
                new Query<XsEntity>(params).getPage(),
                new EntityWrapper<XsEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public String zdfp() {
        List<XsEntity> xsList = xsDao.getList();
        // list排序
        xsList.stream().sorted(Comparator.comparing(XsEntity::getSfssmz)).collect(Collectors.toList());
        List<DormEntity> dormes = dormDao.getListForBoy();
        if (xsList != null && xsList.size() > 0) {
            for (XsEntity xs : xsList) {
                // 分配条件 三个少数名族三个汉族
                for (DormEntity dorm : dormes) {
                    if (xs.getSex().equals("1") && dorm.getType().equals("1")) {
                        if (dorm.getRnrs() > dorm.getRzrs()) {
                            // 如果是汉族 最多三个汉族
                            if (xs.getSfssmz().equals("0") && dorm.getHzrs() < 3) {
                                saveInfo(xs, dorm);
                            } else if (xs.getSfssmz().equals("1") && (dorm.getRzrs() - dorm.getHzrs()) <= 3) {
                                // 少数民族
                                saveInfo(xs, dorm);
                            }
                        }
                    } else if (xs.getSex().equals("0") && dorm.getType().equals("0")) {
                        if (dorm.getRnrs() > dorm.getRzrs()) {
                            if (xs.getSfssmz().equals("0") && dorm.getHzrs() < 3) {
                                saveInfo(xs, dorm);
                            } else if (xs.getSfssmz().equals("1") && (dorm.getRzrs() - dorm.getHzrs()) <= 3) {
                                saveInfo(xs, dorm);
                            }
                        }
                    }
                }
            }
        }
        return "ok";
    }

    private void saveInfo(XsEntity xs, DormEntity dorm) {
        DxEntity dxs = dxDao.findExist(xs.getXh());
        if (dxs != null) {
            logger.error("重复数据-无效-error");
            logger.info("重复数据-无效-INFO");
            logger.debug("重复数据-无效-debug");
        } else {
            xs.setDormId(dorm.getSsh());
            xs.setSfrz("1");
            xsDao.updateById(xs);
            dorm.setRzrs(dorm.getRzrs() + 1);
            if (dorm.getXs().equals("空")){
                dorm.setXs(xs.getXm());
            } else {
                dorm.setXs(dorm.getXs()+","+xs.getXm());
            }

            // 判断是否汉族 如果是加1
            if (xs.getSfssmz().equals("0")) {
                dorm.setHzrs(dorm.getHzrs() + 1);
            }
            dormDao.updateById(dorm);
            DxEntity dx = new DxEntity();
            dx.setXh(xs.getXh());
            dx.setSsh(dorm.getSsh());
            dxDao.insert(dx);
            logger.error("分配完成!");
        }
    }

    @Override
    public String qkfp() {
        List<XsEntity> xsList = xsDao.getAllXs();
        List<DormEntity> dormes = dormDao.getListForBoy();
        List<DxEntity> dxList = dxDao.getList();
        for (XsEntity xs: xsList){
            xs.setSfrz("0");
            xs.setDormId("未分配");
            xsDao.updateById(xs);
        }
        for (DormEntity d: dormes){
            d.setHzrs(0);
            d.setRzrs(0);
            d.setXs("空");
            dormDao.updateById(d);
        }
        for (DxEntity dx:dxList){
            dxDao.deleteById(dx.getOpenid());
        }
        return null;
    }

}
