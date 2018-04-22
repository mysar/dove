package im.yan.modules.dorm.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import im.yan.modules.dorm.entity.DxEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 学生宿舍已分配信息
 */
@Mapper
public interface DxDao extends BaseMapper<DxEntity> {

    /**
     * 查询所有
     * @return
     */
    List<DxEntity> getList();
    //List<DxEntity> getListForGirl(@Param("xh")String xh);
    List<DxEntity> getCount();

    DxEntity findExist(@Param("xh")String xh);
}
