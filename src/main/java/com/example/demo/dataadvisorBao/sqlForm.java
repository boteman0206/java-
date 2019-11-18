//package com.marcpoint.modules.dataadvisor.form;
//
//
//import lombok.Data;
//
////@Data
//public class sqlForm {
//    //      公共sql
//    private String lMotherBaby = "l_motherbaby.post"; // 母婴库
//    private String lMedicine = "l_medicine.post_inquiry";  // 医疗库
//    private String weiBo = "nestle.bdl_platform_weibo_blog_daily"; //微博库
//
//    private String noiseUser = "l_motherbaby.user_noise"; //水军库
//
//    private String motherSqlClassify =
//            "JOIN l_motherbaby.user b ON a.platform_id = b.platform_id AND a.user_id=b.user_id " +
//                    "JOIN prod_platform_dim.motherbaby_location c ON concat(b.province,b.city)=c.location " +
//                    "JOIN prod_platform_dim.mplocation d ON c.regionid=d.regionid";
//
//    // 医疗 连接用户表
//    private String tableUserDoc = "join l_medicine.user_doc b on a.user_id=b.user_id";
//    // 连接职称表
//    private String tableTitleName = "join prod_platform_dim.md_jobtitle_middle m on b.user_job_title=m.titleailas";
//
//    //   科室表 2019-11-12 更换科室表
////    private String tableDeparrtMentName = "join prod_platform_dim.md_department_middle_split j on b.user_department=j.departmentalias";
//    private String tableDeparrtMentName = "join prod_platform_dim.userdoc_standard_department j on b.user_id=j.user_id";
//
//    // 连接医院的等级表
//    private String tableHlevel = "join prod_platform_dim.hospital k on b.user_hospital=k.hname";
//
//    //    # 城市等级表  prod_platform_dim.city   城市等级和 citytier   和                 nielsen_citytier 尼尔森城市等级
//    private String tableCityTier =
//            "join prod_platform_dim.hospital k on b.user_hospital=k.hname " +
//                    "join prod_platform_dim.city d on k.cityid=d.cityid";
//
//    //    # 省份表 地域表   省份在functionbase.province    cityregion 这是地域        province 是省份
//    private String tableProvince =
//            "join prod_platform_dim.hospital k on b.user_hospital=k.hname " +
//                    "join prod_platform_dim.city d on k.cityid=d.cityid " +
//                    "join prod_platform_dim.province f on d.proid=f.proid";
//
//    public String getTableUserDoc() {
//        return tableUserDoc;
//    }
//
//    public String getTableTitleName() {
//        return tableTitleName;
//    }
//
//    public String getTableDeparrtMentName() {
//        return tableDeparrtMentName;
//    }
//
//    public String getTableHlevel() {
//        return tableHlevel;
//    }
//
//    public String getTableCityTier() {
//        return tableCityTier;
//    }
//
//    public String getTableProvince() {
//        return tableProvince;
//    }
//
//    public String getlMotherBaby() {
//        return lMotherBaby;
//    }
//
//    public void setlMotherBaby(String lMotherBaby) {
//        this.lMotherBaby = lMotherBaby;
//    }
//
//    public String getlMedicine() {
//        return lMedicine;
//    }
//
//    public void setlMedicine(String lMedicine) {
//        this.lMedicine = lMedicine;
//    }
//
//    public String getWeiBo() {
//        return weiBo;
//    }
//
//    public void setWeiBo(String weiBo) {
//        this.weiBo = weiBo;
//    }
//
//    public String getNoiseUser() {
//        return noiseUser;
//    }
//
//    public void setNoiseUser(String noiseUser) {
//        this.noiseUser = noiseUser;
//    }
//
//    public String getMotherSqlClassify() {
//        return motherSqlClassify;
//    }
//
//    public void setMotherSqlClassify(String motherSqlClassify) {
//        this.motherSqlClassify = motherSqlClassify;
//    }
//}
