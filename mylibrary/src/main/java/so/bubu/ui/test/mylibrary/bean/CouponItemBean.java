package so.bubu.ui.test.mylibrary.bean;

import java.util.List;

/**
 * Created by zhengheng on 17/12/25.
 */
public class CouponItemBean {

    private List<ObjectsBean> objects;

    public List<ObjectsBean> getObjects() {
        return objects;
    }

    public void setObjects(List<ObjectsBean> objects) {
        this.objects = objects;
    }

    public static class ObjectsBean {
        /**
         * biz30Day : 37
         * category : 彩妆/香水/美妆工具
         * categoryId : 10
         * commision : 0.75
         * couponAmount : 10
         * couponEffectiveEndTime : 2017-12-30T15:59:59.000Z
         * couponRemain : 10000
         * couponShareUrl : https://uland.taobao.com/coupon/edetail?e=tqIfYdOhq%2BAN%2BoQUE6FNzGPHTcqQ4ufIGZPSe9jdjR088L0dUrFHspPccAg7n0MpqjwLHlkAIdkCVzRffmjsmRpywujSvOp2nUIklpPPqYLEXRJ%2BB1et7NS8cpu%2BWjLoqwE8NLNX5iBD%2FBmXgrUwH%2BYsfTfahS6g&pid=mm_119950409_20916506_70766512&af=1&tj1=1&tj2=1
         * couponTotal : 10000
         * discountPrice : 25
         * displayCategory : 美妆_眼眉妆
         * finalPrice : 15
         * id : 5a2611821579a30062bf77c6
         * isFeatured : true
         * picUrl : http://gd2.alicdn.com/imgextra/i2/1810079026/TB2vMVedZbI8KJjy1zdXXbe1VXa_!!1810079026.jpg
         * pickSubcategory :
         * platform : 淘宝
         * subcategoryId : 12
         * title : 火烈鸟 梦幻卷翘璀璨浓密精细纤长睫毛膏
         */

        private int biz30Day;
        private String category;
        private int categoryId;
        private double commision;
        private int couponAmount;
        private String couponEffectiveEndTime;
        private int couponRemain;
        private String couponShareUrl;
        private int couponTotal;
        private int discountPrice;
        private String displayCategory;
        private int finalPrice;
        private String id;
        private boolean isFeatured;
        private String picUrl;
        private String pickSubcategory;
        private String platform;
        private int subcategoryId;
        private String title;

        public int getBiz30Day() {
            return biz30Day;
        }

        public void setBiz30Day(int biz30Day) {
            this.biz30Day = biz30Day;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public double getCommision() {
            return commision;
        }

        public void setCommision(double commision) {
            this.commision = commision;
        }

        public int getCouponAmount() {
            return couponAmount;
        }

        public void setCouponAmount(int couponAmount) {
            this.couponAmount = couponAmount;
        }

        public String getCouponEffectiveEndTime() {
            return couponEffectiveEndTime;
        }

        public void setCouponEffectiveEndTime(String couponEffectiveEndTime) {
            this.couponEffectiveEndTime = couponEffectiveEndTime;
        }

        public int getCouponRemain() {
            return couponRemain;
        }

        public void setCouponRemain(int couponRemain) {
            this.couponRemain = couponRemain;
        }

        public String getCouponShareUrl() {
            return couponShareUrl;
        }

        public void setCouponShareUrl(String couponShareUrl) {
            this.couponShareUrl = couponShareUrl;
        }

        public int getCouponTotal() {
            return couponTotal;
        }

        public void setCouponTotal(int couponTotal) {
            this.couponTotal = couponTotal;
        }

        public int getDiscountPrice() {
            return discountPrice;
        }

        public void setDiscountPrice(int discountPrice) {
            this.discountPrice = discountPrice;
        }

        public String getDisplayCategory() {
            return displayCategory;
        }

        public void setDisplayCategory(String displayCategory) {
            this.displayCategory = displayCategory;
        }

        public int getFinalPrice() {
            return finalPrice;
        }

        public void setFinalPrice(int finalPrice) {
            this.finalPrice = finalPrice;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public boolean isIsFeatured() {
            return isFeatured;
        }

        public void setIsFeatured(boolean isFeatured) {
            this.isFeatured = isFeatured;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getPickSubcategory() {
            return pickSubcategory;
        }

        public void setPickSubcategory(String pickSubcategory) {
            this.pickSubcategory = pickSubcategory;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public int getSubcategoryId() {
            return subcategoryId;
        }

        public void setSubcategoryId(int subcategoryId) {
            this.subcategoryId = subcategoryId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}

