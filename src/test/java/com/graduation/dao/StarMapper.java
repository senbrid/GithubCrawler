package com.graduation.dao;

import com.graduation.model.Star;
import com.graduation.model.StarExample;
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

public interface StarMapper {
    @SelectProvider(type=StarSqlProvider.class, method="countByExample")
    int countByExample(StarExample example);

    @DeleteProvider(type=StarSqlProvider.class, method="deleteByExample")
    int deleteByExample(StarExample example);

    @Delete({
        "delete from tb_star",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_star (id, repositoryId, ",
        "starLogin, updated)",
        "values (#{id,jdbcType=INTEGER}, #{repositoryid,jdbcType=BIGINT}, ",
        "#{starlogin,jdbcType=VARCHAR}, #{updated,jdbcType=TIMESTAMP})"
    })
    int insert(Star record);

    @InsertProvider(type=StarSqlProvider.class, method="insertSelective")
    int insertSelective(Star record);

    @SelectProvider(type=StarSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="repositoryId", javaType=Long.class, jdbcType=JdbcType.BIGINT),
        @Arg(column="starLogin", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="updated", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    List<Star> selectByExample(StarExample example);

    @Select({
        "select",
        "id, repositoryId, starLogin, updated",
        "from tb_star",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="repositoryId", javaType=Long.class, jdbcType=JdbcType.BIGINT),
        @Arg(column="starLogin", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="updated", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    Star selectByPrimaryKey(Integer id);

    @UpdateProvider(type=StarSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Star record, @Param("example") StarExample example);

    @UpdateProvider(type=StarSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Star record, @Param("example") StarExample example);

    @UpdateProvider(type=StarSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Star record);

    @Update({
        "update tb_star",
        "set repositoryId = #{repositoryid,jdbcType=BIGINT},",
          "starLogin = #{starlogin,jdbcType=VARCHAR},",
          "updated = #{updated,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Star record);
}