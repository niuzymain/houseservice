package mybatis.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbWorkareaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbWorkareaExample() {
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

        public Criteria andWorkareaIdIsNull() {
            addCriterion("workarea_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkareaIdIsNotNull() {
            addCriterion("workarea_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkareaIdEqualTo(Integer value) {
            addCriterion("workarea_id =", value, "workareaId");
            return (Criteria) this;
        }

        public Criteria andWorkareaIdNotEqualTo(Integer value) {
            addCriterion("workarea_id <>", value, "workareaId");
            return (Criteria) this;
        }

        public Criteria andWorkareaIdGreaterThan(Integer value) {
            addCriterion("workarea_id >", value, "workareaId");
            return (Criteria) this;
        }

        public Criteria andWorkareaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("workarea_id >=", value, "workareaId");
            return (Criteria) this;
        }

        public Criteria andWorkareaIdLessThan(Integer value) {
            addCriterion("workarea_id <", value, "workareaId");
            return (Criteria) this;
        }

        public Criteria andWorkareaIdLessThanOrEqualTo(Integer value) {
            addCriterion("workarea_id <=", value, "workareaId");
            return (Criteria) this;
        }

        public Criteria andWorkareaIdIn(List<Integer> values) {
            addCriterion("workarea_id in", values, "workareaId");
            return (Criteria) this;
        }

        public Criteria andWorkareaIdNotIn(List<Integer> values) {
            addCriterion("workarea_id not in", values, "workareaId");
            return (Criteria) this;
        }

        public Criteria andWorkareaIdBetween(Integer value1, Integer value2) {
            addCriterion("workarea_id between", value1, value2, "workareaId");
            return (Criteria) this;
        }

        public Criteria andWorkareaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("workarea_id not between", value1, value2, "workareaId");
            return (Criteria) this;
        }

        public Criteria andWorkareaNameIsNull() {
            addCriterion("workarea_name is null");
            return (Criteria) this;
        }

        public Criteria andWorkareaNameIsNotNull() {
            addCriterion("workarea_name is not null");
            return (Criteria) this;
        }

        public Criteria andWorkareaNameEqualTo(String value) {
            addCriterion("workarea_name =", value, "workareaName");
            return (Criteria) this;
        }

        public Criteria andWorkareaNameNotEqualTo(String value) {
            addCriterion("workarea_name <>", value, "workareaName");
            return (Criteria) this;
        }

        public Criteria andWorkareaNameGreaterThan(String value) {
            addCriterion("workarea_name >", value, "workareaName");
            return (Criteria) this;
        }

        public Criteria andWorkareaNameGreaterThanOrEqualTo(String value) {
            addCriterion("workarea_name >=", value, "workareaName");
            return (Criteria) this;
        }

        public Criteria andWorkareaNameLessThan(String value) {
            addCriterion("workarea_name <", value, "workareaName");
            return (Criteria) this;
        }

        public Criteria andWorkareaNameLessThanOrEqualTo(String value) {
            addCriterion("workarea_name <=", value, "workareaName");
            return (Criteria) this;
        }

        public Criteria andWorkareaNameLike(String value) {
            addCriterion("workarea_name like", value, "workareaName");
            return (Criteria) this;
        }

        public Criteria andWorkareaNameNotLike(String value) {
            addCriterion("workarea_name not like", value, "workareaName");
            return (Criteria) this;
        }

        public Criteria andWorkareaNameIn(List<String> values) {
            addCriterion("workarea_name in", values, "workareaName");
            return (Criteria) this;
        }

        public Criteria andWorkareaNameNotIn(List<String> values) {
            addCriterion("workarea_name not in", values, "workareaName");
            return (Criteria) this;
        }

        public Criteria andWorkareaNameBetween(String value1, String value2) {
            addCriterion("workarea_name between", value1, value2, "workareaName");
            return (Criteria) this;
        }

        public Criteria andWorkareaNameNotBetween(String value1, String value2) {
            addCriterion("workarea_name not between", value1, value2, "workareaName");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNull() {
            addCriterion("priority is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("priority is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(Integer value) {
            addCriterion("priority =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(Integer value) {
            addCriterion("priority <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(Integer value) {
            addCriterion("priority >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("priority >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(Integer value) {
            addCriterion("priority <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(Integer value) {
            addCriterion("priority <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<Integer> values) {
            addCriterion("priority in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<Integer> values) {
            addCriterion("priority not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(Integer value1, Integer value2) {
            addCriterion("priority between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(Integer value1, Integer value2) {
            addCriterion("priority not between", value1, value2, "priority");
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

        public Criteria andLasteditTimeIsNull() {
            addCriterion("lastedit_time is null");
            return (Criteria) this;
        }

        public Criteria andLasteditTimeIsNotNull() {
            addCriterion("lastedit_time is not null");
            return (Criteria) this;
        }

        public Criteria andLasteditTimeEqualTo(Date value) {
            addCriterion("lastedit_time =", value, "lasteditTime");
            return (Criteria) this;
        }

        public Criteria andLasteditTimeNotEqualTo(Date value) {
            addCriterion("lastedit_time <>", value, "lasteditTime");
            return (Criteria) this;
        }

        public Criteria andLasteditTimeGreaterThan(Date value) {
            addCriterion("lastedit_time >", value, "lasteditTime");
            return (Criteria) this;
        }

        public Criteria andLasteditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lastedit_time >=", value, "lasteditTime");
            return (Criteria) this;
        }

        public Criteria andLasteditTimeLessThan(Date value) {
            addCriterion("lastedit_time <", value, "lasteditTime");
            return (Criteria) this;
        }

        public Criteria andLasteditTimeLessThanOrEqualTo(Date value) {
            addCriterion("lastedit_time <=", value, "lasteditTime");
            return (Criteria) this;
        }

        public Criteria andLasteditTimeIn(List<Date> values) {
            addCriterion("lastedit_time in", values, "lasteditTime");
            return (Criteria) this;
        }

        public Criteria andLasteditTimeNotIn(List<Date> values) {
            addCriterion("lastedit_time not in", values, "lasteditTime");
            return (Criteria) this;
        }

        public Criteria andLasteditTimeBetween(Date value1, Date value2) {
            addCriterion("lastedit_time between", value1, value2, "lasteditTime");
            return (Criteria) this;
        }

        public Criteria andLasteditTimeNotBetween(Date value1, Date value2) {
            addCriterion("lastedit_time not between", value1, value2, "lasteditTime");
            return (Criteria) this;
        }

        public Criteria andParentareaIdIsNull() {
            addCriterion("parentarea_id is null");
            return (Criteria) this;
        }

        public Criteria andParentareaIdIsNotNull() {
            addCriterion("parentarea_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentareaIdEqualTo(Integer value) {
            addCriterion("parentarea_id =", value, "parentareaId");
            return (Criteria) this;
        }

        public Criteria andParentareaIdNotEqualTo(Integer value) {
            addCriterion("parentarea_id <>", value, "parentareaId");
            return (Criteria) this;
        }

        public Criteria andParentareaIdGreaterThan(Integer value) {
            addCriterion("parentarea_id >", value, "parentareaId");
            return (Criteria) this;
        }

        public Criteria andParentareaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parentarea_id >=", value, "parentareaId");
            return (Criteria) this;
        }

        public Criteria andParentareaIdLessThan(Integer value) {
            addCriterion("parentarea_id <", value, "parentareaId");
            return (Criteria) this;
        }

        public Criteria andParentareaIdLessThanOrEqualTo(Integer value) {
            addCriterion("parentarea_id <=", value, "parentareaId");
            return (Criteria) this;
        }

        public Criteria andParentareaIdIn(List<Integer> values) {
            addCriterion("parentarea_id in", values, "parentareaId");
            return (Criteria) this;
        }

        public Criteria andParentareaIdNotIn(List<Integer> values) {
            addCriterion("parentarea_id not in", values, "parentareaId");
            return (Criteria) this;
        }

        public Criteria andParentareaIdBetween(Integer value1, Integer value2) {
            addCriterion("parentarea_id between", value1, value2, "parentareaId");
            return (Criteria) this;
        }

        public Criteria andParentareaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parentarea_id not between", value1, value2, "parentareaId");
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