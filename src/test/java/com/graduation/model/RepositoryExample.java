package com.graduation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RepositoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RepositoryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andFullNameIsNull() {
            addCriterion("full_name is null");
            return (Criteria) this;
        }

        public Criteria andFullNameIsNotNull() {
            addCriterion("full_name is not null");
            return (Criteria) this;
        }

        public Criteria andFullNameEqualTo(String value) {
            addCriterion("full_name =", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameNotEqualTo(String value) {
            addCriterion("full_name <>", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameGreaterThan(String value) {
            addCriterion("full_name >", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameGreaterThanOrEqualTo(String value) {
            addCriterion("full_name >=", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameLessThan(String value) {
            addCriterion("full_name <", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameLessThanOrEqualTo(String value) {
            addCriterion("full_name <=", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameLike(String value) {
            addCriterion("full_name like", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameNotLike(String value) {
            addCriterion("full_name not like", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameIn(List<String> values) {
            addCriterion("full_name in", values, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameNotIn(List<String> values) {
            addCriterion("full_name not in", values, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameBetween(String value1, String value2) {
            addCriterion("full_name between", value1, value2, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameNotBetween(String value1, String value2) {
            addCriterion("full_name not between", value1, value2, "fullName");
            return (Criteria) this;
        }

        public Criteria andDefaultBranchIsNull() {
            addCriterion("default_branch is null");
            return (Criteria) this;
        }

        public Criteria andDefaultBranchIsNotNull() {
            addCriterion("default_branch is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultBranchEqualTo(String value) {
            addCriterion("default_branch =", value, "defaultBranch");
            return (Criteria) this;
        }

        public Criteria andDefaultBranchNotEqualTo(String value) {
            addCriterion("default_branch <>", value, "defaultBranch");
            return (Criteria) this;
        }

        public Criteria andDefaultBranchGreaterThan(String value) {
            addCriterion("default_branch >", value, "defaultBranch");
            return (Criteria) this;
        }

        public Criteria andDefaultBranchGreaterThanOrEqualTo(String value) {
            addCriterion("default_branch >=", value, "defaultBranch");
            return (Criteria) this;
        }

        public Criteria andDefaultBranchLessThan(String value) {
            addCriterion("default_branch <", value, "defaultBranch");
            return (Criteria) this;
        }

        public Criteria andDefaultBranchLessThanOrEqualTo(String value) {
            addCriterion("default_branch <=", value, "defaultBranch");
            return (Criteria) this;
        }

        public Criteria andDefaultBranchLike(String value) {
            addCriterion("default_branch like", value, "defaultBranch");
            return (Criteria) this;
        }

        public Criteria andDefaultBranchNotLike(String value) {
            addCriterion("default_branch not like", value, "defaultBranch");
            return (Criteria) this;
        }

        public Criteria andDefaultBranchIn(List<String> values) {
            addCriterion("default_branch in", values, "defaultBranch");
            return (Criteria) this;
        }

        public Criteria andDefaultBranchNotIn(List<String> values) {
            addCriterion("default_branch not in", values, "defaultBranch");
            return (Criteria) this;
        }

        public Criteria andDefaultBranchBetween(String value1, String value2) {
            addCriterion("default_branch between", value1, value2, "defaultBranch");
            return (Criteria) this;
        }

        public Criteria andDefaultBranchNotBetween(String value1, String value2) {
            addCriterion("default_branch not between", value1, value2, "defaultBranch");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNull() {
            addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNotNull() {
            addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualTo(Date value) {
            addCriterion("created_at =", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(Date value) {
            addCriterion("created_at <>", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(Date value) {
            addCriterion("created_at >", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("created_at >=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(Date value) {
            addCriterion("created_at <", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(Date value) {
            addCriterion("created_at <=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(List<Date> values) {
            addCriterion("created_at in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(List<Date> values) {
            addCriterion("created_at not in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(Date value1, Date value2) {
            addCriterion("created_at between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(Date value1, Date value2) {
            addCriterion("created_at not between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNull() {
            addCriterion("updated_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNotNull() {
            addCriterion("updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtEqualTo(Date value) {
            addCriterion("updated_at =", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotEqualTo(Date value) {
            addCriterion("updated_at <>", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThan(Date value) {
            addCriterion("updated_at >", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_at >=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThan(Date value) {
            addCriterion("updated_at <", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThanOrEqualTo(Date value) {
            addCriterion("updated_at <=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIn(List<Date> values) {
            addCriterion("updated_at in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotIn(List<Date> values) {
            addCriterion("updated_at not in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtBetween(Date value1, Date value2) {
            addCriterion("updated_at between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotBetween(Date value1, Date value2) {
            addCriterion("updated_at not between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andPushedAtIsNull() {
            addCriterion("pushed_at is null");
            return (Criteria) this;
        }

        public Criteria andPushedAtIsNotNull() {
            addCriterion("pushed_at is not null");
            return (Criteria) this;
        }

        public Criteria andPushedAtEqualTo(Date value) {
            addCriterion("pushed_at =", value, "pushedAt");
            return (Criteria) this;
        }

        public Criteria andPushedAtNotEqualTo(Date value) {
            addCriterion("pushed_at <>", value, "pushedAt");
            return (Criteria) this;
        }

        public Criteria andPushedAtGreaterThan(Date value) {
            addCriterion("pushed_at >", value, "pushedAt");
            return (Criteria) this;
        }

        public Criteria andPushedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("pushed_at >=", value, "pushedAt");
            return (Criteria) this;
        }

        public Criteria andPushedAtLessThan(Date value) {
            addCriterion("pushed_at <", value, "pushedAt");
            return (Criteria) this;
        }

        public Criteria andPushedAtLessThanOrEqualTo(Date value) {
            addCriterion("pushed_at <=", value, "pushedAt");
            return (Criteria) this;
        }

        public Criteria andPushedAtIn(List<Date> values) {
            addCriterion("pushed_at in", values, "pushedAt");
            return (Criteria) this;
        }

        public Criteria andPushedAtNotIn(List<Date> values) {
            addCriterion("pushed_at not in", values, "pushedAt");
            return (Criteria) this;
        }

        public Criteria andPushedAtBetween(Date value1, Date value2) {
            addCriterion("pushed_at between", value1, value2, "pushedAt");
            return (Criteria) this;
        }

        public Criteria andPushedAtNotBetween(Date value1, Date value2) {
            addCriterion("pushed_at not between", value1, value2, "pushedAt");
            return (Criteria) this;
        }

        public Criteria andSizeIsNull() {
            addCriterion("size is null");
            return (Criteria) this;
        }

        public Criteria andSizeIsNotNull() {
            addCriterion("size is not null");
            return (Criteria) this;
        }

        public Criteria andSizeEqualTo(Integer value) {
            addCriterion("size =", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotEqualTo(Integer value) {
            addCriterion("size <>", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThan(Integer value) {
            addCriterion("size >", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("size >=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThan(Integer value) {
            addCriterion("size <", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThanOrEqualTo(Integer value) {
            addCriterion("size <=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeIn(List<Integer> values) {
            addCriterion("size in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotIn(List<Integer> values) {
            addCriterion("size not in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeBetween(Integer value1, Integer value2) {
            addCriterion("size between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("size not between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andStarCountIsNull() {
            addCriterion("star_count is null");
            return (Criteria) this;
        }

        public Criteria andStarCountIsNotNull() {
            addCriterion("star_count is not null");
            return (Criteria) this;
        }

        public Criteria andStarCountEqualTo(Integer value) {
            addCriterion("star_count =", value, "starCount");
            return (Criteria) this;
        }

        public Criteria andStarCountNotEqualTo(Integer value) {
            addCriterion("star_count <>", value, "starCount");
            return (Criteria) this;
        }

        public Criteria andStarCountGreaterThan(Integer value) {
            addCriterion("star_count >", value, "starCount");
            return (Criteria) this;
        }

        public Criteria andStarCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("star_count >=", value, "starCount");
            return (Criteria) this;
        }

        public Criteria andStarCountLessThan(Integer value) {
            addCriterion("star_count <", value, "starCount");
            return (Criteria) this;
        }

        public Criteria andStarCountLessThanOrEqualTo(Integer value) {
            addCriterion("star_count <=", value, "starCount");
            return (Criteria) this;
        }

        public Criteria andStarCountIn(List<Integer> values) {
            addCriterion("star_count in", values, "starCount");
            return (Criteria) this;
        }

        public Criteria andStarCountNotIn(List<Integer> values) {
            addCriterion("star_count not in", values, "starCount");
            return (Criteria) this;
        }

        public Criteria andStarCountBetween(Integer value1, Integer value2) {
            addCriterion("star_count between", value1, value2, "starCount");
            return (Criteria) this;
        }

        public Criteria andStarCountNotBetween(Integer value1, Integer value2) {
            addCriterion("star_count not between", value1, value2, "starCount");
            return (Criteria) this;
        }

        public Criteria andWatchersCountIsNull() {
            addCriterion("watchers_count is null");
            return (Criteria) this;
        }

        public Criteria andWatchersCountIsNotNull() {
            addCriterion("watchers_count is not null");
            return (Criteria) this;
        }

        public Criteria andWatchersCountEqualTo(Integer value) {
            addCriterion("watchers_count =", value, "watchersCount");
            return (Criteria) this;
        }

        public Criteria andWatchersCountNotEqualTo(Integer value) {
            addCriterion("watchers_count <>", value, "watchersCount");
            return (Criteria) this;
        }

        public Criteria andWatchersCountGreaterThan(Integer value) {
            addCriterion("watchers_count >", value, "watchersCount");
            return (Criteria) this;
        }

        public Criteria andWatchersCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("watchers_count >=", value, "watchersCount");
            return (Criteria) this;
        }

        public Criteria andWatchersCountLessThan(Integer value) {
            addCriterion("watchers_count <", value, "watchersCount");
            return (Criteria) this;
        }

        public Criteria andWatchersCountLessThanOrEqualTo(Integer value) {
            addCriterion("watchers_count <=", value, "watchersCount");
            return (Criteria) this;
        }

        public Criteria andWatchersCountIn(List<Integer> values) {
            addCriterion("watchers_count in", values, "watchersCount");
            return (Criteria) this;
        }

        public Criteria andWatchersCountNotIn(List<Integer> values) {
            addCriterion("watchers_count not in", values, "watchersCount");
            return (Criteria) this;
        }

        public Criteria andWatchersCountBetween(Integer value1, Integer value2) {
            addCriterion("watchers_count between", value1, value2, "watchersCount");
            return (Criteria) this;
        }

        public Criteria andWatchersCountNotBetween(Integer value1, Integer value2) {
            addCriterion("watchers_count not between", value1, value2, "watchersCount");
            return (Criteria) this;
        }

        public Criteria andForksCountIsNull() {
            addCriterion("forks_count is null");
            return (Criteria) this;
        }

        public Criteria andForksCountIsNotNull() {
            addCriterion("forks_count is not null");
            return (Criteria) this;
        }

        public Criteria andForksCountEqualTo(Integer value) {
            addCriterion("forks_count =", value, "forksCount");
            return (Criteria) this;
        }

        public Criteria andForksCountNotEqualTo(Integer value) {
            addCriterion("forks_count <>", value, "forksCount");
            return (Criteria) this;
        }

        public Criteria andForksCountGreaterThan(Integer value) {
            addCriterion("forks_count >", value, "forksCount");
            return (Criteria) this;
        }

        public Criteria andForksCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("forks_count >=", value, "forksCount");
            return (Criteria) this;
        }

        public Criteria andForksCountLessThan(Integer value) {
            addCriterion("forks_count <", value, "forksCount");
            return (Criteria) this;
        }

        public Criteria andForksCountLessThanOrEqualTo(Integer value) {
            addCriterion("forks_count <=", value, "forksCount");
            return (Criteria) this;
        }

        public Criteria andForksCountIn(List<Integer> values) {
            addCriterion("forks_count in", values, "forksCount");
            return (Criteria) this;
        }

        public Criteria andForksCountNotIn(List<Integer> values) {
            addCriterion("forks_count not in", values, "forksCount");
            return (Criteria) this;
        }

        public Criteria andForksCountBetween(Integer value1, Integer value2) {
            addCriterion("forks_count between", value1, value2, "forksCount");
            return (Criteria) this;
        }

        public Criteria andForksCountNotBetween(Integer value1, Integer value2) {
            addCriterion("forks_count not between", value1, value2, "forksCount");
            return (Criteria) this;
        }

        public Criteria andLanguageIsNull() {
            addCriterion("language is null");
            return (Criteria) this;
        }

        public Criteria andLanguageIsNotNull() {
            addCriterion("language is not null");
            return (Criteria) this;
        }

        public Criteria andLanguageEqualTo(String value) {
            addCriterion("language =", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotEqualTo(String value) {
            addCriterion("language <>", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageGreaterThan(String value) {
            addCriterion("language >", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageGreaterThanOrEqualTo(String value) {
            addCriterion("language >=", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLessThan(String value) {
            addCriterion("language <", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLessThanOrEqualTo(String value) {
            addCriterion("language <=", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLike(String value) {
            addCriterion("language like", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotLike(String value) {
            addCriterion("language not like", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageIn(List<String> values) {
            addCriterion("language in", values, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotIn(List<String> values) {
            addCriterion("language not in", values, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageBetween(String value1, String value2) {
            addCriterion("language between", value1, value2, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotBetween(String value1, String value2) {
            addCriterion("language not between", value1, value2, "language");
            return (Criteria) this;
        }

        public Criteria andDeveloperloginIsNull() {
            addCriterion("developerLogin is null");
            return (Criteria) this;
        }

        public Criteria andDeveloperloginIsNotNull() {
            addCriterion("developerLogin is not null");
            return (Criteria) this;
        }

        public Criteria andDeveloperloginEqualTo(String value) {
            addCriterion("developerLogin =", value, "developerlogin");
            return (Criteria) this;
        }

        public Criteria andDeveloperloginNotEqualTo(String value) {
            addCriterion("developerLogin <>", value, "developerlogin");
            return (Criteria) this;
        }

        public Criteria andDeveloperloginGreaterThan(String value) {
            addCriterion("developerLogin >", value, "developerlogin");
            return (Criteria) this;
        }

        public Criteria andDeveloperloginGreaterThanOrEqualTo(String value) {
            addCriterion("developerLogin >=", value, "developerlogin");
            return (Criteria) this;
        }

        public Criteria andDeveloperloginLessThan(String value) {
            addCriterion("developerLogin <", value, "developerlogin");
            return (Criteria) this;
        }

        public Criteria andDeveloperloginLessThanOrEqualTo(String value) {
            addCriterion("developerLogin <=", value, "developerlogin");
            return (Criteria) this;
        }

        public Criteria andDeveloperloginLike(String value) {
            addCriterion("developerLogin like", value, "developerlogin");
            return (Criteria) this;
        }

        public Criteria andDeveloperloginNotLike(String value) {
            addCriterion("developerLogin not like", value, "developerlogin");
            return (Criteria) this;
        }

        public Criteria andDeveloperloginIn(List<String> values) {
            addCriterion("developerLogin in", values, "developerlogin");
            return (Criteria) this;
        }

        public Criteria andDeveloperloginNotIn(List<String> values) {
            addCriterion("developerLogin not in", values, "developerlogin");
            return (Criteria) this;
        }

        public Criteria andDeveloperloginBetween(String value1, String value2) {
            addCriterion("developerLogin between", value1, value2, "developerlogin");
            return (Criteria) this;
        }

        public Criteria andDeveloperloginNotBetween(String value1, String value2) {
            addCriterion("developerLogin not between", value1, value2, "developerlogin");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNull() {
            addCriterion("updated is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNotNull() {
            addCriterion("updated is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedEqualTo(Date value) {
            addCriterion("updated =", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotEqualTo(Date value) {
            addCriterion("updated <>", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThan(Date value) {
            addCriterion("updated >", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("updated >=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThan(Date value) {
            addCriterion("updated <", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("updated <=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedIn(List<Date> values) {
            addCriterion("updated in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotIn(List<Date> values) {
            addCriterion("updated not in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedBetween(Date value1, Date value2) {
            addCriterion("updated between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("updated not between", value1, value2, "updated");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}