package com.wwl.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BillsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BillsExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andBillsidIsNull() {
            addCriterion("billsId is null");
            return (Criteria) this;
        }

        public Criteria andBillsidIsNotNull() {
            addCriterion("billsId is not null");
            return (Criteria) this;
        }

        public Criteria andBillsidEqualTo(Integer value) {
            addCriterion("billsId =", value, "billsid");
            return (Criteria) this;
        }

        public Criteria andBillsidNotEqualTo(Integer value) {
            addCriterion("billsId <>", value, "billsid");
            return (Criteria) this;
        }

        public Criteria andBillsidGreaterThan(Integer value) {
            addCriterion("billsId >", value, "billsid");
            return (Criteria) this;
        }

        public Criteria andBillsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("billsId >=", value, "billsid");
            return (Criteria) this;
        }

        public Criteria andBillsidLessThan(Integer value) {
            addCriterion("billsId <", value, "billsid");
            return (Criteria) this;
        }

        public Criteria andBillsidLessThanOrEqualTo(Integer value) {
            addCriterion("billsId <=", value, "billsid");
            return (Criteria) this;
        }

        public Criteria andBillsidIn(List<Integer> values) {
            addCriterion("billsId in", values, "billsid");
            return (Criteria) this;
        }

        public Criteria andBillsidNotIn(List<Integer> values) {
            addCriterion("billsId not in", values, "billsid");
            return (Criteria) this;
        }

        public Criteria andBillsidBetween(Integer value1, Integer value2) {
            addCriterion("billsId between", value1, value2, "billsid");
            return (Criteria) this;
        }

        public Criteria andBillsidNotBetween(Integer value1, Integer value2) {
            addCriterion("billsId not between", value1, value2, "billsid");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterionForJDBCDate("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterionForJDBCDate("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterionForJDBCDate("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterionForJDBCDate("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andLifegoodsIsNull() {
            addCriterion("lifeGoods is null");
            return (Criteria) this;
        }

        public Criteria andLifegoodsIsNotNull() {
            addCriterion("lifeGoods is not null");
            return (Criteria) this;
        }

        public Criteria andLifegoodsEqualTo(Float value) {
            addCriterion("lifeGoods =", value, "lifegoods");
            return (Criteria) this;
        }

        public Criteria andLifegoodsNotEqualTo(Float value) {
            addCriterion("lifeGoods <>", value, "lifegoods");
            return (Criteria) this;
        }

        public Criteria andLifegoodsGreaterThan(Float value) {
            addCriterion("lifeGoods >", value, "lifegoods");
            return (Criteria) this;
        }

        public Criteria andLifegoodsGreaterThanOrEqualTo(Float value) {
            addCriterion("lifeGoods >=", value, "lifegoods");
            return (Criteria) this;
        }

        public Criteria andLifegoodsLessThan(Float value) {
            addCriterion("lifeGoods <", value, "lifegoods");
            return (Criteria) this;
        }

        public Criteria andLifegoodsLessThanOrEqualTo(Float value) {
            addCriterion("lifeGoods <=", value, "lifegoods");
            return (Criteria) this;
        }

        public Criteria andLifegoodsIn(List<Float> values) {
            addCriterion("lifeGoods in", values, "lifegoods");
            return (Criteria) this;
        }

        public Criteria andLifegoodsNotIn(List<Float> values) {
            addCriterion("lifeGoods not in", values, "lifegoods");
            return (Criteria) this;
        }

        public Criteria andLifegoodsBetween(Float value1, Float value2) {
            addCriterion("lifeGoods between", value1, value2, "lifegoods");
            return (Criteria) this;
        }

        public Criteria andLifegoodsNotBetween(Float value1, Float value2) {
            addCriterion("lifeGoods not between", value1, value2, "lifegoods");
            return (Criteria) this;
        }

        public Criteria andWaterbillIsNull() {
            addCriterion("waterBill is null");
            return (Criteria) this;
        }

        public Criteria andWaterbillIsNotNull() {
            addCriterion("waterBill is not null");
            return (Criteria) this;
        }

        public Criteria andWaterbillEqualTo(Float value) {
            addCriterion("waterBill =", value, "waterbill");
            return (Criteria) this;
        }

        public Criteria andWaterbillNotEqualTo(Float value) {
            addCriterion("waterBill <>", value, "waterbill");
            return (Criteria) this;
        }

        public Criteria andWaterbillGreaterThan(Float value) {
            addCriterion("waterBill >", value, "waterbill");
            return (Criteria) this;
        }

        public Criteria andWaterbillGreaterThanOrEqualTo(Float value) {
            addCriterion("waterBill >=", value, "waterbill");
            return (Criteria) this;
        }

        public Criteria andWaterbillLessThan(Float value) {
            addCriterion("waterBill <", value, "waterbill");
            return (Criteria) this;
        }

        public Criteria andWaterbillLessThanOrEqualTo(Float value) {
            addCriterion("waterBill <=", value, "waterbill");
            return (Criteria) this;
        }

        public Criteria andWaterbillIn(List<Float> values) {
            addCriterion("waterBill in", values, "waterbill");
            return (Criteria) this;
        }

        public Criteria andWaterbillNotIn(List<Float> values) {
            addCriterion("waterBill not in", values, "waterbill");
            return (Criteria) this;
        }

        public Criteria andWaterbillBetween(Float value1, Float value2) {
            addCriterion("waterBill between", value1, value2, "waterbill");
            return (Criteria) this;
        }

        public Criteria andWaterbillNotBetween(Float value1, Float value2) {
            addCriterion("waterBill not between", value1, value2, "waterbill");
            return (Criteria) this;
        }

        public Criteria andElectricitybillIsNull() {
            addCriterion("electricityBill is null");
            return (Criteria) this;
        }

        public Criteria andElectricitybillIsNotNull() {
            addCriterion("electricityBill is not null");
            return (Criteria) this;
        }

        public Criteria andElectricitybillEqualTo(Float value) {
            addCriterion("electricityBill =", value, "electricitybill");
            return (Criteria) this;
        }

        public Criteria andElectricitybillNotEqualTo(Float value) {
            addCriterion("electricityBill <>", value, "electricitybill");
            return (Criteria) this;
        }

        public Criteria andElectricitybillGreaterThan(Float value) {
            addCriterion("electricityBill >", value, "electricitybill");
            return (Criteria) this;
        }

        public Criteria andElectricitybillGreaterThanOrEqualTo(Float value) {
            addCriterion("electricityBill >=", value, "electricitybill");
            return (Criteria) this;
        }

        public Criteria andElectricitybillLessThan(Float value) {
            addCriterion("electricityBill <", value, "electricitybill");
            return (Criteria) this;
        }

        public Criteria andElectricitybillLessThanOrEqualTo(Float value) {
            addCriterion("electricityBill <=", value, "electricitybill");
            return (Criteria) this;
        }

        public Criteria andElectricitybillIn(List<Float> values) {
            addCriterion("electricityBill in", values, "electricitybill");
            return (Criteria) this;
        }

        public Criteria andElectricitybillNotIn(List<Float> values) {
            addCriterion("electricityBill not in", values, "electricitybill");
            return (Criteria) this;
        }

        public Criteria andElectricitybillBetween(Float value1, Float value2) {
            addCriterion("electricityBill between", value1, value2, "electricitybill");
            return (Criteria) this;
        }

        public Criteria andElectricitybillNotBetween(Float value1, Float value2) {
            addCriterion("electricityBill not between", value1, value2, "electricitybill");
            return (Criteria) this;
        }

        public Criteria andCoalbillIsNull() {
            addCriterion("coalBill is null");
            return (Criteria) this;
        }

        public Criteria andCoalbillIsNotNull() {
            addCriterion("coalBill is not null");
            return (Criteria) this;
        }

        public Criteria andCoalbillEqualTo(Float value) {
            addCriterion("coalBill =", value, "coalbill");
            return (Criteria) this;
        }

        public Criteria andCoalbillNotEqualTo(Float value) {
            addCriterion("coalBill <>", value, "coalbill");
            return (Criteria) this;
        }

        public Criteria andCoalbillGreaterThan(Float value) {
            addCriterion("coalBill >", value, "coalbill");
            return (Criteria) this;
        }

        public Criteria andCoalbillGreaterThanOrEqualTo(Float value) {
            addCriterion("coalBill >=", value, "coalbill");
            return (Criteria) this;
        }

        public Criteria andCoalbillLessThan(Float value) {
            addCriterion("coalBill <", value, "coalbill");
            return (Criteria) this;
        }

        public Criteria andCoalbillLessThanOrEqualTo(Float value) {
            addCriterion("coalBill <=", value, "coalbill");
            return (Criteria) this;
        }

        public Criteria andCoalbillIn(List<Float> values) {
            addCriterion("coalBill in", values, "coalbill");
            return (Criteria) this;
        }

        public Criteria andCoalbillNotIn(List<Float> values) {
            addCriterion("coalBill not in", values, "coalbill");
            return (Criteria) this;
        }

        public Criteria andCoalbillBetween(Float value1, Float value2) {
            addCriterion("coalBill between", value1, value2, "coalbill");
            return (Criteria) this;
        }

        public Criteria andCoalbillNotBetween(Float value1, Float value2) {
            addCriterion("coalBill not between", value1, value2, "coalbill");
            return (Criteria) this;
        }

        public Criteria andShoppingonlineIsNull() {
            addCriterion("shoppingOnline is null");
            return (Criteria) this;
        }

        public Criteria andShoppingonlineIsNotNull() {
            addCriterion("shoppingOnline is not null");
            return (Criteria) this;
        }

        public Criteria andShoppingonlineEqualTo(Float value) {
            addCriterion("shoppingOnline =", value, "shoppingonline");
            return (Criteria) this;
        }

        public Criteria andShoppingonlineNotEqualTo(Float value) {
            addCriterion("shoppingOnline <>", value, "shoppingonline");
            return (Criteria) this;
        }

        public Criteria andShoppingonlineGreaterThan(Float value) {
            addCriterion("shoppingOnline >", value, "shoppingonline");
            return (Criteria) this;
        }

        public Criteria andShoppingonlineGreaterThanOrEqualTo(Float value) {
            addCriterion("shoppingOnline >=", value, "shoppingonline");
            return (Criteria) this;
        }

        public Criteria andShoppingonlineLessThan(Float value) {
            addCriterion("shoppingOnline <", value, "shoppingonline");
            return (Criteria) this;
        }

        public Criteria andShoppingonlineLessThanOrEqualTo(Float value) {
            addCriterion("shoppingOnline <=", value, "shoppingonline");
            return (Criteria) this;
        }

        public Criteria andShoppingonlineIn(List<Float> values) {
            addCriterion("shoppingOnline in", values, "shoppingonline");
            return (Criteria) this;
        }

        public Criteria andShoppingonlineNotIn(List<Float> values) {
            addCriterion("shoppingOnline not in", values, "shoppingonline");
            return (Criteria) this;
        }

        public Criteria andShoppingonlineBetween(Float value1, Float value2) {
            addCriterion("shoppingOnline between", value1, value2, "shoppingonline");
            return (Criteria) this;
        }

        public Criteria andShoppingonlineNotBetween(Float value1, Float value2) {
            addCriterion("shoppingOnline not between", value1, value2, "shoppingonline");
            return (Criteria) this;
        }

        public Criteria andOtherIsNull() {
            addCriterion("other is null");
            return (Criteria) this;
        }

        public Criteria andOtherIsNotNull() {
            addCriterion("other is not null");
            return (Criteria) this;
        }

        public Criteria andOtherEqualTo(Float value) {
            addCriterion("other =", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotEqualTo(Float value) {
            addCriterion("other <>", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThan(Float value) {
            addCriterion("other >", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThanOrEqualTo(Float value) {
            addCriterion("other >=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThan(Float value) {
            addCriterion("other <", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThanOrEqualTo(Float value) {
            addCriterion("other <=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherIn(List<Float> values) {
            addCriterion("other in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotIn(List<Float> values) {
            addCriterion("other not in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherBetween(Float value1, Float value2) {
            addCriterion("other between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotBetween(Float value1, Float value2) {
            addCriterion("other not between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andModifiedIsNull() {
            addCriterion("Modified is null");
            return (Criteria) this;
        }

        public Criteria andModifiedIsNotNull() {
            addCriterion("Modified is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedEqualTo(String value) {
            addCriterion("Modified =", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedNotEqualTo(String value) {
            addCriterion("Modified <>", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedGreaterThan(String value) {
            addCriterion("Modified >", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedGreaterThanOrEqualTo(String value) {
            addCriterion("Modified >=", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedLessThan(String value) {
            addCriterion("Modified <", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedLessThanOrEqualTo(String value) {
            addCriterion("Modified <=", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedLike(String value) {
            addCriterion("Modified like", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedNotLike(String value) {
            addCriterion("Modified not like", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedIn(List<String> values) {
            addCriterion("Modified in", values, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedNotIn(List<String> values) {
            addCriterion("Modified not in", values, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedBetween(String value1, String value2) {
            addCriterion("Modified between", value1, value2, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedNotBetween(String value1, String value2) {
            addCriterion("Modified not between", value1, value2, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeIsNull() {
            addCriterion("ModifiedTime is null");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeIsNotNull() {
            addCriterion("ModifiedTime is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeEqualTo(Date value) {
            addCriterion("ModifiedTime =", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeNotEqualTo(Date value) {
            addCriterion("ModifiedTime <>", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeGreaterThan(Date value) {
            addCriterion("ModifiedTime >", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ModifiedTime >=", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeLessThan(Date value) {
            addCriterion("ModifiedTime <", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeLessThanOrEqualTo(Date value) {
            addCriterion("ModifiedTime <=", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeIn(List<Date> values) {
            addCriterion("ModifiedTime in", values, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeNotIn(List<Date> values) {
            addCriterion("ModifiedTime not in", values, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeBetween(Date value1, Date value2) {
            addCriterion("ModifiedTime between", value1, value2, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeNotBetween(Date value1, Date value2) {
            addCriterion("ModifiedTime not between", value1, value2, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCteatortimeIsNull() {
            addCriterion("cteatorTime is null");
            return (Criteria) this;
        }

        public Criteria andCteatortimeIsNotNull() {
            addCriterion("cteatorTime is not null");
            return (Criteria) this;
        }

        public Criteria andCteatortimeEqualTo(Date value) {
            addCriterion("cteatorTime =", value, "cteatortime");
            return (Criteria) this;
        }

        public Criteria andCteatortimeNotEqualTo(Date value) {
            addCriterion("cteatorTime <>", value, "cteatortime");
            return (Criteria) this;
        }

        public Criteria andCteatortimeGreaterThan(Date value) {
            addCriterion("cteatorTime >", value, "cteatortime");
            return (Criteria) this;
        }

        public Criteria andCteatortimeGreaterThanOrEqualTo(Date value) {
            addCriterion("cteatorTime >=", value, "cteatortime");
            return (Criteria) this;
        }

        public Criteria andCteatortimeLessThan(Date value) {
            addCriterion("cteatorTime <", value, "cteatortime");
            return (Criteria) this;
        }

        public Criteria andCteatortimeLessThanOrEqualTo(Date value) {
            addCriterion("cteatorTime <=", value, "cteatortime");
            return (Criteria) this;
        }

        public Criteria andCteatortimeIn(List<Date> values) {
            addCriterion("cteatorTime in", values, "cteatortime");
            return (Criteria) this;
        }

        public Criteria andCteatortimeNotIn(List<Date> values) {
            addCriterion("cteatorTime not in", values, "cteatortime");
            return (Criteria) this;
        }

        public Criteria andCteatortimeBetween(Date value1, Date value2) {
            addCriterion("cteatorTime between", value1, value2, "cteatortime");
            return (Criteria) this;
        }

        public Criteria andCteatortimeNotBetween(Date value1, Date value2) {
            addCriterion("cteatorTime not between", value1, value2, "cteatortime");
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