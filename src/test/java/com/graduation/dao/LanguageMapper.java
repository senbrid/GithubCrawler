package com.graduation.dao;

import com.graduation.model.Language;
import com.graduation.model.LanguageExample;
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

public interface LanguageMapper {
    @SelectProvider(type=LanguageSqlProvider.class, method="countByExample")
    int countByExample(LanguageExample example);

    @DeleteProvider(type=LanguageSqlProvider.class, method="deleteByExample")
    int deleteByExample(LanguageExample example);

    @Delete({
        "delete from tb_language",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_language (id, repositoryId, ",
        "language, size, ",
        "updated)",
        "values (#{id,jdbcType=INTEGER}, #{repositoryid,jdbcType=BIGINT}, ",
        "#{language,jdbcType=VARCHAR}, #{size,jdbcType=INTEGER}, ",
        "#{updated,jdbcType=TIMESTAMP})"
    })
    int insert(Language record);

    @InsertProvider(type=LanguageSqlProvider.class, method="insertSelective")
    int insertSelective(Language record);

    @SelectProvider(type=LanguageSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="repositoryId", javaType=Long.class, jdbcType=JdbcType.BIGINT),
        @Arg(column="language", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="size", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="updated", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    List<Language> selectByExample(LanguageExample example);

    @Select({
        "select",
        "id, repositoryId, language, size, updated",
        "from tb_language",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="repositoryId", javaType=Long.class, jdbcType=JdbcType.BIGINT),
        @Arg(column="language", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="size", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="updated", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    Language selectByPrimaryKey(Integer id);

    @UpdateProvider(type=LanguageSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Language record, @Param("example") LanguageExample example);

    @UpdateProvider(type=LanguageSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Language record, @Param("example") LanguageExample example);

    @UpdateProvider(type=LanguageSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Language record);

    @Update({
        "update tb_language",
        "set repositoryId = #{repositoryid,jdbcType=BIGINT},",
          "language = #{language,jdbcType=VARCHAR},",
          "size = #{size,jdbcType=INTEGER},",
          "updated = #{updated,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Language record);
}