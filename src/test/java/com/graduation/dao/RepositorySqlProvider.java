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

import com.graduation.model.Repository;
import com.graduation.model.RepositoryExample.Criteria;
import com.graduation.model.RepositoryExample.Criterion;
import com.graduation.model.RepositoryExample;
import java.util.List;
import java.util.Map;

public class RepositorySqlProvider {

    public String countByExample(RepositoryExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("tb_repository");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(RepositoryExample example) {
        BEGIN();
        DELETE_FROM("tb_repository");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(Repository record) {
        BEGIN();
        INSERT_INTO("tb_repository");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getFullName() != null) {
            VALUES("full_name", "#{fullName,jdbcType=VARCHAR}");
        }
        
        if (record.getDefaultBranch() != null) {
            VALUES("default_branch", "#{defaultBranch,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedAt() != null) {
            VALUES("created_at", "#{createdAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatedAt() != null) {
            VALUES("updated_at", "#{updatedAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPushedAt() != null) {
            VALUES("pushed_at", "#{pushedAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSize() != null) {
            VALUES("size", "#{size,jdbcType=INTEGER}");
        }
        
        if (record.getStarCount() != null) {
            VALUES("star_count", "#{starCount,jdbcType=INTEGER}");
        }
        
        if (record.getWatchersCount() != null) {
            VALUES("watchers_count", "#{watchersCount,jdbcType=INTEGER}");
        }
        
        if (record.getForksCount() != null) {
            VALUES("forks_count", "#{forksCount,jdbcType=INTEGER}");
        }
        
        if (record.getLanguage() != null) {
            VALUES("language", "#{language,jdbcType=VARCHAR}");
        }
        
        if (record.getDeveloperlogin() != null) {
            VALUES("developerLogin", "#{developerlogin,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdated() != null) {
            VALUES("updated", "#{updated,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExampleWithBLOBs(RepositoryExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("name");
        SELECT("full_name");
        SELECT("default_branch");
        SELECT("created_at");
        SELECT("updated_at");
        SELECT("pushed_at");
        SELECT("size");
        SELECT("star_count");
        SELECT("watchers_count");
        SELECT("forks_count");
        SELECT("language");
        SELECT("developerLogin");
        SELECT("updated");
        SELECT("description");
        FROM("tb_repository");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String selectByExample(RepositoryExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("name");
        SELECT("full_name");
        SELECT("default_branch");
        SELECT("created_at");
        SELECT("updated_at");
        SELECT("pushed_at");
        SELECT("size");
        SELECT("star_count");
        SELECT("watchers_count");
        SELECT("forks_count");
        SELECT("language");
        SELECT("developerLogin");
        SELECT("updated");
        FROM("tb_repository");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Repository record = (Repository) parameter.get("record");
        RepositoryExample example = (RepositoryExample) parameter.get("example");
        
        BEGIN();
        UPDATE("tb_repository");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getFullName() != null) {
            SET("full_name = #{record.fullName,jdbcType=VARCHAR}");
        }
        
        if (record.getDefaultBranch() != null) {
            SET("default_branch = #{record.defaultBranch,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedAt() != null) {
            SET("created_at = #{record.createdAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatedAt() != null) {
            SET("updated_at = #{record.updatedAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPushedAt() != null) {
            SET("pushed_at = #{record.pushedAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSize() != null) {
            SET("size = #{record.size,jdbcType=INTEGER}");
        }
        
        if (record.getStarCount() != null) {
            SET("star_count = #{record.starCount,jdbcType=INTEGER}");
        }
        
        if (record.getWatchersCount() != null) {
            SET("watchers_count = #{record.watchersCount,jdbcType=INTEGER}");
        }
        
        if (record.getForksCount() != null) {
            SET("forks_count = #{record.forksCount,jdbcType=INTEGER}");
        }
        
        if (record.getLanguage() != null) {
            SET("language = #{record.language,jdbcType=VARCHAR}");
        }
        
        if (record.getDeveloperlogin() != null) {
            SET("developerLogin = #{record.developerlogin,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdated() != null) {
            SET("updated = #{record.updated,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{record.description,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("tb_repository");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("name = #{record.name,jdbcType=VARCHAR}");
        SET("full_name = #{record.fullName,jdbcType=VARCHAR}");
        SET("default_branch = #{record.defaultBranch,jdbcType=VARCHAR}");
        SET("created_at = #{record.createdAt,jdbcType=TIMESTAMP}");
        SET("updated_at = #{record.updatedAt,jdbcType=TIMESTAMP}");
        SET("pushed_at = #{record.pushedAt,jdbcType=TIMESTAMP}");
        SET("size = #{record.size,jdbcType=INTEGER}");
        SET("star_count = #{record.starCount,jdbcType=INTEGER}");
        SET("watchers_count = #{record.watchersCount,jdbcType=INTEGER}");
        SET("forks_count = #{record.forksCount,jdbcType=INTEGER}");
        SET("language = #{record.language,jdbcType=VARCHAR}");
        SET("developerLogin = #{record.developerlogin,jdbcType=VARCHAR}");
        SET("updated = #{record.updated,jdbcType=TIMESTAMP}");
        SET("description = #{record.description,jdbcType=LONGVARCHAR}");
        
        RepositoryExample example = (RepositoryExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("tb_repository");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("name = #{record.name,jdbcType=VARCHAR}");
        SET("full_name = #{record.fullName,jdbcType=VARCHAR}");
        SET("default_branch = #{record.defaultBranch,jdbcType=VARCHAR}");
        SET("created_at = #{record.createdAt,jdbcType=TIMESTAMP}");
        SET("updated_at = #{record.updatedAt,jdbcType=TIMESTAMP}");
        SET("pushed_at = #{record.pushedAt,jdbcType=TIMESTAMP}");
        SET("size = #{record.size,jdbcType=INTEGER}");
        SET("star_count = #{record.starCount,jdbcType=INTEGER}");
        SET("watchers_count = #{record.watchersCount,jdbcType=INTEGER}");
        SET("forks_count = #{record.forksCount,jdbcType=INTEGER}");
        SET("language = #{record.language,jdbcType=VARCHAR}");
        SET("developerLogin = #{record.developerlogin,jdbcType=VARCHAR}");
        SET("updated = #{record.updated,jdbcType=TIMESTAMP}");
        
        RepositoryExample example = (RepositoryExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(Repository record) {
        BEGIN();
        UPDATE("tb_repository");
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getFullName() != null) {
            SET("full_name = #{fullName,jdbcType=VARCHAR}");
        }
        
        if (record.getDefaultBranch() != null) {
            SET("default_branch = #{defaultBranch,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedAt() != null) {
            SET("created_at = #{createdAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatedAt() != null) {
            SET("updated_at = #{updatedAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPushedAt() != null) {
            SET("pushed_at = #{pushedAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSize() != null) {
            SET("size = #{size,jdbcType=INTEGER}");
        }
        
        if (record.getStarCount() != null) {
            SET("star_count = #{starCount,jdbcType=INTEGER}");
        }
        
        if (record.getWatchersCount() != null) {
            SET("watchers_count = #{watchersCount,jdbcType=INTEGER}");
        }
        
        if (record.getForksCount() != null) {
            SET("forks_count = #{forksCount,jdbcType=INTEGER}");
        }
        
        if (record.getLanguage() != null) {
            SET("language = #{language,jdbcType=VARCHAR}");
        }
        
        if (record.getDeveloperlogin() != null) {
            SET("developerLogin = #{developerlogin,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdated() != null) {
            SET("updated = #{updated,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=LONGVARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(RepositoryExample example, boolean includeExamplePhrase) {
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