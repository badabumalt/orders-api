package com.example.ordersapi;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientRepository repo;
    public ClientController(ClientRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Client> getAll() { return repo.findAll(); }

    @GetMapping("/{id}")
    public Client getOne(@PathVariable Long id) { return repo.findById(id).orElseThrow(); }

    @PostMapping
    public Client create(@RequestBody Client client) { return repo.save(client); }

    @PutMapping("/{id}")
    public Client update(@PathVariable Long id, @RequestBody Client updated) {
        updated.setId(id);
        return repo.save(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { repo.deleteById(id); }
}