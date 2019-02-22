package mybatis.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbHeadimgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbHeadimgExample() {
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

        public Criteria andHeadimgIdIsNull() {
            addCriterion("headimg_id is null");
            return (Criteria) this;
        }

        public Criteria andHeadimgIdIsNotNull() {
            addCriterion("headimg_id is not null");
            return (Criteria) this;
        }

        public Criteria andHeadimgIdEqualTo(Integer value) {
            addCriterion("headimg_id =", value, "headimgId");
            return (Criteria) this;
        }

        public Criteria andHeadimgIdNotEqualTo(Integer value) {
            addCriterion("headimg_id <>", value, "headimgId");
            return (Criteria) this;
        }

        public Criteria andHeadimgIdGreaterThan(Integer value) {
            addCriterion("headimg_id >", value, "headimgId");
            return (Criteria) this;
        }

        public Criteria andHeadimgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("headimg_id >=", value, "headimgId");
            return (Criteria) this;
        }

        public Criteria andHeadimgIdLessThan(Integer value) {
            addCriterion("headimg_id <", value, "headimgId");
            return (Criteria) this;
        }

        public Criteria andHeadimgIdLessThanOrEqualTo(Integer value) {
            addCriterion("headimg_id <=", value, "headimgId");
            return (Criteria) this;
        }

        public Criteria andHeadimgIdIn(List<Integer> values) {
            addCriterion("headimg_id in", values, "headimgId");
            return (Criteria) this;
        }

        public Criteria andHeadimgIdNotIn(List<Integer> values) {
            addCriterion("headimg_id not in", values, "headimgId");
            return (Criteria) this;
        }

        public Criteria andHeadimgIdBetween(Integer value1, Integer value2) {
            addCriterion("headimg_id between", value1, value2, "headimgId");
            return (Criteria) this;
        }

        public Criteria andHeadimgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("headimg_id not between", value1, value2, "headimgId");
            return (Criteria) this;
        }

        public Criteria andHeadimgTitleIsNull() {
            addCriterion("headimg_title is null");
            return (Criteria) this;
        }

        public Criteria andHeadimgTitleIsNotNull() {
            addCriterion("headimg_title is not null");
            return (Criteria) this;
        }

        public Criteria andHeadimgTitleEqualTo(String value) {
            addCriterion("headimg_title =", value, "headimgTitle");
            return (Criteria) this;
        }

        public Criteria andHeadimgTitleNotEqualTo(String value) {
            addCriterion("headimg_title <>", value, "headimgTitle");
            return (Criteria) this;
        }

        public Criteria andHeadimgTitleGreaterThan(String value) {
            addCriterion("headimg_title >", value, "headimgTitle");
            return (Criteria) this;
        }

        public Criteria andHeadimgTitleGreaterThanOrEqualTo(String value) {
            addCriterion("headimg_title >=", value, "headimgTitle");
            return (Criteria) this;
        }

        public Criteria andHeadimgTitleLessThan(String value) {
            addCriterion("headimg_title <", value, "headimgTitle");
            return (Criteria) this;
        }

        public Criteria andHeadimgTitleLessThanOrEqualTo(String value) {
            addCriterion("headimg_title <=", value, "headimgTitle");
            return (Criteria) this;
        }

        public Criteria andHeadimgTitleLike(String value) {
            addCriterion("headimg_title like", value, "headimgTitle");
            return (Criteria) this;
        }

        public Criteria andHeadimgTitleNotLike(String value) {
            addCriterion("headimg_title not like", value, "headimgTitle");
            return (Criteria) this;
        }

        public Criteria andHeadimgTitleIn(List<String> values) {
            addCriterion("headimg_title in", values, "headimgTitle");
            return (Criteria) this;
        }

        public Criteria andHeadimgTitleNotIn(List<String> values) {
            addCriterion("headimg_title not in", values, "headimgTitle");
            return (Criteria) this;
        }

        public Criteria andHeadimgTitleBetween(String value1, String value2) {
            addCriterion("headimg_title between", value1, value2, "headimgTitle");
            return (Criteria) this;
        }

        public Criteria andHeadimgTitleNotBetween(String value1, String value2) {
            addCriterion("headimg_title not between", value1, value2, "headimgTitle");
            return (Criteria) this;
        }

        public Criteria andHeadimgDetailsIsNull() {
            addCriterion("headimg_details is null");
            return (Criteria) this;
        }

        public Criteria andHeadimgDetailsIsNotNull() {
            addCriterion("headimg_details is not null");
            return (Criteria) this;
        }

        public Criteria andHeadimgDetailsEqualTo(String value) {
            addCriterion("headimg_details =", value, "headimgDetails");
            return (Criteria) this;
        }

        public Criteria andHeadimgDetailsNotEqualTo(String value) {
            addCriterion("headimg_details <>", value, "headimgDetails");
            return (Criteria) this;
        }

        public Criteria andHeadimgDetailsGreaterThan(String value) {
            addCriterion("headimg_details >", value, "headimgDetails");
            return (Criteria) this;
        }

        public Criteria andHeadimgDetailsGreaterThanOrEqualTo(String value) {
            addCriterion("headimg_details >=", value, "headimgDetails");
            return (Criteria) this;
        }

        public Criteria andHeadimgDetailsLessThan(String value) {
            addCriterion("headimg_details <", value, "headimgDetails");
            return (Criteria) this;
        }

        public Criteria andHeadimgDetailsLessThanOrEqualTo(String value) {
            addCriterion("headimg_details <=", value, "headimgDetails");
            return (Criteria) this;
        }

        public Criteria andHeadimgDetailsLike(String value) {
            addCriterion("headimg_details like", value, "headimgDetails");
            return (Criteria) this;
        }

        public Criteria andHeadimgDetailsNotLike(String value) {
            addCriterion("headimg_details not like", value, "headimgDetails");
            return (Criteria) this;
        }

        public Criteria andHeadimgDetailsIn(List<String> values) {
            addCriterion("headimg_details in", values, "headimgDetails");
            return (Criteria) this;
        }

        public Criteria andHeadimgDetailsNotIn(List<String> values) {
            addCriterion("headimg_details not in", values, "headimgDetails");
            return (Criteria) this;
        }

        public Criteria andHeadimgDetailsBetween(String value1, String value2) {
            addCriterion("headimg_details between", value1, value2, "headimgDetails");
            return (Criteria) this;
        }

        public Criteria andHeadimgDetailsNotBetween(String value1, String value2) {
            addCriterion("headimg_details not between", value1, value2, "headimgDetails");
            return (Criteria) this;
        }

        public Criteria andHeadimgUrlIsNull() {
            addCriterion("headimg_url is null");
            return (Criteria) this;
        }

        public Criteria andHeadimgUrlIsNotNull() {
            addCriterion("headimg_url is not null");
            return (Criteria) this;
        }

        public Criteria andHeadimgUrlEqualTo(String value) {
            addCriterion("headimg_url =", value, "headimgUrl");
            return (Criteria) this;
        }

        public Criteria andHeadimgUrlNotEqualTo(String value) {
            addCriterion("headimg_url <>", value, "headimgUrl");
            return (Criteria) this;
        }

        public Criteria andHeadimgUrlGreaterThan(String value) {
            addCriterion("headimg_url >", value, "headimgUrl");
            return (Criteria) this;
        }

        public Criteria andHeadimgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("headimg_url >=", value, "headimgUrl");
            return (Criteria) this;
        }

        public Criteria andHeadimgUrlLessThan(String value) {
            addCriterion("headimg_url <", value, "headimgUrl");
            return (Criteria) this;
        }

        public Criteria andHeadimgUrlLessThanOrEqualTo(String value) {
            addCriterion("headimg_url <=", value, "headimgUrl");
            return (Criteria) this;
        }

        public Criteria andHeadimgUrlLike(String value) {
            addCriterion("headimg_url like", value, "headimgUrl");
            return (Criteria) this;
        }

        public Criteria andHeadimgUrlNotLike(String value) {
            addCriterion("headimg_url not like", value, "headimgUrl");
            return (Criteria) this;
        }

        public Criteria andHeadimgUrlIn(List<String> values) {
            addCriterion("headimg_url in", values, "headimgUrl");
            return (Criteria) this;
        }

        public Criteria andHeadimgUrlNotIn(List<String> values) {
            addCriterion("headimg_url not in", values, "headimgUrl");
            return (Criteria) this;
        }

        public Criteria andHeadimgUrlBetween(String value1, String value2) {
            addCriterion("headimg_url between", value1, value2, "headimgUrl");
            return (Criteria) this;
        }

        public Criteria andHeadimgUrlNotBetween(String value1, String value2) {
            addCriterion("headimg_url not between", value1, value2, "headimgUrl");
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