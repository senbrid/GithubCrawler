package com.graduation.dao;

import com.graduation.model.Fork;
import com.graduation.model.ForkExample;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ForkMapper {
    @SelectProvider(type=ForkSqlProvider.class, method="countByExample")
    int countByExample(ForkExample example);

    @DeleteProvider(type=ForkSqlProvider.class, method="deleteByExample")
    int deleteByExample(ForkExample example);

    @Delete({
        "delete from tb_fork",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_fork (id, repositoryId, ",
        "forkLogin, updated)",
        "values (#{id,jdbcType=INTEGER}, #{repositoryid,jdbcType=BIGINT}, ",
        "#{forklogin,jdbcType=VARCHAR}, #{updated,jdbcType=TIMESTAMP})"
    })
    int insert(Fork record);

    @InsertProvider(type=ForkSqlProvider.class, method="insertSelective")
    int insertSelective(Fork record);

    @SelectProvider(type=ForkSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="repositoryId", javaType=Long.class, jdbcType=JdbcType.BIGINT),
        @Arg(column="forkLogin", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="updated", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    List<Fork> selectByExample(ForkExample example);

    @Select({
        "select",
        "id, repositoryId, forkLogin, updated",
        "from tb_fork",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="repositoryId", javaType=Long.class, jdbcType=JdbcType.BIGINT),
        @Arg(column="forkLogin", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="updated", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    Fork selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ForkSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Fork record, @Param("example") ForkExample example);

    @UpdateProvider(type=ForkSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Fork record, @Param("example") ForkExample example);

    @UpdateProvider(type=ForkSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Fork record);

    @Update({
        "update tb_fork",
        "set repositoryId = #{repositoryid,jdbcType=BIGINT},",
          "forkLogin = #{forklogin,jdbcType=VARCHAR},",
          "updated = #{updated,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Fork record);
}