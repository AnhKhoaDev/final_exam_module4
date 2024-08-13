package com.codegym.final_exam_module4.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class OrderDTO {
    Long id;

    String nameProduct;

    double price;

    String nameCategory;

    @NotNull(message = "Ngày mua không được để trống")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Future(message = "Ngày mua phải lớn hơn ngày hiện tại")
    LocalDate orderDate;

    @NotNull(message = "Số lượng không được để trống")
    @Min(value = 1, message = "Số lượng phải là số nguyên dương")
    double quantity;

    double TotalPrice;
}
