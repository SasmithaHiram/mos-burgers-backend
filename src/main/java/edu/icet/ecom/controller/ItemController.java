package edu.icet.ecom.controller;

import edu.icet.ecom.dto.Item;
import edu.icet.ecom.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
@CrossOrigin

public class ItemController {
    final ItemService service;

    @PostMapping("/add-item")
    public void addItem(@RequestBody Item item) {
        service.addItem(item);
    }

    @GetMapping("/get-all-items")
    public List<Item> getAllItems() {
        return service.getAllItems();
    }

}
