package com.example.ordersapi;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderRepository repo;
    public OrderController(OrderRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Order> getAll() { return repo.findAll(); }

    @GetMapping("/{id}")
    public Order getOne(@PathVariable Long id) { return repo.findById(id).orElseThrow(); }

    @PostMapping
    public Order create(@RequestBody Order order) { return repo.save(order); }

    @PutMapping("/{id}")
    public Order update(@PathVariable Long id, @RequestBody Order updated) {
        updated.setId(id);
        return repo.save(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { repo.deleteById(id); }
}