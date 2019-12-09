package com.ruoyi.transport.controller;

import java.util.List;

import com.ruoyi.transport.domain.TOrderVehicleDriver;
import com.ruoyi.transport.model.OrderInfoRequestModel;
import com.ruoyi.transport.model.OrderDetailModel;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.transport.service.ITOrderService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.framework.util.ShiroUtils;

/**
 * 订单Controller
 *
 * @author huanshare
 * @date 2019-12-06
 */
@Controller
@RequestMapping("/transport/order")
public class TOrderController extends BaseController {
    private String prefix = "transport/order";

    @Autowired
    private ITOrderService tOrderService;

    @RequiresPermissions("transport:order:view")
    @GetMapping()
    public String order() {
        return prefix + "/order";
    }

    /**
     * 查询订单列表
     */
    @RequiresPermissions("transport:order:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(OrderInfoRequestModel tOrder) {
        startPage();
        List<OrderDetailModel> list = tOrderService.selectTOrderList(tOrder);
        return getDataTable(list);
    }

    /**
     * 导出订单列表
     */
    @RequiresPermissions("transport:order:export")
    @Log(title = "订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OrderInfoRequestModel tOrder) {
        List<OrderDetailModel> list = tOrderService.selectTOrderList(tOrder);
        ExcelUtil<OrderDetailModel> util = new ExcelUtil<>(OrderDetailModel.class);
        return util.exportExcel(list, "order");
    }

    /**
     * 新增订单
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存订单
     */
    @RequiresPermissions("transport:order:add")
    @Log(title = "订单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestBody OrderDetailModel tOrder) {
        tOrder.setCreateBy(ShiroUtils.getLoginName());
        tOrder.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(tOrderService.insertTOrder(tOrder));
    }

    /**
     * 修改订单
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        OrderDetailModel tOrder = tOrderService.selectTOrderById(id);
        mmap.put("tOrder", tOrder);
        return prefix + "/edit";
    }

    /**
     * 修改保存订单
     */
    @RequiresPermissions("transport:order:edit")
    @Log(title = "订单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(OrderDetailModel tOrder) {
        tOrder.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(tOrderService.updateTOrder(tOrder));
    }

    /**
     * 删除订单
     */
    @RequiresPermissions("transport:order:remove")
    @Log(title = "订单", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        String updateBy = ShiroUtils.getLoginName();
        return toAjax(tOrderService.deleteTOrderByIds(ids, updateBy));
    }
}
