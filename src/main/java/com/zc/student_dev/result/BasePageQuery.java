package com.zc.student_dev.result;


import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;


public class BasePageQuery {
    /**
     * 每页最大显示的记录条数
     */
    @ApiModelProperty(hidden = true, allowEmptyValue = true)
    private static final Integer MAX_PAGE_SIZE = 100;

    /**
     * 每页默认显示10条记录
     */
    @ApiModelProperty(hidden = true, allowEmptyValue = true)
    private static final Integer DEFALUT_PAGE_SIZE = 10;

    /**
     * 升序排序
     */
    @ApiModelProperty(hidden = true, allowEmptyValue = true)
    public static final String SORT_DIR_ASC = "asc";

    /**
     * 降序排序
     */
    @ApiModelProperty(hidden = true, allowEmptyValue = true)
    public static final String SORT_DIR_DESC = "desc";

    /**
     * 当前页码
     */
    @ApiModelProperty(value = "当前页码", example = "1")
    private Integer page;

    /**
     * 每页显示的记录数
     */
    @ApiModelProperty(value = "每页显示的记录数", example = "1")
    private Integer limit = DEFALUT_PAGE_SIZE;

    /**
     * 排序字段名
     */
    @ApiModelProperty(value = "排序字段名")
    private String sortName;

    /**
     * 排序方向（ASC、DESC）
     */
    @ApiModelProperty(value = "排序方向（ASC、DESC）")
    private String sortOrder;

    /**
     * 是否全部展示
     */
    @ApiModelProperty(value = "是否全部展示")
    private Boolean selectAll;

    public Integer getPage() {
        if (page == null || page < 0) {
            return 1;
        }
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        if (limit == null || limit < 1) {
            return DEFALUT_PAGE_SIZE;
        }
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getSortName() {
        return this.sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Boolean getSelectAll() {
        return (selectAll == null) ? false : selectAll;
    }

    public void setSelectAll(Boolean selectAll) {
        this.selectAll = selectAll;
    }

    @ApiModelProperty(hidden = true, value = "null")
    public boolean isDesc() {
        return SORT_DIR_DESC.equalsIgnoreCase(sortOrder);
    }

    @ApiModelProperty(hidden = true, value = "null")
    public boolean isAsc() {
        return SORT_DIR_ASC.equalsIgnoreCase(sortOrder);
    }

    @ApiModelProperty(hidden = true, value = "null")
    public boolean isMultiSortName() {
    	if(StringUtils.isBlank(sortName)) {
    		return false;
    	}
        return (sortName.contains(",")||sortName.contains("，"));
    }

    @ApiModelProperty(hidden = true, value = "null")
    public Map<String, Object> turnQueryObjToMap(){
        Map<String, Object> map = new HashMap<>();
        if (page != null){
            map.put("page", page);
        }
        if (limit != null){
            map.put("limit", limit);
        }
        if (!StringUtils.isEmpty(sortName)){
            map.put("sortName", sortName);
        }
        if (!StringUtils.isEmpty(sortOrder)){
            map.put("sortOrder", sortOrder);
        }
        return map;
    }
}
