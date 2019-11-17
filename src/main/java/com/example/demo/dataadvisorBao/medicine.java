//package com.marcpoint.modules.dataadvisor.controller;
//
//
//import com.marcpoint.common.annotation.SysLog;
//import com.marcpoint.common.utils.R;
//import com.marcpoint.common.utils.RedisUtils;
//import com.marcpoint.modules.dataadvisor.entity.DataAdvisorTemplateEntity;
//import com.marcpoint.modules.dataadvisor.form.CommonParametersForm;
//import com.marcpoint.modules.dataadvisor.form.MedicineForm;
//import com.marcpoint.modules.dataadvisor.form.sqlForm;
//import com.marcpoint.modules.dataadvisor.service.DataAdvisorTemplateService;
//import com.marcpoint.modules.dataadvisor.util.ThreadSearch;
//import com.marcpoint.modules.sys.controller.AbstractController;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.web.bind.annotation.*;
//
//import java.beans.IntrospectionException;
//import java.lang.reflect.InvocationTargetException;
//import java.util.*;
//
//
//@RestController
//@RequestMapping("/api/dataadvisor")
//@Api(value = "/api/dataadvisor", tags = "medicine", description = "关于医疗查询的操作")
//public class MedicineController extends AbstractController {
//    protected Logger logger = LoggerFactory.getLogger(getClass());
//
//    @Autowired
//    private RedisUtils redisUtil;
//    @Autowired
//    private DataAdvisorTemplateService dataAdvisorTemplateService;
//    @Autowired
//    @Qualifier("hiveJdbcTemplate")
//    JdbcTemplate jdbcTemplate;
//    @SysLog("查询医疗")
//    @PostMapping("/get-medicine")
//    @ApiOperation(value = "get-medicine")
//    public R getMedicineTerrify(@RequestBody MedicineForm medicineForm) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
//        logger.info("get-medicine");
//
//        String values_accounts = "";
//        String values_contents = " a.content ";
//        String medicineSqlAccounts = "";
//        StringBuilder condition = new StringBuilder("");
//        StringBuilder join_base_string = new StringBuilder("");
//
//        sqlForm sqlForm = new sqlForm();
//        Map<String, String> join_base_map = new LinkedHashMap<>();
//        ArrayList<String> condition_list = new ArrayList<>();
//
//        if((medicineForm.getShowData() == null || medicineForm.getShowData().equals("")) &&
//                (medicineForm.getShowClassifyData() == null || medicineForm.getShowClassifyData().equals(""))){
//            return R.error("统计总数据和分类统计数据必须选择一个！");
//        }
//
//        // 选择平台
////        增加平台的全选中功能
//        if (!medicineForm.getPlatformId().contains("all")){
//            CommonMethod.getPlatform(medicineForm.getPlatformId(), condition_list);
//        }
//
//        // 时间范围选择
//        CommonMethod.getDataRange(medicineForm.getDataRange(), condition_list);
//
////        // 关键字
//        CommonMethod.getAndkeyWords(medicineForm.getKeyWords(), condition_list);
//
//        // 更多选择
//        if (medicineForm.getMultipleChoice() != null && !(medicineForm.getMultipleChoice().isEmpty())){
//            CommonParametersForm commonParametersForm = new CommonParametersForm();
//
//            List medicineClassfyData = commonParametersForm.getMedicineClassifyData();
//            for (Map<String, List> map : medicineForm.getMultipleChoice()) {
//                for (Map.Entry<String, List> stringStringEntry : map.entrySet()) {
//                    String key = stringStringEntry.getKey();
//                    List value = stringStringEntry.getValue();
//                    StringBuilder value_clssfy = new StringBuilder();
//                    for (int i = 0; i < value.size(); i++) {
//                        value_clssfy.append("'" + value.get(i) + "'");
//                        if(!(i == value.size()-1)){
//                            value_clssfy.append(",");
//                        }
//                    }
//                    if(medicineClassfyData.contains(key) && !(join_base_map.containsKey("tableUserDoc"))){
//                        join_base_map.put("tableUserDoc", sqlForm.getTableUserDoc());
//                    }
//                    if("titlename".equals(key)){
//                        join_base_map.put("tableTitleName", sqlForm.getTableTitleName());
//                        condition_list.add("m." + key + " in (" + value_clssfy + ")");
//                    }else if("hlevel".equals(key)){
//                        join_base_map.put("tableHlevel", sqlForm.getTableHlevel());
//                        condition_list.add("k." + key + " in (" + value_clssfy + ")");
//                    } else if("departmentname".equals(key)){
//                        join_base_map.put("tableDepartmentName", sqlForm.getTableDeparrtMentName());
//                        condition_list.add("j." + key + " in (" + value_clssfy + ")");
//                    }else if("province".equals(key) || "cityregion".equals(key)){
//                        join_base_map.put("tableProvince", sqlForm.getTableProvince());
//                        condition_list.add("f." + key + " in (" + value_clssfy + ")");
//                    }else if("citytier".equals(key) || "nielsen_citytier".equals(key)){
//                        join_base_map.put("tableCityTier", sqlForm.getTableCityTier());
//                        condition_list.add("d." + key + " in (" + value_clssfy + ")");
//                    }else {
//                        condition_list.add("a." + key + " in (" + value_clssfy + ")");
//                    }
//                }
//            }
//        }
//
//        // 拼接条件
//        CommonMethod.joinCoditionList(condition_list, condition);
//        //            在join_base_map中清除重复的表
//        Map mapbase = removeDuplicateMap(join_base_map);
//        for (Object stringStringEntry : mapbase.keySet()){
//            join_base_string.append(mapbase.get(stringStringEntry) + " ");
//        }
//        //  是否统计总数据
//        if (medicineForm.getShowData() != null && !("".equals(medicineForm.getShowData()))) {
//            values_accounts = " count(*) records, count(distinct a.post_id) posts, count(distinct a.user_id) users ";
//            // 返回查询总数据的sql
//            medicineSqlAccounts =  "SELECT " + values_accounts + " FROM " + sqlForm.getlMedicine() + " a " + join_base_string + condition;
//        }
//
//        //      查询内容做词云
//        String motherSqlContents = "SELECT " + values_contents + " FROM " + sqlForm.getlMedicine() + " a " + join_base_string + condition + " limit 2000";
//
//        //      是否分类统计
//        Map sql_select = new HashMap();
//        if (medicineForm.getShowClassifyData() != null && !("".equals(medicineForm.getShowClassifyData()))){
//            List getList = medicineForm.getClassifyStatic();  // 前端获取的分类字段
//            CommonParametersForm medicineClassfy = new CommonParametersForm();
//            List medicineClassfyData = medicineClassfy.getMedicineClassifyData(); // 固定分类连接表字段
//            //  用户选择了分类统计 但是没有传入分类字段
//            if(getList == null){
//                return R.error("检查传入的分类参数");
//            }
//            for (Object o : getList) {
//                String val = "";
//                Map<String, String>  join_base_map_new = new LinkedHashMap<>();
//                if(!join_base_map.isEmpty()){
//                    join_base_map_new.putAll(join_base_map);
//                }
//                if(medicineClassfyData.contains(o) && !(join_base_map.containsKey("tableUserDao"))){
//                    join_base_map_new.put("tableUserDoc", sqlForm.getTableUserDoc());
//                }
//                if("titlename".equals(o.toString())){
//                    join_base_map_new.put("tableTitleName", sqlForm.getTableTitleName());
//                    val = "m." + o.toString();
//                }else if("hlevel".equals(o.toString())){
//                    join_base_map_new.put("tableHlevel", sqlForm.getTableHlevel());
//                    val = "k." + o.toString();
//                } else if("departmentname".equals(o.toString())){
//                    join_base_map_new.put("tableDepartmentName", sqlForm.getTableDeparrtMentName());
//                    val = "j." + o.toString();
//                }else if("province".equals(o.toString()) || "cityregion".equals(o.toString())){
//                    join_base_map_new.put("tableProvince", sqlForm.getTableProvince());
//                    val = "f." + o.toString();
//                }else if("citytier".equals(o.toString()) || "nielsen_citytier".equals(o.toString())){
//                    join_base_map_new.put("tableCityTier", sqlForm.getTableCityTier());
//                    val = "d." + o.toString();
//                }else if("year".equals(o.toString()) || "month".equals(o.toString())){
//                    val = o.toString().toUpperCase()+ "(a.created_at)";
//                }else{
//                    val = "a." + o.toString();
//                }
//
//                //  去除重复的连表
//                join_base_string = new StringBuilder("");
//                Map map = removeDuplicateMap(join_base_map_new);
//                for (Object stringStringEntry : map.keySet()){
//                    join_base_string.append(map.get(stringStringEntry) + " ");
//                }
//                values_accounts = val + " classify, " + " count(*) records, count(distinct a.post_id) posts, count(distinct a.user_id) users ";
//                String sql = "SELECT " + values_accounts + " FROM " + sqlForm.getlMedicine() + " a " + join_base_string + condition + " GROUP BY " + val;
//                // 返回分类查询的sql
//                sql_select.put(o.toString(), sql);
//            }
//
//        }
//
//        Map returnMap = new HashMap();
//        if(!sql_select.isEmpty()){
//            returnMap.put("SqlClassify", sql_select);
//        }
//        if(!("".equals(medicineSqlAccounts))){
//            returnMap.put("SqlAccounts", medicineSqlAccounts);
//        }
//        returnMap.put("SqlContents", motherSqlContents);
//        // 获取uuid
//        String uuid = CommonMethod.getUuid();
//        returnMap.put("uuid", uuid);
//
//
//        // TODO 开启线程去查询 调用接口查询进行保存
//        CommonMethod commonMethod = new CommonMethod();
//        DataAdvisorTemplateEntity dataAdvisorTemplateEntity = commonMethod.joinTemplateParamters(medicineForm, medicineForm.getTemplate(), "", 2, getUserId());
//        ThreadSearch threadSearch = new ThreadSearch(dataAdvisorTemplateEntity, dataAdvisorTemplateService, medicineForm.getTemplate(), redisUtil, uuid, jdbcTemplate, returnMap);
//        new Thread(threadSearch).start();
//        return R.ok()
//                .put("result", returnMap);
//    }
//
//    public Map removeDuplicateMap(Map map){
//
//        if(map.containsKey("tableProvince")){
//            if(map.containsKey("tableCityTier")){
//                map.remove("tableCityTier");
//            }
//            if(map.containsKey("tableHlevel")){
//                map.remove("tableHlevel");
//            }
//        }else if (map.containsKey("tableCItyTier")){
//            if (map.containsKey("tableHlevel")){
//                map.remove("tableHlevel");
//            }
//        }
//        return map;
//    }
//
//
//}
