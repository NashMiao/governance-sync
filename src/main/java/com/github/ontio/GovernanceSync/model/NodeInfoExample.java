package com.github.ontio.governancesync.model;

import java.util.ArrayList;
import java.util.List;

public class NodeInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NodeInfoExample() {
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

        public Criteria andNodeIndexIsNull() {
            addCriterion("node_index is null");
            return (Criteria) this;
        }

        public Criteria andNodeIndexIsNotNull() {
            addCriterion("node_index is not null");
            return (Criteria) this;
        }

        public Criteria andNodeIndexEqualTo(Long value) {
            addCriterion("node_index =", value, "nodeIndex");
            return (Criteria) this;
        }

        public Criteria andNodeIndexNotEqualTo(Long value) {
            addCriterion("node_index <>", value, "nodeIndex");
            return (Criteria) this;
        }

        public Criteria andNodeIndexGreaterThan(Long value) {
            addCriterion("node_index >", value, "nodeIndex");
            return (Criteria) this;
        }

        public Criteria andNodeIndexGreaterThanOrEqualTo(Long value) {
            addCriterion("node_index >=", value, "nodeIndex");
            return (Criteria) this;
        }

        public Criteria andNodeIndexLessThan(Long value) {
            addCriterion("node_index <", value, "nodeIndex");
            return (Criteria) this;
        }

        public Criteria andNodeIndexLessThanOrEqualTo(Long value) {
            addCriterion("node_index <=", value, "nodeIndex");
            return (Criteria) this;
        }

        public Criteria andNodeIndexIn(List<Long> values) {
            addCriterion("node_index in", values, "nodeIndex");
            return (Criteria) this;
        }

        public Criteria andNodeIndexNotIn(List<Long> values) {
            addCriterion("node_index not in", values, "nodeIndex");
            return (Criteria) this;
        }

        public Criteria andNodeIndexBetween(Long value1, Long value2) {
            addCriterion("node_index between", value1, value2, "nodeIndex");
            return (Criteria) this;
        }

        public Criteria andNodeIndexNotBetween(Long value1, Long value2) {
            addCriterion("node_index not between", value1, value2, "nodeIndex");
            return (Criteria) this;
        }

        public Criteria andPublicKeyIsNull() {
            addCriterion("public_key is null");
            return (Criteria) this;
        }

        public Criteria andPublicKeyIsNotNull() {
            addCriterion("public_key is not null");
            return (Criteria) this;
        }

