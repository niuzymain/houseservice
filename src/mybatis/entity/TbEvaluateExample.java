package mybatis.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbEvaluateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbEvaluateExample() {
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

        public Criteria andEvaluateIdIsNull() {
            addCriterion("evaluate_id is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdIsNotNull() {
            addCriterion("evaluate_id is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdEqualTo(Integer value) {
            addCriterion("evaluate_id =", value, "evaluateId");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdNotEqualTo(Integer value) {
            addCriterion("evaluate_id <>", value, "evaluateId");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdGreaterThan(Integer value) {
            addCriterion("evaluate_id >", value, "evaluateId");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("evaluate_id >=", value, "evaluateId");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdLessThan(Integer value) {
            addCriterion("evaluate_id <", value, "evaluateId");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdLessThanOrEqualTo(Integer value) {
            addCriterion("evaluate_id <=", value, "evaluateId");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdIn(List<Integer> values) {
            addCriterion("evaluate_id in", values, "evaluateId");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdNotIn(List<Integer> values) {
            addCriterion("evaluate_id not in", values, "evaluateId");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdBetween(Integer value1, Integer value2) {
            addCriterion("evaluate_id between", value1, value2, "evaluateId");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("evaluate_id not between", value1, value2, "evaluateId");
            return (Criteria) this;
        }

        public Criteria andEvaluateDesIsNull() {
            addCriterion("evaluate_des is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateDesIsNotNull() {
            addCriterion("evaluate_des is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateDesEqualTo(String value) {
            addCriterion("evaluate_des =", value, "evaluateDes");
            return (Criteria) this;
        }

        public Criteria andEvaluateDesNotEqualTo(String value) {
            addCriterion("evaluate_des <>", value, "evaluateDes");
            return (Criteria) this;
        }

        public Criteria andEvaluateDesGreaterThan(String value) {
            addCriterion("evaluate_des >", value, "evaluateDes");
            return (Criteria) this;
        }

        public Criteria andEvaluateDesGreaterThanOrEqualTo(String value) {
            addCriterion("evaluate_des >=", value, "evaluateDes");
            return (Criteria) this;
        }

        public Criteria andEvaluateDesLessThan(String value) {
            addCriterion("evaluate_des <", value, "evaluateDes");
            return (Criteria) this;
        }

        public Criteria andEvaluateDesLessThanOrEqualTo(String value) {
            addCriterion("evaluate_des <=", value, "evaluateDes");
            return (Criteria) this;
        }

        public Criteria andEvaluateDesLike(String value) {
            addCriterion("evaluate_des like", value, "evaluateDes");
            return (Criteria) this;
        }

        public Criteria andEvaluateDesNotLike(String value) {
            addCriterion("evaluate_des not like", value, "evaluateDes");
            return (Criteria) this;
        }

        public Criteria andEvaluateDesIn(List<String> values) {
            addCriterion("evaluate_des in", values, "evaluateDes");
            return (Criteria) this;
        }

        public Criteria andEvaluateDesNotIn(List<String> values) {
            addCriterion("evaluate_des not in", values, "evaluateDes");
            return (Criteria) this;
        }

        public Criteria andEvaluateDesBetween(String value1, String value2) {
            addCriterion("evaluate_des between", value1, value2, "evaluateDes");
            return (Criteria) this;
        }

        public Criteria andEvaluateDesNotBetween(String value1, String value2) {
            addCriterion("evaluate_des not between", value1, value2, "evaluateDes");
            return (Criteria) this;
        }

        public Criteria andEvaluateScoreIsNull() {
            addCriterion("evaluate_score is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateScoreIsNotNull() {
            addCriterion("evaluate_score is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateScoreEqualTo(Integer value) {
            addCriterion("evaluate_score =", value, "evaluateScore");
            return (Criteria) this;
        }

        public Criteria andEvaluateScoreNotEqualTo(Integer value) {
            addCriterion("evaluate_score <>", value, "evaluateScore");
            return (Criteria) this;
        }

        public Criteria andEvaluateScoreGreaterThan(Integer value) {
            addCriterion("evaluate_score >", value, "evaluateScore");
            return (Criteria) this;
        }

        public Criteria andEvaluateScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("evaluate_score >=", value, "evaluateScore");
            return (Criteria) this;
        }

        public Criteria andEvaluateScoreLessThan(Integer value) {
            addCriterion("evaluate_score <", value, "evaluateScore");
            return (Criteria) this;
        }

        public Criteria andEvaluateScoreLessThanOrEqualTo(Integer value) {
            addCriterion("evaluate_score <=", value, "evaluateScore");
            return (Criteria) this;
        }

        public Criteria andEvaluateScoreIn(List<Integer> values) {
            addCriterion("evaluate_score in", values, "evaluateScore");
            return (Criteria) this;
        }

        public Criteria andEvaluateScoreNotIn(List<Integer> values) {
            addCriterion("evaluate_score not in", values, "evaluateScore");
            return (Criteria) this;
        }

        public Criteria andEvaluateScoreBetween(Integer value1, Integer value2) {
            addCriterion("evaluate_score between", value1, value2, "evaluateScore");
            return (Criteria) this;
        }

        public Criteria andEvaluateScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("evaluate_score not between", value1, value2, "evaluateScore");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andServicerIdIsNull() {
            addCriterion("servicer_id is null");
            return (Criteria) this;
        }

        public Criteria andServicerIdIsNotNull() {
            addCriterion("servicer_id is not null");
            return (Criteria) this;
        }

        public Criteria andServicerIdEqualTo(Integer value) {
            addCriterion("servicer_id =", value, "servicerId");
            return (Criteria) this;
        }

        public Criteria andServicerIdNotEqualTo(Integer value) {
            addCriterion("servicer_id <>", value, "servicerId");
            return (Criteria) this;
        }

        public Criteria andServicerIdGreaterThan(Integer value) {
            addCriterion("servicer_id >", value, "servicerId");
            return (Criteria) this;
        }

        public Criteria andServicerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("servicer_id >=", value, "servicerId");
            return (Criteria) this;
        }

        public Criteria andServicerIdLessThan(Integer value) {
            addCriterion("servicer_id <", value, "servicerId");
            return (Criteria) this;
        }

        public Criteria andServicerIdLessThanOrEqualTo(Integer value) {
            addCriterion("servicer_id <=", value, "servicerId");
            return (Criteria) this;
        }

        public Criteria andServicerIdIn(List<Integer> values) {
            addCriterion("servicer_id in", values, "servicerId");
            return (Criteria) this;
        }

        public Criteria andServicerIdNotIn(List<Integer> values) {
            addCriterion("servicer_id not in", values, "servicerId");
            return (Criteria) this;
        }

        public Criteria andServicerIdBetween(Integer value1, Integer value2) {
            addCriterion("servicer_id between", value1, value2, "servicerId");
            return (Criteria) this;
        }

        public Criteria andServicerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("servicer_id not between", value1, value2, "servicerId");
            return (Criteria) this;
        }

        public Criteria andEnableStatusIsNull() {
            addCriterion("enable_status is null");
            return (Criteria) this;
        }

        public Criteria andEnableStatusIsNotNull() {
            addCriterion("enable_status is not null");
            return (Criteria) this;
        }

        public Criteria andEnableStatusEqualTo(Integer value) {
            addCriterion("enable_status =", value, "enableStatus");
            return (Criteria) this;
        }

        public Criteria andEnableStatusNotEqualTo(Integer value) {
            addCriterion("enable_status <>", value, "enableStatus");
            return (Criteria) this;
        }

        public Criteria andEnableStatusGreaterThan(Integer value) {
            addCriterion("enable_status >", value, "enableStatus");
            return (Criteria) this;
        }

        public Criteria andEnableStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("enable_status >=", value, "enableStatus");
            return (Criteria) this;
        }

        public Criteria andEnableStatusLessThan(Integer value) {
            addCriterion("enable_status <", value, "enableStatus");
            return (Criteria) this;
        }

        public Criteria andEnableStatusLessThanOrEqualTo(Integer value) {
            addCriterion("enable_status <=", value, "enableStatus");
            return (Criteria) this;
        }

        public Criteria andEnableStatusIn(List<Integer> values) {
            addCriterion("enable_status in", values, "enableStatus");
            return (Criteria) this;
        }

        public Criteria andEnableStatusNotIn(List<Integer> values) {
            addCriterion("enable_status not in", values, "enableStatus");
            return (Criteria) this;
        }

        public Criteria andEnableStatusBetween(Integer value1, Integer value2) {
            addCriterion("enable_status between", value1, value2, "enableStatus");
            return (Criteria) this;
        }

        public Criteria andEnableStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("enable_status not between", value1, value2, "enableStatus");
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