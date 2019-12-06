package com.ruoyi.transport.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.transport.domain.TVehicle;
import com.ruoyi.transport.service.ITVehicleService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.framework.util.ShiroUtils;
/**
 * 车辆Controller
 * 
 * @author huanshare
 * @date 2019-12-06
 */
@Controller
@RequestMapping("/transport/vehicle")
public class TVehicleController extends BaseController
{
    private String prefix = "transport/vehicle";

    @Autowired
    private ITVehicleService tVehicleService;

    @RequiresPermissions("transport:vehicle:view")
    @GetMapping()
    public String vehicle()
    {
        return prefix + "/vehicle";
    }

    /**
     * 查询车辆列表
     */
    @RequiresPermissions("transport:vehicle:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TVehicle tVehicle)
    {
        startPage();
        List<TVehicle> list = tVehicleService.selectTVehicleList(tVehicle);
        return getDataTable(list);
    }

    /**
     * 导出车辆列表
     */
    @RequiresPermissions("transport:vehicle:export")
    @Log(title = "车辆", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TVehicle tVehicle)
    {
        List<TVehicle> list = tVehicleService.selectTVehicleList(tVehicle);
        ExcelUtil<TVehicle> util = new ExcelUtil<TVehicle>(TVehicle.class);
        return util.exportExcel(list, "vehicle");
    }

    /**
     * 新增车辆
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存车辆
     */
    @RequiresPermissions("transport:vehicle:add")
    @Log(title = "车辆", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TVehicle tVehicle)
    {
        tVehicle.setCreateBy(ShiroUtils.getLoginName());
        tVehicle.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(tVehicleService.insertTVehicle(tVehicle));
    }

    /**
     * 修改车辆
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TVehicle tVehicle = tVehicleService.selectTVehicleById(id);
        mmap.put("tVehicle", tVehicle);
        return prefix + "/edit";
    }

    /**
     * 修改保存车辆
     */
    @RequiresPermissions("transport:vehicle:edit")
    @Log(title = "车辆", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TVehicle tVehicle)
    {
        tVehicle.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(tVehicleService.updateTVehicle(tVehicle));
    }

    /**
     * 删除车辆
     */
    @RequiresPermissions("transport:vehicle:remove")
    @Log(title = "车辆", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        String updateBy=ShiroUtils.getLoginName();
        return toAjax(tVehicleService.deleteTVehicleByIds(ids,updateBy));
    }
}
