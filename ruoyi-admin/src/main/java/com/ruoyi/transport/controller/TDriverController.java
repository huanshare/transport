package com.ruoyi.transport.controller;

import java.util.List;

import com.ruoyi.framework.util.ShiroUtils;
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
import com.ruoyi.transport.domain.TDriver;
import com.ruoyi.transport.service.ITDriverService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 司机Controller
 *
 * @author ruoyi
 * @date 2019-12-03
 */
@Controller
@RequestMapping("/transport/driver")
public class TDriverController extends BaseController {
    private String prefix = "transport/driver";

    @Autowired
    private ITDriverService tDriverService;

    @RequiresPermissions("transport:driver:view")
    @GetMapping()
    public String driver() {
        return prefix + "/driver";
    }

    /**
     * 查询司机列表
     */
    @RequiresPermissions("transport:driver:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TDriver tDriver) {
        startPage();
        List<TDriver> list = tDriverService.selectTDriverList(tDriver);
        return getDataTable(list);
    }

    /**
     * 导出司机列表
     */
    @RequiresPermissions("transport:driver:export")
    @Log(title = "司机", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TDriver tDriver) {
        List<TDriver> list = tDriverService.selectTDriverList(tDriver);
        ExcelUtil<TDriver> util = new ExcelUtil<TDriver>(TDriver.class);
        return util.exportExcel(list, "driver");
    }

    /**
     * 新增司机
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存司机
     */
    @RequiresPermissions("transport:driver:add")
    @Log(title = "司机", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TDriver tDriver) {
        tDriver.setCreateBy(ShiroUtils.getLoginName());
        tDriver.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(tDriverService.insertTDriver(tDriver));
    }

    /**
     * 修改司机
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        TDriver tDriver = tDriverService.selectTDriverById(id);
        mmap.put("tDriver", tDriver);
        return prefix + "/edit";
    }

    /**
     * 修改保存司机
     */
    @RequiresPermissions("transport:driver:edit")
    @Log(title = "司机", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TDriver tDriver) {
        tDriver.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(tDriverService.updateTDriver(tDriver));
    }

    /**
     * 删除司机
     */
    @RequiresPermissions("transport:driver:remove")
    @Log(title = "司机", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        String updateBy = ShiroUtils.getLoginName();
        return toAjax(tDriverService.deleteTDriverByIds(ids, updateBy));
    }
}
