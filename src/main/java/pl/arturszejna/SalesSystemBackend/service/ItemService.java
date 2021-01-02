package pl.arturszejna.SalesSystemBackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.arturszejna.SalesSystemBackend.entity.Item;
import pl.arturszejna.SalesSystemBackend.repository.ItemRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public Item add(Item newItem){
        return itemRepository.save(newItem);
    }

    public List<Item> findAll(){
        return itemRepository.findAll();
    }

    public ResponseEntity delete(Long idItem){
        itemRepository.deleteById(idItem);
        return ResponseEntity.ok().build();
    }

}