        public Criteria andPublicKeyEqualTo(String value) {
            addCriterion("public_key =", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyNotEqualTo(String value) {
            addCriterion("public_key <>", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyGreaterThan(String value) {
            addCriterion("public_key >", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyGreaterThanOrEqualTo(String value) {
            addCriterion("public_key >=", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyLessThan(String value) {
            addCriterion("public_key <", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyLessThanOrEqualTo(String value) {
            addCriterion("public_key <=", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyLike(String value) {
            addCriterion("public_key like", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyNotLike(String value) {
            addCriterion("public_key not like", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyIn(List<String> values) {
            addCriterion("public_key in", values, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyNotIn(List<String> values) {
            addCriterion("public_key not in", values, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyBetween(String value1, String value2) {
            addCriterion("public_key between", value1, value2, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyNotBetween(String value1, String value2) {
            addCriterion("public_key not between", value1, value2, "publicKey");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andInitPosIsNull() {
            addCriterion("init_pos is null");
            return (Criteria) this;
        }

        public Criteria andInitPosIsNotNull() {
            addCriterion("init_pos is not null");
            return (Criteria) this;
        }

        public Criteria andInitPosEqualTo(Long value) {
            addCriterion("init_pos =", value, "initPos");
            return (Criteria) this;
        }

        public Criteria andInitPosNotEqualTo(Long value) {
            addCriterion("init_pos <>", value, "initPos");
            return (Criteria) this;
        }

        public Criteria andInitPosGreaterThan(Long value) {
            addCriterion("init_pos >", value, "initPos");
            return (Criteria) this;
        }

        public Criteria andInitPosGreaterThanOrEqualTo(Long value) {
            addCriterion("init_pos >=", value, "initPos");
            return (Criteria) this;
        }

        public Criteria andInitPosLessThan(Long value) {
            addCriterion("init_pos <", value, "initPos");
            return (Criteria) this;
        }

        public Criteria andInitPosLessThanOrEqualTo(Long value) {
            addCriterion("init_pos <=", value, "initPos");
            return (Criteria) this;
        }

        public Criteria andInitPosIn(List<Long> values) {
            addCriterion("init_pos in", values, "initPos");
            return (Criteria) this;
        }

        public Criteria andInitPosNotIn(List<Long> values) {
            addCriterion("init_pos not in", values, "initPos");
            return (Criteria) this;
        }

        public Criteria andInitPosBetween(Long value1, Long value2) {
            addCriterion("init_pos between", value1, value2, "initPos");
            return (Criteria) this;
        }

        public Criteria andInitPosNotBetween(Long value1, Long value2) {
            addCriterion("init_pos not between", value1, value2, "initPos");
            return (Criteria) this;
        }

        public Criteria andTotalPosIsNull() {
            addCriterion("total_pos is null");
            return (Criteria) this;
        }

        public Criteria andTotalPosIsNotNull() {
            addCriterion("total_pos is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPosEqualTo(Long value) {
            addCriterion("total_pos =", value, "totalPos");
            return (Criteria) this;
        }

        public Criteria andTotalPosNotEqualTo(Long value) {
            addCriterion("total_pos <>", value, "totalPos");
            return (Criteria) this;
        }

        public Criteria andTotalPosGreaterThan(Long value) {
            addCriterion("total_pos >", value, "totalPos");
            return (Criteria) this;
        }

        public Criteria andTotalPosGreaterThanOrEqualTo(Long value) {
            addCriterion("total_pos >=", value, "totalPos");
            return (Criteria) this;
        }

        public Criteria andTotalPosLessThan(Long value) {
            addCriterion("total_pos <", value, "totalPos");
            return (Criteria) this;
        }

        public Criteria andTotalPosLessThanOrEqualTo(Long value) {
            addCriterion("total_pos <=", value, "totalPos");
            return (Criteria) this;
        }

        public Criteria andTotalPosIn(List<Long> values) {
            addCriterion("total_pos in", values, "totalPos");
            return (Criteria) this;
        }

        public Criteria andTotalPosNotIn(List<Long> values) {
            addCriterion("total_pos not in", values, "totalPos");
            return (Criteria) this;
        }

        public Criteria andTotalPosBetween(Long value1, Long value2) {
            addCriterion("total_pos between", value1, value2, "totalPos");
            return (Criteria) this;
        }

        public Criteria andTotalPosNotBetween(Long value1, Long value2) {
            addCriterion("total_pos not between", value1, value2, "totalPos");
            return (Criteria) this;
        }

        public Criteria andMaxAuthorizeIsNull() {
            addCriterion("max_authorize is null");
            return (Criteria) this;
        }

        public Criteria andMaxAuthorizeIsNotNull() {
            addCriterion("max_authorize is not null");
            return (Criteria) this;
        }

        public Criteria andMaxAuthorizeEqualTo(String value) {
            addCriterion("max_authorize =", value, "maxAuthorize");
            return (Criteria) this;
        }

        public Criteria andMaxAuthorizeNotEqualTo(String value) {
            addCriterion("max_authorize <>", value, "maxAuthorize");
            return (Criteria) this;
        }

        public Criteria andMaxAuthorizeGreaterThan(String value) {
            addCriterion("max_authorize >", value, "maxAuthorize");
            return (Criteria) this;
        }

        public Criteria andMaxAuthorizeGreaterThanOrEqualTo(String value) {
            addCriterion("max_authorize >=", value, "maxAuthorize");
            return (Criteria) this;
        }

        public Criteria andMaxAuthorizeLessThan(String value) {
            addCriterion("max_authorize <", value, "maxAuthorize");
            return (Criteria) this;
        }

        public Criteria andMaxAuthorizeLessThanOrEqualTo(String value) {
            addCriterion("max_authorize <=", value, "maxAuthorize");
            return (Criteria) this;
        }

        public Criteria andMaxAuthorizeLike(String value) {
            addCriterion("max_authorize like", value, "maxAuthorize");
            return (Criteria) this;
        }

        public Criteria andMaxAuthorizeNotLike(String value) {
            addCriterion("max_authorize not like", value, "maxAuthorize");
            return (Criteria) this;
        }

        public Criteria andMaxAuthorizeIn(List<String> values) {
            addCriterion("max_authorize in", values, "maxAuthorize");
            return (Criteria) this;
        }

        public Criteria andMaxAuthorizeNotIn(List<String> values) {
            addCriterion("max_authorize not in", values, "maxAuthorize");
            return (Criteria) this;
        }

        public Criteria andMaxAuthorizeBetween(String value1, String value2) {
            addCriterion("max_authorize between", value1, value2, "maxAuthorize");
            return (Criteria) this;
        }

        public Criteria andMaxAuthorizeNotBetween(String value1, String value2) {
            addCriterion("max_authorize not between", value1, value2, "maxAuthorize");
            return (Criteria) this;
        }

        public Criteria andNodeProportionIsNull() {
            addCriterion("node_proportion is null");
            return (Criteria) this;
        }

        public Criteria andNodeProportionIsNotNull() {
            addCriterion("node_proportion is not null");
            return (Criteria) this;
        }

        public Criteria andNodeProportionEqualTo(String value) {
            addCriterion("node_proportion =", value, "nodeProportion");
            return (Criteria) this;
        }

        public Criteria andNodeProportionNotEqualTo(String value) {
            addCriterion("node_proportion <>", value, "nodeProportion");
            return (Criteria) this;
        }

        public Criteria andNodeProportionGreaterThan(String value) {
            addCriterion("node_proportion >", value, "nodeProportion");
            return (Criteria) this;
        }

        public Criteria andNodeProportionGreaterThanOrEqualTo(String value) {
            addCriterion("node_proportion >=", value, "nodeProportion");
            return (Criteria) this;
        }

        public Criteria andNodeProportionLessThan(String value) {
            addCriterion("node_proportion <", value, "nodeProportion");
            return (Criteria) this;
        }

        public Criteria andNodeProportionLessThanOrEqualTo(String value) {
            addCriterion("node_proportion <=", value, "nodeProportion");
            return (Criteria) this;
        }

        public Criteria andNodeProportionLike(String value) {
            addCriterion("node_proportion like", value, "nodeProportion");
            return (Criteria) this;
        }

        public Criteria andNodeProportionNotLike(String value) {
            addCriterion("node_proportion not like", value, "nodeProportion");
            return (Criteria) this;
        }

        public Criteria andNodeProportionIn(List<String> values) {
            addCriterion("node_proportion in", values, "nodeProportion");
            return (Criteria) this;
        }

        public Criteria andNodeProportionNotIn(List<String> values) {
            addCriterion("node_proportion not in", values, "nodeProportion");
            return (Criteria) this;
        }

        public Criteria andNodeProportionBetween(String value1, String value2) {
            addCriterion("node_proportion between", value1, value2, "nodeProportion");
            return (Criteria) this;
        }

        public Criteria andNodeProportionNotBetween(String value1, String value2) {
            addCriterion("node_proportion not between", value1, value2, "nodeProportion");
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