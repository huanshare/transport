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
import com.ruoyi.transport.domain.TOrderTime;
import com.ruoyi.transport.service.ITOrderTimeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.framework.util.ShiroUtils;
/**
 * 订单时间Controller
 * 
 * @author huannshare
 * @date 2019-12-21
 */
@Controller
@RequestMapping("/transport/tOrderTime")
public class TOrderTimeController extends BaseController
{
    private String prefix = "transport/tOrderTime";

    @Autowired
    private ITOrderTimeService tOrderTimeService;

    @RequiresPermissions("transport:tOrderTime:view")
    @GetMapping()
    public String tOrderTime()
    {
        return prefix + "/tOrderTime";
    }

    /**
     * 查询订单时间列表
     */
    @RequiresPermissions("transport:tOrderTime:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TOrderTime tOrderTime)
    {
        startPage();
        List<TOrderTime> list = tOrderTimeService.selectTOrderTimeList(tOrderTime);
        return getDataTable(list);
    }

    /**
     * 导出订单时间列表
     */
    @RequiresPermissions("transport:tOrderTime:export")
    @Log(title = "订单时间", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TOrderTime tOrderTime)
    {
        List<TOrderTime> list = tOrderTimeService.selectTOrderTimeList(tOrderTime);
        ExcelUtil<TOrderTime> util = new ExcelUtil<TOrderTime>(TOrderTime.class);
        return util.exportExcel(list, "tOrderTime");
    }

    /**
     * 新增订单时间
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存订单时间
     */
    @RequiresPermissions("transport:tOrderTime:add")
    @Log(title = "订单时间", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TOrderTime tOrderTime)
    {
        tOrderTime.setCreateBy(ShiroUtils.getLoginName());
        tOrderTime.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(tOrderTimeService.insertTOrderTime(tOrderTime));
    }

    /**
     * 修改订单时间
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TOrderTime tOrderTime = tOrderTimeService.selectTOrderTimeById(id);
        mmap.put("tOrderTime", tOrderTime);
        return prefix + "/edit";
    }

    /**
     * 修改保存订单时间
     */
    @RequiresPermissions("transport:tOrderTime:edit")
    @Log(title = "订单时间", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TOrderTime tOrderTime)
    {
        tOrderTime.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(tOrderTimeService.updateTOrderTime(tOrderTime));
    }

    /**
     * 删除订单时间
     */
    @RequiresPermissions("transport:tOrderTime:remove")
    @Log(title = "订单时间", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        String updateBy=ShiroUtils.getLoginName();
        return toAjax(tOrderTimeService.deleteTOrderTimeByIds(ids,updateBy));
    }
}
