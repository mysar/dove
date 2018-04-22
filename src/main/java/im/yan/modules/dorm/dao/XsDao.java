package im.yan.modules.dorm.dao;

import im.yan.modules.dorm.entity.XsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-03-21 21:18:19
 */
@Mapper
public interface XsDao extends BaseMapper<XsEntity> {


    List<XsEntity> getList();

    List<XsEntity> getAllXs();


	
}
