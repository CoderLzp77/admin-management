package com.controller;

import com.pojo.Expenseitem;
import com.pojo.Vo.ReimbursementVo;
import com.service.ExpenseItemService;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Reimburse")
@CrossOrigin
public class ReimburseController {
    @Autowired
    private R r;
    @Autowired
    private ExpenseItemService expenseItemService;
    @PostMapping(value = "/AddReimburse")
    public R AddReimburse(@RequestBody ReimbursementVo reimbursementVo){
   return null;
    }
}
