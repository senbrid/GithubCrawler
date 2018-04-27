package com.graduation.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.graduation.model.Developer;
import com.graduation.model.DeveloperExample.Criteria;
import com.graduation.model.DeveloperExample.Criterion;
import com.graduation.model.DeveloperExample;
import java.util.List;
import java.util.Map;

public class DeveloperSqlProvider {

    public String countByExample(DeveloperExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("tb_developer");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(DeveloperExample example) {
        BEGIN();
        DELETE_FROM("tb_developer");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(Developer record) {
        BEGIN();
        INSERT_INTO("tb_developer");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getLogin() != null) {
            VALUES("login", "#{login,jdbcType=VARCHAR}");
        }
        
        if (record.getAvatarUrl() != null) {
            VALUES("avatar_url", "#{avatarUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCompany() != null) {
            VALUES("company", "#{company,jdbcType=VARCHAR}");
        }
        
        if (record.getLocation() != null) {
            VALUES("location", "#{location,jdbcType=VARCHAR}");
        }
        
        if (record.getBlog() != null) {
            VALUES("blog", "#{blog,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getBio() != null) {
            VALUES("bio", "#{bio,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            VALUES("type", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getPublicRepos() != null) {
            VALUES("public_repos", "#{publicRepos,jdbcType=INTEGER}");
        }
        
        if (record.getFollowers() != null) {
            VALUES("followers", "#{followers,jdbcType=INTEGER}");
        }
        
        if (record.getFollowing() != null) {
            VALUES("following", "#{following,jdbcType=INTEGER}");
        }
        
        if (record.getCreatedAt() != null) {
            VALUES("created_at", "#{createdAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatedAt() != null) {
            VALUES("updated_at", "#{updatedAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdated() != null) {
            VALUES("updated", "#{updated,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    public String selectByExample(DeveloperExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("login");
        SELECT("avatar_url");
        SELECT("name");
        SELECT("company");
        SELECT("location");
        SELECT("blog");
        SELECT("email");
        SELECT("bio");
        SELECT("type");
        SELECT("public_repos");
        SELECT("followers");
        SELECT("following");
        SELECT("created_at");
        SELECT("updated_at");
        SELECT("updated");
        FROM("tb_developer");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Developer record = (Developer) parameter.get("record");
        DeveloperExample example = (DeveloperExample) parameter.get("example");
        
        BEGIN();
        UPDATE("tb_developer");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getLogin() != null) {
            SET("login = #{record.login,jdbcType=VARCHAR}");
        }
        
        if (record.getAvatarUrl() != null) {
            SET("avatar_url = #{record.avatarUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getCompany() != null) {
            SET("company = #{record.company,jdbcType=VARCHAR}");
        }
        
        if (record.getLocation() != null) {
            SET("location = #{record.location,jdbcType=VARCHAR}");
        }
        
        if (record.getBlog() != null) {
            SET("blog = #{record.blog,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            SET("email = #{record.email,jdbcType=VARCHAR}");
        }
        
        if (record.getBio() != null) {
            SET("bio = #{record.bio,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            SET("type = #{record.type,jdbcType=VARCHAR}");
        }
        
        if (record.getPublicRepos() != null) {
            SET("public_repos = #{record.publicRepos,jdbcType=INTEGER}");
        }
        
        if (record.getFollowers() != null) {
            SET("followers = #{record.followers,jdbcType=INTEGER}");
        }
        
        if (record.getFollowing() != null) {
            SET("following = #{record.following,jdbcType=INTEGER}");
        }
        
        if (record.getCreatedAt() != null) {
            SET("created_at = #{record.createdAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatedAt() != null) {
            SET("updated_at = #{record.updatedAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdated() != null) {
            SET("updated = #{record.updated,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("tb_developer");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("login = #{record.login,jdbcType=VARCHAR}");
        SET("avatar_url = #{record.avatarUrl,jdbcType=VARCHAR}");
        SET("name = #{record.name,jdbcType=VARCHAR}");
        SET("company = #{record.company,jdbcType=VARCHAR}");
        SET("location = #{record.location,jdbcType=VARCHAR}");
        SET("blog = #{record.blog,jdbcType=VARCHAR}");
        SET("email = #{record.email,jdbcType=VARCHAR}");
        SET("bio = #{record.bio,jdbcType=VARCHAR}");
        SET("type = #{record.type,jdbcType=VARCHAR}");
        SET("public_repos = #{record.publicRepos,jdbcType=INTEGER}");
        SET("followers = #{record.followers,jdbcType=INTEGER}");
        SET("following = #{record.following,jdbcType=INTEGER}");
        SET("created_at = #{record.createdAt,jdbcType=TIMESTAMP}");
        SET("updated_at = #{record.updatedAt,jdbcType=TIMESTAMP}");
        SET("updated = #{record.updated,jdbcType=TIMESTAMP}");
        
        DeveloperExample example = (DeveloperExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(Developer record) {
        BEGIN();
        UPDATE("tb_developer");
        
        if (record.getLogin() != null) {
            SET("login = #{login,jdbcType=VARCHAR}");
        }
        
        if (record.getAvatarUrl() != null) {
            SET("avatar_url = #{avatarUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCompany() != null) {
            SET("company = #{company,jdbcType=VARCHAR}");
        }
        
        if (record.getLocation() != null) {
            SET("location = #{location,jdbcType=VARCHAR}");
        }
        
        if (record.getBlog() != null) {
            SET("blog = #{blog,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getBio() != null) {
            SET("bio = #{bio,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            SET("type = #{type,jdbcType=VARCHAR}");
        }
        
        if (record.getPublicRepos() != null) {
            SET("public_repos = #{publicRepos,jdbcType=INTEGER}");
        }
        
        if (record.getFollowers() != null) {
            SET("followers = #{followers,jdbcType=INTEGER}");
        }
        
        if (record.getFollowing() != null) {
            SET("following = #{following,jdbcType=INTEGER}");
        }
        
        if (record.getCreatedAt() != null) {
            SET("created_at = #{createdAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatedAt() != null) {
            SET("updated_at = #{updatedAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdated() != null) {
            SET("updated = #{updated,jdbcType=TIMESTAMP}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(DeveloperExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}