package com.github.ontio.governancesync.mapper;

import com.github.ontio.governancesync.model.NodeInfo;
import com.github.ontio.governancesync.model.NodeInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

public interface NodeInfoMapper {
    long countByExample(NodeInfoExample example);

    int deleteByExample(NodeInfoExample example);

    @Delete({
        "delete from t_node_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into t_node_info (id, name, ",
        "node_index, public_key, ",
        "address, status, ",
        "init_pos, total_pos, ",
        "max_authorize, node_proportion)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{nodeIndex,jdbcType=BIGINT}, #{publicKey,jdbcType=VARCHAR}, ",
        "#{address,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, ",
        "#{initPos,jdbcType=BIGINT}, #{totalPos,jdbcType=BIGINT}, ",
        "#{maxAuthorize,jdbcType=VARCHAR}, #{nodeProportion,jdbcType=VARCHAR})"
    })
    int insert(NodeInfo record);

    int insertSelective(NodeInfo record);

    List<NodeInfo> selectByExampleWithRowbounds(NodeInfoExample example, RowBounds rowBounds);

    List<NodeInfo> selectByExample(NodeInfoExample example);

    @Select({
        "select",
        "id, name, node_index, public_key, address, status, init_pos, total_pos, max_authorize, ",
        "node_proportion",
        "from t_node_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.github.ontio.governancesync.mapper.NodeInfoMapper.BaseResultMap")
    NodeInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NodeInfo record, @Param("example") NodeInfoExample example);

    int updateByExample(@Param("record") NodeInfo record, @Param("example") NodeInfoExample example);

    int updateByPrimaryKeySelective(NodeInfo record);

    @Update({
        "update t_node_info",
        "set name = #{name,jdbcType=VARCHAR},",
          "node_index = #{nodeIndex,jdbcType=BIGINT},",
          "public_key = #{publicKey,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "init_pos = #{initPos,jdbcType=BIGINT},",
          "total_pos = #{totalPos,jdbcType=BIGINT},",
          "max_authorize = #{maxAuthorize,jdbcType=VARCHAR},",
          "node_proportion = #{nodeProportion,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(NodeInfo record);

    @Delete({"delete from t_node_info"})
    int deleteAll();

    @Select({
        "select",
        "id, name, node_index, public_key, address, status, init_pos, total_pos, max_authorize, ",
        "node_proportion",
        "from t_node_info"
    })
    List<NodeInfo> selectAll();

}