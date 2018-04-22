package im.yan.modules.dorm.dao;

import im.yan.modules.dorm.entity.DormEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Tip:
 * Create By Im.Yan
 */
@Mapper
public interface DormDao extends BaseMapper<DormEntity> {

    /**
     * 男生宿舍
     *
     * @return
     * @throws Exception
     */
    List<DormEntity> getListForBoy();

    /**
     * 女生宿舍
     * @return
     * @throws Exception
     */
    List<DormEntity> getListForGirl();

    /**
     * 暂定宿舍
     * @return
     * @throws Exception
     */
    List<DormEntity> getListForBlank();
	
}
