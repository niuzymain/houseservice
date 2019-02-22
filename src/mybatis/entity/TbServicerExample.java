package mybatis.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbServicerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbServicerExample() {
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

        public Criteria andServicerIdnumIsNull() {
            addCriterion("servicer_idnum is null");
            return (Criteria) this;
        }

        public Criteria andServicerIdnumIsNotNull() {
            addCriterion("servicer_idnum is not null");
            return (Criteria) this;
        }

        public Criteria andServicerIdnumEqualTo(String value) {
            addCriterion("servicer_idnum =", value, "servicerIdnum");
            return (Criteria) this;
        }

        public Criteria andServicerIdnumNotEqualTo(String value) {
            addCriterion("servicer_idnum <>", value, "servicerIdnum");
            return (Criteria) this;
        }

        public Criteria andServicerIdnumGreaterThan(String value) {
            addCriterion("servicer_idnum >", value, "servicerIdnum");
            return (Criteria) this;
        }

        public Criteria andServicerIdnumGreaterThanOrEqualTo(String value) {
            addCriterion("servicer_idnum >=", value, "servicerIdnum");
            return (Criteria) this;
        }

        public Criteria andServicerIdnumLessThan(String value) {
            addCriterion("servicer_idnum <", value, "servicerIdnum");
            return (Criteria) this;
        }

        public Criteria andServicerIdnumLessThanOrEqualTo(String value) {
            addCriterion("servicer_idnum <=", value, "servicerIdnum");
            return (Criteria) this;
        }

        public Criteria andServicerIdnumLike(String value) {
            addCriterion("servicer_idnum like", value, "servicerIdnum");
            return (Criteria) this;
        }

        public Criteria andServicerIdnumNotLike(String value) {
            addCriterion("servicer_idnum not like", value, "servicerIdnum");
            return (Criteria) this;
        }

        public Criteria andServicerIdnumIn(List<String> values) {
            addCriterion("servicer_idnum in", values, "servicerIdnum");
            return (Criteria) this;
        }

        public Criteria andServicerIdnumNotIn(List<String> values) {
            addCriterion("servicer_idnum not in", values, "servicerIdnum");
            return (Criteria) this;
        }

        public Criteria andServicerIdnumBetween(String value1, String value2) {
            addCriterion("servicer_idnum between", value1, value2, "servicerIdnum");
            return (Criteria) this;
        }

        public Criteria andServicerIdnumNotBetween(String value1, String value2) {
            addCriterion("servicer_idnum not between", value1, value2, "servicerIdnum");
            return (Criteria) this;
        }

        public Criteria andServicerNameIsNull() {
            addCriterion("servicer_name is null");
            return (Criteria) this;
        }

        public Criteria andServicerNameIsNotNull() {
            addCriterion("servicer_name is not null");
            return (Criteria) this;
        }

        public Criteria andServicerNameEqualTo(String value) {
            addCriterion("servicer_name =", value, "servicerName");
            return (Criteria) this;
        }

        public Criteria andServicerNameNotEqualTo(String value) {
            addCriterion("servicer_name <>", value, "servicerName");
            return (Criteria) this;
        }

        public Criteria andServicerNameGreaterThan(String value) {
            addCriterion("servicer_name >", value, "servicerName");
            return (Criteria) this;
        }

        public Criteria andServicerNameGreaterThanOrEqualTo(String value) {
            addCriterion("servicer_name >=", value, "servicerName");
            return (Criteria) this;
        }

        public Criteria andServicerNameLessThan(String value) {
            addCriterion("servicer_name <", value, "servicerName");
            return (Criteria) this;
        }

        public Criteria andServicerNameLessThanOrEqualTo(String value) {
            addCriterion("servicer_name <=", value, "servicerName");
            return (Criteria) this;
        }

        public Criteria andServicerNameLike(String value) {
            addCriterion("servicer_name like", value, "servicerName");
            return (Criteria) this;
        }

        public Criteria andServicerNameNotLike(String value) {
            addCriterion("servicer_name not like", value, "servicerName");
            return (Criteria) this;
        }

        public Criteria andServicerNameIn(List<String> values) {
            addCriterion("servicer_name in", values, "servicerName");
            return (Criteria) this;
        }

        public Criteria andServicerNameNotIn(List<String> values) {
            addCriterion("servicer_name not in", values, "servicerName");
            return (Criteria) this;
        }

        public Criteria andServicerNameBetween(String value1, String value2) {
            addCriterion("servicer_name between", value1, value2, "servicerName");
            return (Criteria) this;
        }

        public Criteria andServicerNameNotBetween(String value1, String value2) {
            addCriterion("servicer_name not between", value1, value2, "servicerName");
            return (Criteria) this;
        }

        public Criteria andServicerAgeIsNull() {
            addCriterion("servicer_age is null");
            return (Criteria) this;
        }

        public Criteria andServicerAgeIsNotNull() {
            addCriterion("servicer_age is not null");
            return (Criteria) this;
        }

        public Criteria andServicerAgeEqualTo(Integer value) {
            addCriterion("servicer_age =", value, "servicerAge");
            return (Criteria) this;
        }

        public Criteria andServicerAgeNotEqualTo(Integer value) {
            addCriterion("servicer_age <>", value, "servicerAge");
            return (Criteria) this;
        }

        public Criteria andServicerAgeGreaterThan(Integer value) {
            addCriterion("servicer_age >", value, "servicerAge");
            return (Criteria) this;
        }

        public Criteria andServicerAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("servicer_age >=", value, "servicerAge");
            return (Criteria) this;
        }

        public Criteria andServicerAgeLessThan(Integer value) {
            addCriterion("servicer_age <", value, "servicerAge");
            return (Criteria) this;
        }

        public Criteria andServicerAgeLessThanOrEqualTo(Integer value) {
            addCriterion("servicer_age <=", value, "servicerAge");
            return (Criteria) this;
        }

        public Criteria andServicerAgeIn(List<Integer> values) {
            addCriterion("servicer_age in", values, "servicerAge");
            return (Criteria) this;
        }

        public Criteria andServicerAgeNotIn(List<Integer> values) {
            addCriterion("servicer_age not in", values, "servicerAge");
            return (Criteria) this;
        }

        public Criteria andServicerAgeBetween(Integer value1, Integer value2) {
            addCriterion("servicer_age between", value1, value2, "servicerAge");
            return (Criteria) this;
        }

        public Criteria andServicerAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("servicer_age not between", value1, value2, "servicerAge");
            return (Criteria) this;
        }

        public Criteria andServicerSexIsNull() {
            addCriterion("servicer_sex is null");
            return (Criteria) this;
        }

        public Criteria andServicerSexIsNotNull() {
            addCriterion("servicer_sex is not null");
            return (Criteria) this;
        }

        public Criteria andServicerSexEqualTo(Integer value) {
            addCriterion("servicer_sex =", value, "servicerSex");
            return (Criteria) this;
        }

        public Criteria andServicerSexNotEqualTo(Integer value) {
            addCriterion("servicer_sex <>", value, "servicerSex");
            return (Criteria) this;
        }

        public Criteria andServicerSexGreaterThan(Integer value) {
            addCriterion("servicer_sex >", value, "servicerSex");
            return (Criteria) this;
        }

        public Criteria andServicerSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("servicer_sex >=", value, "servicerSex");
            return (Criteria) this;
        }

        public Criteria andServicerSexLessThan(Integer value) {
            addCriterion("servicer_sex <", value, "servicerSex");
            return (Criteria) this;
        }

        public Criteria andServicerSexLessThanOrEqualTo(Integer value) {
            addCriterion("servicer_sex <=", value, "servicerSex");
            return (Criteria) this;
        }

        public Criteria andServicerSexIn(List<Integer> values) {
            addCriterion("servicer_sex in", values, "servicerSex");
            return (Criteria) this;
        }

        public Criteria andServicerSexNotIn(List<Integer> values) {
            addCriterion("servicer_sex not in", values, "servicerSex");
            return (Criteria) this;
        }

        public Criteria andServicerSexBetween(Integer value1, Integer value2) {
            addCriterion("servicer_sex between", value1, value2, "servicerSex");
            return (Criteria) this;
        }

        public Criteria andServicerSexNotBetween(Integer value1, Integer value2) {
            addCriterion("servicer_sex not between", value1, value2, "servicerSex");
            return (Criteria) this;
        }

        public Criteria andServicerPhoneIsNull() {
            addCriterion("servicer_phone is null");
            return (Criteria) this;
        }

        public Criteria andServicerPhoneIsNotNull() {
            addCriterion("servicer_phone is not null");
            return (Criteria) this;
        }

        public Criteria andServicerPhoneEqualTo(String value) {
            addCriterion("servicer_phone =", value, "servicerPhone");
            return (Criteria) this;
        }

        public Criteria andServicerPhoneNotEqualTo(String value) {
            addCriterion("servicer_phone <>", value, "servicerPhone");
            return (Criteria) this;
        }

        public Criteria andServicerPhoneGreaterThan(String value) {
            addCriterion("servicer_phone >", value, "servicerPhone");
            return (Criteria) this;
        }

        public Criteria andServicerPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("servicer_phone >=", value, "servicerPhone");
            return (Criteria) this;
        }

        public Criteria andServicerPhoneLessThan(String value) {
            addCriterion("servicer_phone <", value, "servicerPhone");
            return (Criteria) this;
        }

        public Criteria andServicerPhoneLessThanOrEqualTo(String value) {
            addCriterion("servicer_phone <=", value, "servicerPhone");
            return (Criteria) this;
        }

        public Criteria andServicerPhoneLike(String value) {
            addCriterion("servicer_phone like", value, "servicerPhone");
            return (Criteria) this;
        }

        public Criteria andServicerPhoneNotLike(String value) {
            addCriterion("servicer_phone not like", value, "servicerPhone");
            return (Criteria) this;
        }

        public Criteria andServicerPhoneIn(List<String> values) {
            addCriterion("servicer_phone in", values, "servicerPhone");
            return (Criteria) this;
        }

        public Criteria andServicerPhoneNotIn(List<String> values) {
            addCriterion("servicer_phone not in", values, "servicerPhone");
            return (Criteria) this;
        }

        public Criteria andServicerPhoneBetween(String value1, String value2) {
            addCriterion("servicer_phone between", value1, value2, "servicerPhone");
            return (Criteria) this;
        }

        public Criteria andServicerPhoneNotBetween(String value1, String value2) {
            addCriterion("servicer_phone not between", value1, value2, "servicerPhone");
            return (Criteria) this;
        }

        public Criteria andServicerImgIsNull() {
            addCriterion("servicer_img is null");
            return (Criteria) this;
        }

        public Criteria andServicerImgIsNotNull() {
            addCriterion("servicer_img is not null");
            return (Criteria) this;
        }

        public Criteria andServicerImgEqualTo(String value) {
            addCriterion("servicer_img =", value, "servicerImg");
            return (Criteria) this;
        }

        public Criteria andServicerImgNotEqualTo(String value) {
            addCriterion("servicer_img <>", value, "servicerImg");
            return (Criteria) this;
        }

        public Criteria andServicerImgGreaterThan(String value) {
            addCriterion("servicer_img >", value, "servicerImg");
            return (Criteria) this;
        }

        public Criteria andServicerImgGreaterThanOrEqualTo(String value) {
            addCriterion("servicer_img >=", value, "servicerImg");
            return (Criteria) this;
        }

        public Criteria andServicerImgLessThan(String value) {
            addCriterion("servicer_img <", value, "servicerImg");
            return (Criteria) this;
        }

        public Criteria andServicerImgLessThanOrEqualTo(String value) {
            addCriterion("servicer_img <=", value, "servicerImg");
            return (Criteria) this;
        }

        public Criteria andServicerImgLike(String value) {
            addCriterion("servicer_img like", value, "servicerImg");
            return (Criteria) this;
        }

        public Criteria andServicerImgNotLike(String value) {
            addCriterion("servicer_img not like", value, "servicerImg");
            return (Criteria) this;
        }

        public Criteria andServicerImgIn(List<String> values) {
            addCriterion("servicer_img in", values, "servicerImg");
            return (Criteria) this;
        }

        public Criteria andServicerImgNotIn(List<String> values) {
            addCriterion("servicer_img not in", values, "servicerImg");
            return (Criteria) this;
        }

        public Criteria andServicerImgBetween(String value1, String value2) {
            addCriterion("servicer_img between", value1, value2, "servicerImg");
            return (Criteria) this;
        }

        public Criteria andServicerImgNotBetween(String value1, String value2) {
            addCriterion("servicer_img not between", value1, value2, "servicerImg");
            return (Criteria) this;
        }

        public Criteria andServicerExperienceIsNull() {
            addCriterion("servicer_experience is null");
            return (Criteria) this;
        }

        public Criteria andServicerExperienceIsNotNull() {
            addCriterion("servicer_experience is not null");
            return (Criteria) this;
        }

        public Criteria andServicerExperienceEqualTo(Integer value) {
            addCriterion("servicer_experience =", value, "servicerExperience");
            return (Criteria) this;
        }

        public Criteria andServicerExperienceNotEqualTo(Integer value) {
            addCriterion("servicer_experience <>", value, "servicerExperience");
            return (Criteria) this;
        }

        public Criteria andServicerExperienceGreaterThan(Integer value) {
            addCriterion("servicer_experience >", value, "servicerExperience");
            return (Criteria) this;
        }

        public Criteria andServicerExperienceGreaterThanOrEqualTo(Integer value) {
            addCriterion("servicer_experience >=", value, "servicerExperience");
            return (Criteria) this;
        }

        public Criteria andServicerExperienceLessThan(Integer value) {
            addCriterion("servicer_experience <", value, "servicerExperience");
            return (Criteria) this;
        }

        public Criteria andServicerExperienceLessThanOrEqualTo(Integer value) {
            addCriterion("servicer_experience <=", value, "servicerExperience");
            return (Criteria) this;
        }

        public Criteria andServicerExperienceIn(List<Integer> values) {
            addCriterion("servicer_experience in", values, "servicerExperience");
            return (Criteria) this;
        }

        public Criteria andServicerExperienceNotIn(List<Integer> values) {
            addCriterion("servicer_experience not in", values, "servicerExperience");
            return (Criteria) this;
        }

        public Criteria andServicerExperienceBetween(Integer value1, Integer value2) {
            addCriterion("servicer_experience between", value1, value2, "servicerExperience");
            return (Criteria) this;
        }

        public Criteria andServicerExperienceNotBetween(Integer value1, Integer value2) {
            addCriterion("servicer_experience not between", value1, value2, "servicerExperience");
            return (Criteria) this;
        }

        public Criteria andServicerScoreIsNull() {
            addCriterion("servicer_score is null");
            return (Criteria) this;
        }

        public Criteria andServicerScoreIsNotNull() {
            addCriterion("servicer_score is not null");
            return (Criteria) this;
        }

        public Criteria andServicerScoreEqualTo(Integer value) {
            addCriterion("servicer_score =", value, "servicerScore");
            return (Criteria) this;
        }

        public Criteria andServicerScoreNotEqualTo(Integer value) {
            addCriterion("servicer_score <>", value, "servicerScore");
            return (Criteria) this;
        }

        public Criteria andServicerScoreGreaterThan(Integer value) {
            addCriterion("servicer_score >", value, "servicerScore");
            return (Criteria) this;
        }

        public Criteria andServicerScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("servicer_score >=", value, "servicerScore");
            return (Criteria) this;
        }

        public Criteria andServicerScoreLessThan(Integer value) {
            addCriterion("servicer_score <", value, "servicerScore");
            return (Criteria) this;
        }

        public Criteria andServicerScoreLessThanOrEqualTo(Integer value) {
            addCriterion("servicer_score <=", value, "servicerScore");
            return (Criteria) this;
        }

        public Criteria andServicerScoreIn(List<Integer> values) {
            addCriterion("servicer_score in", values, "servicerScore");
            return (Criteria) this;
        }

        public Criteria andServicerScoreNotIn(List<Integer> values) {
            addCriterion("servicer_score not in", values, "servicerScore");
            return (Criteria) this;
        }

        public Criteria andServicerScoreBetween(Integer value1, Integer value2) {
            addCriterion("servicer_score between", value1, value2, "servicerScore");
            return (Criteria) this;
        }

        public Criteria andServicerScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("servicer_score not between", value1, value2, "servicerScore");
            return (Criteria) this;
        }

        public Criteria andServicerPriceIsNull() {
            addCriterion("servicer_price is null");
            return (Criteria) this;
        }

        public Criteria andServicerPriceIsNotNull() {
            addCriterion("servicer_price is not null");
            return (Criteria) this;
        }

        public Criteria andServicerPriceEqualTo(String value) {
            addCriterion("servicer_price =", value, "servicerPrice");
            return (Criteria) this;
        }

        public Criteria andServicerPriceNotEqualTo(String value) {
            addCriterion("servicer_price <>", value, "servicerPrice");
            return (Criteria) this;
        }

        public Criteria andServicerPriceGreaterThan(String value) {
            addCriterion("servicer_price >", value, "servicerPrice");
            return (Criteria) this;
        }

        public Criteria andServicerPriceGreaterThanOrEqualTo(String value) {
            addCriterion("servicer_price >=", value, "servicerPrice");
            return (Criteria) this;
        }

        public Criteria andServicerPriceLessThan(String value) {
            addCriterion("servicer_price <", value, "servicerPrice");
            return (Criteria) this;
        }

        public Criteria andServicerPriceLessThanOrEqualTo(String value) {
            addCriterion("servicer_price <=", value, "servicerPrice");
            return (Criteria) this;
        }

        public Criteria andServicerPriceLike(String value) {
            addCriterion("servicer_price like", value, "servicerPrice");
            return (Criteria) this;
        }

        public Criteria andServicerPriceNotLike(String value) {
            addCriterion("servicer_price not like", value, "servicerPrice");
            return (Criteria) this;
        }

        public Criteria andServicerPriceIn(List<String> values) {
            addCriterion("servicer_price in", values, "servicerPrice");
            return (Criteria) this;
        }

        public Criteria andServicerPriceNotIn(List<String> values) {
            addCriterion("servicer_price not in", values, "servicerPrice");
            return (Criteria) this;
        }

        public Criteria andServicerPriceBetween(String value1, String value2) {
            addCriterion("servicer_price between", value1, value2, "servicerPrice");
            return (Criteria) this;
        }

        public Criteria andServicerPriceNotBetween(String value1, String value2) {
            addCriterion("servicer_price not between", value1, value2, "servicerPrice");
            return (Criteria) this;
        }

        public Criteria andServicerDesIsNull() {
            addCriterion("servicer_des is null");
            return (Criteria) this;
        }

        public Criteria andServicerDesIsNotNull() {
            addCriterion("servicer_des is not null");
            return (Criteria) this;
        }

        public Criteria andServicerDesEqualTo(String value) {
            addCriterion("servicer_des =", value, "servicerDes");
            return (Criteria) this;
        }

        public Criteria andServicerDesNotEqualTo(String value) {
            addCriterion("servicer_des <>", value, "servicerDes");
            return (Criteria) this;
        }

        public Criteria andServicerDesGreaterThan(String value) {
            addCriterion("servicer_des >", value, "servicerDes");
            return (Criteria) this;
        }

        public Criteria andServicerDesGreaterThanOrEqualTo(String value) {
            addCriterion("servicer_des >=", value, "servicerDes");
            return (Criteria) this;
        }

        public Criteria andServicerDesLessThan(String value) {
            addCriterion("servicer_des <", value, "servicerDes");
            return (Criteria) this;
        }

        public Criteria andServicerDesLessThanOrEqualTo(String value) {
            addCriterion("servicer_des <=", value, "servicerDes");
            return (Criteria) this;
        }

        public Criteria andServicerDesLike(String value) {
            addCriterion("servicer_des like", value, "servicerDes");
            return (Criteria) this;
        }

        public Criteria andServicerDesNotLike(String value) {
            addCriterion("servicer_des not like", value, "servicerDes");
            return (Criteria) this;
        }

        public Criteria andServicerDesIn(List<String> values) {
            addCriterion("servicer_des in", values, "servicerDes");
            return (Criteria) this;
        }

        public Criteria andServicerDesNotIn(List<String> values) {
            addCriterion("servicer_des not in", values, "servicerDes");
            return (Criteria) this;
        }

        public Criteria andServicerDesBetween(String value1, String value2) {
            addCriterion("servicer_des between", value1, value2, "servicerDes");
            return (Criteria) this;
        }

        public Criteria andServicerDesNotBetween(String value1, String value2) {
            addCriterion("servicer_des not between", value1, value2, "servicerDes");
            return (Criteria) this;
        }

        public Criteria andServicerFileIsNull() {
            addCriterion("servicer_file is null");
            return (Criteria) this;
        }

        public Criteria andServicerFileIsNotNull() {
            addCriterion("servicer_file is not null");
            return (Criteria) this;
        }

        public Criteria andServicerFileEqualTo(String value) {
            addCriterion("servicer_file =", value, "servicerFile");
            return (Criteria) this;
        }

        public Criteria andServicerFileNotEqualTo(String value) {
            addCriterion("servicer_file <>", value, "servicerFile");
            return (Criteria) this;
        }

        public Criteria andServicerFileGreaterThan(String value) {
            addCriterion("servicer_file >", value, "servicerFile");
            return (Criteria) this;
        }

        public Criteria andServicerFileGreaterThanOrEqualTo(String value) {
            addCriterion("servicer_file >=", value, "servicerFile");
            return (Criteria) this;
        }

        public Criteria andServicerFileLessThan(String value) {
            addCriterion("servicer_file <", value, "servicerFile");
            return (Criteria) this;
        }

        public Criteria andServicerFileLessThanOrEqualTo(String value) {
            addCriterion("servicer_file <=", value, "servicerFile");
            return (Criteria) this;
        }

        public Criteria andServicerFileLike(String value) {
            addCriterion("servicer_file like", value, "servicerFile");
            return (Criteria) this;
        }

        public Criteria andServicerFileNotLike(String value) {
            addCriterion("servicer_file not like", value, "servicerFile");
            return (Criteria) this;
        }

        public Criteria andServicerFileIn(List<String> values) {
            addCriterion("servicer_file in", values, "servicerFile");
            return (Criteria) this;
        }

        public Criteria andServicerFileNotIn(List<String> values) {
            addCriterion("servicer_file not in", values, "servicerFile");
            return (Criteria) this;
        }

        public Criteria andServicerFileBetween(String value1, String value2) {
            addCriterion("servicer_file between", value1, value2, "servicerFile");
            return (Criteria) this;
        }

        public Criteria andServicerFileNotBetween(String value1, String value2) {
            addCriterion("servicer_file not between", value1, value2, "servicerFile");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNull() {
            addCriterion("city_id is null");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNotNull() {
            addCriterion("city_id is not null");
            return (Criteria) this;
        }

        public Criteria andCityIdEqualTo(Integer value) {
            addCriterion("city_id =", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotEqualTo(Integer value) {
            addCriterion("city_id <>", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThan(Integer value) {
            addCriterion("city_id >", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("city_id >=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThan(Integer value) {
            addCriterion("city_id <", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThanOrEqualTo(Integer value) {
            addCriterion("city_id <=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdIn(List<Integer> values) {
            addCriterion("city_id in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotIn(List<Integer> values) {
            addCriterion("city_id not in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdBetween(Integer value1, Integer value2) {
            addCriterion("city_id between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("city_id not between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andLocalIdIsNull() {
            addCriterion("local_id is null");
            return (Criteria) this;
        }

        public Criteria andLocalIdIsNotNull() {
            addCriterion("local_id is not null");
            return (Criteria) this;
        }

        public Criteria andLocalIdEqualTo(Integer value) {
            addCriterion("local_id =", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdNotEqualTo(Integer value) {
            addCriterion("local_id <>", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdGreaterThan(Integer value) {
            addCriterion("local_id >", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("local_id >=", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdLessThan(Integer value) {
            addCriterion("local_id <", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdLessThanOrEqualTo(Integer value) {
            addCriterion("local_id <=", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdIn(List<Integer> values) {
            addCriterion("local_id in", values, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdNotIn(List<Integer> values) {
            addCriterion("local_id not in", values, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdBetween(Integer value1, Integer value2) {
            addCriterion("local_id between", value1, value2, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdNotBetween(Integer value1, Integer value2) {
            addCriterion("local_id not between", value1, value2, "localId");
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

        public Criteria andCheckStatusIsNull() {
            addCriterion("check_status is null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNotNull() {
            addCriterion("check_status is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusEqualTo(Integer value) {
            addCriterion("check_status =", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotEqualTo(Integer value) {
            addCriterion("check_status <>", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThan(Integer value) {
            addCriterion("check_status >", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("check_status >=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThan(Integer value) {
            addCriterion("check_status <", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThanOrEqualTo(Integer value) {
            addCriterion("check_status <=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIn(List<Integer> values) {
            addCriterion("check_status in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotIn(List<Integer> values) {
            addCriterion("check_status not in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusBetween(Integer value1, Integer value2) {
            addCriterion("check_status between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("check_status not between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andAccountNameIsNull() {
            addCriterion("account_name is null");
            return (Criteria) this;
        }

        public Criteria andAccountNameIsNotNull() {
            addCriterion("account_name is not null");
            return (Criteria) this;
        }

        public Criteria andAccountNameEqualTo(String value) {
            addCriterion("account_name =", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotEqualTo(String value) {
            addCriterion("account_name <>", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameGreaterThan(String value) {
            addCriterion("account_name >", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameGreaterThanOrEqualTo(String value) {
            addCriterion("account_name >=", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLessThan(String value) {
            addCriterion("account_name <", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLessThanOrEqualTo(String value) {
            addCriterion("account_name <=", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLike(String value) {
            addCriterion("account_name like", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotLike(String value) {
            addCriterion("account_name not like", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameIn(List<String> values) {
            addCriterion("account_name in", values, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotIn(List<String> values) {
            addCriterion("account_name not in", values, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameBetween(String value1, String value2) {
            addCriterion("account_name between", value1, value2, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotBetween(String value1, String value2) {
            addCriterion("account_name not between", value1, value2, "accountName");
            return (Criteria) this;
        }

        public Criteria andPassWordIsNull() {
            addCriterion("pass_word is null");
            return (Criteria) this;
        }

        public Criteria andPassWordIsNotNull() {
            addCriterion("pass_word is not null");
            return (Criteria) this;
        }

        public Criteria andPassWordEqualTo(String value) {
            addCriterion("pass_word =", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotEqualTo(String value) {
            addCriterion("pass_word <>", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordGreaterThan(String value) {
            addCriterion("pass_word >", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordGreaterThanOrEqualTo(String value) {
            addCriterion("pass_word >=", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordLessThan(String value) {
            addCriterion("pass_word <", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordLessThanOrEqualTo(String value) {
            addCriterion("pass_word <=", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordLike(String value) {
            addCriterion("pass_word like", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotLike(String value) {
            addCriterion("pass_word not like", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordIn(List<String> values) {
            addCriterion("pass_word in", values, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotIn(List<String> values) {
            addCriterion("pass_word not in", values, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordBetween(String value1, String value2) {
            addCriterion("pass_word between", value1, value2, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotBetween(String value1, String value2) {
            addCriterion("pass_word not between", value1, value2, "passWord");
            return (Criteria) this;
        }

        public Criteria andDegreeIdIsNull() {
            addCriterion("degree_id is null");
            return (Criteria) this;
        }

        public Criteria andDegreeIdIsNotNull() {
            addCriterion("degree_id is not null");
            return (Criteria) this;
        }

        public Criteria andDegreeIdEqualTo(Integer value) {
            addCriterion("degree_id =", value, "degreeId");
            return (Criteria) this;
        }

        public Criteria andDegreeIdNotEqualTo(Integer value) {
            addCriterion("degree_id <>", value, "degreeId");
            return (Criteria) this;
        }

        public Criteria andDegreeIdGreaterThan(Integer value) {
            addCriterion("degree_id >", value, "degreeId");
            return (Criteria) this;
        }

        public Criteria andDegreeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("degree_id >=", value, "degreeId");
            return (Criteria) this;
        }

        public Criteria andDegreeIdLessThan(Integer value) {
            addCriterion("degree_id <", value, "degreeId");
            return (Criteria) this;
        }

        public Criteria andDegreeIdLessThanOrEqualTo(Integer value) {
            addCriterion("degree_id <=", value, "degreeId");
            return (Criteria) this;
        }

        public Criteria andDegreeIdIn(List<Integer> values) {
            addCriterion("degree_id in", values, "degreeId");
            return (Criteria) this;
        }

        public Criteria andDegreeIdNotIn(List<Integer> values) {
            addCriterion("degree_id not in", values, "degreeId");
            return (Criteria) this;
        }

        public Criteria andDegreeIdBetween(Integer value1, Integer value2) {
            addCriterion("degree_id between", value1, value2, "degreeId");
            return (Criteria) this;
        }

        public Criteria andDegreeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("degree_id not between", value1, value2, "degreeId");
            return (Criteria) this;
        }

        public Criteria andServicetypeIdIsNull() {
            addCriterion("servicetype_id is null");
            return (Criteria) this;
        }

        public Criteria andServicetypeIdIsNotNull() {
            addCriterion("servicetype_id is not null");
            return (Criteria) this;
        }

        public Criteria andServicetypeIdEqualTo(Integer value) {
            addCriterion("servicetype_id =", value, "servicetypeId");
            return (Criteria) this;
        }

        public Criteria andServicetypeIdNotEqualTo(Integer value) {
            addCriterion("servicetype_id <>", value, "servicetypeId");
            return (Criteria) this;
        }

        public Criteria andServicetypeIdGreaterThan(Integer value) {
            addCriterion("servicetype_id >", value, "servicetypeId");
            return (Criteria) this;
        }

        public Criteria andServicetypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("servicetype_id >=", value, "servicetypeId");
            return (Criteria) this;
        }

        public Criteria andServicetypeIdLessThan(Integer value) {
            addCriterion("servicetype_id <", value, "servicetypeId");
            return (Criteria) this;
        }

        public Criteria andServicetypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("servicetype_id <=", value, "servicetypeId");
            return (Criteria) this;
        }

        public Criteria andServicetypeIdIn(List<Integer> values) {
            addCriterion("servicetype_id in", values, "servicetypeId");
            return (Criteria) this;
        }

        public Criteria andServicetypeIdNotIn(List<Integer> values) {
            addCriterion("servicetype_id not in", values, "servicetypeId");
            return (Criteria) this;
        }

        public Criteria andServicetypeIdBetween(Integer value1, Integer value2) {
            addCriterion("servicetype_id between", value1, value2, "servicetypeId");
            return (Criteria) this;
        }

        public Criteria andServicetypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("servicetype_id not between", value1, value2, "servicetypeId");
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