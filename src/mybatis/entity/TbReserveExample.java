package mybatis.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbReserveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbReserveExample() {
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

        public Criteria andReserveIdIsNull() {
            addCriterion("reserve_id is null");
            return (Criteria) this;
        }

        public Criteria andReserveIdIsNotNull() {
            addCriterion("reserve_id is not null");
            return (Criteria) this;
        }

        public Criteria andReserveIdEqualTo(Integer value) {
            addCriterion("reserve_id =", value, "reserveId");
            return (Criteria) this;
        }

        public Criteria andReserveIdNotEqualTo(Integer value) {
            addCriterion("reserve_id <>", value, "reserveId");
            return (Criteria) this;
        }

        public Criteria andReserveIdGreaterThan(Integer value) {
            addCriterion("reserve_id >", value, "reserveId");
            return (Criteria) this;
        }

        public Criteria andReserveIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("reserve_id >=", value, "reserveId");
            return (Criteria) this;
        }

        public Criteria andReserveIdLessThan(Integer value) {
            addCriterion("reserve_id <", value, "reserveId");
            return (Criteria) this;
        }

        public Criteria andReserveIdLessThanOrEqualTo(Integer value) {
            addCriterion("reserve_id <=", value, "reserveId");
            return (Criteria) this;
        }

        public Criteria andReserveIdIn(List<Integer> values) {
            addCriterion("reserve_id in", values, "reserveId");
            return (Criteria) this;
        }

        public Criteria andReserveIdNotIn(List<Integer> values) {
            addCriterion("reserve_id not in", values, "reserveId");
            return (Criteria) this;
        }

        public Criteria andReserveIdBetween(Integer value1, Integer value2) {
            addCriterion("reserve_id between", value1, value2, "reserveId");
            return (Criteria) this;
        }

        public Criteria andReserveIdNotBetween(Integer value1, Integer value2) {
            addCriterion("reserve_id not between", value1, value2, "reserveId");
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

        public Criteria andReserveAddrIsNull() {
            addCriterion("reserve_addr is null");
            return (Criteria) this;
        }

        public Criteria andReserveAddrIsNotNull() {
            addCriterion("reserve_addr is not null");
            return (Criteria) this;
        }

        public Criteria andReserveAddrEqualTo(String value) {
            addCriterion("reserve_addr =", value, "reserveAddr");
            return (Criteria) this;
        }

        public Criteria andReserveAddrNotEqualTo(String value) {
            addCriterion("reserve_addr <>", value, "reserveAddr");
            return (Criteria) this;
        }

        public Criteria andReserveAddrGreaterThan(String value) {
            addCriterion("reserve_addr >", value, "reserveAddr");
            return (Criteria) this;
        }

        public Criteria andReserveAddrGreaterThanOrEqualTo(String value) {
            addCriterion("reserve_addr >=", value, "reserveAddr");
            return (Criteria) this;
        }

        public Criteria andReserveAddrLessThan(String value) {
            addCriterion("reserve_addr <", value, "reserveAddr");
            return (Criteria) this;
        }

        public Criteria andReserveAddrLessThanOrEqualTo(String value) {
            addCriterion("reserve_addr <=", value, "reserveAddr");
            return (Criteria) this;
        }

        public Criteria andReserveAddrLike(String value) {
            addCriterion("reserve_addr like", value, "reserveAddr");
            return (Criteria) this;
        }

        public Criteria andReserveAddrNotLike(String value) {
            addCriterion("reserve_addr not like", value, "reserveAddr");
            return (Criteria) this;
        }

        public Criteria andReserveAddrIn(List<String> values) {
            addCriterion("reserve_addr in", values, "reserveAddr");
            return (Criteria) this;
        }

        public Criteria andReserveAddrNotIn(List<String> values) {
            addCriterion("reserve_addr not in", values, "reserveAddr");
            return (Criteria) this;
        }

        public Criteria andReserveAddrBetween(String value1, String value2) {
            addCriterion("reserve_addr between", value1, value2, "reserveAddr");
            return (Criteria) this;
        }

        public Criteria andReserveAddrNotBetween(String value1, String value2) {
            addCriterion("reserve_addr not between", value1, value2, "reserveAddr");
            return (Criteria) this;
        }

        public Criteria andReserveDesIsNull() {
            addCriterion("reserve_des is null");
            return (Criteria) this;
        }

        public Criteria andReserveDesIsNotNull() {
            addCriterion("reserve_des is not null");
            return (Criteria) this;
        }

        public Criteria andReserveDesEqualTo(String value) {
            addCriterion("reserve_des =", value, "reserveDes");
            return (Criteria) this;
        }

        public Criteria andReserveDesNotEqualTo(String value) {
            addCriterion("reserve_des <>", value, "reserveDes");
            return (Criteria) this;
        }

        public Criteria andReserveDesGreaterThan(String value) {
            addCriterion("reserve_des >", value, "reserveDes");
            return (Criteria) this;
        }

        public Criteria andReserveDesGreaterThanOrEqualTo(String value) {
            addCriterion("reserve_des >=", value, "reserveDes");
            return (Criteria) this;
        }

        public Criteria andReserveDesLessThan(String value) {
            addCriterion("reserve_des <", value, "reserveDes");
            return (Criteria) this;
        }

        public Criteria andReserveDesLessThanOrEqualTo(String value) {
            addCriterion("reserve_des <=", value, "reserveDes");
            return (Criteria) this;
        }

        public Criteria andReserveDesLike(String value) {
            addCriterion("reserve_des like", value, "reserveDes");
            return (Criteria) this;
        }

        public Criteria andReserveDesNotLike(String value) {
            addCriterion("reserve_des not like", value, "reserveDes");
            return (Criteria) this;
        }

        public Criteria andReserveDesIn(List<String> values) {
            addCriterion("reserve_des in", values, "reserveDes");
            return (Criteria) this;
        }

        public Criteria andReserveDesNotIn(List<String> values) {
            addCriterion("reserve_des not in", values, "reserveDes");
            return (Criteria) this;
        }

        public Criteria andReserveDesBetween(String value1, String value2) {
            addCriterion("reserve_des between", value1, value2, "reserveDes");
            return (Criteria) this;
        }

        public Criteria andReserveDesNotBetween(String value1, String value2) {
            addCriterion("reserve_des not between", value1, value2, "reserveDes");
            return (Criteria) this;
        }

        public Criteria andReservePhoneIsNull() {
            addCriterion("reserve_phone is null");
            return (Criteria) this;
        }

        public Criteria andReservePhoneIsNotNull() {
            addCriterion("reserve_phone is not null");
            return (Criteria) this;
        }

        public Criteria andReservePhoneEqualTo(String value) {
            addCriterion("reserve_phone =", value, "reservePhone");
            return (Criteria) this;
        }

        public Criteria andReservePhoneNotEqualTo(String value) {
            addCriterion("reserve_phone <>", value, "reservePhone");
            return (Criteria) this;
        }

        public Criteria andReservePhoneGreaterThan(String value) {
            addCriterion("reserve_phone >", value, "reservePhone");
            return (Criteria) this;
        }

        public Criteria andReservePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("reserve_phone >=", value, "reservePhone");
            return (Criteria) this;
        }

        public Criteria andReservePhoneLessThan(String value) {
            addCriterion("reserve_phone <", value, "reservePhone");
            return (Criteria) this;
        }

        public Criteria andReservePhoneLessThanOrEqualTo(String value) {
            addCriterion("reserve_phone <=", value, "reservePhone");
            return (Criteria) this;
        }

        public Criteria andReservePhoneLike(String value) {
            addCriterion("reserve_phone like", value, "reservePhone");
            return (Criteria) this;
        }

        public Criteria andReservePhoneNotLike(String value) {
            addCriterion("reserve_phone not like", value, "reservePhone");
            return (Criteria) this;
        }

        public Criteria andReservePhoneIn(List<String> values) {
            addCriterion("reserve_phone in", values, "reservePhone");
            return (Criteria) this;
        }

        public Criteria andReservePhoneNotIn(List<String> values) {
            addCriterion("reserve_phone not in", values, "reservePhone");
            return (Criteria) this;
        }

        public Criteria andReservePhoneBetween(String value1, String value2) {
            addCriterion("reserve_phone between", value1, value2, "reservePhone");
            return (Criteria) this;
        }

        public Criteria andReservePhoneNotBetween(String value1, String value2) {
            addCriterion("reserve_phone not between", value1, value2, "reservePhone");
            return (Criteria) this;
        }

        public Criteria andReserveMegIsNull() {
            addCriterion("reserve_meg is null");
            return (Criteria) this;
        }

        public Criteria andReserveMegIsNotNull() {
            addCriterion("reserve_meg is not null");
            return (Criteria) this;
        }

        public Criteria andReserveMegEqualTo(String value) {
            addCriterion("reserve_meg =", value, "reserveMeg");
            return (Criteria) this;
        }

        public Criteria andReserveMegNotEqualTo(String value) {
            addCriterion("reserve_meg <>", value, "reserveMeg");
            return (Criteria) this;
        }

        public Criteria andReserveMegGreaterThan(String value) {
            addCriterion("reserve_meg >", value, "reserveMeg");
            return (Criteria) this;
        }

        public Criteria andReserveMegGreaterThanOrEqualTo(String value) {
            addCriterion("reserve_meg >=", value, "reserveMeg");
            return (Criteria) this;
        }

        public Criteria andReserveMegLessThan(String value) {
            addCriterion("reserve_meg <", value, "reserveMeg");
            return (Criteria) this;
        }

        public Criteria andReserveMegLessThanOrEqualTo(String value) {
            addCriterion("reserve_meg <=", value, "reserveMeg");
            return (Criteria) this;
        }

        public Criteria andReserveMegLike(String value) {
            addCriterion("reserve_meg like", value, "reserveMeg");
            return (Criteria) this;
        }

        public Criteria andReserveMegNotLike(String value) {
            addCriterion("reserve_meg not like", value, "reserveMeg");
            return (Criteria) this;
        }

        public Criteria andReserveMegIn(List<String> values) {
            addCriterion("reserve_meg in", values, "reserveMeg");
            return (Criteria) this;
        }

        public Criteria andReserveMegNotIn(List<String> values) {
            addCriterion("reserve_meg not in", values, "reserveMeg");
            return (Criteria) this;
        }

        public Criteria andReserveMegBetween(String value1, String value2) {
            addCriterion("reserve_meg between", value1, value2, "reserveMeg");
            return (Criteria) this;
        }

        public Criteria andReserveMegNotBetween(String value1, String value2) {
            addCriterion("reserve_meg not between", value1, value2, "reserveMeg");
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