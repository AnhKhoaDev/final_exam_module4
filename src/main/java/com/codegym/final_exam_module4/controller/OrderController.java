package com.codegym.final_exam_module4.controller;

import com.codegym.final_exam_module4.dto.OrderDTO;
import com.codegym.final_exam_module4.model.Category;
import com.codegym.final_exam_module4.model.Product;
import com.codegym.final_exam_module4.service.ICategoryService;
import com.codegym.final_exam_module4.service.IOrderService;
import com.codegym.final_exam_module4.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class OrderController {
    private final IOrderService orderService;
    private final IProductService productService;
    private final ICategoryService categoryService;

    @ModelAttribute("products")
    public List<Product> getProducts()  {
        return productService.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> getCategories()  {
        return categoryService.findAll();
    }

    @GetMapping
    public String getHomePage(Model model) {
        List<OrderDTO> orders = orderService.findAll();
        model.addAttribute("orders", orders);
        return "/index";
    }

    @GetMapping("/update/{id}")
    public String getUpdateOrderPage(Model model, @PathVariable Long id) {
        OrderDTO orders = orderService.findById(id);
        model.addAttribute("orders", orders);
        return "/update";
    }

    @PostMapping("/update/{id}")
    public String updateTransaction(@ModelAttribute("orders") OrderDTO orderDTO,
                                    BindingResult bindingResult,
                                    @PathVariable Long id,
                                     RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/update";
        }
        orderService.update(orderDTO, id);
        redirectAttributes.addFlashAttribute("message", "Giao dịch đã cập nhật thành công.");
        return "redirect:/home";
    }
}
