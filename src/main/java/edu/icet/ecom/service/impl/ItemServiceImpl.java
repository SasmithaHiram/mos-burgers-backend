package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.Item;
import edu.icet.ecom.entity.CustomerEntity;
import edu.icet.ecom.entity.ItemEntity;
import edu.icet.ecom.repository.ItemRepository;
import edu.icet.ecom.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ItemServiceImpl implements ItemService {
    final ItemRepository repository;
    final ModelMapper mapper;

    @Override
    public void addItem(Item item) {
        repository.save(mapper.map(item, ItemEntity.class));
    }

    @Override
    public void updateItem(Item item) {
        repository.save(mapper.map(item, ItemEntity.class));
    }

    @Override
    public List<Item> getAllItems() {
        List<ItemEntity> itemEntityList = repository.findAll();

        ArrayList<Item> items = new ArrayList<>();
        itemEntityList.forEach(itemEntity -> {
            items.add(mapper.map(itemEntity, Item.class));
        });
        return items;
    }

}
